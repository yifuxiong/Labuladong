package Chapter1.数组.双指针技巧总结.T344;

// 反转字符串
// 双指针

public class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int left = 0, right = n - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        Solution solut = new Solution();
        solut.reverseString(s);
    }
}
