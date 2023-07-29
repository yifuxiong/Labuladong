package 经典排序算法.quick_sort;

import java.util.Random;

// 快速排序优化算法
public class SolutionII {
    Random rand = new Random();

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partion(nums, left, right);
            quickSort(nums, left, mid);
            quickSort(nums, mid + 1, right);
        }
    }

    public int partion(int[] nums, int left, int right) {
        int pivotIdx = left + rand.nextInt(right - left + 1);
        int pivot = nums[pivotIdx];

        int temp = nums[left];
        nums[left] = pivot;
        pivot = temp;

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

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9, 8, 3, 4, 4, 8, 8};

        SolutionII solutII = new SolutionII();
        solutII.quickSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
