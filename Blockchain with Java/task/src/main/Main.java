package main;

import blockchain.Block;
import blockchain.Blockchain;
import blockchain.Miner;
import blockchain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Blockchain blockchain = new Blockchain();

            Miner miner1 = new Miner("miner1");
            Miner miner2 = new Miner("miner2");
            Miner miner3 = new Miner("miner3");
            Miner miner4 = new Miner("miner4");
            Miner miner5 = new Miner("miner5");
            Miner miner6 = new Miner("miner6");
            Miner miner7 = new Miner("miner7");
            Miner miner8 = new Miner("miner8");
            Miner miner9 = new Miner("miner9");

            blockchain.addInitialBalance(miner1.getName(), 100);
            blockchain.addInitialBalance(miner2.getName(), 100);
            blockchain.addInitialBalance(miner3.getName(), 100);
            blockchain.addInitialBalance(miner4.getName(), 100);
            blockchain.addInitialBalance(miner5.getName(), 100);
            blockchain.addInitialBalance(miner6.getName(), 100);
            blockchain.addInitialBalance(miner7.getName(), 100);
            blockchain.addInitialBalance(miner8.getName(), 100);
            blockchain.addInitialBalance(miner9.getName(), 100);

            List<Transaction> transactions = new ArrayList<>();
            transactions.add(new Transaction("miner9", "miner1", 30));
            transactions.add(new Transaction("miner9", "miner2", 30));
            transactions.add(new Transaction("miner9", "Nick", 30));

            Block block1 = miner9.mineBlock(1, "0", transactions);
            blockchain.addBlock(block1);

            transactions = new ArrayList<>();
            transactions.add(new Transaction("miner9", "Bob", 10));
            transactions.add(new Transaction("miner7", "Alice", 10));
            transactions.add(new Transaction("Nick", "ShoesShop", 1));
            transactions.add(new Transaction("Nick", "FastFood", 2));
            transactions.add(new Transaction("Nick", "CarShop", 15));
            transactions.add(new Transaction("miner7", "CarShop", 90));

            Block block2 = miner7.mineBlock(2, block1.getHash(), transactions);
            blockchain.addBlock(block2);

            transactions = new ArrayList<>();
            transactions.add(new Transaction("CarShop", "Worker1", 10));
            transactions.add(new Transaction("CarShop", "Worker2", 10));
            transactions.add(new Transaction("CarShop", "Worker3", 10));
            transactions.add(new Transaction("CarShop", "Director1", 30));
            transactions.add(new Transaction("CarShop", "CarPartsShop", 45));
            transactions.add(new Transaction("Bob", "GamingShop", 5));
            transactions.add(new Transaction("Alice", "BeautyShop", 5));

            Block block3 = miner1.mineBlock(3, block2.getHash(), transactions);
            blockchain.addBlock(block3);

            for (int i = 4; i <= 15; i++) {
                transactions = new ArrayList<>();
                transactions.add(new Transaction("miner" + ((i - 1) % 9 + 1), "miner" + (i % 9 + 1), 10));
                Miner currentMiner = new Miner("miner" + (i % 9 + 1));
                Block newBlock = currentMiner.mineBlock(i, blockchain.getBlocks().get(blockchain.getBlocks().size() - 1).getHash(), transactions);
                blockchain.addBlock(newBlock);
            }

            for (Block block : blockchain.getBlocks()) {
                System.out.println(block);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}