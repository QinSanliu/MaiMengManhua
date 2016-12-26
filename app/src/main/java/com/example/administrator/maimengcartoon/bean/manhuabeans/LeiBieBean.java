package com.example.administrator.maimengcartoon.bean.manhuabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */

public class LeiBieBean {

    /**
     * page : 1
     * r : cartoonCategory/list
     * size : 10
     * REQUEST_METHOD : GET
     */

    private ParamsBean params;
    /**
     * countTotal : 20
     * otherType : 0
     * otherTitle :
     */

    private ExtraInfoBean extraInfo;
    /**
     * params : {"page":"1","r":"cartoonCategory/list","size":"10","REQUEST_METHOD":"GET"}
     * extraInfo : {"countTotal":"20","otherType":0,"otherTitle":""}
     * code : 0
     * error :
     * results : [{"id":"21","name":"最新上架","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/17899dfe87eaba1c0b4595f8202fc5c8_92202.jpeg","useType":"1","priority":"0","status":"1","remark":"大波新秀登场","createTime":"2016-09-27 11:37:25","modifyTime":"2016-09-27 11:37:25","userID":"","showMode":"0"},{"id":"20","name":"最新更新","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/9fb2b875891c451dbff0ec679367c3b0_94847.jpeg","useType":"1","priority":"1","status":"1","remark":"大大填坑啦！","createTime":"2016-09-27 11:37:18","modifyTime":"2016-09-27 11:37:18","userID":"","showMode":"1"},{"id":"19","name":"完结漫画","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/58baedbb1f640a7570158cbae33acaa3_105971.jpeg","useType":"1","priority":"1","status":"1","remark":"完结撒花~","createTime":"2016-09-27 11:37:08","modifyTime":"2016-09-27 11:37:08","userID":"","showMode":"0"},{"id":"2","name":"恋爱","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/6097e807fdc987b05ddcd55cde9dcaea_86997.jpeg","useType":"0","priority":"2","status":"1","remark":"甜蜜又有苦涩","createTime":"2016-09-18 14:35:23","modifyTime":"2016-09-18 14:35:23","userID":"","showMode":"0"},{"id":"3","name":"运动","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/bc3b8d1c3a651dc8080c033281ba1c4c_65315.jpeg","useType":"0","priority":"3","status":"1","remark":"青春和汗水","createTime":"2016-09-19 11:42:48","modifyTime":"2016-09-19 11:42:48","userID":"","showMode":"0"},{"id":"14","name":"耽美","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/9af15ef5c07bae51004d6793afe9d167_56827.jpeg","useType":"0","priority":"4","status":"1","remark":"天下大同~","createTime":"2016-09-18 17:11:28","modifyTime":"2016-09-18 17:11:28","userID":"","showMode":"0"},{"id":"5","name":"搞笑","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/f76694f3d4bfedb9948fbe8e46ee6524_47289.jpeg","useType":"0","priority":"5","status":"1","remark":"哈哈哈哈哈哈","createTime":"2016-09-18 17:11:44","modifyTime":"2016-09-18 17:11:44","userID":"","showMode":"0"},{"id":"8","name":"校园","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/124d3cd9ead1c88a665f9701f57e6a0b_58004.jpeg","useType":"0","priority":"6","status":"1","remark":"青春还是搞怪","createTime":"2016-09-19 11:41:29","modifyTime":"2016-09-19 11:41:29","userID":"","showMode":"0"},{"id":"23","name":"冒险","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/e1249cb00bdbfd3109e71f733f44f095_74398.jpeg","useType":"0","priority":"7","status":"1","remark":"被选中的孩子","createTime":"2016-09-18 17:12:01","modifyTime":"2016-09-18 17:12:01","userID":"10","showMode":"0"},{"id":"1","name":"热血","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/3218321cd12fac72b271504887a6d449_63639.jpeg","useType":"0","priority":"8","status":"1","remark":"你燃起来了嘛","createTime":"2016-09-19 11:41:58","modifyTime":"2016-09-19 11:41:58","userID":"","showMode":"0"}]
     */

    private int code;
    private String error;
    /**
     * id : 21
     * name : 最新上架
     * images : http://7xkbpd.com2.z0.glb.qiniucdn.com/17899dfe87eaba1c0b4595f8202fc5c8_92202.jpeg
     * useType : 1
     * priority : 0
     * status : 1
     * remark : 大波新秀登场
     * createTime : 2016-09-27 11:37:25
     * modifyTime : 2016-09-27 11:37:25
     * userID :
     * showMode : 0
     */

    private List<ResultsBean> results;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public ExtraInfoBean getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfoBean extraInfo) {
        this.extraInfo = extraInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ParamsBean {
        private String page;
        private String r;
        private String size;
        private String REQUEST_METHOD;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getREQUEST_METHOD() {
            return REQUEST_METHOD;
        }

        public void setREQUEST_METHOD(String REQUEST_METHOD) {
            this.REQUEST_METHOD = REQUEST_METHOD;
        }
    }

    public static class ExtraInfoBean {
        private String countTotal;
        private int otherType;
        private String otherTitle;

        public String getCountTotal() {
            return countTotal;
        }

        public void setCountTotal(String countTotal) {
            this.countTotal = countTotal;
        }

        public int getOtherType() {
            return otherType;
        }

        public void setOtherType(int otherType) {
            this.otherType = otherType;
        }

        public String getOtherTitle() {
            return otherTitle;
        }

        public void setOtherTitle(String otherTitle) {
            this.otherTitle = otherTitle;
        }
    }

    public static class ResultsBean {
        private String id;
        private String name;
        private String images;
        private String useType;
        private String priority;
        private String status;
        private String remark;
        private String createTime;
        private String modifyTime;
        private String userID;
        private String showMode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getUseType() {
            return useType;
        }

        public void setUseType(String useType) {
            this.useType = useType;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getShowMode() {
            return showMode;
        }

        public void setShowMode(String showMode) {
            this.showMode = showMode;
        }
    }
}
