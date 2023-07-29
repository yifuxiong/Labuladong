package Chapter3.经典面试题.分治算法详解_运算优先级.T241;

// 【分治算法】
// 我感觉下次遇到多位数字的加减乘除运算，可以按照这个思路，通过运算符分隔
// 这样数字就不需要考虑1位或者多位了

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();

    // labuladong
    // 分治算法
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                // 分
                List<Integer> leftStr = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightStr = diffWaysToCompute(expression.substring(i + 1));

                // 治
                for (int a : leftStr) {
                    for (int b : rightStr) {
                        // 将两边的值作排列组合
                        if (ch == '+') {
                            ans.add(a + b);
                        } else if (ch == '-') {
                            ans.add(a - b);
                        } else if (ch == '*') {
                            ans.add(a * b);
                        }
                    }
                }
            }
        }

        // 分的终止条件
        if (ans.isEmpty()) {
            // 为什么这里用ans.isEmtpy()作为终止条件？
            // 比如expression='234'，只有数字
            // 那么ans就是新new的，必然为空
            // 这样我只需要把这个字符串放进ans中再返回就行了
            ans.add(Integer.parseInt(expression));
        }

        memo.put(expression, ans);
        return ans;
    }

    public static void main(String[] args) {
        String expression = "2-1-1";
        String expression2 = "2*3-4*5";

        Solution solut = new Solution();
        System.out.println(solut.diffWaysToCompute(expression2));
    }
}
