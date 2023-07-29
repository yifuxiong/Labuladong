package Chapter1.数组.二维数组的花式遍历技巧.T59;

// 螺旋构建二维数组

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int k = 1;
        int up = 0, down = n - 1;
        int left = 0, right = n - 1;

        while (true) {
            for (int j = left; j <= right; j++) {
                ret[up][j] = k;
                k++;
            }
            up += 1;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                ret[i][right] = k;
                k++;
            }
            right -= 1;
            if (left > right) {
                break;
            }
            for (int j = right; j >= left; j--) {
                ret[down][j] = k;
                k++;
            }
            down -= 1;
            if (up > down) {
                break;
            }
            for (int i = down; i >= up; i--) {
                ret[i][left] = k;
                k++;
            }
            left += 1;
            if (left > right) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 3;

        Solution solut = new Solution();
        int[][] ret = solut.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}
