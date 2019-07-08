package com.stackroute.mashupcontent.service;

import com.stackroute.mashupcontent.comman.*;
import org.springframework.context.annotation.Bean;



public interface ContentService {

    public ResponseDto createContent(RequestDto requestDto);
}
