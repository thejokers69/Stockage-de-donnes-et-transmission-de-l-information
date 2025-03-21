package ma.mundiapolis;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<BlockChain> blockChains =  new ArrayList<>();
        List<Transaction> transactions1= new ArrayList<>();
        transactions1.add(new Transaction("Account1", "Account2", 100));// transaction 1
        transactions1.add(new Transaction("Account2", "Account1", 50));// transaction 2
        blockChains.add(new BlockChain(0,transactions1, "0" ));
        List<Transaction> transactions2= new ArrayList<>();

        transactions2.add(new Transaction("Account3", "Account4", 100));// transaction 1
        transactions2.add(new Transaction("Account4", "Account3", 50));// transaction 2

        blockChains.add(new BlockChain(1,transactions2, blockChains.get(0).getCurrentHash() ));
//        blockChains.add(new BlockChain(2,"block 3", blockChains.get(1).getCurrentHash() ));
//        blockChains.add(new BlockChain(3,"block 4", blockChains.get(2).getCurrentHash() ));
//        blockChains.add(new BlockChain(4,"block 5", blockChains.get(3).getCurrentHash() ));

        blockChains.forEach(System.out::println);

        System.out.println(verifyBlockChain(blockChains)?"BlockChain is valid":"BlockChain is not valid");
    }

    private static boolean verifyBlockChain(List<BlockChain> blockChains){
        for (int i = 1; i < blockChains.size(); i++) {
            if(!blockChains.get(i).getPreviousHash().equals(blockChains.get(i-1).getCurrentHash())){
                return false;
            }
        }
        return true;
    }
}