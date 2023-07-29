package 经典排序算法.字符串或按前缀字符排序.T440;

public class Solution {
    // 递推
    // 1 <= k <= n <= 10^9  TLE
    // 能做，但是n不能太大
    public int findKthNumber(int n, int k) {
        int num = 1;
        int i = 0;
        while (i < n) {
            if (i == k - 1) {
                return num;
            }
            if (num * 10 < n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num += 1;
            }
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 13;
        int k = 3;

        Solution solut = new Solution();
        System.out.println(solut.findKthNumber(n, k));
    }
}
