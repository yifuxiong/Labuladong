package Chapter2.贪心类型问题.扫描线技巧_安排会议室.T253;

import java.util.*;

public class Solution {
    // 返回需要申请的会议室数量
    // 转换思路：是否存在某个时间段，同时进行会议的数量最大
    public int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int count = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
        }
        return count;
    }

    // 差分数组
    public int minMeetingRooms2(int[][] meetings) {
        int maxTime = 0;
        for (int[] meeting : meetings) {
            maxTime = Math.max(meeting[1], maxTime);
        }

        int[] wholeTime = new int[maxTime + 1];
        Diff d = new Diff(wholeTime);
        for (int[] meeting : meetings) {
            int left = meeting[0];
            int right = meeting[1];
            d.increment(left, right, 1);
        }

        int count = 0;
        for (int i = 0; i < maxTime; i++) {
            count = Math.max(count, d.result()[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};  // 2

        Solution solut = new Solution();
        System.out.println(solut.minMeetingRooms(meetings));
        System.out.println(solut.minMeetingRooms2(meetings));
    }
}

class Diff {
    int n;
    int[] diff;

    public Diff(int[] nums) {
        this.n = nums.length;
        diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int left, int right, int incre) {
        diff[left] += incre;
        if (right + 1 < n) {
            diff[right + 1] -= incre;
        }
    }

    public int[] result() {
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
