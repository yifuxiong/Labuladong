package 滑动窗口.T424;

import java.util.HashMap;
import java.util.Map;

// 替换后的最长重复字符
public class Solution {
    Map<Character, Integer> window = new HashMap<>();

    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int maxLen = 0;
        while (right < n) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);
            maxLen = Math.max(maxLen, window.get(c));

            // 注意这里没有(right - left + 1 > maxLen + k)
            // 因为right已经++了
            while (right - left > maxLen + k) {
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);
            }
        }
        return maxLen + k > n ? n : maxLen + k;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        // out = 4

        String s2 = "AABABBA";
        int k2 = 1;
        // out = 4

        Solution solut = new Solution();
        System.out.println(solut.characterReplacement(s2, k2));
    }
}
