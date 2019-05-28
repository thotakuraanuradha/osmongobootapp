package com.stackroute.mashupcontent.repositories;

import com.stackroute.mashupcontent.model.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PlayerRepository extends MongoRepository<Player, Integer> {

    //Player findBy_id(int  contentId);
}
