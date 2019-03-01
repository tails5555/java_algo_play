package net.leetcode_interview;

import java.util.TreeSet;

// Leetcode Interview Question No. 6
// 지그재그 변환 문제
/*
 * 0     6       12       18
 * 1   5 7    11 13    17 19    23
 * 2 4   8 10    14 16    20 22
 * 3     9       15       21
 *
 * 0       8           16
 * 1     7 9        15 17
 * 2   6   10    14    18
 * 3 5     11 13       19
 * 4       12          20
 *
 * (0 6 12) (1 5 7 11 13) ... 이렇게 출력하는 문제.
 * (3, 4), (4, 6), (5, 8), (6, 10) ... (n, 4 + (n - 3) * 2) (n >= 3)
 */
public class Solution006 {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        else if(numRows == 2){
            int idx = 0;
            char[] tmp = new char[s.length()];

            for(int k = 0; k < s.length(); k += 2){
                tmp[idx++] = s.charAt(k);
            }

            for(int k = 1; k < s.length(); k += 2){
                tmp[idx++] = s.charAt(k);
            }

            return new String(tmp);
        } else {
            int distance = 4 + (numRows - 3) * 2;
            char[] tmp = new char[s.length()];

            TreeSet<Integer>[] rules = new TreeSet[numRows];
            for(int k = 0; k < numRows; k++){
                rules[k] = new TreeSet<>();
                for(int l = k; l < s.length() + distance; l += distance){
                    if(l < s.length())
                        rules[k].add(l);
                    if(k != 0 && k != numRows - 1 && (l - k * 2) > 0 && (l - k * 2) < s.length()) {
                        rules[k].add(l - k * 2);
                    }
                }
            }

            int idx = 0;
            for(int k = 0; k < rules.length; k++){
                for(int a : rules[k]){
                    tmp[idx++] = s.charAt(a);
                }
            }

            return new String(tmp);
        }
    }

    public static void main(String[] args){
        System.out.println(convert("가나다라마바사아자차카타파하아야어여오요우유으이", 1));
        System.out.println(convert("가나다라마바사아자차카타파하아야어여오요우유으이", 2));
        System.out.println(convert("가나다라마바사아자차카타파하아야어여오요우유으이", 3));
        System.out.println(convert("가나다라마바사아자차카타파하아야어여오요우유으이", 4));

        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
