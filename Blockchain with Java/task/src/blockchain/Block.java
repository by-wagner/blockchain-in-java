package blockchain;

import util.StringUtil;

import java.util.Date;
import java.util.List;

public class Block {
    private int id;
    private String previousHash;
    private String hash;
    private long timestamp;
    private int magicNumber;
    private List<Transaction> transactions;

    public Block(int id, String previousHash, List<Transaction> transactions) {
        this.id = id;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.transactions = transactions;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        StringBuilder input = new StringBuilder(id + previousHash + timestamp);
        for (Transaction transaction : transactions) {
            input.append(transaction.toString());
        }
        input.append(magicNumber);
        return StringUtil.applySha256(input.toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        StringBuilder blockData = new StringBuilder("Block:\n");
        blockData.append("Created by: miner").append(id).append("\n");
        blockData.append("miner").append(id).append(" gets 100 VC\n");
        blockData.append("Id: ").append(id).append("\n");
        blockData.append("Timestamp: ").append(timestamp).append("\n");
        blockData.append("Magic number: ").append(magicNumber).append("\n");
        blockData.append("Hash of the previous block:\n").append(previousHash).append("\n");
        blockData.append("Hash of the block:\n").append(hash).append("\n");
        blockData.append("Block data:\n");
        for (Transaction transaction : transactions) {
            blockData.append(transaction.toString()).append("\n");
        }
        blockData.append("Block was generating for 0 seconds\n");
        blockData.append("N was increased to ").append(magicNumber).append("\n");
        return blockData.toString();
    }
}