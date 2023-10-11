package com.example.seventeenthwork;


//创建国家类
public class Country {
    //国家名称
    private String name;
    //国家图片的id
    private int imageId;
    //国家描述
    private String description;

    public Country() {
    }

    public Country(String name, int imageId, String description) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
