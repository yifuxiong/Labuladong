package 拓扑排序.剑指_Offer_II_114_外星文字典;

import java.util.*;

public class Solution {
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> indegrees = new HashMap<>();
    boolean valid = true;

    public String alienOrder(String[] words) {
        int length = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                // 如果不存在这个key，那就put这个key - value
                edges.putIfAbsent(c, new ArrayList<Character>());
            }
        }

        for (int i = 1; i < length && valid; i++) {
            // 将这个单词与前一个单词之间加一条边
            addEdge(words[i - 1], words[i]);
        }

        if (!valid) {
            return "";
        }

        Queue<Character> queue = new ArrayDeque<>();
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!indegrees.containsKey(u)) {
                queue.offer(u);
            }
        }

        StringBuffer order = new StringBuffer();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            order.append(u);
            List<Character> adjacent = edges.get(u);
            for (char v : adjacent) {
                indegrees.put(v, indegrees.get(v) - 1);
                if (indegrees.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        return order.length() == edges.size() ? order.toString() : "";
    }

    public void addEdge(String before, String after){
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length){
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2){
                edges.get(c1).add(c2);
                // c2的度+1
                indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                break;
            }
            index++;
        }

        // after不能是before的前缀
        if (index == length && length1 > length2){
            valid = false;
        }
    }
}
