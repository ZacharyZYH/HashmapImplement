package yuhaoz18;

import java.util.ArrayList;

/**
 * CuckooHashing
 */
public class CuckooHashing extends Hashing {
    /**
     * select one of the two functions base on mode
     * @param i input value
     * @param mode use super.hash() on 0, an alternate hash on 1
     * @return hashed value
     */
    private int hash(int i, int mode) {
        if(mode == 0) return super.hash(i);
        return super.hash(i / SIZE);
    }

    private ArrayList<ArrayList<int[]>> outerList;

    public CuckooHashing() {
        outerList = new ArrayList<ArrayList<int[]>>();
        outerList.add(new ArrayList<int[]>());
        outerList.add(new ArrayList<int[]>());
        int i = SIZE;
        while(i-- != 0) {
            outerList.get(0).add(new int[]{-1, 0});
            outerList.get(1).add(new int[]{-1, 0});
        }
    }

    @Override
    public int search(int k) throws Exception {
        if(outerList.get(0).get(hash(k, 0))[0] == k)
            return outerList.get(0).get(hash(k, 0))[1];
        if(outerList.get(1).get(hash(k, 1))[0] == k)
            return outerList.get(1).get(hash(k, 1))[1];
        throw new Exception("Key " + k + " Not Exist!");
    }

    @Override
    public void set(int k, int v) throws Exception {
        int t = 0, inputK = k, count = 0;
        while(k != -1) {
            if(k == inputK) count++;
            if(count == 3) throw new Exception("Infinite loop when set()! Need to resize or change hash function");
            int tempK = k, tempV = v;
            k = outerList.get(t).get(hash(tempK, t))[0];
            v = outerList.get(t).get(hash(tempK, t))[1];
            outerList.get(t).get(hash(tempK, t))[0] = tempK;
            outerList.get(t).get(hash(tempK, t))[1] = tempV;
            t = 1 - t;
        }
    }

    @Override
    public void delete(int k) throws Exception {
        if(outerList.get(0).get(hash(k, 0))[0] == k)
            outerList.get(0).get(hash(k, 0))[0] = -1;
        else if(outerList.get(1).get(hash(k, 1))[0] == k)
            outerList.get(1).get(hash(k, 1))[0] = -1;
        else throw new Exception("Key " + k + " Not Exist!");
    }
}