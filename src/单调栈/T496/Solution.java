package 单调栈.T496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // nums1是nums2的子集
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = next(nums2);
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            table.put(nums2[i], greater[i]);
        }

        int n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = table.get(nums1[i]);
        }
        return res;
    }

    public int[] next(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= nums[i]) {
                stack.pollLast();
            }
            // 夹私货
            res[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.offerLast(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Solution solut = new Solution();
        int[] res = solut.nextGreaterElement(nums1, nums2);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
