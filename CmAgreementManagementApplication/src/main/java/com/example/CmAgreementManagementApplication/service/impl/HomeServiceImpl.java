package com.example.CmAgreementManagementApplication.service.impl;

import com.example.CmAgreementManagementApplication.dto.OneToMany.DtoHome;
import com.example.CmAgreementManagementApplication.dto.OneToMany.DtoRoom;
import com.example.CmAgreementManagementApplication.exception.BaseException;
import com.example.CmAgreementManagementApplication.exception.ErrorMessage;
import com.example.CmAgreementManagementApplication.exception.MessageType;
import com.example.CmAgreementManagementApplication.model.relations.OneToMany.Home;
import com.example.CmAgreementManagementApplication.model.relations.OneToMany.Room;
import com.example.CmAgreementManagementApplication.repository.IHomeRepository;
import com.example.CmAgreementManagementApplication.service.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private IHomeRepository homeRepository;

    @Override
    public List<DtoHome> findAllHomes() {
        List<DtoHome> dtoHomes = new ArrayList<>();
        for (Home home : homeRepository.findAll()) {
            DtoHome dtoHome = new DtoHome();
            BeanUtils.copyProperties(home, dtoHome);
            List<Room> rooms = home.getRooms();

            if (rooms != null && !rooms.isEmpty()) {
                for (Room room : rooms) {
                    DtoRoom dtoRoom = new DtoRoom();
                    BeanUtils.copyProperties(room, dtoRoom);
                    home.getRooms().add(room);
                }
                dtoHomes.add(dtoHome);
            }
        }
        return dtoHomes;
    }

    @Override
    public DtoHome findHomeById(Long id) {
        Optional<Home> findHomeId = homeRepository.findById(id);
        if (findHomeId.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        Home home = findHomeId.get();
        DtoHome dtoHome = new DtoHome();
        BeanUtils.copyProperties(home, dtoHome);
        List<Room> rooms = home.getRooms();

        if (rooms != null && !rooms.isEmpty()) {
            for (Room room : rooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                home.getRooms().add(room);
            }
        }
        return dtoHome;
    }

    @Override
    public void deleteFoundHomeById(Long id) {
        Optional<Home> findHomeId = homeRepository.findById(id);
        if (findHomeId.isPresent()) {
            Home home = findHomeId.get();
            home.getRooms().clear();
            homeRepository.save(home);
            homeRepository.delete(home);
        }
    }
}
