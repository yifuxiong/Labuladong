package Chapter1.数组.如何去除有序数组的重复元素.T26;

// 数组中删除重复元素
// 双指针（数组就用双下标）

public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
