package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SW Expert D3 두 수의 덧셈 문제 풀이
public class Main3260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine(), " ");

            char[] res = new char[101];
            char[] tmpA = new char[101];
            char[] tmpB = new char[101];

            Arrays.fill(res, '0');
            Arrays.fill(tmpA, '0');
            Arrays.fill(tmpB, '0');

            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            System.arraycopy(A, 0, tmpA, 101 - A.length, A.length);
            System.arraycopy(B, 0, tmpB, 101 - B.length, B.length);

            for(int l = 100; l >= 0; l--){
                int a = (tmpA[l] - '0') + (tmpB[l] - '0') + (res[l] - '0');
                if(a >= 10) {
                    a %= 10;
                    res[l - 1] += 1;
                }
                res[l] = (char) (a + '0');
            }

            int startIdx = 0;
            for(int l = 0; l <= 100; l++){
                if(res[l] != '0') {
                    startIdx = l;
                    break;
                }
            }
            System.out.printf("#%d %s\n", k+1, new String(Arrays.copyOfRange(res, startIdx, 101)));
        }
    }
}
