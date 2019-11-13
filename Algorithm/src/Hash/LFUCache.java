package Hash;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    HashMap<Integer, Integer> VMap ;
    HashMap<Integer, Integer> NMap ;
    int len = 0;
    int capacity = 0;
    int min;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        VMap = new HashMap<> ();
        NMap = new HashMap<> ();
    }

    public int get(int key) {
        if (!NMap.containsKey(key)){
            return -1;
        }
        int i = NMap.get(key);
        NMap.put(key,++i);
        for (Map.Entry<Integer, Integer> entry : NMap.entrySet()) {
            if (entry.getValue()<NMap.get(min)){
                min = entry.getKey();
            }
        }
        return VMap.get(key);
    }

    public void put(int key, int value) {
        if (len >= capacity){
            NMap.remove(min);
            VMap.remove(min);
            len--;
        }
        if (!VMap.containsKey(key)){
            VMap.put(key,value);
            NMap.put(key,1);
            min = key;
            len++;
        }
        else{
            Integer i = NMap.get(key);
            NMap.put(key, ++i);
        }

        for (Map.Entry<Integer, Integer> entry : NMap.entrySet()) {
            if (entry.getValue()<NMap.get(min)){
                min = entry.getKey();
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
}
}
