package 蓄水池采样法;

import java.util.Random;

public class Solution {
    Random rand = new Random();

    public int getOne(int[] nums) {
        int index = 0;
        int times = 0;

        for (int i = 0; i < nums.length; i++) {
            times++;
            if (rand.nextInt(times) == 0) {
                index = i;
            }
        }
        return index;
    }

    // 指定一个值，抽多次
    public int getK(int[] nums, int k) {
        int index = 0;
        int times = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                times++;
                if (rand.nextInt(times) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 1;

        nums[3] = 2;
        nums[4] = 2;

        nums[5] = 3;
        nums[6] = 3;
        nums[7] = 3;

        nums[8] = 4;

        nums[9] = 5;

        Solution solut = new Solution();
        System.out.println(solut.getOne(nums));
        System.out.println(solut.getK(nums, 2));
    }
}
