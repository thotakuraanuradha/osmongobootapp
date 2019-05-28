package com.stackroute.mashupcontent.service;

import com.mongodb.*;
import com.stackroute.mashupcontent.comman.RequestDto;
import com.stackroute.mashupcontent.comman.ResponseDto;
import com.stackroute.mashupcontent.exceptions.ContentAlreadyExistsException;
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

        Player player = requestDto.getPlayer();
        BasicDBObject document = new BasicDBObject();
        document.put("Id", getNextSequence("contentId"));
        Object id1=document.get("Id");
            player.setContentId(((Double)id1).intValue()+1);

        if(playerRepo.existsById((int)(player.getContentId()))) {
            try {
                throw new ContentAlreadyExistsException("This Content already exists");
            }catch(Exception ex){

                ex.printStackTrace();
            }
        }

        String tag=player.getTags().toLowerCase();

        player.setTags(tag);
        //save call of repository


        player =  playerRepo.save(player);
        responseDto = new ResponseDto();
        responseDto.setPlayer(player);

        return responseDto;
    }

    /*method for incrementing sequence value*/
    public static Object getNextSequence(String name){
        MongoClient mongoClient = new MongoClient("mongodb://user680:xyrnTtIFThASX8De@mongodb/contentRepoDB");
        DB db = mongoClient.getDB("contentDB");
        DBCollection collection = db.getCollection("counters");
        BasicDBObject find = new BasicDBObject();
        BasicDBObject update = new BasicDBObject();
        update.put("$inc", new BasicDBObject("seq", 1));
        DBObject obj = collection.findAndModify(find, update);
        Object i = obj.get("seq");
        return i;
    }



}
