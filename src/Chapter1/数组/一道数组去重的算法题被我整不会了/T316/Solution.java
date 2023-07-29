package Chapter1.数组.一道数组去重的算法题被我整不会了.T316;

// 单调栈
// 该题与T1081完全相同

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String removeDuplicateLetters(String s) {
        // 单调栈
        Deque<Character> stack = new ArrayDeque<>();
        // 该字符是否存在于栈中
        boolean[] visit = new boolean[26];
        // 记录整个字符串中，所有字符的个数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            // 如果该字符存在于栈中，直接跳过
            if (visit[c - 'a']) {
                continue;
            }
            // 栈顶元素大于当前字符
            while (!stack.isEmpty() && stack.peek() > c) {
                char p = stack.peek();
                if (count[p - 'a'] > 0) {
                    // 如果后面还有栈顶字符，那么说明栈顶字符可以舍弃
                    visit[p - 'a'] = false;
                    stack.pop();
                } else {
                    break;
                }
            }
            // 当前字符入栈
            stack.push(c);
            visit[c - 'a'] = true;
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        String s2 = "cbacdcbc";

        Solution solut = new Solution();
        System.out.println(solut.removeDuplicateLetters(s2));
    }
}
