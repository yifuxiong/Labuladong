package Chapter3.数学运算技巧.T231;

// 检查二进制数中总共只有1个1

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else {
            return (n & (n - 1)) == 0;
        }
    }

    public static void main(String[] args) {
        int n = 16;

        Solution solut = new Solution();
        System.out.println(solut.isPowerOfTwo(n));
    }
}
