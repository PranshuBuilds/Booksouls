package com.crazy.booksoul.main.home;

public class SliderItem {
   String imageUrl;
   String imageDiscrption;
   SliderItem(){

    }
    public SliderItem(String imageUrl, String imageDiscription){
        this.imageDiscrption=imageDiscription;
        this.imageUrl=imageUrl;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageDiscrption() {
        return imageDiscrption;
    }

    public void setImageDiscrption(String imageDiscrption) {
        this.imageDiscrption = imageDiscrption;
    }
}
