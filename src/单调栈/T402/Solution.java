package 单调栈.T402;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int remain = n - k;

        // 只能从前往后
        // 从后往前遇到"112"这种测试用例没办法解决
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(stack.peekLast()) - '0' > num.charAt(i) - '0') {
                stack.pollLast();
                k -= 1;
            }
            stack.offerLast(i);
        }

        // System.out.println(stack);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < remain; i++) {
            char ch = num.charAt(stack.pollFirst());
            if (ch == '0' && sb.length() == 0){
                continue;
            }else{
                sb.append(ch);
            }
        }
        if (sb.length() == 0){
            return "0";
        }else{
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        // out = 1219

        String num2 = "10200";
        int k2 = 1;
        // out = 200

        String num3 = "10";
        int k3 = 2;
        // out = 0

        String num4 = "112";
        int k4 = 1;

        String num5 = "111111";
        int k5 = 3;

        Solution solut = new Solution();
        System.out.println(solut.removeKdigits(num5, k5));
    }
}
