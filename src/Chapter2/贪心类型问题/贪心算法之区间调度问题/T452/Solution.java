package Chapter2.贪心类型问题.贪心算法之区间调度问题.T452;

import java.util.*;

public class Solution {
    // 这题和T435一样的思路，
    // 转换一下思路：找不重叠的气球，就可以找到至少需要几根箭了
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;  // 返回1是逆序
                }
                if (o1[1] < o2[1]) {
                    return -1;  // 返回-1是正序
                }
                return 0;
            }
        });

        // 至少一根箭
        int ans = 1;
        int[] cur = points[0];
        int end = cur[1];
        for (int i = 1; i < points.length; i++) {
            int[] next = points[i];
            if (next[0] <= end) {
                continue;
            } else {
                ans++;
                end = next[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points2 = {{-2147483646, -2147483645}, {2147483646, 2147483647}};

        Solution solut = new Solution();
        System.out.println(solut.findMinArrowShots(points2));
    }
}
