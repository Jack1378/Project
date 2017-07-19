package com.example.lenovo_pc.myproject.mvp.model.bean;

/**
 * 作者：李飞宇
 * 时间：2017/7/19 10:28
 * 功能：登录的Bean
 */

public class LoginBean {


    /**
     * code : 200
     * datas : {"username":"wxfwcf","userid":"6","key":"d3644869715bcda8838084cab887eb7a"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * username : wxfwcf
         * userid : 6
         * key : d3644869715bcda8838084cab887eb7a
         */

        private String username;
        private String userid;
        private String key;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
