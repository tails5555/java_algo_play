package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Baekjoon KOI 2004 초등부 지역본선 5번 로마 숫자 문제 풀이
public class Main2608 {
    static BufferedReader br;
    static String roman1, roman2;

    static Map<Character, Integer> int_roman = new HashMap<Character, Integer>(){
        {
            put('I', 1); put('V', 5); put('X', 10); put('L', 50); put('C', 100); put('D', 500); put('M', 1000);
        }
    };

    static Map<Integer, Character> roman_int = new HashMap<Integer, Character>(){
        {
            put(1, 'I'); put(5, 'V'); put(10, 'X'); put(50, 'L'); put(100, 'C'); put(500, 'D'); put(1000, 'M');
        }
    };

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        roman1 = br.readLine();
        roman2 = br.readLine();
    }

    static int romanToInt(String s){
        int res = 0;
        char[] alps = s.toCharArray();
        for(int k = 0; k < alps.length; k++){
            res += int_roman.get(alps[k]);
            if(k > 0){
                if((alps[k] == 'V' || alps[k] == 'X') && alps[k - 1] == 'I'){
                    res -= 2;
                }
                if((alps[k] == 'L' || alps[k] == 'C') && alps[k - 1] == 'X'){
                    res -= 20;
                }
                if((alps[k] == 'D' || alps[k] == 'M') && alps[k - 1] == 'C'){
                    res -= 200;
                }
            }
        }
        return res;
    }

    static String intToRoman(int num){
        String s = Integer.toString(num);
        Stack<String> stack = new Stack<>();
        int N = 1;
        for(int k = s.length() - 1; k >= 0; k--){
            StringBuilder sb = new StringBuilder();
            int a = s.charAt(k) - '0';
            if(a == 9){
                sb.append(roman_int.get(N));
                sb.append(roman_int.get(N * 10));
            } else if(a >= 5 && a <= 8) {
                sb.append(roman_int.get(N * 5));
                for(int l = 5; l < a; l++){
                    sb.append(roman_int.get(N));
                }
            } else if(a == 4){
                sb.append(roman_int.get(N));
                sb.append(roman_int.get(N * 5));
            } else {
                for(int l = 0; l < a; l++){
                    sb.append(roman_int.get(N));
                }
            }
            stack.push(sb.toString());
            N *= 10;
        }

        String tmp = "";
        while(!stack.isEmpty()){
            String t = stack.pop();
            tmp += t;
        }
        return tmp;
    }

    static void calculate() {
        int n1 = romanToInt(roman1);
        int n2 = romanToInt(roman2);

        System.out.println(n1 + n2);
        System.out.println(intToRoman(n1 + n2));
    }

    public static void main(String[] args) throws IOException {
        input();
        calculate();
    }
}
