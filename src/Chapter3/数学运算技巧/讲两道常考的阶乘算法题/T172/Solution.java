package Chapter3.数学运算技巧.讲两道常考的阶乘算法题.T172;

public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 125;

        Solution solut = new Solution();
        System.out.println(solut.trailingZeroes(n));
    }
}
