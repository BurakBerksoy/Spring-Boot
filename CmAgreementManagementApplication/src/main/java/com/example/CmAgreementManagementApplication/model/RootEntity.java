package com.example.CmAgreementManagementApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootEntity<T> {
    private boolean result;
    private String errorMessage;
    private T data;

    public <T> RootEntity<T> ok(T data) {
        RootEntity<T> rootEntity = new RootEntity<T>();
        rootEntity.setData(data);
        rootEntity.setResult(true);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }

    public <T> RootEntity<T> error(T data) {
        RootEntity<T> rootEntity = new RootEntity<T>();
        rootEntity.setData(null);
        rootEntity.setResult(false);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }
}
