package com.example.CmAgreementManagementApplication.handler;

import lombok.Data;

import java.util.Date;

@Data
public class Exception<E> {
    private String hostName;
    private String path;
    private Date createDate;
    private E message;
}
