package stack_and_queue.stack_getMin;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;


public class MyStack<T> {

    private Deque<T> stackData;
    private Deque<T> stackMin;
    private Comparator<T> comparator;

    public MyStack() {
        this.stackData = new ArrayDeque<T>();
        this.stackMin = new ArrayDeque<T>();

    }

    public MyStack(Comparator<T> comparator) {
        this.stackData = new ArrayDeque<T>();
        this.stackMin = new ArrayDeque<T>();
        this.comparator = comparator;
    }

    public void push(T e) {
        stackData.push(e);
        if (stackMin.isEmpty()) {
            stackMin.push(e);
        } else {
            if (comparator != null) {
                if (comparator.compare(e, stackMin.peek()) >= 0) {
                    stackMin.push(stackMin.peek());
                } else {
                    stackMin.push(e);
                }
            } else {
                if (((Comparable<T>) e).compareTo(stackMin.peek()) >= 0) {
                    stackMin.push(stackMin.peek());
                }else{
                    stackMin.push(e);
                }
            }

        }
    }

    public T pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        } else {
            stackMin.pop();
            return stackData.pop();
        }
    }

    public T getMin() {
        if(stackMin.isEmpty()){
            throw new RuntimeException("stack is empty");
        }else{
            return stackMin.peek();
        }
    }
}
