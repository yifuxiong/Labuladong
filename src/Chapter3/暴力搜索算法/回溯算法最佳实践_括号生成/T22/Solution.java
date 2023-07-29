package Chapter3.暴力搜索算法.回溯算法最佳实践_括号生成.T22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        char[] chars = new char[2];
        chars[0] = '(';
        chars[1] = ')';
        backTrack(chars, n * 2, new ArrayList<>());
        return ans;
    }

    public void backTrack(char[] chars, int n, List<Character> chs) {
        if (n == 0) {
            // 这两个条件要分开写，
            // 因为n!=0时，递归还没有结束，所以不用return，继续下面的括号选择
            // 而不合法的括号情况要直接return，免得它继续存在栈中
            if (isValid(chs)) {
                StringBuffer sb = new StringBuffer();
                for (char ch : chs) {
                    sb.append(ch);
                }
                if (!ans.contains(sb.toString())) {
                    ans.add(sb.toString());
                }
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            // 当层
            if (i > 0 && chars[i] == chars[i - 1]) {
                continue;
            }
            chs.add(chars[i]);
            // 进入下一层
            backTrack(chars, n - 1, chs);
            chs.remove(chs.size() - 1);
        }
    }

    public boolean isValid(List<Character> chs) {
        int res = 0;
        for (char ch : chs) {
            if (res < 0) {
                return false;
            }
            if (ch == '(') {
                res += 1;
            } else if (ch == ')') {
                res -= 1;
            }
        }
        return res == 0;
    }

    public static void main(String[] args) {
        int n = 2;

        Solution solut = new Solution();
        System.out.println(solut.generateParenthesis(n));
    }
}
