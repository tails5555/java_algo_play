package net.hackerrank.array;

// Hacker Rank Array 문제
// 4번. Minimum Swap 2 문제
// 오름 차순으로 정렬하기 위한 최소 옮기는 횟수 추측 문제
// 맨 앞 순서가 일치하지 않으면 그 인덱스를 앞으로 땡겨서 옮기면 최소 횟수가 나오는 신기한 문제.
public class Example04 {
    static int minimumSwaps(int[] arr) {
        int cnt = 0;
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            while(start + 1 == arr[start] && start < end)
                start += 1;
            while(end + 1 == arr[end] && start < end)
                end -= 1;

            if(start < end){
                int tmp = arr[arr[start] - 1];
                arr[arr[start] - 1] = arr[start];
                arr[start] = tmp;
                cnt += 1;
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        System.out.println(minimumSwaps(new int[] { 4, 3, 1, 2 }));
        System.out.println(minimumSwaps(new int[] { 2, 3, 4, 1, 5 }));
        System.out.println(minimumSwaps(new int[] { 1, 3, 5, 2, 4, 6, 7 }));
    }
}

// [4] 3 1 [2] => 2 3 1 4 1회
// [2] [3] 1 4 => 3 2 1 4 2회
// [3] 2 [1] 4 => 1 2 3 4 3회

// [2] [3] 4 1 5 => 3 2 4 1 5
// [3] 2 [4] 1 5 => 4 2 3 1 5
// [4] 2 3 [1] 5 => 1 2 3 4 5 총 3회
