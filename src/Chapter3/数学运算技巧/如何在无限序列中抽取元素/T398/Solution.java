package Chapter3.数学运算技巧.如何在无限序列中抽取元素.T398;

// 蓄水池抽样法（指定一个元素抽多次）

import java.util.Random;

public class Solution {
    Random r;
    int[] nums;

    public Solution(int[] nums) {
        r = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int index = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                times++;
                if (r.nextInt(times) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};  // 无序排列
        int target = 3;

        Solution solut = new Solution(nums);
        System.out.println(solut.pick(target));
    }
}
