package yuhaoz18;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * HashChaining
 */
public class ChainedHashing extends Hashing {
    private ArrayList<LinkedList<int[]>> outerList;

    public ChainedHashing() {
        outerList = new ArrayList<LinkedList<int[]>>();
        int i = SIZE;
        while(i-- != 0){
            outerList.add(new LinkedList<int[]>());
        }
    }
    
    @Override
    public int search(int k) throws Exception {
        for(int[] kvPair: outerList.get(hash(k))) {
            if(kvPair[0] == k)
                return kvPair[1];
        }
        throw new Exception("Key " + k + " Not Exist!");
    }

    @Override
    public void set(int k, int v) {
        for(int[] kvPair: outerList.get(hash(k))) {
            if(kvPair[0] == k){
                kvPair[1] = v;
                return;
            }
        }
        outerList.get(hash(k)).add(new int[]{k, v});
    }

    @Override
    public void delete(int k) throws Exception {
        for(int i = 0; i < outerList.get(hash(k)).size(); i++) {
            if(outerList.get(hash(k)).get(i)[0] == k){
                outerList.get(hash(k)).remove(i);
                return;
            }
        }
        throw new Exception("Key " + k + " Not Exist!");
    }
}