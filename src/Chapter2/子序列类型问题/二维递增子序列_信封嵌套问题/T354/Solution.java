package Chapter2.子序列类型问题.二维递增子序列_信封嵌套问题.T354;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 对envelopes按照宽度升序，按照高度降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    // 第二维降序排列
                    return o2[1] - o1[1];
                } else {
                    // 第一维升序排列
                    return o1[0] - o2[0];
                }
            }
        });

        // 最长递增子序列
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = 1;

        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes2 = {{1, 1}, {1, 1}, {1, 1}};

        Solution solut = new Solution();
        System.out.println(solut.maxEnvelopes(envelopes2));
    }
}
