package Chapter3.暴力搜索算法.回溯算法团灭子集_排列_组合问题.T77;

// 【不同】元素组合问题
// 回溯法

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backTrack(n, 1, new ArrayList<>(), k);
        return ans;
    }

    public void backTrack(int n, int index, List<Integer> tmp, int k) {
        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i <= n; i++) {
            if (tmp.size() >= k) {
                continue;
            }

            tmp.add(i);
            backTrack(n, i + 1, tmp, k);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        int n2 = 1, k2 = 1;

        Solution solut = new Solution();
        System.out.println(solut.combine(n, k));
    }
}
