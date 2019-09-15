package com.yffd.jemsp.module.support.exception;

public enum SysExceptionEnum {
    JESMP_EXCEPTION(1000, "系统异常", "平台系统异常"),
    SERVICE_EXCEPTION(1001, "系统异常", "服务层处理错误"),
    DAO_EXCEPTION(1002, "系统异常", "持久层处理错误"),
    API_EXCEPTION(1003, "系统异常", "应用接口错误"),

    /** 参数错误：2000-2999 */
    PARAM_IS_EMPTY(2001, "参数为空", "参数为空"),
    PARAM_IS_INVALID(2002, "参数无效", "参数无效"),
    PARAM_TYPE_BIND_ERROR(2003, "参数类型错误", "参数类型错误"),
    PARAM_NOT_COMPLETE(2004, "参数缺失", "参数缺失"),

    /** 数据错误：3000-3999 */
    DATA_EXSIST(3001, "数据已存在", "数据已存在"),
    DATA_NOT_EXSIST(3002, "数据不存在", "数据不存在"),
    DATA_IS_NULL(3003, "数据为空", "数据为空"),


    /** 持久化错误：4000-4999 */
    DB_INSERT_NULL(4001, "系统错误", "持久化操作，插入数据为空"),
    DB_INSERT_RESULT_0(4002, "系统错误", "持久化操作，插入返回结果为0"),
    DB_UPDATE_NULL(4003, "系统错误", "持久化操作，更新数据为空"),
    DB_UPDATE_RESULT_0(4004, "系统错误", "持久化操作，更新返回结果为0"),
    DB_DELETE_NULL(4005, "系统错误", "持久化操作，删除数据为空"),
    DB_DELETE_RESULT_0(4006, "系统错误", "持久化操作，删除返回结果为0"),
    DB_SELECT_BY_NULL(4007, "系统错误", "持久化操作，查询条件为空"),
    DB_SELECT_ONE_RESULT_MULTI(4008, "系统错误", "持久化操作，单条查询返回结果为多条"),
    DB_SELECT_RESULT_NULL(4009, "系统错误", "持久化操作，查询返回结果为空"),
    DB_SQL_ID_EMPTY(4010, "系统错误", "sqlId不能为空"),
    DB_GET_SEQ_VALUE_TIMEOUT(4011, "系统错误", "持久化操作，序列生成超时"),
    DB_UNSUPPORTTYPE(4012, "系统错误", "持久化操作，不支持类型"),

    /** 应用接口错误：5000-5999 */
    API_NOT_FOUND(5001, "请求资源未找到", "请求资源未找到"),
    API_NOT_SUPPORTED_METHOD(5002, "系统错误", "请求方法暂时未支持"),
    API_NOT_SUPPORTED_MEDIA_TYPE(5003, "系统错误", "请求媒体类型未支持"),
    API_NOT_ACCEPTABLE_MEDIA_TYPE(5004, "系统错误", "服务器响应的媒体类型不符客户端期望的媒体类型"),
    API_MISSING_REQUEST_PARAMETER(5005, "系统错误", "请求必要参数丢失"),
    API_NOT_SUPPORTED_CONVERSION(5006, "系统错误", "请求数据转换失败"),
    API_MESSAGE_NOT_READABLE(5007, "系统错误", "消息内容不可读"),
    API_MESSAGE_NOT_WRITABLE(5008, "系统错误", "消息内容不可写"),
    API_NOT_VALID_METHOD_ARGUMENT(5009, "系统错误", "请求方法参数校验失败"),
    API_UPLOAD_FILE_ERROR(5010, "文件上传失败", "文件上传失败"),
    API_ASYNC_REQUEST_TIMEOUT(5011, "系统错误", "异步请求超时"),

    /** 其它错误：9000-9999 */
    OPERATION_EXPIRE(9991, "操作过期", "操作过期"),
    OPERATION_UNSUPPORT(9992, "操作不支持", "操作不支持"),
    ;
    private Integer code;
    private String tip;
    private String msg;

    SysExceptionEnum(Integer code, String tip, String msg) {
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String tip() {
        return tip;
    }

    public String msg() {
        return msg;
    }
}
