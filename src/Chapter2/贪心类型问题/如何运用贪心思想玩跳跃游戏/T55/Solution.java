package Chapter2.贪心类型问题.如何运用贪心思想玩跳跃游戏.T55;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (maxIndex < i) {
                // 只要有一步，能跳的最大位置，只是在这次跳跃的起点位置
                // 说明当前位置都跳不过去，直接返回false
                return false;
            } else {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
