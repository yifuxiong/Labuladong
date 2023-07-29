package 单调栈.T901;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    // <value, index>
    Deque<int[]> stack;
    int idx = 0;

    public StockSpanner() {
        stack = new ArrayDeque<int[]>();
    }

    public int next(int price) {
        idx++;

        while (!stack.isEmpty() && stack.peekLast()[0] <= price){
            stack.pollLast();
        }
        int res = stack.isEmpty() ? idx : (idx - stack.peekLast()[1]);
        stack.offerLast(new int[]{price, idx});
        return res;
    }
}
