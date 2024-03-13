package com.atguigu.crowd.constant;

public final class CrowdConstant {

    /**
     * 账号密码错误提示
     */
    public static final String MESSAGE_LOGIN_FAILED = "抱歉！账号密码错误！请重新输入！";
    /**
     * 账号已注册提示
     */
    public static final String MESSAGE_LOGIN_ACCT_ALREADY_IN_USE = "抱歉！这个账号已经被使用了！";
    /**
     * 未登录访问提示
     */
    public static final String MESSAGE_ACCESS_FORBIDEN = "请登录以后再访问！";
    /**
     * 字符串格式不合法提示
     */
    public static final String MESSAGE_STRING_INVALIDATE = "字符串不合法！请不要传入空字符串！";
    /**
     * 登录账号重复提示
     */
    public static final String MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE = "系统错误：登录账号不唯一！";
    /**
     * Exception对象的视图名前缀
     */
    public static final String ATTR_NAME_EXCEPTION = "exception";
    /**
     * admin对象在Session域的前缀
     */
    public static final String ATTR_NAME_LOGIN_ADMIN = "loginAdmin";
    /**
     * PageInfo对象在模型中的前缀
     */
    public static final String ATTR_NAME_PAGE_INFO = "pageInfo";
    /**
     * 按照16进制将bigInteger的值转换为字符串
     */
    public static final int RADIX = 16;

    private CrowdConstant() {}

}
