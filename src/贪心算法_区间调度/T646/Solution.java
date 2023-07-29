package 贪心算法_区间调度.T646;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });

        int count = 1;
        int x_end = pairs[0][1];
        for (int[] pair: pairs){
            int start = pair[0];
            if (start > x_end){
                // 找到下一个区间了
                count++;
                x_end = pair[1];
            }
        }
        return count;
    }
}
