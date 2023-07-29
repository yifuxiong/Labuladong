package 回文串.T5;

// 中心扩展法
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // 取得到end，左闭右开所以+1
        return s.substring(start, end + 1);
    }

    // 中心扩展
    // 返回回文串长度
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return right - left - 1;
    }
}
