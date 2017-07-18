package com.example.lenovo_pc.myproject.mvp.model.bean;

/**
 * 作者：李飞宇
 * 时间：2017/7/17 21:09
 * 功能：注册的Bean
 */

public class RegisterBean {
    /**
     * code : 400
     * datas : {"error":"请填写用户名"}
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
         * error : 请填写用户名
         */

        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
