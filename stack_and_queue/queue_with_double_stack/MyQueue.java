package stack_and_queue.queue_with_double_stack;

import java.util.ArrayDeque;
import java.util.Deque;

//由两个栈组成的队列

public class MyQueue<T>{
    private Deque<T> stackPush;
    private Deque<T> stackPop;

    public MyQueue() {
        this.stackPush =new ArrayDeque<T>();
        this.stackPop = new ArrayDeque<>();
    }

    public void add(T e){
        stackPush.push(e);
    }

    public T poll(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("queue is empty");
        }else if(stackPop.isEmpty()){//关键在于只有stackPop为空时才将stackPush中的元素全部倒入stackPop中
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public T peek(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
