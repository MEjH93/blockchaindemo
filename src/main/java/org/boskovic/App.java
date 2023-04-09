package org.boskovic;

public class App {
    public static void main( String[] args ) {
        Blockchain chain = new Blockchain();
        Miner miner = new Miner();

        Block genesisBlock = new Block(0, "", Constants.GENESIS_BLOCK);
        miner.mine(genesisBlock, chain);

        Block block1 = new Block(1, "transaction1", chain.getChain().get(chain.getSize() - 1).getHash());
        miner.mine(block1, chain);

        Block block2 = new Block(2, "transaction2", chain.getChain().get(chain.getSize() - 1).getHash());
        miner.mine(block2, chain);

        Block block3 = new Block(3, "transaction3", chain.getChain().get(chain.getSize() - 1).getHash());
        miner.mine(block3, chain);

        System.out.println("Blockchain: " + chain);
        System.out.println("Miner's reward: " + miner.getReward());
    }
}
