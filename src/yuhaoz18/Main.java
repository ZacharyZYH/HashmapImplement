package yuhaoz18;

import java.util.Random;

/**
 * Main
 */
public class Main {

    enum names{Chained_Hashing, Linear_Hashing, Quadratic_Hashing, Cuckoo_Hashing};
    public static void main(String[] args) {
        
        int[] arr;
        System.out.println(300 + " k-v pairs in " + Hashing.SIZE + " sized hashtable:\n");
        arr = setTestArray(300);
        test(arr, names.Chained_Hashing);
        test(arr, names.Linear_Hashing);
        test(arr, names.Quadratic_Hashing);
        test(arr, names.Cuckoo_Hashing);
        System.out.println(500 + " k-v pairs in " + Hashing.SIZE + " sized hashtable:\n");
        arr = setTestArray(500);
        test(arr, names.Chained_Hashing);
        test(arr, names.Linear_Hashing);
        test(arr, names.Quadratic_Hashing);
        test(arr, names.Cuckoo_Hashing);
        System.out.println(700 + " k-v pairs in " + Hashing.SIZE + " sized hashtable:\n");
        arr = setTestArray(700);
        test(arr, names.Chained_Hashing);
        test(arr, names.Linear_Hashing);
        test(arr, names.Quadratic_Hashing);
        test(arr, names.Cuckoo_Hashing);
        System.out.println(900 + " k-v pairs in " + Hashing.SIZE + " sized hashtable:\n");
        arr = setTestArray(900);
        test(arr, names.Chained_Hashing);
        test(arr, names.Linear_Hashing);
        test(arr, names.Quadratic_Hashing);
        test(arr, names.Cuckoo_Hashing);
        return;
    }

    private static int[] setTestArray(int len) {
        int[] arr = new int[len];
        Random r = new Random();
        Hashing.SIZE = 1000;
        for(int i = 0; i < len; i++) {
            arr[i] = r.nextInt(536871066);
        }
        return arr;
    }

    private static void test(int[] arr, names name) {
        int len = arr.length;
        System.out.println(name + ":");
        long time = System.nanoTime();
        Hashing hashing = new ChainedHashing();
        switch (name) {
            case Chained_Hashing:
                break;
            case Linear_Hashing:
                hashing = new LinearHashing();
                break;
            case Quadratic_Hashing:
                hashing = new QuadraticHashing();
                break;
            case Cuckoo_Hashing:
                hashing = new CuckooHashing();
                break;
        }
        long newTime = System.nanoTime();
        System.out.println("time to creat the hashtable: " + (newTime - time) + " nano-seconds");
        time = newTime;

        for (int i = 0; i < len; i++) {
            hashing.testSet(arr[i], arr[i]);
        }
        newTime = System.nanoTime();
        System.out.println("time of inserting: " + (newTime - time) + " nano-seconds");
        time = newTime;

        for (int i = 0; i < len; i++) {
            hashing.testSearchWithoutPrinting(arr[i]);
        }
        newTime = System.nanoTime();
        System.out.println("time of searching: " + (newTime - time) + " nano-seconds");
        time = newTime;

        for (int i = 0; i < len; i++) {
            hashing.testDelete(arr[i]);
        }
        newTime = System.nanoTime();
        System.out.println("time of deleting: " + (newTime - time) + " nano-seconds\n");
        time = newTime;
    }
}