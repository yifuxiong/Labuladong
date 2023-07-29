package 滑动窗口.T76;

// 给你⼀个字符串 s 、⼀个字符串 t，返回 s 中涵盖 t 所有字符的最⼩⼦串；
// 如果 s 中不存在涵盖 t 所有字符 的⼦串，则返回空字符串 ""。

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 初始化need，need就是t的所有字符
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int start = 0, len = Integer.MAX_VALUE;

        int n = s.length();
        int valid = 0;
        int left = 0, right = 0;
        while (right < n) {
            char c = s.charAt(right);
            right++;

            // 更新系数
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 窗口收缩条件
            while (valid == need.size()) {
                // 更新有没有更小的区间
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                // 更新系数
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        if (len == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, start + len);
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String s2 = "aa";
        String t2 = "aa";

        Solution solut = new Solution();
        System.out.println(solut.minWindow(s2, t2));
    }
}
