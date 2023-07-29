package 双向遍历.T2055;

// 蜡烛和盘子

public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 每个盘子找左边最近的蜡烛
        // 和右边最近的蜡烛
        int n = s.length();
        int[] left = new int[n];
        int leftLast = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                leftLast = i;
            }
            left[i] = leftLast;
        }

        int[] right = new int[n];
        int rightLast = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                rightLast = i;
            }
            right[i] = rightLast;
        }

        // 前缀和
        int[] preSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int leftB = right[queries[i][0]];
            int rightB = left[queries[i][1]];
            if (leftB == -1 || rightB == n || leftB >= rightB) {
                ans[i] = 0;
            } else {
                ans[i] = preSum[rightB] - preSum[leftB];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};

        String s2 = "***|**|*****|**||**|*";
        int[][] queries2 = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};

        Solution solut = new Solution();
        int[] ans = solut.platesBetweenCandles(s2, queries2);
        for (int a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
