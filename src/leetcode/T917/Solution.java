package leetcode.T917;

public class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        char[] chs = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            if (!isChar(chs[left])) {
                left++;
                continue;
            }
            if (!isChar(chs[right])) {
                right--;
                continue;
            }

            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;

        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    public boolean isChar(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "7_28]";

        Solution solut = new Solution();
        System.out.println(solut.reverseOnlyLetters(s));
    }
}
