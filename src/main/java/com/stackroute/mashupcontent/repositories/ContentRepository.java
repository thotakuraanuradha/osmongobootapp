package com.stackroute.mashupcontent.repositories;

import com.stackroute.mashupcontent.model.MashupContent;
import com.stackroute.mashupcontent.model.MashupContent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ContentRepository extends MongoRepository<MashupContent, Integer> {

    //Player findBy_id(int  contentId);
}
