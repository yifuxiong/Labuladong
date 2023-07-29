package Chapter2.贪心类型问题.如何运用贪心思想玩跳跃游戏.T45;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 贪心算法
    public int jump(int[] nums) {
        int n = nums.length;

        int end = 0;
        int fastest = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            // 当前位置能跳最远的位置
            fastest = Math.max(fastest, i + nums[i]);
            if (end == i) {  // 起点多记一次
                // 这里意思是，从上个位置，到它的最远距离，记一次step
                // 意思是说，到目前最远的位置之内都只需跳一步
                steps++;
                end = fastest;
            }
        }
        return steps;
    }

    Map<Integer, Integer> cache = new HashMap<>();

    // 递归（动态规划）
    public int jump2(int[] nums) {
        int n = nums.length;
        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int pos) {
        int n = nums.length;
        if (pos >= n - 1) {
            return 0;
        }
        if (pos == n - 2) {
            return 1;
        }

        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }

        int res = n;
        // 子问题
        for (int i = 1; i <= nums[pos]; i++) {
            int subProb = dfs(nums, pos + i);
            res = Math.min(res, subProb + 1);
        }

        cache.put(pos, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};

        Solution solut = new Solution();
        System.out.println(solut.jump(nums2));
        System.out.println(solut.jump2(nums2));
    }
}
