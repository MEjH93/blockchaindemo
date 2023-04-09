package org.boskovic;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Blockchain {

    private final List<Block> chain;

    public Blockchain(){
        this.chain = new LinkedList<>();
    }

    public void addBlock(Block block){
        this.chain.add(block);
    }

    public int getSize(){
        return this.chain.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Block block: this.chain){
            s.append(block.toString());
        }
        return s.toString();
    }
}
