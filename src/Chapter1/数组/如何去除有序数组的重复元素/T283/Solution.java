package Chapter1.数组.如何去除有序数组的重复元素.T283;

public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < n; i++) {
            nums[i] = 0;
        }
    }
}
