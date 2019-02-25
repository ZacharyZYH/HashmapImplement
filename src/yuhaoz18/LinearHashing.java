package yuhaoz18;

import java.util.ArrayList;

/**
 * LinearHashing
 */
public class LinearHashing extends Hashing {
    // {{key, value, 0}, {key, value, 0}, {key, value, 1}} 
    // the third key is a status label
    // 0 means it is empty (and of course unused)
    // 1 means it is nonempty and used
    // 2 means it is nonempty but unused
    private ArrayList<int[]> outerList;

    public LinearHashing() {
        outerList = new ArrayList<int[]>();
        int i = SIZE;
        while(i-- != 0) {
            outerList.add(new int[]{0, 0, 0});
        }
    }

    @Override
    public int search(int k) throws Exception {
        int i = hash(k);
        while(outerList.get(i)[2] != 0 && outerList.get(i)[0] != k) i = (i + 1) % SIZE;
        if(outerList.get(i)[2] == 1) 
            return outerList.get(i)[1];
        throw new Exception("Key " + k + " Not Exist!");
    }

    @Override
    public void set(int k, int v) {
        int i = hash(k);
        while(outerList.get(i)[2] != 0 && outerList.get(i)[0] != k) i = (i + 1) % SIZE;
        outerList.set(i, new int[]{k, v, 1});
    }

    @Override
    public void delete(int k) throws Exception {
        int i = hash(k);
        while(outerList.get(i)[2] != 0 && outerList.get(i)[0] != k) i = (i + 1) % SIZE;
        if(outerList.get(i)[2] == 1) {
            outerList.get(i)[2] = 2;
            return;
        }
        throw new Exception("Key " + k + " Not Exist!");
    }

    
}