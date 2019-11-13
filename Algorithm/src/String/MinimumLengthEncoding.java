package String;

import java.util.*;


/**
 * 820
 */
public class MinimumLengthEncoding {
    //错误写法：应该是排序出现问题，不要问我，我也不懂！
    public int minimumLengthEncoding1(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }
        Collections.sort(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //System.out.println(list);
        StringBuilder sb = new StringBuilder("");
        for (int length = list.size() - 1; length >= 0; length--) {
            if (sb.indexOf(list.get(length)) == -1) {
                sb.append(list.get(length)).append("#");
            }
        }

        //System.out.println(sb.toString());
        return sb.length();
    }

    //*********************************
    public int minimumLengthEncoding2(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        //删除集合中有后缀存在的单词；
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
            {
                good.remove(word.substring(k));
            }
        }
        //计算长度
        int ans = 0;
        for (String word: good)
        {
            ans += word.length() + 1;
        }
        return ans;
    }

    //*-*-*-*-*-*-*-*-*-*-*-*-*-*
    //字典树解法：
    //每个结点都有一个结点数组分部代表不同的字母；
    //该算法关键在于有一共同的字典树且是前缀树
    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
            {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
            {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        MinimumLengthEncoding m = new MinimumLengthEncoding();
        String[] words = {"time", "me", "bell"};
        System.out.println(m.minimumLengthEncoding(words));
    }
}
class TrieNode {
    TrieNode[] children;
    int count;
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c) {
        if (children[c-'a'] == null) {
            children[c-'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}
