package com.example.workout.exception;


/**
 * 业务异常Code
 */
public enum ExceptionType {

    INNER_ERROR(500,"内部错误"),

    UNAUTHORIZED(401,"未登录"),

    BAD_REQUEST(400,"请求错误"),

    FORBIDDEN(403,"无权操作"),

    NOT_FOUND(404,"未找到"),

    DUPLICATE(4000101,"重复添加"),

    USER_NOT_FOUND(40401001,"用户名不存在"),

    METHOD_NOT_SUPPORTED(405,"此请求不支持"),

     UPDATE_ERROR(50001,"持久层更新错误"),

    PARAMETERS_CANNOT_BE_EMPTY(50002,"参数不能为空");

    private Integer code;

    private String message;

    ExceptionType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
