package Chapter2.用动态规划玩游戏.经典动态规划_正则表达式;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    // 递归
    public boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        // base case
        // p遍历完了，判断s是否遍历完了
        if (j == n) {
            return i == m;
        }
        // s遍历完了，判断p是否合法
        if (i == m) {
            // leetcode控制台测试过，如"a**"连续两个*出现的情况是不合法的
            // 如果能匹配空串，一定是字符和 * 成对儿出现
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        // 记录状态(i, j)，消除重叠子问题
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(0, i + 1));
        sb.append(',');
        sb.append(p.substring(0, j + 1));
        String key = sb.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, j, p, j + 2);
            } else {
                res = false;
            }
        }

        // 将当前结果记入备忘录
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "aa", p = "a";
        String s2 = "aa", p2 = "a*";
        String s3 = "ab", p3 = ".*";
        String s4 = "aa", p4 = "*";  // 这个比较特殊

        Solution solut = new Solution();
        System.out.println(solut.isMatch(s4, p4));
    }
}
