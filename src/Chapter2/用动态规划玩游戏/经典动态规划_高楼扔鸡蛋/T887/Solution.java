package Chapter2.用动态规划玩游戏.经典动态规划_高楼扔鸡蛋.T887;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Integer> memo;

    public int superEggDrop(int k, int n) {
        memo = new HashMap<>();
        return dp(k, n);
        // return dpbinary(k, n);
    }

    public int dp(int k, int n) {
        if (k == 1) {
            // 如果只有1一个鸡蛋，最坏的情况需要仍n次
            return n;
        }
        if (n == 0) {
            // 如果没有楼层，那么不需要扔
            return 0;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(k);
        sb.append(',');
        sb.append(n);
        String key = sb.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = Integer.MAX_VALUE;
        // 从1层楼到n层楼
        for (int i = 1; i <= n; i++) {
            // 第i层扔下去，碎了，还剩k-1个鸡蛋，继续往下找
            // 没碎，还剩k个鸡蛋，往上找
            res = Math.min(res, Math.max(dp(k - 1, i - 1), dp(k, n - i)) + 1);
        }
        memo.put(key, res);
        return res;
    }

    public int dpbinary(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(k);
        sb.append(',');
        sb.append(n);
        String key = sb.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 从mid层扔下去，鸡蛋碎了，鸡蛋数-1，选择更低楼层
            int lowVal = dpbinary(k - 1, mid - 1);
            // 从mid层仍下去，鸡蛋没碎，鸡蛋数不变，选择更高楼层
            int highVal = dpbinary(k, n - mid);

            // 找最大值
            if (lowVal < highVal) {
                left = mid;
            } else if (lowVal > highVal) {
                right = mid;
            } else {
                left = mid;
                right = mid;
            }
        }

        int a = Math.max(dpbinary(k - 1, left - 1), dpbinary(k, n - left));
        int b = Math.max(dpbinary(k - 1, right - 1), dpbinary(k, n - right));
        int res = Math.min(a, b) + 1;

        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 14;

        Solution solut = new Solution();
        System.out.println(solut.superEggDrop(k, n));
    }
}
