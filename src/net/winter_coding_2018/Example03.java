package net.winter_coding_2018;

// 이건 아쉽게도 56점... 브루트 포스로 풀었긴 하지만, 너무 비효율적이다.
public class Example03 {
    public static int solution(int[] cookie) {
        int maxCookie = Integer.MIN_VALUE;
        for(int l=0;l<cookie.length;l++){
            for(int m=0;m<cookie.length;m++){
                for (int n = l; n <= m; n++) {
                    int aCount = 0;
                    int bCount = 0;
                    for (int a = l; a < n; a++) {
                        aCount += cookie[a];
                    }
                    for (int b = n; b <= m; b++) {
                        bCount += cookie[b];
                    }
                    if(aCount == bCount) {
                        maxCookie = Math.max(maxCookie, aCount);
                    }
                }
            }
        }
        return maxCookie != Integer.MIN_VALUE ? maxCookie : 0;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[] {1, 1, 2, 3}));
        System.out.println(solution(new int[] {1, 2, 4, 5}));
    }
}
