package Chapter1.设计数据结构.队列实现栈_栈实现队列.T225;

// 用队列实现栈

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    Deque<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offerFirst(x);
    }

    public int pop() {
        return queue.pollFirst();
    }

    public int top() {
        return queue.peekFirst();
    }

    public boolean empty() {
        if (queue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
