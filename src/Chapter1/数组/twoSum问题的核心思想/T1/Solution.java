package Chapter1.数组.twoSum问题的核心思想.T1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (hashMap.containsKey(val) && hashMap.get(val) != i) {
                return new int[]{i, hashMap.get(val)};
            }
        }
        return new int[]{-1, -1};
    }
}
