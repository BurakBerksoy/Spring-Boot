package com.example.CmAgreementManagementApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private MessageType messageType;
    private String detail;

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());
        if (detail != null && !detail.isEmpty()) {
            builder.append(" : ").append(detail);
        }
        return builder.toString();
    }
}
