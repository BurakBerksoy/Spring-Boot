package com.example.CmAgreementManagementApplication.exception;

public class BaseException extends RuntimeException {
    public BaseException() {
        super("Beklenmeyen bir hata oluştu.");
    }

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
