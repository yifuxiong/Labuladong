package Chapter3.暴力搜索算法.BFS算法题解套路框架.T780;

import java.util.*;

public class Solution {
    // bfs TLE
    Set<String> memo = new HashSet<>();

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        String key = "" + sx + "," + sy;
        memo.add(key);

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(key);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                String[] strs = cur.split(",");
                int x = Integer.valueOf(strs[0]);
                int y = Integer.valueOf(strs[1]);
                List<String> states = getState(x, y, tx, ty);
                for (String state : states) {
                    if (!memo.contains(state)) {
                        if (state.equals("" + tx + "," + ty)) {
                            return true;
                        }
                        queue.offer(state);
                        memo.add(state);
                    }
                }
            }
        }
        return false;
    }

    public List<String> getState(int x, int y, int tx, int ty) {
        List<String> states = new ArrayList<>();
        int sum = x + y;
        if (sum <= tx) {
            String down = "" + sum + "," + y;
            states.add(down);
        }
        if (sum <= ty) {
            String right = "" + x + "," + sum;
            states.add(right);
        }
        return states;
    }

    // 数学法 AC
    public boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }

        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }

        if (tx > ty) {
            tx = tx % ty;
            return reachingPoints(sx, sy, tx, ty);
        } else {
            ty = ty % tx;
            return reachingPoints(sx, sy, tx, ty);
        }
    }
}
