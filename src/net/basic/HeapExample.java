package net.basic;

import java.util.Arrays;
import java.util.Random;

// Priority Queue 에 대한 학습을 완전히 이해하기 위해 Heap 자료구조를 복습했음.
// 데이터 추가, 삭제 시간 복잡도는 O(log n), 데이터 단일 조회 시간 복잡도는 O(1) 로 나옴.
public class HeapExample {
    static class Heap {
        private int[] tree;
        private int capacity;
        private String policy;

        public Heap(int size, String policy){
            this.tree = new int[size + 1];
            this.policy = policy;
            this.capacity = 0;

            // 최대 힙에는 null 값을 아주 작은 int 값으로 가정하고, 최소 힙에서는 null 값을 아주 큰 int 값으로 가정합니다.
            if(policy.equals("MAX"))
                Arrays.fill(this.tree, Integer.MIN_VALUE);
            else if(policy.equals("MIN"))
                Arrays.fill(this.tree, Integer.MAX_VALUE);
        }

        public void offer(int value) {
            int cur = this.capacity;
            this.tree[cur] = value;
            this.capacity += 1;

            // 하단부에서 상단부로 heapify 작동
            int child = cur;
            while(child > 0) {
                int parent = child / 2;
                switch(this.policy) {
                    case "MAX":
                        if (this.tree[child] > this.tree[parent]) {
                            int tmp = this.tree[child];
                            this.tree[child] = this.tree[parent];
                            this.tree[parent] = tmp;
                        }
                        break;
                    case "MIN":
                        if (this.tree[child] < this.tree[parent]) {
                            int tmp = this.tree[child];
                            this.tree[child] = this.tree[parent];
                            this.tree[parent] = tmp;
                        }
                        break;
                }
                child /= 2;
            }
        }

        // 상단부에서 하단부로 heapify 작동
        public void heapify(int idx) {
            int newidx = idx;
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;

            if(left < this.capacity) {
                switch(this.policy){
                    case "MAX" :
                        if(this.tree[left] > this.tree[newidx]) {
                            newidx = left;
                        }
                        break;
                    case "MIN" :
                        if(this.tree[newidx] > this.tree[left]) {
                            newidx = left;
                        }
                        break;
                }
            }

            if(right < this.capacity) {
                switch(this.policy){
                    case "MAX" :
                        if(this.tree[right] > this.tree[newidx]) {
                            newidx = right;
                        }
                        break;
                    case "MIN" :
                        if(this.tree[newidx] > this.tree[right]) {
                            newidx = right;
                        }
                        break;
                }
            }

            if(newidx != idx){
                int tmp = this.tree[newidx];
                this.tree[newidx] = this.tree[idx];
                this.tree[idx] = tmp;

                this.heapify(newidx);
            }
        }

        public int peek() {
            int[] tmp = this.tree;
            return tmp[0];
        }

        public Integer poll() {
            if(this.capacity > 0) {
                int res = this.tree[0];

                this.tree[0] = this.tree[this.capacity - 1];
                this.tree[this.capacity - 1] = this.policy.equals("MAX") ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                heapify(0);
                this.capacity -= 1;

                return res;
            } else {
                switch(this.policy) {
                    case "MAX" :
                        return Integer.MAX_VALUE;
                    case "MIN" :
                        return Integer.MIN_VALUE;
                }

                return null;
            }
        }

        @Override
        public String toString() {
            return String.format("%s", Arrays.toString(this.tree));
        }
    }

    public static void main(String[] args){
        final int N = 31;
        Random random = new Random();

        Heap maxHeap = new Heap(N, "MAX");
        for(int k = 0; k < N; k++){
            maxHeap.offer(random.nextInt(1000000) + 1);
            System.out.println(maxHeap);
        }
        for(int k = 0; k < N; k++){
            System.out.println(maxHeap.poll());
        }

        Heap minHeap = new Heap(N, "MIN");
        for(int k = 0; k < N; k++){
            minHeap.offer(random.nextInt(1000000) + 1);
            System.out.println(minHeap);
        }
        for(int k = 0; k < N; k++){
            System.out.println(minHeap.poll());
        }
    }
}
