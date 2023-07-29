package Chapter3.经典面试题.字符串乘法计算.T43;

public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int n1 = (num1.charAt(i) - '0');
                int n2 = (num2.charAt(j) - '0');

                // 重点是怎么确定这两个位置
                // p1是进位，p2是个位
                int p1 = i + j, p2 = i + j + 1;
                int sum = n1 * n2 + ans[p2];
                ans[p1] += sum / 10;  // 十位进位
                ans[p2] = sum % 10;  // 个位不变
            }
        }

        int k = 0;
        while (k < m + n && ans[k] == 0) {
            k++;
        }
        StringBuffer sb = new StringBuffer();
        while (k < m + n) {
            sb.append(ans[k++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";

        Solution solut = new Solution();
        System.out.println(solut.multiply(num1, num2));
    }
}
