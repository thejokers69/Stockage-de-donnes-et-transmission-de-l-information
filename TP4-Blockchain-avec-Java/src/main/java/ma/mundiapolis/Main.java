package ma.mundiapolis;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<BlockChain> blockChains =  new ArrayList<>();
        blockChains.add(new BlockChain(0,"block 1", "0" ));
        blockChains.add(new BlockChain(1,"block 2", blockChains.get(0).getCurrentHash() ));
        blockChains.add(new BlockChain(2,"block 3", blockChains.get(1).getCurrentHash() ));
        blockChains.add(new BlockChain(3,"block 4", blockChains.get(2).getCurrentHash() ));
        blockChains.add(new BlockChain(4,"block 5", blockChains.get(3).getCurrentHash() ));

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