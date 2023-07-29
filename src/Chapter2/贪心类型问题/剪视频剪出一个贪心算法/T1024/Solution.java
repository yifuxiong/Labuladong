package Chapter2.贪心类型问题.剪视频剪出一个贪心算法.T1024;


import java.util.Arrays;

public class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int ans = 0;

        int curEnd = 0, nextEnd = 0;
        int i = 0, n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            // 在第ans个视频的区间内贪心选择下一个视频
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }

            // 找到下一个视频了
            ans++;
            curEnd = nextEnd;
            if (curEnd == time) {
                return ans;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int time = 10;

        int[][] clips2 = {
                {0, 1}, {6, 8}, {0, 2},
                {5, 6}, {0, 4}, {0, 3},
                {6, 7}, {1, 3}, {4, 7},
                {1, 4}, {2, 5}, {2, 6},
                {3, 4}, {4, 5}, {5, 7}, {6, 9}
        };
        int time2 = 9;

        Solution solut = new Solution();
        System.out.println(solut.videoStitching(clips2, time2));
    }
}
