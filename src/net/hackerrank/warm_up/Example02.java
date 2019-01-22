package net.hackerrank.warm_up;

// Hacker Rank Warm Up 문제
// Counting Valleys 문제
// 이는 바다로 내려갔을 때 지면으로 올라온 횟수를 체크하는 문제였음.
public class Example02 {
    static int countingValleys(int n, String s) {
        int phase = 0;
        int visit = 0;
        char[] alps = s.toCharArray();
        for(int k=0;k<n;k++){
            switch(alps[k]) {
                case 'U' :
                    phase += 1;
                    break;
                case 'D' :
                    phase -= 1;
                    break;
            }
            if(phase == 0 && alps[k] == 'U') visit += 1;
        }
        return visit;
    }

    public static void main(String[] args){
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(8, "DDUUUUDD"));
        System.out.println(countingValleys(10, "DDUUUUUUDD"));
    }
}
