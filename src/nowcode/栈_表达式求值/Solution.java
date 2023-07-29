package nowcode.栈_表达式求值;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// '(', ')', '+', '-', '*'
public class Solution {
    public int solve(String s) {
        List<Integer> res = function(s, 0);
        return res.get(0);
    }

    public List<Integer> function(String s, int index) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char op = '+';
        int i;
        for (i = index; i < s.length(); i++) {
            // 判断是否为数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
                if (i != s.length() - 1) {
                    continue;
                }
            }

            // 碰到左括号'('，开始递归
            if (s.charAt(i) == '(') {
                List<Integer> tmp = function(s, i + 1);
                num = tmp.get(0);
                i = tmp.get(1);
                if (i != s.length() - 1) {
                    continue;
                }
            }

            // 判断符号
            switch (op) {
                case '+':
                    stack.offerLast(num);
                    break;
                case '-':
                    stack.offerLast(-num);
                    break;
                case '*':
                    int last = stack.pollLast();
                    stack.offerLast(last * num);
                    break;
            }
            num = 0;

            // 碰到右括号')'，结束递归
            if (s.charAt(i) == ')') {
                break;
            } else {
                op = s.charAt(i);
            }
        }

        // 本函数的操作部分
        int sum = 0;
        // 栈中元素相加
        while (!stack.isEmpty()) {
            sum += stack.pollLast();
        }
        List<Integer> res = new ArrayList<>();
        res.add(sum);
        // 最后一位存放索引
        res.add(i);
        return res;
    }

    public static void main(String[] args) {
        String s = "(2*(3-4))*5";  // out = -10
        String s2 = "3+2*3*4-1"; // out = 26

        Solution solut = new Solution();
        System.out.println(solut.solve(s2));
    }
}
