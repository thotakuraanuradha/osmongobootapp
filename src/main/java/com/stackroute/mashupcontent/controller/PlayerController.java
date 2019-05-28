package com.stackroute.mashupcontent.controller;

import com.stackroute.mashupcontent.comman.RequestDto;
import com.stackroute.mashupcontent.comman.ResponseDto;
import com.stackroute.mashupcontent.loggerclient.LogUtils;
import com.stackroute.mashupcontent.model.Player;
import com.stackroute.mashupcontent.repositories.PlayerRepository;
import com.stackroute.mashupcontent.service.PlayerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin("*")
@RequestMapping("/player")
@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    PlayerService playerService;

    private static final Logger logger = LogManager.getLogger();



    @RequestMapping(value = "/home", method = GET)
    public String Hello(){
        return "application is up ";
    }

    @RequestMapping(value = "/", method = POST)
    public ResponseEntity<String> craeteContent(@Valid @RequestBody RequestDto requestDto) {

        ResponseDto responseDto = new ResponseDto();
        ResponseEntity responseEntity = null;


        try{
            responseDto = playerService.createContent(requestDto);
            ObjectMapper mapper = new ObjectMapper();
           // responseDto.setPlayer(player);

            String jsonInString = null;
            try {
                jsonInString = mapper.writeValueAsString(responseDto);
            } catch (JsonProcessingException e) {
                LogUtils.logError(logger, "createContent  JSON Processing error !" + e.getMessage());
            }

            responseEntity = new ResponseEntity(jsonInString, HttpStatus.OK);

            LogUtils.logInfo(logger, "Player Controller with createContent info. End:::");
        }catch(Exception ex) {

            LogUtils.logInfo(logger, "Exceptiion in  createContent :"+ex.getMessage());
        }
        return responseEntity;

    }



    @RequestMapping(value = "/", method =GET)
    public ResponseEntity<String> getContent() {

        ResponseDto responseDto = new ResponseDto();
        ResponseEntity responseEntity = null;


        try{
           List<Player> playerList = playerRepo.findAll();
            ObjectMapper mapper = new ObjectMapper();
            responseDto.setPlayerList(playerList);

            String jsonInString = null;
            try {
                jsonInString = mapper.writeValueAsString(responseDto);
            } catch (JsonProcessingException e) {
                LogUtils.logError(logger, "getContent  JSON Processing error !" + e.getMessage());
            }

            responseEntity = new ResponseEntity(jsonInString, HttpStatus.OK);

            LogUtils.logInfo(logger, "Player Controller with getContent info. End:::");
        }catch(Exception ex) {

            LogUtils.logInfo(logger, "Exceptiion in  getContent :"+ex.getMessage());
        }
        return responseEntity;

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getContentById(@PathVariable("id") int id) {


        ResponseDto responseDto = new ResponseDto();
        ResponseEntity responseEntity = null;


        try{
            Optional<Player> optional= playerRepo.findById(id);

            Player player = optional.get();
            ObjectMapper mapper = new ObjectMapper();
            responseDto.setPlayer(player);

            String jsonInString = null;
            try {
                jsonInString = mapper.writeValueAsString(responseDto);
            } catch (JsonProcessingException e) {
                LogUtils.logError(logger, "getContentById  JSON Processing error !" + e.getMessage());
            }

            responseEntity = new ResponseEntity(jsonInString, HttpStatus.OK);

            LogUtils.logInfo(logger, "Player Controller with getContentById info. End:::");
        }catch(Exception ex) {

            LogUtils.logInfo(logger, "Exceptiion in  getContentById :"+ex.getMessage());
        }
        return responseEntity;

    }


//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public void modifyContentById(@PathVariable("id") String id, @Valid @RequestBody RequestDto requestDto) {
//
//        requestDto.getPlayer().set_id(id);
//        playerRepo.save(pets);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteContent(@PathVariable int id) {

        ResponseDto responseDto = new ResponseDto();
        ResponseEntity responseEntity = null;
        try {


                playerRepo.delete(playerRepo.findById(id).get());


                responseEntity = new ResponseEntity(HttpStatus.OK);

            LogUtils.logInfo(logger, "Player Controller with deletecontent info. End:::");


        }catch(Exception ex) {

            LogUtils.logInfo(logger, "Exceptiion in  delete :"+ex.getMessage());
        }
        return responseEntity;

    }

}
