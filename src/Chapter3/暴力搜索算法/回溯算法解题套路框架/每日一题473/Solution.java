package Chapter3.暴力搜索算法.回溯算法解题套路框架.每日一题473;

import java.util.Arrays;

public class Solution {
    boolean ans = false;

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }

        int maxVal = Arrays.stream(matchsticks).max().getAsInt();
        if (maxVal > sum / 4) {
            return false;
        }

        // 逆序
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int target = sum / 4;
        dfs(matchsticks, 0, 0, 0, 0, 0, target);
        return ans;
    }

    // 超时
    public void dfs(int[] matchsticks, int index, int line1, int line2, int line3, int line4, int target) {
        if (line1 > target || line2 > target || line3 > target || line4 > target) {
            return;
        }

        int n = matchsticks.length;
        if (index == n) {
            if (line1 == line2 && line2 == line3 && line3 == line4) {
                ans = true;
            }
            return;
        }

        int val = matchsticks[index];
        dfs(matchsticks, index + 1, line1 + val, line2, line3, line4, target);
        dfs(matchsticks, index + 1, line1, line2 + val, line3, line4, target);
        dfs(matchsticks, index + 1, line1, line2, line3 + val, line4, target);
        dfs(matchsticks, index + 1, line1, line2, line3, line4 + val, target);
    }

    public static void main(String[] args) {
        int[] matchsticks = {1, 1, 2, 2, 2};
        int[] matchsticks2 = {3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] matchsticks3 = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        int[] matchsticks4 = {4, 4, 4, 4, 5, 5, 5, 5, 3, 3, 3, 3, 4, 4, 8};

        Solution solut = new Solution();
        System.out.println(solut.makesquare(matchsticks4));
    }
}
