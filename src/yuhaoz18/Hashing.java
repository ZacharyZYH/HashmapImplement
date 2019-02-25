package yuhaoz18;

/**
 * Hashing
 */
abstract class Hashing {
    // search(k), set(k, v) and delete(k)
    public static int SIZE = 1000;

    public abstract int search(int k) throws Exception;

    public abstract void set(int k, int v) throws Exception;

    public abstract void delete(int k) throws Exception;

    protected int hash(int i) {
        return i % SIZE;
    }

    public void testSet(int k, int v) {
        try {
            set(k, v);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    /**
     * test search() function
     * @param k
     */
    public void testSearch(int k) {
        try {
            System.out.println(search(k));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * test search() function
     * @param k
     */
    public void testSearchWithoutPrinting(int k) {
        try {
            search(k);
        } catch (Exception e) {
            
        }
    }

    
    /**
     * test Delete() function, print the exception if it exists
     * @param k key
     */
    public void testDelete(int k) {
        try {
            delete(k);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
