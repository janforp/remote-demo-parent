package com.janita.httpclient.bean;

/**
 * Created by Janita on 2017-03-30 13:31
 */
public class RuizhiLogin {

    private String token;
    private String role;
    private String school_code;
    private String user_id;
    private String server_rootdir;
    private Integer result;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSchool_code() {
        return school_code;
    }

    public void setSchool_code(String school_code) {
        this.school_code = school_code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getServer_rootdir() {
        return server_rootdir;
    }

    public void setServer_rootdir(String server_rootdir) {
        this.server_rootdir = server_rootdir;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RuizhiLogin{" +
                "token='" + token + '\'' +
                ", role='" + role + '\'' +
                ", school_code='" + school_code + '\'' +
                ", user_id='" + user_id + '\'' +
                ", server_rootdir='" + server_rootdir + '\'' +
                ", result=" + result +
                '}';
    }
}
