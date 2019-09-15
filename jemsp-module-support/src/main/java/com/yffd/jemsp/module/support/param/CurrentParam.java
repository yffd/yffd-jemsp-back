package com.yffd.jemsp.module.support.param;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 系统当前执行参数，由架构进行属性赋值
 */
public class CurrentParam implements Serializable {
    private static final long serialVersionUID = 6536059439316710578L;
    private String userId;
    private String userName;
    private String orgId;
    private String orgName;
    private Set<String> roles;
    private Set<String> permissions;
    private Date operateTime;

    public CurrentParam() {
    }

    public CurrentParam(String userId, String userName, String orgId, String orgName,
                        Set<String> roles, Set<String> permissions, Date operateTime) {
        this.userId = userId;
        this.userName = userName;
        this.orgId = orgId;
        this.orgName = orgName;
        this.roles = roles;
        this.permissions = permissions;
        this.operateTime = operateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
