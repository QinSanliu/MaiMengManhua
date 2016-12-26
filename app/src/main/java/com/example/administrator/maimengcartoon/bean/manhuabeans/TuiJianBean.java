package com.example.administrator.maimengcartoon.bean.manhuabeans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */

public class TuiJianBean implements Serializable{
    private ParamsBean params;

    private ExtraInfoBean extraInfo;

    private int code;
    private String error;


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
        private String categorys;
        private String page;
        private String r;
        private String isNew;
        private String size;
        private String REQUEST_METHOD;

        public String getCategorys() {
            return categorys;
        }

        public void setCategorys(String categorys) {
            this.categorys = categorys;
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

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
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

    public static class ResultsBean implements Serializable{
        private String id;
        private String title;
        private String type;
        private String valueType;
        private String valueID;
        private String url;
        private String showMode;
        private String showNums;
        private String priority;
        private String status;
        private String desc;
        private String createTime;
        private String modifyTime;
        private String userID;
        private String icon;
        private String images;
        private String images2;




        private List<CartoonSetListBean> cartoonSetList;
        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getImages2() {
            return images2;
        }

        public void setImages2(String images2) {
            this.images2 = images2;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValueType() {
            return valueType;
        }

        public void setValueType(String valueType) {
            this.valueType = valueType;
        }

        public String getValueID() {
            return valueID;
        }

        public void setValueID(String valueID) {
            this.valueID = valueID;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getShowMode() {
            return showMode;
        }

        public void setShowMode(String showMode) {
            this.showMode = showMode;
        }

        public String getShowNums() {
            return showNums;
        }

        public void setShowNums(String showNums) {
            this.showNums = showNums;
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

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<CartoonSetListBean> getCartoonSetList() {
            return cartoonSetList;
        }

        public void setCartoonSetList(List<CartoonSetListBean> cartoonSetList) {
            this.cartoonSetList = cartoonSetList;
        }

        public static class CartoonSetListBean implements Serializable{
            private String id;
            private String name;
            private String images;
            private String introduction;
            private String author;
            private String readMode;
            private String status;
            private String isOver;
            private String priority;
            private String modifyTime;
            private String totalChapterCount;
            private String updateInfo;
            private String categoryLabel;

            public String getCategoryLabel() {
                return categoryLabel;
            }

            public void setCategoryLabel(String categoryLabel) {
                this.categoryLabel = categoryLabel;
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

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getReadMode() {
                return readMode;
            }

            public void setReadMode(String readMode) {
                this.readMode = readMode;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIsOver() {
                return isOver;
            }

            public void setIsOver(String isOver) {
                this.isOver = isOver;
            }

            public String getPriority() {
                return priority;
            }

            public void setPriority(String priority) {
                this.priority = priority;
            }

            public String getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(String modifyTime) {
                this.modifyTime = modifyTime;
            }

            public String getTotalChapterCount() {
                return totalChapterCount;
            }

            public void setTotalChapterCount(String totalChapterCount) {
                this.totalChapterCount = totalChapterCount;
            }

            public String getUpdateInfo() {
                return updateInfo;
            }

            public void setUpdateInfo(String updateInfo) {
                this.updateInfo = updateInfo;
            }
        }
    }
}
