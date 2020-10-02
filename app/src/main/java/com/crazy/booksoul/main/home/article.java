package com.crazy.booksoul.main.home;

public class article {

    public final static int ARTICLE=0;
    public final static int INTERESTING_ARTICLE=1;
    public final static int PODCAST=2;
    public final static int QUICKS=3;
    public final static int PUBLISHER=4;
    public final static int CURATED=5;
    public final static int UPDATED=6;
    public final static int CATEGORY=7;

    private int viewtype;



    public int getViewtype() {
        return viewtype;
    }

    public void setViewtype(int viewtype) {
        this.viewtype = viewtype;
    }

///// ARTICLE LAYOUT
    String imageUrl;
    String title;
    int discription;
    public int progressBar;
    String topic;

    public article(int viewtype, String title, String imageUrl, int discription, int progressBar, String topic){
        this.imageUrl=imageUrl;
        this.discription=discription;
        this.topic=topic;
        this.title=title;
        this.viewtype=viewtype;
        this.progressBar=progressBar;
    }

    public int getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(int progressBar) {
        this.progressBar = progressBar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public  String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getDiscription() {
        return discription;
    }

    public void setDiscription(int discription) {
        this.discription = discription;
    }



    ////interesting article

    String interstingUrl;
    String intretingDiscription;
    String interestingTopic;
    int progress;

    public article(int viewtype, String interestingTopic, String interstingUrl, String intretingDiscription, int progress){
        this.interstingUrl=interstingUrl;
        this.interestingTopic=interestingTopic;
        this.intretingDiscription=intretingDiscription;
        this.progress=progress;
        this.viewtype=viewtype;

    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getInterestingTopic() {
        return interestingTopic;
    }

    public void setInterestingTopic(String interestingTopic) {
        this.interestingTopic = interestingTopic;
    }

    public String getInterstingUrl() {
        return interstingUrl;
    }

    public void setInterstingUrl(String interstingUrl) {
        this.interstingUrl = interstingUrl;
    }

    public String getIntretingDiscription() {
        return intretingDiscription;
    }

    public void setIntretingDiscription(String intretingDiscription) {
        this.intretingDiscription = intretingDiscription;
    }


    ////single string article

    String string;

    public article(int viewtype, String string){
        this.string=string;

        this.viewtype=viewtype;

    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
