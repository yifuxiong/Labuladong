package 单调栈.T42接雨水;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peekLast()] <= height[i]) {
                int bottom = height[stack.pollLast()];
                if (stack.isEmpty()) {
                    break;
                }
                int left = height[stack.peekLast()];
                int right = height[i];
                int h = Math.min(left, right) - bottom;
                int w = i - stack.peekLast() - 1;
                area += h * w;

                // 这行不能加
                // while下第一行已经有了
                // stack.pollLast();
            }
            stack.offerLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};  // out = 6
        int[] height2 = {4, 2, 0, 3, 2, 5};  // out = 9

        Solution solut = new Solution();
        System.out.println(solut.trap(height2));
    }
}
