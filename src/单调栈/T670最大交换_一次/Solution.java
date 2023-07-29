package 单调栈.T670最大交换_一次;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 找到左边第一个比右边某个大数小的，左边【尽可能靠左】，右边【尽可能大】且【尽可能靠右】。
 *
 * 维护被交换的坐标：
 * （1）当出现可以交换【更左边】的时候（单调栈弹出），左边变为弹出坐标；
 * （2）当出现【更大】的数将右边交换的坐标弹出时，右边坐标变为新坐标；
 * （3）当出现与右边坐标【一样大】的但【更靠右】时，右边坐标变为新坐标。
 *
 * */
public class Solution {
    public int maximumSwap(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int n = chs.length;
        int left = n, right = n;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && chs[stack.peekLast()] < chs[i]) {
                int idx = stack.pollLast();
                // (1)更加靠左的最小值
                if (idx < left) {
                    left = idx;
                    right = i;
                }
                // (2)更加靠右的最大值
                if (right == idx) {
                    right = i;
                }
            }
            // (3)最大值相同，但更靠右
            if (right < n && chs[right] == chs[i]) {
                right = i;
            }
            stack.offerLast(i);
        }

        // left < n表示找到左边一个更小的数了，右边也一定移动过了
        if (left < n) {
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            return Integer.parseInt(new String(chs));
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 281482;

        Solution solut = new Solution();
        System.out.println(solut.maximumSwap(num));
    }
}
