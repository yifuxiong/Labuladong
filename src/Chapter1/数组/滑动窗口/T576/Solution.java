package Chapter1.数组.滑动窗口.T576;

// 数组[26] + 滑动窗口

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        int left = 0, right = s1.length() - 1;
        while (right < s2.length() - 1) {
            count2[s2.charAt(left) - 'a']--;
            left++;
            right++;
            count2[s2.charAt(right) - 'a']++;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    // labuladong 滑动窗口模板
    // 对于这道题的解法代码，基本上和最小覆盖子串一模一样，只需要改变两个地方：
    // 1、本题移动 left 缩小窗口的时机是窗口大小大于 t.size() 时，应为排列嘛，显然长度应该是一样的。
    // 2、当发现 valid == need.size() 时，就说明窗口中就是一个合法的排列，所以立即返回 true。
    // 至于如何处理窗口的扩大和缩小，和最小覆盖子串完全相同。
    public boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        String s12 = "ab", s22 = "eidboaoo";

        Solution solut = new Solution();
        System.out.println(solut.checkInclusion(s12, s22));
        System.out.println(solut.checkInclusion2(s12, s22));

    }
}
