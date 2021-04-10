package io.github.thanhduybk.common.payload.response;

import java.util.Arrays;

public enum ResponseCode {
    // 2xx
    OK(200),
    NO_CONTENT(204),

    // 4xx
    NOT_FOUND(404),
    UNAUTHORIZED(401),
    ACCESS_DENIED(403),
    BAD_REQUEST(400),

    // 5xx
    UNEXPECTED_ERROR(500),
    ;

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public int toHttpStatus() {
        return code;
    }

    public static boolean isErrorCode(ResponseCode responseCode) {
        return responseCode.getCode() >= 400;
    }

    public static ResponseCode fromHttpStatus(int statusCode) {
        return Arrays.stream(values())
                .filter(responseCode -> responseCode.getCode() == statusCode)
                .findFirst()
                .orElse(null);
    }
}