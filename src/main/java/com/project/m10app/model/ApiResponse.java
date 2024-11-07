package com.project.m10app.model;

import lombok.Data;

@Data
public class ApiResponse {
    private int statusCode;
    private DataWrapper data;

    public ApiResponse(int statusCode, DataWrapper data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    @Data
    public static class DataWrapper {
        private String message;
        private Object data;

        public DataWrapper(String message, Object data) {
            this.message = message;
            this.data = data;
        }
    }
}
