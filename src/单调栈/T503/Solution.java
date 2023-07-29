package 单调栈.T503;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 环形数组使用单调栈
    // 一般思路是通过 % 运算符求模（余数），来模拟环形特效

    // 但本题这种需求，常用套路就是将数组长度翻倍
    // 不用构造新数组，而是利用循环数组的技巧来模拟数组长度翻倍的效果
    int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> s = new ArrayDeque<>();
        // 数组长度加倍模拟环形数组
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引 i 要求模，其他的和模板一样
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
    // res会被刷新一遍，太妙了!
}
