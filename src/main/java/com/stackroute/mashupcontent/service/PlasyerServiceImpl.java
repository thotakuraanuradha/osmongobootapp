package com.stackroute.mashupcontent.service;

import com.stackroute.mashupcontent.comman.RequestDto;
import com.stackroute.mashupcontent.comman.ResponseDto;
import com.stackroute.mashupcontent.model.Player;
import com.stackroute.mashupcontent.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlasyerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepo;

    ResponseDto responseDto;


    public ResponseDto createContent(RequestDto requestDto){

       Player player =  playerRepo.save(requestDto.getPlayer());

        responseDto.setPlayer(player);

        return responseDto;
    }




}
