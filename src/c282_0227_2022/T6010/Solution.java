package c282_0227_2022.T6010;

import java.util.Arrays;

/*
* 6010. 完成旅途的最少时间
题目难度 Medium
给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。

每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。

给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
* */

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = Arrays.stream(time).min().getAsInt();

        // 这个右边界人都快找死
        int m = 0;
        for (int t : time) {
            m = Math.max(m, t);
        }
        long right = m * (long) totalTrips + 1;

        while (left < right) {
            long mid = left + (right - left) / 2;

            long cnt = getCnt(time, mid);
            if (cnt == totalTrips) {
                right = mid;
            } else if (cnt < totalTrips) {
                left = mid + 1;
            } else if (cnt > totalTrips) {
                right = mid;
            }
        }
        return left;
    }

    public long getCnt(int[] time, long mid) {
        long ans = 0;
        for (int t : time) {
            ans += mid / t;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] time = {5, 10, 10};
        int totalTrips = 9;  // 25

        int[] time2 = {9, 3, 10, 5};
        int totalTrips2 = 2;  // 5

        int[] time3 = {1};
        int totalTrips3 = 4;  // 4

        int[] time4 = {9, 2};
        int totalTrips4 = 8;  // 14

        int[] time5 = {100000};
        int totalTrips5 = 10000000;

        Solution solut = new Solution();
        System.out.println(solut.minimumTime(time5, totalTrips5));
    }
}
