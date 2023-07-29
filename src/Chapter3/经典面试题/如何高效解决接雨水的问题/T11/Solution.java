package Chapter3.经典面试题.如何高效解决接雨水的问题.T11;

public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n < 2) {
            return 0;
        }

        int leftMax = height[0];
        int rightMax = height[n - 1];

        int ans = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ans = Math.max(ans, (right - left) * leftMax);
                left++;
            } else {
                ans = Math.max(ans, (right - left) * rightMax);
                right--;
            }
        }

        return ans;
    }
}
