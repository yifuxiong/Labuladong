package Chapter1.设计数据结构.队列实现栈_栈实现队列.T232;

// 用双栈实现队列

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public Solution() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
