package com.liying.service;

public class RoleService {

    private String roleName;
    private String roleAge;

    public String test(){
        return "this is the role class!!!";
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleAge() {
        return roleAge;
    }

    public void setRoleAge(String roleAge) {
        this.roleAge = roleAge;
    }
}
