package nowcode.栈_表达式求值_leetcode;

// leetcode第227题

import java.util.Deque;
import java.util.LinkedList;

// '+', '-', '*', '/'，无括号，且字符串中间允许有多个空格
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (preSign == '/') {
                    stack.push((int) stack.pop() / num);
                }
                // 计算完之后，一定要把num重新设置为0，且上个运算符设为当前运算符
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        for (int i : stack) {
            ans += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";  // out = 5

        Solution solut = new Solution();
        System.out.println(solut.calculate(s));
    }
}
