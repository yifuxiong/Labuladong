package 经典排序算法.quick_sort;

import java.util.Random;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public Main() {
        int n = Integer.parseInt(scan.nextLine());
        String[] strNums = scan.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }

        System.out.println(topK(nums, 5));
    }

    public int parti(int[] nums, int low, int high) {
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        int pivot = nums[pivotIndex];

        // 交换到首位
        int temp = nums[low];
        nums[low] = pivot;
        pivot = temp;

        int left = low, right = high;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
//            if (left < right) {
//                nums[left] = nums[right];
//                left++;
//            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
//            if (left < right) {
//                nums[right] = nums[left];
//                right--;
//            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public void qsort(int[] nums, int low, int high) {
        if (low < high) {
            int pos = parti(nums, low, high);
            qsort(nums, low, pos - 1);
            qsort(nums, pos + 1, high);
        }
    }

    public int topK(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;

        int from = 0, to = n - 1;
        while (true) {
            int idx = parti(nums, from, to);
            if (idx == target) {
                return nums[idx];
            } else if (idx > target) {
                to = idx - 1;
            } else {
                from = idx + 1;
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
