package soexample.umeng.com.baiyu20181210.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class ShopBean {


    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"代码十万行，单车变摩托","createTime":"2018-12-10T09:19:33","imgUrls":"http://www.zhaoapi.cn/images/quarter/154207742146112.jpg","jid":902,"praiseNum":null,"shareNum":null,"uid":88,"user":{"age":null,"fans":"null","follow":false,"icon":"http://www.zhaoapi.cn/images/88.jpg","nickname":"解杰 ","praiseNum":"null"}},{"commentNum":null,"content":"起来嗨","createTime":"2017-12-11T23:17:18","imgUrls":null,"jid":903,"praiseNum":null,"shareNum":null,"uid":92,"user":{"age":null,"fans":"null","follow":false,"icon":"http://www.zhaoapi.cn/images/151425855261420171226112227.jpg","nickname":"jinlin","praiseNum":"null"}},{"commentNum":null,"content":"藏拙","createTime":"2017-12-12T16:51:40","imgUrls":null,"jid":910,"praiseNum":null,"shareNum":null,"uid":1113,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"123","createTime":"2017-12-12T16:57:16","imgUrls":null,"jid":911,"praiseNum":null,"shareNum":null,"uid":1113,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"而我确实你转念之间就挂过的那阵风","createTime":"2017-12-12T20:54:39","imgUrls":null,"jid":912,"praiseNum":null,"shareNum":null,"uid":1113,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"宋聪聪","createTime":"2018-12-10T09:20:13","imgUrls":"http://www.zhaoapi.cn/images/quarter/1541646030180e.jpg","jid":913,"praiseNum":null,"shareNum":null,"uid":2956,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1517216050414cropped_1517215935857.jpg","nickname":"soul","praiseNum":"null"}},{"commentNum":null,"content":"11","createTime":"2018-12-10T09:20:37","imgUrls":"http://www.zhaoapi.cn/images/quarter/15415809447971.jpeg","jid":932,"praiseNum":null,"shareNum":null,"uid":3028,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513148630412image.jpg","nickname":"14","praiseNum":"null"}},{"commentNum":null,"content":"11","createTime":"2018-12-10T09:21:24","imgUrls":"http://www.zhaoapi.cn/images/quarter/1541579747883timg.jpg","jid":933,"praiseNum":null,"shareNum":null,"uid":3028,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513148630412image.jpg","nickname":"14","praiseNum":"null"}},{"commentNum":null,"content":"11","createTime":"2018-12-10T09:21:00","imgUrls":"http://www.zhaoapi.cn/images/quarter/15415809373521.jpeg","jid":934,"praiseNum":null,"shareNum":null,"uid":3028,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513148630412image.jpg","nickname":"14","praiseNum":"null"}},{"commentNum":null,"content":"1","createTime":"2018-12-10T09:29:45","imgUrls":"http://www.zhaoapi.cn/images/quarter/1541579728383aaa.jpg","jid":935,"praiseNum":null,"shareNum":null,"uid":3028,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513148630412image.jpg","nickname":"14","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public static ShopBean objectFromData(String str) {

        return new Gson().fromJson(str, ShopBean.class);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 代码十万行，单车变摩托
         * createTime : 2018-12-10T09:19:33
         * imgUrls : http://www.zhaoapi.cn/images/quarter/154207742146112.jpg
         * jid : 902
         * praiseNum : null
         * shareNum : null
         * uid : 88
         * user : {"age":null,"fans":"null","follow":false,"icon":"http://www.zhaoapi.cn/images/88.jpg","nickname":"解杰 ","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : http://www.zhaoapi.cn/images/88.jpg
             * nickname : 解杰
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public static UserBean objectFromData(String str) {

                return new Gson().fromJson(str, UserBean.class);
            }

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
