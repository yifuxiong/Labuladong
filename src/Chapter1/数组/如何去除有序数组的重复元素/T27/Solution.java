package Chapter1.数组.如何去除有序数组的重复元素.T27;

// 原地移除元素
// 双指针：将数组中的重复元素移动到数组末尾

public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;

        Solution solut = new Solution();
        System.out.println(solut.removeElement(nums2, val2));
    }
}
