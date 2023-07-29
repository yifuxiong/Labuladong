package Chapter3.暴力搜索算法.BFS算法题解套路框架.T752;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)){
            return 0;
        }
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        if (deads.contains("0000")) {
            return -1;
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int step = 0;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();

                List<String> states = getState(tmp);
                for (String state : states) {
                    if (!deads.contains(state)) {
                        if (!visited.contains(state)) {
                            if (state.equals(target)) {
                                return step;
                            }
                            queue.offer(state);
                            visited.add(state);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public List<String> getState(String tmp) {
        List<String> res = new ArrayList<>();
        char[] chs = tmp.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char t = chs[i];
            // 向前拨一位
            chs[i] = (t == '0' ? '9' : (char) (t - 1));
            res.add(new String(chs));
            // 向后拨一位
            chs[i] = (t == '9' ? '0' : (char) (t + 1));
            res.add(new String(chs));
            chs[i] = t;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        String[] deadends2 = {"8888"};
        String target2 = "0009";

        String[] deadends3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target3 = "8888";

        String[] deadends4 = {"0201", "0101", "0102", "1212", "2002"};
        String target4 = "0000";

        Solution solut = new Solution();
        System.out.println(solut.openLock(deadends4, target4));
    }
}
