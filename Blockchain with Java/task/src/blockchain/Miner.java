package blockchain;

import java.util.List;

public class Miner {
    private String name;
    private int reward;

    public Miner(String name) {
        this.name = name;
        this.reward = 100;
    }

    public Block mineBlock(int id, String previousHash, List<Transaction> transactions) {
        transactions.add(new Transaction("SYSTEM", name, 100));
        Block newBlock = new Block(id, previousHash, transactions);
        newBlock.setMagicNumber(findMagicNumber(newBlock));
        reward += 100;
        return newBlock;
    }

    private int findMagicNumber(Block block) {
        int magicNumber = 0;
        while (!block.calculateHash().substring(0, 4).equals("0000")) {
            block.setMagicNumber(++magicNumber);
        }
        return magicNumber;
    }

    public String getName() {
        return name;
    }

    public int getReward() {
        return reward;
    }
}