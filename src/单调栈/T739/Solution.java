package 单调栈.T739;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 栈中存放下标
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                stack.pollLast();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peekLast() - i);
            stack.offerLast(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 76};

        Solution solut = new Solution();
        int[] res = solut.dailyTemperatures(temperatures);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
