package net.hackerrank.recursion;

// Hacker Rank 재귀 함수 응용 문제
// Fibonacci Numbers 문제
public class Example01 {
    public static int fibonacci(int i) {
        if(i == 0) return 0;
        if(i == 1 || i == 2) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    public static void main(String[] args){
        for(int k=0;k<=10;k++){
            System.out.println(fibonacci(k));
        }
    }
}
