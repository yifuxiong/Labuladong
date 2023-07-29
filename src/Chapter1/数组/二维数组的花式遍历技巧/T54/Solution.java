package Chapter1.数组.二维数组的花式遍历技巧.T54;

import java.util.ArrayList;
import java.util.List;

// 矩阵的螺旋遍历
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;

        int up = 0, down = n - 1;
        int left = 0, right = m - 1;
        while (true) {
            // 上面，从左到右
            for (int j = left; j <= right; j++) {
                ret.add(matrix[up][j]);
            }
            up += 1;
            if (up > down) {
                break;
            }
            // 右侧，从上到下
            for (int i = up; i <= down; i++) {
                ret.add(matrix[i][right]);
            }
            right -= 1;
            if (left > right) {
                break;
            }
            // 下面，从右到左
            for (int j = right; j >= left; j--) {
                ret.add(matrix[down][j]);
            }
            down -= 1;
            if (up > down) {
                break;
            }
            // 左侧，从下到上
            for (int i = down; i >= up; i--) {
                ret.add(matrix[i][left]);
            }
            left += 1;
            if (left > right) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        Solution solut = new Solution();
        List<Integer> ret = solut.spiralOrder(matrix2);
        System.out.println(ret);
    }
}
