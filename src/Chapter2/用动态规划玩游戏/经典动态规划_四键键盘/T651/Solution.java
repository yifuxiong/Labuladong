package Chapter2.用动态规划玩游戏.经典动态规划_四键键盘.T651;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Integer> memo = new HashMap<>();

    // 记忆化搜索
    public int maxA(int N) {
        return dfs(N, 0, 0);
    }

    // n是剩余按键次数
    // aNum是屏幕上当前a的个数
    // 剪切板中a的个数
    public int dfs(int n, int aNum, int copy) {
        if (n <= 0) {
            return aNum;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(n).append(",");
        sb.append(aNum).append(",");
        sb.append(copy).append("#");
        String key = sb.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // A, Ctrl+A or Ctrl+C, Ctrl+V
        int A = dfs(n - 1, aNum + 1, copy);
        int Ctrl_A_C = dfs(n - 2, aNum, aNum);
        int Ctrl_V = dfs(n - 1, aNum + copy, copy);

        int res = Math.max(Math.max(A, Ctrl_A_C), Ctrl_V);
        memo.put(key, res);
        return res;
    }

    // 动态规划
    public int maxA2(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            // 按A键
            dp[i] = dp[i - 1] + 1;

            for (int j = 2; j < i; j++) {
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N 次按键之后最多有几个 A？
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 3;  // 3
        int N2 = 7;  // 9

        Solution solut = new Solution();
        System.out.println(solut.maxA(N));
        System.out.println(solut.maxA2(N));
    }
}
