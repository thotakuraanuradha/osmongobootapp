package com.stackroute.mashupcontent.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection="MashupContent")
public class MashupContent {

    @Id
    public int contentId;
    @Field
    private String contentType;
    @Field
    private String contentDesc;
    @Field
    private String contentTitle;
    @Field
    private String  inputFormat;
    @Field
    private String outputFormat;
    @Field
    private String difficulty;
    @Field
    private String tags;
    @Field
    private String gitUrl;
    @Field
    private String username;
    @Field
    private String branchName;
    //@Field
   // private String contentDetails;
    @Field
    private String commitHash;



    public MashupContent() {
    }

    public MashupContent(int contentId, String contentType, String contentDesc, String contentTitle, String inputFormat, String outputFormat, String difficulty, String tags, String gitUrl, String username, String branchName) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.contentDesc = contentDesc;
        this.contentTitle = contentTitle;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.difficulty = difficulty;
        this.tags = tags;
        this.gitUrl = gitUrl;
        this.username = username;
        this.branchName = branchName;
    }





    public String getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(String commitHash) {
        this.commitHash = commitHash;
    }



    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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
                "contentId='" + contentId + '\'' +
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
