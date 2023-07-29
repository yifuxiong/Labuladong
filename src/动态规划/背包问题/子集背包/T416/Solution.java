package 动态规划.背包问题.子集背包.T416;

import java.util.HashMap;
import java.util.Map;

// 虽然加了memo，只能解决相同值很多的情况
// 对于不同值很多的情况，加了memo也解决不了
public class Solution {
    Map<String, Boolean> memo;

    public boolean canPartition(int[] nums) {
        memo = new HashMap<>();
        return dfs(nums, 0, 0, 0);
    }

    public boolean dfs(int[] nums, int a, int b, int index) {
        if (index == nums.length) {
            if (a == b) {
                return true;
            } else {
                return false;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(a);
        sb.append('#');
        sb.append(b);
        String key = sb.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res1 = dfs(nums, a + nums[index], b, index + 1);
        boolean res2 = dfs(nums, a, b + nums[index], index + 1);
        boolean res = res1 || res2;
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};  // true
        int[] nums2 = {1, 2, 3, 5};  // false
        int[] nums3 = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 99, 97};

        Solution solut = new Solution();
        System.out.println(solut.canPartition(nums3));
    }
}
