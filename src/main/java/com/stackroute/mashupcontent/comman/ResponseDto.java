package com.stackroute.mashupcontent.comman;

import com.stackroute.mashupcontent.model.MashupContent;


import java.util.ArrayList;
import java.util.List;

public class ResponseDto {

    private MashupContent mashupContent;

    List<MashupContent> mashupContentList = new ArrayList<>();

    public MashupContent getMashupContent() {
        return mashupContent;
    }

    public void setMashupContent(MashupContent mashupContent) {
        this.mashupContent = mashupContent;
    }

    public List<MashupContent> getMashupContentList() {
        return mashupContentList;
    }

    public void setMashupContentList(List<MashupContent> mashupContentList) {
        this.mashupContentList = mashupContentList;
    }
}
