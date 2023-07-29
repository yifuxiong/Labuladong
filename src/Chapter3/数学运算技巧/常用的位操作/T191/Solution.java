package Chapter3.数学运算技巧.T191;

// 使用n&(n-1)，每次消去n的二进制数的最后一个1

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        // n & (n - 1)可以消除n中最后一位1，
        // 因此循环能进行多少次，那么这个数中就有多少个1
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        // 二进制前加0b
        int n = 0b00000000000000000000000000001011;

        Solution solut = new Solution();
        System.out.println(solut.hammingWeight(n));
    }
}
