package net.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

// 정렬과 Heap(Priority Queue) 를 이용한 중앙 값(median 이다. middle idx 가 아니다.) 찾기 문제
// 시간 복잡도는 둘 다 O(n log n) 이 나옴.
public class FindMedianExample {
    // Case 01. 배열을 복사하고 난 후에 가운뎃 값을 계산하는 방법
    // 시간 복잡도는 O(n log n), 공간 복잡도는 O(n) 이 걸린다.
    static double finding_median1(int[] arr){
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);

        // 0 0 0 (0 0) 0 0 0 => 길이 8 중에서 인덱스 3, 4를 발견한다.
        if(tmp.length % 2 == 0) {
            int mid = (0 + tmp.length) / 2;
            int pivot1 = tmp[mid - 1];
            int pivot2 = tmp[mid];
            return (pivot1 + pivot2) / 2.0;
        }

        // 0 0 (0) 0 0 => 길이 5 중에서 인덱스 2를 발견한다.
        else {
            int mid = (0 + tmp.length) / 2;
            return tmp[mid];
        }
    }

    // Case 02. 우선 순위 큐(Priority Queue) 를 이용한 중앙 값 찾는 방법
    // 시간 복잡도는 O(n log n) 이 걸리고, 공간 복잡도는 O(1) 이다.
    static double finding_median2(int[] arr){
        PriorityQueue<Integer> higher = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> lower = new PriorityQueue<>();

        for(int k=0;k<arr.length;k++){
            higher.offer(arr[k]);
            lower.offer(higher.poll());

            if(higher.size() < lower.size()) {
                higher.offer(lower.poll());
            }
        }

        if(higher.size() == lower.size()) { // 최대 힙과 최소 힙의 크기가 같다는 것은 중앙 값을 구하길 원하는 배열의 길이가 짝수라는 것이다.
            return (higher.peek() + lower.peek()) / 2.0;
        } else { // 크기가 서로 다른 것은 중앙 값을 구하길 원하는 배열의 길이가 홀수라는 것이다.
            return higher.peek();
        }
    }

    public static void main(String[] args){
        Random random = new Random();
        int N = random.nextInt(17) + 3;
        int[] arr = new int[N];
        for(int k=0;k<arr.length;k++){
            arr[k] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(finding_median1(arr));
        System.out.println(finding_median2(arr));
    }
}
