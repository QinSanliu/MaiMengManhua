package com.example.administrator.maimengcartoon.bean.zixunbean;

import java.util.List;

/**
 * Created by Administrator on 2016-12-14.
 */

public class ZiXunSubjectEntrity {

    /**
     * order : priority
     * page : 1
     * r : special/list
     * size : 2
     * REQUEST_METHOD : GET
     */

    private ParamsBean params;
    /**
     * countTotal : 29
     */

    private ExtraInfoBean extraInfo;
    /**
     * params : {"order":"priority","page":"1","r":"special/list","size":"2","REQUEST_METHOD":"GET"}
     * extraInfo : {"countTotal":"29"}
     * code : 0
     * error :
     * results : [{"messageCount":"79","id":"6","name":"补番推荐","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/9ae3300f3630a623ff51ee866a0030d7_59612.jpeg","thumbnail":"http://7xkbpd.com2.z0.glb.qiniucdn.com/005e657f654012b01988726013685014_102624.jpeg","beginTime":"2016-05-20 00:00:00","endTime":"2018-05-27 00:00:00","priority":"100","status":"1","createTime":"2016-04-18 12:55:31","modifyTime":"2016-10-03 10:08:07","userID":"38","content":"不管是表番还是里番，上古老番还是最热新番，只有你没看过，没有你不想看！"},{"messageCount":"39","id":"15","name":"经典回顾","images":"http://7xkbpd.com2.z0.glb.qiniucdn.com/57320a19e36f6fe04ce9a919adbe182e_57149.jpeg","thumbnail":"http://7xkbpd.com2.z0.glb.qiniucdn.com/963cd1392681bb9e62f4117e3795c2a4_62452.jpeg","beginTime":"2016-05-20 00:00:00","endTime":"2018-05-27 00:00:00","priority":"99","status":"1","createTime":"2016-05-20 17:28:39","modifyTime":"2016-10-03 10:08:26","userID":"38","content":"漫漫追番路，你可曾有过那些记忆深刻的经典呢？"}]
     */

    private int code;
    private String error;
    /**
     * messageCount : 79
     * id : 6
     * name : 补番推荐
     * images : http://7xkbpd.com2.z0.glb.qiniucdn.com/9ae3300f3630a623ff51ee866a0030d7_59612.jpeg
     * thumbnail : http://7xkbpd.com2.z0.glb.qiniucdn.com/005e657f654012b01988726013685014_102624.jpeg
     * beginTime : 2016-05-20 00:00:00
     * endTime : 2018-05-27 00:00:00
     * priority : 100
     * status : 1
     * createTime : 2016-04-18 12:55:31
     * modifyTime : 2016-10-03 10:08:07
     * userID : 38
     * content : 不管是表番还是里番，上古老番还是最热新番，只有你没看过，没有你不想看！
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
        private String order;
        private String page;
        private String r;
        private String size;
        private String REQUEST_METHOD;

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

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

        public String getCountTotal() {
            return countTotal;
        }

        public void setCountTotal(String countTotal) {
            this.countTotal = countTotal;
        }
    }

    public static class ResultsBean {
        private String messageCount;
        private String id;
        private String name;
        private String images;
        private String thumbnail;
        private String beginTime;
        private String endTime;
        private String priority;
        private String status;
        private String createTime;
        private String modifyTime;
        private String userID;
        private String content;

        public String getMessageCount() {
            return messageCount;
        }

        public void setMessageCount(String messageCount) {
            this.messageCount = messageCount;
        }

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

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
