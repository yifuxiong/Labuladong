package Chapter3.经典面试题.如何高效解决接雨水的问题.T42;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 计算这一格的雨水
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int h = Math.min(height[i], height[left]) - height[top];
                int w = i - left - 1;
                ans += h * w;
            }
            stack.push(i);
        }
        return ans;
    }

    // 数组存储
    // 时间复杂度O(n)，空间复杂度O(n)
    public int trap2(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return ans;
    }

    // 双指针
    // 时间复杂度O(n)，空间复杂度O(1)
    public int trap3(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }

        int ans = 0;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (leftMax < height[left]) {
                leftMax = height[left];
            }
            if (rightMax < height[right]) {
                rightMax = height[right];
            }

            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        Solution solut = new Solution();
        System.out.println(solut.trap(height2));
        System.out.println(solut.trap2(height2));
        System.out.println(solut.trap3(height2));
    }
}
