package Chapter1.数组.前缀和数组.T560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int diff = sum - k;
            if (preSum.containsKey(diff)) {
                ans += preSum.get(diff);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int k = 0;

        Solution solut = new Solution();
        System.out.println(solut.subarraySum(nums, k));
    }
}
