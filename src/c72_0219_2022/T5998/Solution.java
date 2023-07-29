package c72_0219_2022.T5998;

// 第2题
// 找到和为给定整数的三个连续整数

public class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[]{};
        }

        long[] ans = new long[3];
        if (num > 0) {
            ans[0] = num / 3 - 1;
            ans[1] = num / 3;
            ans[2] = num / 3 + 1;
        } else if (num == 0) {
            ans[0] = -1;
            ans[1] = 0;
            ans[2] = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        long num = 12423510;

        Solution solut = new Solution();
        long[] ans = solut.sumOfThree(num);
        if (ans.length != 0) {
            System.out.println(ans[0]);
            System.out.println(ans[1]);
            System.out.println(ans[2]);
        }
    }
}
