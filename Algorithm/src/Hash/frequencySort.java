package Hash;
import java.util.*;

public class frequencySort {
    public String frequencySort(String s) {
        HashMap <Character,Integer> map = new HashMap<> ();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                Integer integer = map.get(c);
                map.put(c,++integer);
            }
            else {
                map.put(c, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<> ();
        for (Map.Entry<Character, Integer> entry : entries) {
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            int i = 0;
            while (i<entry.getValue()){
                sb.append(entry.getKey());
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        frequencySort fs = new frequencySort();
        System.out.println(fs.frequencySort("cccaab"));
    }
}
