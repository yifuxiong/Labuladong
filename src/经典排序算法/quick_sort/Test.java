package 经典排序算法.quick_sort;

import java.util.Random;
import java.util.Scanner;

// 第K小的数字
public class Test {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public int partion(int[] nums, int left, int right) {
        int pivotIdx = left + rand.nextInt(right - left + 1);
        int pivot = nums[pivotIdx];

        int temp = pivot;
        pivot = nums[left];
        nums[left] = temp;

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int topK(int[] nums, int k) {
        int n = nums.length;
        // 从小到大排
        int target = k - 1;
        // 从大到小排
        // int target = n - k;

        int from = 0, to = n - 1;
        while (true) {
            int mid = partion(nums, from, to);
            if (mid == target) {
                return nums[mid];
            } else if (mid < target) {
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 6, 2, 7, 4};

        Test t = new Test();
        int tk = t.topK(nums, 1);
        System.out.println(tk);
    }
}
