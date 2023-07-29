package 滑动窗口.T438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词⼦串，返回这些⼦串的起始索引。
// 不考虑答案输出的顺 序。
// 异位词指由相同字⺟重排列形成的字符串（包括相同的字符串）。

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 初始化
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 更新参数
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 窗口收缩
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    ans.add(left);
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        String s2 = "abab";
        String p2 = "ab";

        Solution solut = new Solution();
        System.out.println(solut.findAnagrams(s2, p2));
    }
}
