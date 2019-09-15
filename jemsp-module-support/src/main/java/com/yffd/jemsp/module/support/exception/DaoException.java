package com.yffd.jemsp.module.support.exception;

public class DaoException extends SysException {
    private static final long serialVersionUID = -3457933413197980781L;
    private Integer code;//异常编号
    private String tip;//异常提示，主要用于前端提示
    private String msg;//异常信息，主要用于后端日志
    private String sqlId = "";

    private DaoException(Integer code, String tip, String msg) {
        super(code, tip, msg);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    private DaoException(Integer code, String tip, String msg, Throwable cause) {
        super(code, tip, msg, cause);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    private DaoException(Integer code, String tip, String msg, String sqlId) {
        super(code, tip, msg);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
        this.sqlId  = sqlId;
    }

    private DaoException(Integer code, String tip, String msg, String sqlId, Throwable cause) {
        super(code, tip, msg, cause);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
        this.sqlId  = sqlId;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getTip() {
        return tip;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public String getSqlId() {
        return sqlId;
    }

    @Override
    public String getMessage() {
        return String.format("code:%s, tip:%s, msg:%s, sqlId:%s", this.getCode(), this.getTip(),
                this.getMsg(), this.getSqlId());
    }

    public static DaoException instance() {
        return new DaoException(SysExceptionEnum.DAO_EXCEPTION.code(),
                SysExceptionEnum.DAO_EXCEPTION.tip(),
                SysExceptionEnum.DAO_EXCEPTION.msg());
    }

    public static DaoException instance(String tip) {
        return new DaoException(SysExceptionEnum.DAO_EXCEPTION.code(), tip,
                SysExceptionEnum.DAO_EXCEPTION.msg());
    }

    public static DaoException instance(String tip, Throwable cause) {
        return new DaoException(SysExceptionEnum.DAO_EXCEPTION.code(), tip,
                SysExceptionEnum.DAO_EXCEPTION.msg(), cause);
    }


    /**
     * 数据库操作，插入数据为空
     */
    public static DaoException DB_INSERT_NULL(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_INSERT_NULL.code(),
                SysExceptionEnum.DB_INSERT_NULL.tip(), SysExceptionEnum.DB_INSERT_NULL.msg(), sqlId);
    }

    /**
     * 数据库操作，插入返回结果为0
     */
    public static DaoException DB_INSERT_RESULT_0(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_INSERT_RESULT_0.code(),
                SysExceptionEnum.DB_INSERT_RESULT_0.tip(),
                SysExceptionEnum.DB_INSERT_RESULT_0.msg(), sqlId);
    }

    /**
     * 数据库操作，更新数据为空
     */
    public static DaoException DB_UPDATE_NULL(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_UPDATE_NULL.code(),
                SysExceptionEnum.DB_UPDATE_NULL.tip(),
                SysExceptionEnum.DB_UPDATE_NULL.msg(), sqlId);
    }

    /**
     * 数据库操作，更新返回结果为0
     */
    public static DaoException DB_UPDATE_RESULT_0(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_UPDATE_RESULT_0.code(),
                SysExceptionEnum.DB_UPDATE_RESULT_0.tip(),
                SysExceptionEnum.DB_UPDATE_RESULT_0.msg(), sqlId);
    }

    /**
     * 数据库操作，删除数据为空
     */
    public static DaoException DB_DELETE_NULL(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_DELETE_NULL.code(),
                SysExceptionEnum.DB_DELETE_NULL.tip(),
                SysExceptionEnum.DB_DELETE_NULL.msg(), sqlId);
    }

    /**
     * 数据库操作，删除返回结果为0
     */
    public static DaoException DB_DELETE_RESULT_0(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_DELETE_RESULT_0.code(),
                SysExceptionEnum.DB_DELETE_RESULT_0.tip(),
                SysExceptionEnum.DB_DELETE_RESULT_0.msg(), sqlId);
    }

    /**
     * 数据库操作，查询条件为空
     */
    public static DaoException DB_SELECT_BY_NULL(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_SELECT_BY_NULL.code(),
                SysExceptionEnum.DB_SELECT_BY_NULL.tip(),
                SysExceptionEnum.DB_SELECT_BY_NULL.msg(), sqlId);
    }

    /**
     * 数据库操作，单条查询返回结果为多条
     */
    public static DaoException DB_SELECT_ONE_RESULT_MULTI(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_SELECT_ONE_RESULT_MULTI.code(),
                SysExceptionEnum.DB_SELECT_ONE_RESULT_MULTI.tip(),
                SysExceptionEnum.DB_SELECT_ONE_RESULT_MULTI.msg(), sqlId);
    }

    /**
     * 数据库操作，序列生成超时
     */
    public static DaoException DB_GET_SEQ_VALUE_TIMEOUT(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_GET_SEQ_VALUE_TIMEOUT.code(),
                SysExceptionEnum.DB_GET_SEQ_VALUE_TIMEOUT.tip(),
                SysExceptionEnum.DB_GET_SEQ_VALUE_TIMEOUT.msg(), sqlId);
    }

    /**
     * 数据库操作，查询返回结果为空
     */
    public static DaoException DB_SELECT_RESULT_NULL(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_SELECT_RESULT_NULL.code(),
                SysExceptionEnum.DB_SELECT_RESULT_NULL.tip(),
                SysExceptionEnum.DB_SELECT_RESULT_NULL.msg(), sqlId);
    }

    /**
     * sqlId 不能为空
     */
    public static DaoException DB_SQL_ID_EMPTY() {
        return new DaoException(SysExceptionEnum.DB_SQL_ID_EMPTY.code(),
                SysExceptionEnum.DB_SQL_ID_EMPTY.tip(),
                SysExceptionEnum.DB_SQL_ID_EMPTY.msg(), "");
    }

    /**
     * sqlId 不能为空
     */
    public static DaoException DB_SQL_ID_EMPTY(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_SQL_ID_EMPTY.code(),
                SysExceptionEnum.DB_SQL_ID_EMPTY.tip(),
                SysExceptionEnum.DB_SQL_ID_EMPTY.msg(), sqlId);
    }


    public static DaoException DB_UNSUPPORTTYPE(String sqlId) {
        return new DaoException(SysExceptionEnum.DB_UNSUPPORTTYPE.code(),
                SysExceptionEnum.DB_UNSUPPORTTYPE.tip(),
                SysExceptionEnum.DB_UNSUPPORTTYPE.msg(), sqlId);
    }

}
