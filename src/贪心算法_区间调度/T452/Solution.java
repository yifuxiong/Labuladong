package 贪心算法_区间调度.T452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                // 特殊用例2147483647 - (-2147483646)，超过int范围
                // 改用Integer.compare
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 1;
        int x_end = points[0][1];
        for (int[] point: points){
            int start = point[0];
            if (start > x_end){
                count++;
                x_end = point[1];
            }
        }
        return count;
    }
}
