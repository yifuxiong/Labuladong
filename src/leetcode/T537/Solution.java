package leetcode.T537;

public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] s1 = num1.split("\\+|i");
        String[] s2 = num2.split("\\+|i");

        // 或者用substring(0, num1.indexOf('+'))
        // substring(num1.indexOf('+') + 1, num1.indexOf('i'))

        int n1 = Integer.valueOf(s1[0]);
        int n1i = Integer.valueOf(s1[1]);
        int n2 = Integer.valueOf(s2[0]);
        int n2i = Integer.valueOf(s2[1]);

        int real = n1 * n2 - n1i * n2i;
        int virtual = n1 * n2i + n2 * n1i;
        StringBuffer sb = new StringBuffer();
        sb.append(real);
        sb.append('+');
        sb.append(virtual);
        sb.append('i');

        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "1+1i", num2 = "1+1i";
        String num12 = "1+-1i", num22 = "1+-1i";

        Solution solut = new Solution();
        System.out.println(solut.complexNumberMultiply(num12, num22));
    }
}
