package com.example.lenovo_pc.myproject.mvp.model.bean;

/**
 * 作者：李飞宇
 * 时间：2017/7/17 21:09
 * 功能：注册的用户信息数据库的Bean
 */

public class RegisterBean {
    private String member_name;
    private String member_passwd;
    private String member_email;

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_passwd() {
        return member_passwd;
    }

    public void setMember_passwd(String member_passwd) {
        this.member_passwd = member_passwd;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }
}
