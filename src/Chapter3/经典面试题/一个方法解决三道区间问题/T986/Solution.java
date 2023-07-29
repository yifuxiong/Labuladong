package Chapter3.经典面试题.一个方法解决三道区间问题.T986;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> tmp = new ArrayList<>();
        int m = firstList.length, n = secondList.length;

        // 这题是为了求交集，如果有一个长度为0，那么没有交集
        if (m == 0) {
            return firstList;
        }
        if (n == 0) {
            return secondList;
        }

        int i = 0, j = 0;
        while (i < m && j < n) {
            int[] list1 = firstList[i];
            int[] list2 = secondList[j];

            // 找到相交的情况
            if (list1[1] >= list2[0] && list2[1] >= list1[0]){
                int left = Math.max(list1[0], list2[0]);
                int right = Math.min(list1[1], list2[1]);
                tmp.add(new int[]{left, right});
            }

            if (list1[1] > list2[1]) {
                j++;
            } else {
                i++;
            }
        }

        int size = tmp.size();
        int[][] ans = new int[size][2];
        for (int k = 0; k < size; k++) {
            ans[k] = tmp.get(k);
        }
        return ans;
    }
}
