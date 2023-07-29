package 双向遍历.T821;

import java.util.Arrays;

class Solution {
    // 从左边和右边遍历2次
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, n);

        int left = -n;  // 细节
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                left = i;
            }
            ans[i] = Math.min(ans[i], i - left);
        }

        int right = n * 2;  // 细节
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right = i;
            }
            ans[i] = Math.min(ans[i], right - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';

        Solution solut = new Solution();
        int[] ans = solut.shortestToChar(s, c);
        for (int a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
