package wangyi_子集背包;

// 题意转换很重要，题目是求【最少丢掉多少物品】能够平分给两个人，
// 转换为两个人从0开始拿，计算出所有满足平分条件的最值（最少丢弃）

// 首先将题目转换为两个人从0开始拿物品，对于每一件物品开始进行选择，
// 对于每个物品有三种选择，给第一个人、给第二个人、丢掉。


public class Solution {
    int res = Integer.MAX_VALUE;

    public int least(int[] nums) {
        dfs(nums, 0, 0, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int index, int bag1, int bag2, int loss) {
        if (index == nums.length) {
            if (bag1 == bag2) {
                res = Math.min(res, loss);
            }
            return;
        }

        int val = nums[index];
        dfs(nums, index + 1, bag1 + val, bag2, loss);
        dfs(nums, index + 1, bag1, bag2 + val, loss);
        dfs(nums, index + 1, bag1, bag2, loss + val);
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 12, 18, 20};

        Solution solut = new Solution();
        System.out.println(solut.least(nums));
    }
}
