package com.stackroute.mashupcontent.repositories;

import com.stackroute.mashupcontent.model.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PlayerRepository extends MongoRepository<Player, String> {

    Player findBy_id(String _Id);
}
