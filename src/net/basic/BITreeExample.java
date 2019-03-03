package net.basic;

import java.util.Random;

// Binary Indexed Tree 예제
// (idx & -idx) 는 비트 연산자라 어렵지만, 이는 다음 2의 제곱 수를 찾기 위한 문단입니다.
class BinaryIndexedTree {
    private int[] node;
    private int length;

    public BinaryIndexedTree(int size) {
        this.node = new int[size + 1];
        this.length = size;
    }

    // 1번째부터 N번째 까지 합계를 반환합니다.
    public int read(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += node[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    // idx 번째의 값에 val 를 더합니다.
    public void update(int idx, int val) {
        while (idx < node.length) {
            node[idx] += val;
            idx += (idx & -idx);
        }
    }

    // l 부터 r 까지의 합계를 반환합니다.
    public int range_sum(int l, int r) {
        return read(r) - read(l - 1);
    }

    public int length() {
        return this.length;
    }
}

public class BITreeExample {
    static Random random;
    public static void main(String[] args){
        random = new Random();
        BinaryIndexedTree bit = new BinaryIndexedTree(31);
        for(int k = 1; k <= bit.length(); k++){
            bit.update(k, random.nextInt(9) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= bit.length(); k++){
            sb.append(String.format("%d ", bit.read(k)));
        }

        // 각각 [1, 1], [1, 2], ... [1, N] 까지의 합을 일렬로 나열한 값입니다.
        System.out.println(sb.toString());

        // 3번째 수부터 8번째 수까지 합입니다.
        System.out.println(bit.range_sum(3, 8));
    }
}
