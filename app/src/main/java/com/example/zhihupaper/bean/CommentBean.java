package com.example.zhihupaper.bean;

import java.util.List;

/**
 * Created by xubinhong on 2018/1/14.
 */

public class CommentBean {

    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * author : 李悦佳l
         * content : 香港最低工时13000  一个master15000 不可信
         * avatar : http://pic4.zhimg.com/4a7769d3b_im.jpg
         * time : 1515910474
         * reply_to : {"content":"我在香港读的master，然后在香港某世界500强公司做程序猿，起薪1.5w，5年了，每年大概300-400hkd的涨幅; 我老公，刚认识的时候月薪5000(在内地)，也是程序猿，现在税后3w+。(*T▽T*)我才是那个生活在水深火热之中的！\n\nPS. 你的文字一点也不像只有高中文凭(除了几个错别字)。有想法，又肯干，看好你哦！","status":0,"id":30978273,"author":"菡菡菡菡菡菡菡菡"}
         * id : 30980534
         * likes : 0
         */

        private String author;
        private String content;
        private String avatar;
        private int time;
        private ReplyToBean reply_to;
        private int id;
        private int likes;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public ReplyToBean getReply_to() {
            return reply_to;
        }

        public void setReply_to(ReplyToBean reply_to) {
            this.reply_to = reply_to;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public static class ReplyToBean {
            /**
             * content : 我在香港读的master，然后在香港某世界500强公司做程序猿，起薪1.5w，5年了，每年大概300-400hkd的涨幅; 我老公，刚认识的时候月薪5000(在内地)，也是程序猿，现在税后3w+。(*T▽T*)我才是那个生活在水深火热之中的！

             PS. 你的文字一点也不像只有高中文凭(除了几个错别字)。有想法，又肯干，看好你哦！
             * status : 0
             * id : 30978273
             * author : 菡菡菡菡菡菡菡菡
             */

            private String content;
            private int status;
            private int id;
            private String author;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }
        }
    }
}
