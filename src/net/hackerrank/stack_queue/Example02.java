package net.hackerrank.stack_queue;

import java.util.Scanner;
import java.util.Stack;

// Hacker Rank Stack, Queue 응용 문제
// A Tale of Two Stacks 문제(2개의 스택으로 Queue 를 구현하는 문제)
public class Example02 {
    static class MyQueue<T> {
        Stack<T> lifo;
        Stack<T> fifo;

        public MyQueue() {
            super();
            this.lifo = new Stack<>();
            this.fifo = new Stack<>();
        }

        public void lifoToFifo() {
            if(fifo.isEmpty())
                while(!lifo.isEmpty())
                    fifo.push(lifo.pop());
        }

        public void enqueue(T value) {
            lifo.push(value);
        }

        public T dequeue() {
            lifoToFifo();
            return fifo.pop();
        }

        public T peek() {
            lifoToFifo();
            return fifo.peek();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
