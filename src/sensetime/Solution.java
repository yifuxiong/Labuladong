package sensetime;

/*
 * leetcode T632
 *
 * 给定k个有序数组，每个数组有N个元素，找出一个最小的闭区间，使其包含每个数组中的至少一个元素。
 * 比如：
 * 给定两个区间[a, b], [c, d];
 * 如果b - a < d - c，则认为[a, b]是更小的区间；
 * 如果b - a == d - c，且a < c，则认为[a, b]是更小的区间。
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        System.out.println("size=" + size);
        Map<Integer, List<Integer>> indices = new HashMap<>();

        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            for (int x : nums.get(i)) {
                List<Integer> list = indices.getOrDefault(x, new ArrayList<>());
                list.add(i);
                indices.put(x, list);
                xMin = Math.min(xMin, x);
                xMax = Math.max(xMax, x);
            }
        }
        System.out.println(xMin + ", " + xMax);
        // System.out.println(indices);

        int[] freq = new int[size];
        int inside = 0;
        int left = xMin, right = xMin - 1;
        int bestLeft = xMin, bestRight = xMax;

        while (right < xMax) {
            right++;
            if (indices.containsKey(right)) {
                for (int x : indices.get(right)) {
                    freq[x]++;
                    if (freq[x] == 1) {
                        // 每增加一个新数组下标
                        // 相当于每满足一个数组中，存在right这个值
                        inside++;
                    }
                }

                // 当所有数组都有这个值
                while (inside == size) {
                    if (right - left < bestRight - bestLeft) {
                        bestLeft = left;
                        bestRight = right;
                    }

                    if (indices.containsKey(left)) {
                        for (int x : indices.get(left)) {
                            freq[x]--;
                            if (freq[x] == 0) {
                                inside--;
                            }
                        }
                    }
                    left++;
                }
            }
        }

        return new int[]{bestLeft, bestRight};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        n1.add(4);
        n1.add(10);
        n1.add(15);
        n1.add(24);
        n1.add(26);
        nums.add(n1);
        List<Integer> n2 = new ArrayList<>();
        n2.add(0);
        n2.add(9);
        n2.add(12);
        n2.add(20);
        nums.add(n2);
        List<Integer> n3 = new ArrayList<>();
        n3.add(5);
        n3.add(18);
        n3.add(22);
        n3.add(30);
        nums.add(n3);

        Solution solut = new Solution();
        int[] ans = solut.smallestRange(nums);
        for (int a : ans) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
}
