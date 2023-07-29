package 滑动窗口.T567;

// 给你两个字符串 s1 和 s2，写⼀个函数来判断 s2 是否包含 s1 的排列
// （s1 的排列之⼀是 s2 的⼦串）。
// 如 果是，返回 true，否则返回 false。

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 初始化
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int n = s2.length();
        int valid = 0;
        int left = 0, right = 0;
        while (right < n) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 收缩窗口条件
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
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

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "eidboaoo";

        Solution solut = new Solution();
        System.out.println(solut.checkInclusion(s1, s3));
    }
}
