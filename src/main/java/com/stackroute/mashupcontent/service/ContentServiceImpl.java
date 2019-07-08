package com.stackroute.mashupcontent.service;

import com.mongodb.*;
import com.stackroute.mashupcontent.comman.RequestDto;
import com.stackroute.mashupcontent.comman.ResponseDto;
import com.stackroute.mashupcontent.exceptions.ContentAlreadyExistsException;
import com.stackroute.mashupcontent.model.MashupContent;
import com.stackroute.mashupcontent.model.MashupContentSequence;
import com.stackroute.mashupcontent.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.FindAndModifyOptions;


@Service
public class  ContentServiceImpl implements ContentService {

    @Autowired
    ContentRepository contentRepo;

    ResponseDto responseDto;

    @Autowired
    private MongoOperations mongoOperation;


    public ResponseDto createContent(RequestDto requestDto){

        MashupContent mashupContent = requestDto.getMashupContent();

        //Integer seqId = getNextSequence("mashupcontentseq");

    //      player.setContentId(seqId);

        mashupContent.setContentId((getNextSequenceId("mashupcontentseq")));

        if(contentRepo.existsById(mashupContent.getContentId())) {
            try {
                throw new ContentAlreadyExistsException("This Content already exists");
            }catch(Exception ex){

                ex.printStackTrace();
            }
        }

        String tag=mashupContent.getTags().toLowerCase();
        String str = requestDto.getContentDetails();
        str = str.replaceAll("\\<.*?\\>", "");
        str = str.replaceAll("\\&quot;.*?", "");
      //  str = str.replaceAll("\\\n.*?", " ");
        str = str.replaceAll("\\&lt;.*?", "<");

        int idx1=str.indexOf("contentDesc");
        int idx2=str.indexOf("inputFormat");
        int idx3=str.indexOf("outputFormat");
        String title = str.substring(0,idx1);
        String contentDesc = str.substring(idx1,idx2);
        contentDesc = contentDesc.replaceAll("contentDesc:","");
        String inp = str.substring(idx2,idx3);
        inp = inp.replaceAll("inputFormat:","");
        String out = str.substring(idx3,str.length()-1);
        out = out.replaceAll("outputFormat:","");
      //  player.setContentDetails(str);
        mashupContent.setContentDesc(contentDesc);
        mashupContent.setInputFormat(inp);
        mashupContent.setOutputFormat(out);
        mashupContent.setTags(tag);
        mashupContent.setCommitHash(mashupContent.getCommitHash());
        //save call of repository
       // player.setContentDetails(str);

        mashupContent =  contentRepo.save(mashupContent);
        responseDto = new ResponseDto();
        responseDto.setMashupContent(mashupContent);

        return responseDto;
    }


//    public static Integer getNextSequence(String name) {
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        DB db = mongoClient.getDB("mashupdbtest");
//        DBCollection collection = db.getCollection("ContentSequence");
//        BasicDBObject find = new BasicDBObject();
//        BasicDBObject update = new BasicDBObject();
//        update.put("$inc", new BasicDBObject("seq", 1));
//        DBObject obj = collection.findAndModify(find, update);
//
//        Integer seqId = (Integer)obj.get("seq");
//        return seqId;
//    }





    public int getNextSequenceId(String key) {

        //get sequence id
        Query query = new Query(Criteria.where("_id").is(key));

        //increase sequence id by 1
        Update update = new Update();
        update.inc("seq", 1);

        //return new increased id
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        //this is the magic happened.
        MashupContentSequence seqId =
                mongoOperation.findAndModify(query, update, options, MashupContentSequence.class);

        //if no id, throws SequenceException
        //optional, just a way to tell user when the sequence id is failed to generate.
        if (seqId == null) {
            try {
                throw new Exception("Unable to get sequence id for key : " + key);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        return seqId.getSeq();

    }



}
