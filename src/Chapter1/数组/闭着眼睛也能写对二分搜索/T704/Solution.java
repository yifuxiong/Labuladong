package Chapter1.数组.闭着眼睛也能写对二分搜索.T704;

// 寻找一个数（基本的二分搜索）

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int target2 = 2;

        Solution solut = new Solution();
        System.out.println(solut.search(nums, target2));
    }
}
