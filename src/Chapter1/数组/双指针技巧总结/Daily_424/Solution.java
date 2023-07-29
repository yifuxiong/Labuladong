package Chapter1.数组.双指针技巧总结.Daily_424;

// 双指针

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] table = new int[26];

        char[] chs = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < chs.length; right++) {
            int index = chs[right] - 'A';
            table[index]++;
            maxLen = Math.max(maxLen, table[index]);

            if (right - left + 1 > maxLen + k) {
                table[chs[left] - 'A']--;
                // 左指针移动
                left++;
            }
        }
        return chs.length - left;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;

        Solution solut = new Solution();
        System.out.println(solut.characterReplacement(s, k));
    }

}
