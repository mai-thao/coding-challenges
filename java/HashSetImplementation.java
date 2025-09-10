import java.util.LinkedList;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement HashSetImplementation class:
 * - `void add(key)` Inserts the value key into the HashSet.
 * - `bool contains(key)` Returns whether the value key exists in the HashSet or not.
 * - `void remove(key)` Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 */
public class HashSetImplementation {
    static class MyHashSet {
        private final int BUCKET_SIZE = 10000;
        private final LinkedList<Integer>[] bucket;

        public MyHashSet() {
            bucket = new LinkedList[BUCKET_SIZE];
            for (int i = 0; i < BUCKET_SIZE; i++) {
                bucket[i] = new LinkedList<>();
            }
        }

        public void add(int key) {
            int bucketIdx = key % BUCKET_SIZE;
            if (!bucket[bucketIdx].contains(key)) {
                bucket[bucketIdx].add(key);
            }
        }

        public void remove(int key) {
            int bucketIdx = key % BUCKET_SIZE;
            if (bucket[bucketIdx].contains(key)) {
                bucket[bucketIdx].remove(Integer.valueOf(key));
            }
        }

        public boolean contains(int key) {
            int bucketIdx = key % BUCKET_SIZE;
            return bucket[bucketIdx].contains(key);
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);                           // set = [1]
        myHashSet.add(2);                           // set = [1, 2]
        System.out.println(myHashSet.contains(1));  // return true
        System.out.println(myHashSet.contains(3));  // return false (not found)
        myHashSet.add(2);                           // set = [1, 2]
        System.out.println(myHashSet.contains(2));  // return true
        myHashSet.remove(2);                   // set = [1]
        System.out.println(myHashSet.contains(2));  // return false (already removed)
    }
}
