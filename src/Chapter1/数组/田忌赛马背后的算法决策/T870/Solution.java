package Chapter1.数组.田忌赛马背后的算法决策.T870;

// 双指针

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        // [0]存储下标，[1]存储值
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int[] ans = new int[nums1.length];

        int left = 0, right = nums1.length - 1;
        while (!pq.isEmpty()) {
            int[] out = pq.poll();
            int i = out[0];
            int val = out[1];  // 每次poll出来的val都是pq中的最大值
            if (val >= nums1[right]) {
                // 只要是不能赢，那就垫手
                ans[i] = nums1[left];
                left++;
            } else if (val < nums1[right]) {
                ans[i] = nums1[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};

        int[] nums12 = {12, 24, 8, 32};
        int[] nums22 = {13, 25, 32, 11};

        Solution solut = new Solution();
        int[] ans = solut.advantageCount(nums12, nums22);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
