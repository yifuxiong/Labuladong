package 滑动窗口.T3;

// 给定⼀个字符串 s，请你找出其中不含有重复字符的最⻓⼦串的⻓度。

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int ans = 0;

        int n = s.length();
        int left = 0, right = 0;
        while (right < n) {
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断窗口是否要收缩
            while (window.get(c) > 1) {
                // 添加可行解

                char d = s.charAt(left);
                left++;

                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 另外，要在收缩窗⼝完成后更新 res，
            // 因为窗⼝收缩的 while 条件是存在重复元素，
            // 换句话说收缩完成后⼀ 定保证窗⼝中没有重复。
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";  // 3

        Solution solut = new Solution();
        System.out.println(solut.lengthOfLongestSubstring(s));
    }
}
