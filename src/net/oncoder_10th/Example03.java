package net.oncoder_10th;

// 온코더 10회 공식테스트 3번
public class Example03 {
    static long combination(int N, int C) {
        long a = 1;
        for(int k = N; k >= N - C + 1; k--) {
            a *= k;
        }

        long b = 1;
        for(int k = 1; k <= C; k++){
            b *= k;
        }

        return a / b;
    }
    public static double solution(int N){
        if(N == 1 || N == 2)
            return 1;
        else {
            long total = combination(N * 5, 5);
            long sum = 0L;
            for(int k = 2; k >= 0; k--) {
                sum += (N * combination((N - 1) * 5, k) * combination(5, 5 - k));
            }
            return (double) sum / total;
        }
    }
    public static void main(String[] args){
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(9));
    }
}
