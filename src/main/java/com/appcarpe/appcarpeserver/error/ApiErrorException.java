package com.appcarpe.appcarpeserver.error;

public class ApiErrorException extends Exception {
    private final ApiError apiError;

    public ApiErrorException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }
}
