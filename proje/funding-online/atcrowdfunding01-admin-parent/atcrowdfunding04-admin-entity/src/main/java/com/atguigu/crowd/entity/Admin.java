package com.atguigu.crowd.entity;

/**
 * 管理员实体类.
 */
public class Admin {

    /**
     * 管理员id.
     */
    private Integer id;

    /**
     * 登录账户.
     */
    private String loginAcct;

    /**
     * 用户密码.
     */
    private String userPswd;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 账户创建时间
     */
    private String createTime;

    public Admin() {

    }

    public Admin(Integer id, String loginAcct, String userPswd, String userName, String email, String createTime) {
        super();
        this.id = id;
        this.loginAcct = loginAcct;
        this.userPswd = userPswd;
        this.userName = userName;
        this.email = email;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", loginAcct=" + loginAcct + ", userPswd=" + userPswd + ", userName=" + userName
            + ", email=" + email + ", createTime=" + createTime + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginAcct() {
        return loginAcct;
    }

    public void setLoginAcct(String loginAcct) {
        this.loginAcct = loginAcct == null ? null : loginAcct.trim();
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd == null ? null : userPswd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}
