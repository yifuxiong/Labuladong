package Chapter1.数组.二维数组的花式遍历技巧.T48;

// 二维矩阵的 顺/逆 时针旋转矩阵

public class Solution {
    // 顺时针旋转
    public void rotate(int[][] matrix) {
        // 先沿主对角线翻转
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再对每行进行翻转
        for (int[] mtx : matrix) {
            int i = 0, j = mtx.length - 1;
            while (i < j) {
                int temp = mtx[i];
                mtx[i] = mtx[j];
                mtx[j] = temp;
                i++;
                j--;
            }
        }
    }

    // 逆时针旋转
    public void rotate_inv(int[][] matrix) {
        // 先沿副对角线进行翻转
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }

        // 再对每行进行翻转
        for (int[] mtx : matrix) {
            int i = 0, j = mtx.length - 1;
            while (i < j) {
                int temp = mtx[i];
                mtx[i] = mtx[j];
                mtx[j] = temp;
                i++;
                j--;
            }
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int[] mtx : matrix) {
            for (int i = 0; i < mtx.length; i++) {
                System.out.print(mtx[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Solution solut = new Solution();
        // solut.rotate(matrix);
        solut.rotate_inv(matrix);
        solut.printMatrix(matrix);
    }
}
