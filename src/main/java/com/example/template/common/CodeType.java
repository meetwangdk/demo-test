package com.example.template.common;

public enum CodeType {
    SUCCESS(0, "success"),
    SELECT_ERROR(1000001, "selectError"),
    INSERT_ERROR(1000002, "insertError"),
    UPDATE_ERROR(1000003, "updateError"),
    DELETE_ERROR(1000004, "deleteError"),
    UNKNOWN_ERROR(9900999, "unknownError");

    int status;
    String resMsg;

    CodeType(int status, String resMsg) {
        this.status = status;
        this.resMsg = resMsg;
    }

    public int getStatus() {
        return status;
    }

    public String getResMsg() {
        return resMsg;
    }
}
