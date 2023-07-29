package Chapter2.贪心类型问题.贪心算法之区间调度问题.T435;

import java.util.*;

public class Solution {
    /*
    正确的思路其实很简单，可以分为以下三步：
    1、从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
    2、把所有与 x 区间相交的区间从区间集合 intvs 中删除。
    3、重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
     */
    public int intervalSchedule(int[][] intvs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int[] intv : intvs) {
            pq.offer(intv);
        }

        int[] cur = pq.poll();
        int ans = 1;
        int end = cur[1];
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[0] < end) {
                continue;
            } else {
                end = next[1];
                ans++;
            }
        }
        return intvs.length - ans;
    }

    public static void main(String[] args) {
        int[][] intvs = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        Solution solut = new Solution();
        System.out.println(solut.intervalSchedule(intvs));
    }
}
