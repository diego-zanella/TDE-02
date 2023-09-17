package game;

import java.util.*;

class Stack {
    private LinkedList<Integer> stack = new LinkedList<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        if (!isEmpty()) {
            return stack.pop();
        }
        return -1; 
    }

    public int peek() {
        if (!isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int size() {
        return stack.size();
    }

    public void printStack() {
        for (Integer value : stack) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
