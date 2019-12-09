package com.example.demo.bean;

public class UserInfo {
    private Integer uid;
    private String name;
    private String password;
    private String salt;
    private Integer state;
    private String userName;
    
    public String toString()
    {
        return "uid: " + uid +
               "\nname: " + name +
               "\npassword: " + password +
               "\nstate: " + state +
               "\nsalt: " + salt +
               "\nuserName: " + userName;
    }

    public String getCredentialsSalt()
    {
        return this.userName + this.salt;
    }

    /**
     * @return Integer return the id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param id the id to set
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return Integer return the state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return String return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param username the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}