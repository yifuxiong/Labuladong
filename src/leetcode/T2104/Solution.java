package leetcode.T2104;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ans += (maxVal - minVal);
            }
        }
        return ans;
    }

    // 单调栈
    public long subArrayRanges2(int[] nums) {
        int n = nums.length;
        // nums[i]作为最小值，左边右边的值要均大于nums[i]
        // 因此找到左右第一个小于nums[i]的值的索引作为边界
        int[] minLeft = new int[n];
        int[] minRight = new int[n];

        // 同理，nums[i]作为最大值，左边右边的值要均小于nums[i]
        // 因此找到左右第一个大于nums[i]的值的索引作为边界
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        Deque<Integer> minStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();

        // 正序遍历
        for (int i = 0; i < n; i++) {
            // 找到最近一个比它小的
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);

            // 找到最近一个比它大的
            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }

        minStack.clear();
        maxStack.clear();

        // 逆序遍历
        for (int i = n - 1; i >= 0; i--) {
            // 找到最近一个比它小的
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) {
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? n : minStack.peek();
            minStack.push(i);

            // 找到最近一个比它大的
            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }

        long minVal = 0, maxVal = 0;
        for (int i = 0; i < n; i++){
            minVal += (long)(minRight[i] - i) * (i - minLeft[i]) * nums[i];
            maxVal += (long)(maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
        }

        return maxVal - minVal;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {1, 3, 3};
        int[] nums3 = {4, -2, -3, 4, 1};

        Solution solut = new Solution();
        System.out.println(solut.subArrayRanges(nums3));
        System.out.println(solut.subArrayRanges2(nums3));
    }
}
