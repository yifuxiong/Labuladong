package Chapter1.数组.滑动窗口.T3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int ans = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        Solution solut = new Solution();
        System.out.println(solut.lengthOfLongestSubstring(s));
    }
}
