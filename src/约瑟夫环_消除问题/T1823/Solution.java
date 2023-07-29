package 约瑟夫环_消除问题.T1823;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 队列模拟
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            // 前k-1个加到队列后面去
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            // 将第k个淘汰，后面继续循环队列
            queue.poll();
        }
        return queue.peek();
    }

    // 数学方法：迭代
    public int findTheWinner2(int n, int k) {
        int p = 0;
        // 这里是逆推公式
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }

    // 数学方法：递归
    // 每次往同一方向，以固定步长 k 进行消数。
    // 由于下一次操作的发起点为消除位置的下一个点
    // （即前后两次操作发起点在原序列下标中相差 k），
    // 同时问题规模会从 n 变为 n − 1，
    // 因此原问题答案等价于 findTheWinner(n - 1, k) + k。
    //
    // 一些细节，由于编号从 1 开始，在返回答案时我们需要将结果为 0 的值映射回编号 n。
    public int findTheWinner3(int n, int k) {
        if (n <= 1) {
            return n;
        }
        // 逆推公式
        // https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/solution/by-huang-bin-bin-7-zvh1/
        int ans = (findTheWinner3(n - 1, k) + k) % n;
        return ans == 0 ? n : ans;
    }

    public static void main(String[] args) {
        int n = 5, k = 2;

        Solution solut = new Solution();
        System.out.println(solut.findTheWinner(n, k));
        System.out.println(solut.findTheWinner2(n, k));
        System.out.println(solut.findTheWinner3(n, k));
    }
}
