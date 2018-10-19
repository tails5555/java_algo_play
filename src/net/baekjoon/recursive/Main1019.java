package net.baekjoon.recursive;

import java.util.Scanner;
// Baekjoon 1019번 문제 풀이
public class Main1019 {
    static int[] result=new int[10];
    static Scanner s=new Scanner(System.in);
    // 10단위 이전과 9단위 이후의 숫자들을 그냥 처리한다.
    public static void counting(int a, int point){
        while(a > 0){
            result[a%10]+=point;
            a /= 10;
        }
    }
    public static void main(String[] args){
        int page=s.nextInt();
        int start = 1;
        int point = 1;
        while( start <= page ){
            // 끝 범위를 9단위로부터 끝내도록 한다.
            while(page % 10 != 9 && start <= page){
                counting(page, point);
                page--;
            }

            // 여기서 범위가 잘 못 된다면 while문을 종결한다.
            if(page < start) break;

            // 시작 범위를 10 단위로부터 시작할 수 있도록 한다.
            while(start % 10 != 0 && start <= page){
                counting(start, point);
                start++;
            }

            // 시작 범위와 끝 단위에 대해 10씩 나뉘어 준다.
            page /= 10;
            start /= 10;

            // 그러면 일의 자리에 있는 숫자들에 맞춰서 계산을 할 수 있게 된다.
            for(int k=0;k<result.length;k++){
                result[k] += ( page - start + 1 ) * point;
            }

            // 다음 자리 수는 어자피 10 단위씩 늘어나게 된다.
            point *= 10;
        }

        // 결과 출력으로 반환을 한다.
        for(int k=0;k<result.length;k++){
            System.out.print(result[k]+" ");
        }
    }
}
