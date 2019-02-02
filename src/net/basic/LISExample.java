package net.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// LIS(Longest Increasin' Subsequence) 최장 부분 증가 수열 관련 소스 코드
public class LISExample {
    static int[] array;
    static int[] sorted_array;
    static Random random;

    // Case 01. Dynamic Programming 을 이용한 방법.
    // 시간 복잡도는 O(N2) 이 나오고, 공간 복잡도는 O(N) 만큼 잡아 먹습니다.
    static int lis_using_dp() {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[array.length];
        dp[0] = 1;

        for(int k = 1; k < array.length; k++){
            dp[k] = 1;
            for(int l = 0; l < k; l++) {
                if(array[k] > array[l] && dp[k] < (dp[l] + 1)) {
                    dp[k] = dp[l] + 1;
                }
            }
            max = Math.max(max, dp[k]);
        }

        System.out.println(Arrays.toString(dp));
        return max;
    }

    // Case 02. Index Tree 를 활용한 방법
    // 시간 복잡도는 총 O(N log N) 이 나오고, 공간 복잡도는 O(N) 만큼 잡아 먹습니다.
    static int lis_using_index_tree() {
        sorted_array = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted_array);

        List<Integer> index_tree = new ArrayList<>();
        index_tree.add(Integer.MIN_VALUE);
        int size = 0;

        for(int k = 0; k < array.length; k++){
            if(array[k] > index_tree.get(size)) {
                index_tree.add(array[k]);
                size += 1;
            } else {
                int idx = lower_bound(index_tree, array[k]);
                index_tree.set(idx, array[k]);
            }
        }

        // Index Tree 에 남아 있는 값들을 출력하는 문장입니다.
        for(int k = 1; k <= size; k++) {
            System.out.print(index_tree.get(k) + " ");
            if(k == size) {
                System.out.println();
            }
        }

        return size;
    }

    // Index Tree 에 타겟에 맞는 값을 넣기 위해 이진 탐색으로 인덱스 자리를 탐색함. 시간 복잡도는 O(log N)
    static int lower_bound(List<Integer> list, int target) {
        int mid;
        int start = 0, end = list.size() - 1;
        while(start < end) {
            mid = (start + end) / 2;
            if(list.get(mid) >= target)
                end = mid;
            else
                start = mid + 1;
        }

        return end;
    }

    public static void main(String[] args){
        random = new Random();
        array = new int[50];
        for(int k = 0; k < 50; k++){
            array[k] = random.nextInt(100000) + 1;
        }

        System.out.println(Arrays.toString(array));

        System.out.println(lis_using_dp());
        System.out.println(lis_using_index_tree());
    }
}

// [10, 20, 90, 80, 40, 50, 100]
// Case 1. 10 => 1
// Case 2. 10 20 => 2
// Case 3. 10 20 90 => 3
// Case 4. 10 20 90 혹은 10 20 80 => 3
// Case 5. 10 20 90 혹은 10 20 80 혹은 10 20 40 => 3
// Case 6. 10 20 40 50 => 4
// Case 7. 10 20 40 50 100 => 5