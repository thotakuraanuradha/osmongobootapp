package com.stackroute.mashupcontent.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MashupContentSequence")
@Builder
/*counter entity class for storing sequence value*/
public class MashupContentSequence {

    @Id
    public String id;
    public int seq;

    public MashupContentSequence() {
    }

    public MashupContentSequence(String id, int seq) {
        this.id = id;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
