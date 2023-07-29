package Chapter3.暴力搜索算法.回溯算法团灭子集_排列_组合问题.T78;

// 【不相同】元素的【组合】问题
// 回溯法

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, int index, List<Integer> tmp) {
        // 触发条件：当前ans中不包含tmp，那就把tmp加入ans
        ans.add(new ArrayList<>(tmp));

        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {0};

        Solution solut = new Solution();
        System.out.println(solut.subsets(nums));
    }
}
