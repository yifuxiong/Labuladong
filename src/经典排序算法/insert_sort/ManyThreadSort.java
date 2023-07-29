package 经典排序算法.insert_sort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ManyThreadSort {
//    public static void insertSort(int[] nums) {
//        int n = nums.length;
//        for (int i = 1; i < n; i++) {
//            int cur = nums[i];
//            int j = i;
//            while (j > 0 && cur < nums[j - 1]) {
//                nums[j] = nums[j - 1];
//                j--;
//            }
//            nums[j] = cur;
//
//            // 打印一遍
//            for (int k = 0; k < nums.length; k++) {
//                System.out.print(nums[k] + " ");
//            }
//            System.out.println();
//        }
//    }

    // 创建一个线程缓冲池
    public static ExecutorService pool = Executors.newCachedThreadPool();
    public static int[] nums = {31, 17, 13, 26, 4, 13, 45, 12, 25, 12, 13};

    public static int flag = 1; // 是否发生数据交换的标记

    public static synchronized void setFlag(int expect) {
        // 加锁控制，防止标志被其他线程改写
        flag = expect;
    }

    public static synchronized int getFlag() {
        return flag;
    }

    public static class OddEvenSortThread implements Runnable {
        int i;
        CountDownLatch latch;

        public OddEvenSortThread(int i, CountDownLatch latch) {
            this.i = i;
            this.latch = latch;
        }

        @Override
        public void run() {
            if (nums[i] > nums[i + 1]) {
                // 如果前面的数组元素大于后面的元素，交换顺序
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                setFlag(1);
            }
            latch.countDown();
        }
    }

    public static void eSort(int[] nums) throws InterruptedException {
        System.out.println("start");
        int start = 0;
        while (getFlag() == 1 || start == 1) {
            setFlag(0);
            CountDownLatch countDownLatch = new CountDownLatch(nums.length / 2 - (nums.length % 2 == 0 ? start : 0));
            for (int i = start; i < nums.length - 1; i += 2) {
                pool.submit(new OddEvenSortThread(i, countDownLatch));
            }
            countDownLatch.await();
            if (start == 0) {
                // 奇数和偶数切换，防止一直进行偶排序或者奇数排序
                start = 1;
            } else {
                start = 0;
            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        eSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
