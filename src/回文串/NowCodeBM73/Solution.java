package 回文串.NowCodeBM73;

// 这题和T516还不同
// 这题只能找连续的回文串
// T516可以删除或者不删除某些字符，这种情况下找回文串

public class Solution {
    public int getLongestPalindrome(String A) {
        int n = A.length();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = getLen(A, i, i);
            int len2 = getLen(A, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return end - start - 1;
    }

    public int getLen(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left + 1;
    }
}
