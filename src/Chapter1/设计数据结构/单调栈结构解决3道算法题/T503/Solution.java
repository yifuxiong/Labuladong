package Chapter1.设计数据结构.单调栈结构解决3道算法题.T503;

// 循环输出当前数字右侧第一个较大数字
// 这里数组长度*2，主要是为了最后一个数字。（前n-1个数字正常调用单调栈）

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] nums2 = {1, 2, 3, 4, 3};

        Solution solut = new Solution();
        int[] ans = solut.nextGreaterElements(nums2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
        System.out.println();
    }
}
