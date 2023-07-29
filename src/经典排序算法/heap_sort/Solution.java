package 经典排序算法.heap_sort;


public class Solution {
    // 大根堆
    public void bigHeapAdjust(int[] heap, int low, int high) {
        int tmpRoot = heap[low];
        int i = low;
        // 左孩子索引
        int j = i * 2 + 1;

        // 退出循环的条件
        // 1.孩子节点索引超出堆的范围
        // 2.不需要调整
        while (j <= high) {
            if (j + 1 <= high && heap[j] < heap[j + 1]) {
                // 选择较大值
                j += 1;
            }
            if (tmpRoot < heap[j]) {
                heap[i] = heap[j];
                i = j;
                j = i * 2 + 1;
            } else {
                // 如果根节点比较大者还要大，那么这一段不需要调整
                break;
            }
        }
        heap[i] = tmpRoot;
    }

    // 小根堆
    public void littleHeapAdjust(int[] heap, int low, int high) {
        int tmpRoot = heap[low];
        int i = low;
        int j = i * 2 + 1;

        while (j <= high) {
            if (j + 1 <= high && heap[j] > heap[j + 1]) {
                // 选择较小值
                j += 1;
            }
            if (tmpRoot > heap[j]) {
                heap[i] = heap[j];
                i = j;
                j = i * 2 + 1;
            } else {
                break;
            }
        }
        heap[i] = tmpRoot;
    }

    public static void main(String[] args) {
    }
}
