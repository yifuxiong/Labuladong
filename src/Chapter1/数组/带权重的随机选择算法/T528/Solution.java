package Chapter1.数组.带权重的随机选择算法.T528;

// 前缀和 + 二分查找（左边界）

import java.util.Random;

public class Solution {
    Random rand;
    int[] preSum;

    public Solution(int[] w) {
        rand = new Random();
        int n = w.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        int target = rand.nextInt(preSum[n - 1]) + 1;
        int left = 0, right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (preSum[mid] == target) {
                // 找到了？我要找最左边的
                right = mid;
            } else if (preSum[mid] < target) {
                left = mid + 1;
            } else if (preSum[mid] > target) {
                right = mid;
            }
        }
        // preSum相对于w数组的索引，往后移了一位
        return left - 1;
    }
}
