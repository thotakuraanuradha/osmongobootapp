package com.stackroute.mashupcontent.repositories;


import com.stackroute.mashupcontent.model.MashupContentSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepo extends MongoRepository<MashupContentSequence, Integer> {
}
