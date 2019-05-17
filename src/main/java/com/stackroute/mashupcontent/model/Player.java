package com.stackroute.mashupcontent.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Player {

    @Id
    private ObjectId _Id;

    private String contentType;

    private String contentDesc;

    private String contentTitle;


    public Player(ObjectId _Id, String contentType, String contentDesc, String contentTitle) {
        this._Id = _Id;
        this.contentType = contentType;
        this.contentDesc = contentDesc;
        this.contentTitle = contentTitle;
    }

    public Player() {
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _Id.toHexString(); }
    public void set_id(ObjectId _id) { this._Id = _id; }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    @Override
    public String toString() {
        return "Player{" +
                "contentId=" + _Id +
                ", contentType='" + contentType + '\'' +
                ", contentDesc='" + contentDesc + '\'' +
                ", contentTitle='" + contentTitle + '\'' +
                '}';
    }



}
