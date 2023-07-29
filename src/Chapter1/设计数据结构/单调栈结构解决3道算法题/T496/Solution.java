package Chapter1.设计数据结构.单调栈结构解决3道算法题.T496;

// 单调栈
// 一个for遍历数组，一个while出栈（一定是出栈，出完保证栈单调）

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int n2 = nums2.length;
        for (int i = 0; i < n2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                hashMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        int n1 = nums1.length;
        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        Solution solut = new Solution();
        int[] ans = solut.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
        System.out.println();
    }
}
