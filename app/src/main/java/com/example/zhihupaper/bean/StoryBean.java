package com.example.zhihupaper.bean;

import java.util.List;

/**
 * Created by xubinhong on 2018/1/12.
 */

public class StoryBean {

    /**
     * date : 20180112
     * stories : [{"images":["https://pic4.zhimg.com/v2-d2ec4b35c58c8306b37681ed9a9473ff.jpg"],"type":0,"id":9665585,"ga_prefix":"011219","title":"滴滴接盘小蓝单车，峰回路转还是违法难行？"},{"images":["https://pic3.zhimg.com/v2-0138865b4744b4cd68303c2fad866d72.jpg"],"type":0,"id":9665658,"ga_prefix":"011217","title":"9 岁男孩因丢手机，被母亲捆绑棒打 5 小时致死：我们何时才能不旁观？"},{"images":["https://pic3.zhimg.com/v2-440a7bc5432519ac265273f9f3772ae2.jpg"],"type":0,"id":9665540,"ga_prefix":"011217","title":"地球上有哪些超出常人想象的自然现象？"},{"images":["https://pic2.zhimg.com/v2-3d87ffb1757ee0a286804d150a38102d.jpg"],"type":0,"id":9665382,"ga_prefix":"011216","title":"医生们，你们说得不一样啊，我到底该听谁的？"},{"images":["https://pic1.zhimg.com/v2-2c4002959699592f9c90ba9fc25ad908.jpg"],"type":0,"id":9665440,"ga_prefix":"011215","title":"有哪些医学概念已经更新，但不为大众所知？"},{"images":["https://pic3.zhimg.com/v2-fd728c0dbc133a1f9c8672d2fea276d6.jpg"],"type":0,"id":9664876,"ga_prefix":"011213","title":"计算机专业，名校毕业和普通学校毕业有什么差别？"},{"images":["https://pic2.zhimg.com/v2-0bf94b228098daf7346cf26b89ee4371.jpg"],"type":0,"id":9665503,"ga_prefix":"011212","title":"大误 · 叔，我跟你说\u2026\u2026"},{"images":["https://pic2.zhimg.com/v2-dcc8a5af136ede64a66ed40ba3d4c399.jpg"],"type":0,"id":9665456,"ga_prefix":"011210","title":"你知道你错了，可你就是不想认错"},{"images":["https://pic2.zhimg.com/v2-953735ccccebf984bb18b7ae52f743c9.jpg"],"type":0,"id":9664653,"ga_prefix":"011209","title":"这一年，心理咨询再一次改变了我"},{"images":["https://pic1.zhimg.com/v2-c8bbe2fb3450ee5b9ea2fce7bbd498cc.jpg"],"type":0,"id":9665403,"ga_prefix":"011208","title":"22 岁的傅园慧：与其苟延残喘，不如纵情燃烧"},{"images":["https://pic1.zhimg.com/v2-da1440365b3d98e78bc9b471ae111958.jpg"],"type":0,"id":9665483,"ga_prefix":"011207","title":"厌食症和催吐族：她们曾以为控制了体重就控制了人生"},{"title":"身为华人，我成了那家帮《指环王》做特效的公司的艺术总监","ga_prefix":"011207","images":["https://pic3.zhimg.com/v2-a9130db5b11b7253ed065bb69afcc1be.jpg"],"multipic":true,"type":0,"id":9665212},{"images":["https://pic2.zhimg.com/v2-0c01db5d65193685097d3e73abec3bc9.jpg"],"type":0,"id":9665226,"ga_prefix":"011206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-a9f78e0461ed61076fa49a78bf088f24.jpg","type":0,"id":9665585,"ga_prefix":"011219","title":"滴滴接盘小蓝单车，峰回路转还是违法难行？"},{"image":"https://pic4.zhimg.com/v2-473c43bb4601b5acf30f19f3f616ee9b.jpg","type":0,"id":9665658,"ga_prefix":"011217","title":"9 岁男孩因丢手机，被母亲捆绑棒打 5 小时致死：我们何时才能不旁观？"},{"image":"https://pic1.zhimg.com/v2-0b618712d0cc00b9957cd75bbcd248a0.jpg","type":0,"id":9665440,"ga_prefix":"011215","title":"有哪些医学概念已经更新，但不为大众所知？"},{"image":"https://pic2.zhimg.com/v2-4d59f3338b2d140eb71d5b930265b4a9.jpg","type":0,"id":9665456,"ga_prefix":"011210","title":"你知道你错了，可你就是不想认错"},{"image":"https://pic4.zhimg.com/v2-c05a72cfbc64e4e8f24652652dd3bc47.jpg","type":0,"id":9665212,"ga_prefix":"011207","title":"身为华人，我成了那家帮《指环王》做特效的公司的艺术总监"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-d2ec4b35c58c8306b37681ed9a9473ff.jpg"]
         * type : 0
         * id : 9665585
         * ga_prefix : 011219
         * title : 滴滴接盘小蓝单车，峰回路转还是违法难行？
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-a9f78e0461ed61076fa49a78bf088f24.jpg
         * type : 0
         * id : 9665585
         * ga_prefix : 011219
         * title : 滴滴接盘小蓝单车，峰回路转还是违法难行？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
