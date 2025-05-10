package com.example.CmAgreementManagementApplication.controller.impl;

import com.example.CmAgreementManagementApplication.model.RootEntity;

public class RestBaseController {

    RootEntity rootEntity = new RootEntity();

    public <T>RootEntity<T> ok(T data) {
        return rootEntity.ok(data);
    }

    public <T>RootEntity<T> error(String errorMessage) {
        return rootEntity.error(errorMessage);
    }
}
