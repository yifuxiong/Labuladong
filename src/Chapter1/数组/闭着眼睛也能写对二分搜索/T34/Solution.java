package Chapter1.数组.闭着眼睛也能写对二分搜索.T34;

// 寻找左侧边界的二分搜索

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        // 先来一遍二分查找，找左边界
        int left = 0, right = n;  // 左闭右开
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 向左侧逼近
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 判断左边界是否越界，或者是否是target
        if (left >= n || nums[left] != target) {
            ans[0] = -1;
        } else {
            ans[0] = left;
        }

        // 再来一遍二分查找，找右边界
        left = 0;
        right = n;  // 左闭右开
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 向右侧逼近
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 判断右边界是否越界，或者是否是target
        if (left - 1 < 0 || nums[left - 1] != target) {
            ans[1] = -1;
        } else {
            ans[1] = left - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;

        int[] nums2 = {};
        int target2 = 0;

        int[] nums3 = {2, 2};
        int target3 = 3;

        Solution solut = new Solution();
        int[] ans = solut.searchRange(nums2, target2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
