package com.example.CmAgreementManagementApplication.service.impl;

import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoCourse;
import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUser;
import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUserIU;
import com.example.CmAgreementManagementApplication.exception.BaseException;
import com.example.CmAgreementManagementApplication.exception.ErrorMessage;
import com.example.CmAgreementManagementApplication.exception.MessageType;
import com.example.CmAgreementManagementApplication.model.relations.ManyToMany.Course;
import com.example.CmAgreementManagementApplication.model.relations.ManyToMany.User;
import com.example.CmAgreementManagementApplication.repository.IUserRepository;
import com.example.CmAgreementManagementApplication.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<DtoUser> allUsers() {
        List<User> users = userRepository.findAll();
        List<DtoUser> dtoUsers = new ArrayList<>();
        for (User user : users) {
            DtoUser dtoUser = new DtoUser();
            BeanUtils.copyProperties(user, dtoUser);

            if (user.getCourses() != null && !user.getCourses().isEmpty()) {
                for (Course course : user.getCourses()) {
                    DtoCourse dtoCourse = new DtoCourse();
                    BeanUtils.copyProperties(course, dtoCourse);
                    dtoUser.getDtoCourses().add(dtoCourse);
                }
            }
            dtoUsers.add(dtoUser);
        }
        return dtoUsers;
    }


    @Override
    public DtoUser getUserById(Integer id) {
        DtoUser dtoUser = new DtoUser();
        Optional<User> findUserId = userRepository.findById(id);
        if (findUserId.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        User user = findUserId.get();
        BeanUtils.copyProperties(user, dtoUser);

        if (user.getCourses() != null && !user.getCourses().isEmpty()) {
            for (Course course : user.getCourses()) {
                DtoCourse dtoCourse = new DtoCourse();
                BeanUtils.copyProperties(course, dtoCourse);
                dtoUser.getDtoCourses().add(dtoCourse);
            }
        }
        return dtoUser;
    }

    @Override
    public DtoUser saveNewUser(DtoUserIU newUserIU) {
        User newUser = new User();
        BeanUtils.copyProperties(newUserIU, newUser);
        User savedUser = userRepository.save(newUser);
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    @Override
    public void deleteFoundUserById(Integer id) {
        Optional<User> findUserId = userRepository.findById(id);
        findUserId.ifPresent(user -> {userRepository.delete(user);});
    }

    @Override
    public DtoUser updateFoundUserById(Integer id, DtoUserIU userIU) {
        Optional<User> findUserId = userRepository.findById(id);
        if (findUserId.isEmpty()) {
            return null;
        }
        User user = findUserId.get();
        user.setUsername(userIU.getUsername());
        user.setPassword(userIU.getPassword());
        userRepository.save(user);

        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(user, dtoUser);
        return dtoUser;
    }
}
