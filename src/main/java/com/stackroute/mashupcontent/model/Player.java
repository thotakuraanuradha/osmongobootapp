package com.stackroute.mashupcontent.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Player {

    @Id
    private String _id;

    private String contentType;

    private String contentDesc;

    private String contentTitle;
		 
    private String  inputFormat;
    
    private String outputFormat;
    
    private String difficulty;
    
    private String tags;


    private String gitUrl;

    private String username;

    public Player() {
    }

    public Player(String _Id, String contentType, String contentDesc, String contentTitle, String inputFormat, String outputFormat, String difficulty, String tags, String gitUrl, String username) {
        this._id = _Id;
        this.contentType = contentType;
        this.contentDesc = contentDesc;
        this.contentTitle = contentTitle;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.difficulty = difficulty;
        this.tags = tags;
        this.gitUrl = gitUrl;
        this.username = username;
    }


    public String get_Id() {
        return _id;
    }

    public void set_Id(String _Id) {
        this._id = _Id;
    }

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

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Player{" +
                "_Id='" + _id + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contentDesc='" + contentDesc + '\'' +
                ", contentTitle='" + contentTitle + '\'' +
                ", inputFormat='" + inputFormat + '\'' +
                ", outputFormat='" + outputFormat + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", tags='" + tags + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
