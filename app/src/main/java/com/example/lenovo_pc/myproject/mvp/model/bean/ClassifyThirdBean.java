package com.example.lenovo_pc.myproject.mvp.model.bean;

import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/7/20 20:12
 * 功能：三级列表的Bean类 参数
 */

public class ClassifyThirdBean {
    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"234","gc_name":"桌布/罩件"},{"gc_id":"235","gc_name":"地毯地垫"},{"gc_id":"236","gc_name":"沙发垫套"},{"gc_id":"237","gc_name":"相框/相片墙"},{"gc_id":"238","gc_name":"墙画墙贴"},{"gc_id":"239","gc_name":"节庆饰品"},{"gc_id":"240","gc_name":"手工/十字绣"},{"gc_id":"241","gc_name":"工艺摆件"},{"gc_id":"242","gc_name":"其他"}]}
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
        private List<ClassListBean> class_list;

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 234
             * gc_name : 桌布/罩件
             */

            private String gc_id;
            private String gc_name;

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }
        }
    }
}
