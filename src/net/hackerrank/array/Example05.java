package net.hackerrank.array;

// Hacker Rank Array 문제
// 5번. Array Manipulation 문제
// 일정 범위에 대한 배열을 채워 나가면서 최댓값을 구하는 문제
// 재미있는건 오히려 3번 4번보다 이게 더 쉬워 보인다는게 함정?? 그러나 타임 아웃을 집중해라.
public class Example05 {
    /*
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        long[] tmp = new long[n];
        for(int k = 0; k < queries.length; k++){
            for(int l = queries[k][0] - 1; l < queries[k][1]; l++){
                tmp[l] += queries[k][2];
                max = Math.max(tmp[l], max);
            }
        }

        return max;
    }
    */

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n+1];
        for(int k = 0; k < queries.length; k++){
            arr[queries[k][0] - 1] += queries[k][2];
            arr[queries[k][1]] -= queries[k][2];
        }

        long max = arr[1];
        for(int k = 1; k <= n; k++){
            arr[k] += arr[k - 1];
            max = Math.max(arr[k], max);
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(arrayManipulation(5, new int[][] {
            { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 }
        }));
        System.out.println(arrayManipulation(10, new int[][] {
            { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 }
        }));
    }
}

// [ 100, 0, -100, 0, 0, 0 ]
// [ 100, 100, -100, 0, 0, -100 ]
// [ 100, 100, 0, 0, -100, -100 ]

// [ 3, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0 ]
// [ 3, 0, 0, 7, 0, -3, 0, 0, -7, 0, 0 ]
// [ 3, 0, 0, 7, 0, -2, 0, 0, -7, -1, 0 ]

// 이 배열에 있는 값을을 서로 더해가면서 최댓값, 최솟값을 찾아 내면 최적의 방법으로 풀 수 있다.