package Chapter3.暴力搜索算法.回溯算法解题套路框架.T46;

// 全排列
// 回溯法
// 画出决策树：确定选择列表 和 已选路径

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtrace(nums, new ArrayList<>());
        return ans;
    }

    // nums是选择列表，track是已选路径
    public void backtrace(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                // 剪枝
                continue;
            }
            track.add(nums[i]);
            backtrace(nums, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution solut = new Solution();
        solut.permute(nums);
        System.out.println(solut.ans);
    }
}
