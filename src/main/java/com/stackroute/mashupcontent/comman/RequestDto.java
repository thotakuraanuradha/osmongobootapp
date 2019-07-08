package com.stackroute.mashupcontent.comman;

import com.stackroute.mashupcontent.model.MashupContent;
import com.stackroute.mashupcontent.model.MashupContent;

public class RequestDto {

    private MashupContent mashupContent;

    private String contentDetails;


    public String getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(String contentDetails) {
        this.contentDetails = contentDetails;
    }

    public MashupContent getMashupContent() {
        return mashupContent;
    }

    public void setMashupContent(MashupContent mashupContent) {
        this.mashupContent = mashupContent;
    }
}
