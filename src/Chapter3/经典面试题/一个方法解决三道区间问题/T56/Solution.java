package Chapter3.经典面试题.一个方法解决三道区间问题.T56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 直接套labuladong模板

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> tmp = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];

            // 情况一：覆盖区间
            if (left <= intv[0] && right >= intv[1]) {
                continue;
            }
            // 情况二：相交区间
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }
            // 情况三：完全不相交
            if (right < intv[0]) {
                tmp.add(new int[]{left, right});
                left = intv[0];
                right = intv[1];
            }
        }
        tmp.add(new int[]{left, right});
        int n = tmp.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}
