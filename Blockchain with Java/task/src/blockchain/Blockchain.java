package blockchain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blockchain {
    private List<Block> blocks;
    private Map<String, Integer> balances;

    public Blockchain() {
        blocks = new ArrayList<>();
        balances = new HashMap<>();
    }

    public void addBlock(Block block) {
        if (blocks.size() == 0) {
            block.setPreviousHash("0");
        } else {
            block.setPreviousHash(blocks.get(blocks.size() - 1).getHash());
        }

        for (Transaction transaction : block.getTransactions()) {
            String sender = transaction.getSender();
            String recipient = transaction.getRecipient();
            int amount = transaction.getAmount();

            if (!sender.equals("SYSTEM")) {
                int senderBalance = balances.getOrDefault(sender, 0);
                if (senderBalance < amount) {
                    throw new IllegalArgumentException("Insufficient balance for transaction");
                }
                balances.put(sender, senderBalance - amount);
            }

            int recipientBalance = balances.getOrDefault(recipient, 0);
            balances.put(recipient, recipientBalance + amount);
        }

        blocks.add(block);
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public boolean isChainValid() {
        for (int i = 1; i < blocks.size(); i++) {
            Block currentBlock = blocks.get(i);
            Block previousBlock = blocks.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public int getBalance(String address) {
        return balances.getOrDefault(address, 0);
    }

    public void addInitialBalance(String address, int amount) {
        balances.put(address, amount);
    }
}