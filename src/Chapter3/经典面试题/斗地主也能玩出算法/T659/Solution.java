package Chapter3.经典面试题.斗地主也能玩出算法.T659;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Integer> need = new HashMap<>();

    public boolean isPossible(int[] nums) {
        // 统计nums中元素的频率
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freq.get(num) == 0) {
                // 已经被用到其他子序列中
                continue;
            }

            // 先判断num是否能接到其他子序列后面
            if (need.containsKey(num) && need.get(num) > 0) {
                // num可以接到之前的某个序列后面
                freq.put(num, freq.get(num) - 1);

                // 对num的需求减1
                need.put(num, need.get(num) - 1);

                // 对num+1的需求加1
                need.put(num + 1, need.getOrDefault(num, 0) + 1);
            } else if (freq.get(num) > 0 && freq.containsKey(num + 1) && freq.get(num + 1) > 0 && freq.containsKey(num + 2) && freq.get(num + 2) > 0) {
                // 将num作为开头，新建一个长度为3的子序列[num, num+1, num+2]
                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);

                // 对num+3的需求加1
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                // 两种情况都不符合，则无法分配
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 3, 4, 4, 5, 5};
        int[] nums3 = {1, 2, 3, 4, 4, 5};

        Solution solut = new Solution();
        System.out.println(solut.isPossible(nums));
    }
}
