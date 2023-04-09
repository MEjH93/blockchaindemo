package org.boskovic;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Block {

    private final int id;
    private final long timestamp;
    private final String previousHash;
    private final String transaction;
    private int nonce;
    private String hash;

    public Block(int id, String transaction, String previousHash){
        this.id = id;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = id
                + previousHash
                + timestamp
                + transaction
                + nonce;
        this.hash = SHA256Helper.generateHash(dataToHash);
    }

    public void incrementNonce(){
        this.nonce++;
    }

}
