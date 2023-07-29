package Chapter3.经典面试题.一个方法解决三道区间问题.T1288;

import java.util.Arrays;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if (a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });

        int ans = 0;
        int end = 0;
        for (int[] interval: intervals){
            if (end < interval[1]){
                ans++;
                end = interval[1];
            }
        }
        return ans;
    }
}
