package net.sw_expert.d3;

// SW Expert D3 100만 이하의 모든 소수
// 에라토스테네스의 체 활용 여부 문제(중-고딩 때 잠깐 봤던 개념이다. 매우 쉬운 편이니 꼭 공부해보자.)
public class Main3131 {
    public static void main(String[] args){
        boolean[] checked = new boolean[1000001];
        int root = (int) Math.sqrt(checked.length);
        for(int k = 2; k <= root; k++){
            if(!checked[k])
                for(int l = k * 2; l <= 1000000; l += k)
                    checked[l] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int k = 2; k <= 1000000; k++){
            if(!checked[k])
                sb.append(k + " ");
        }
        System.out.println(sb.toString());
    }
}
