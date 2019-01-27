package net.hackerrank.greedy;

// Hacker Rank 탐욕 알고리즘 문제
// Reverse Shuffle Merge 문제(문제가 잘 못 되어 풀이만 참조하였음.)
public class Example05 {
    static String reverseShuffleMerge(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int[] used = new int[26], rem = new int[26];
        for (int i = 0; i < count.length; i++) {
            rem[i] = count[i];
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (sb.length() == 0) {
                sb.append(c);
                used[c - 'a']++;
            }else {
                if (2 * used[c - 'a'] == count[c - 'a']) {
                    rem[c - 'a']--;
                    continue;
                }

                while (sb.length() > 0) {
                    char last = sb.charAt(sb.length() - 1);
                    if (c < last && 2 * (rem[last - 'a'] + used[last - 'a']) > count[last - 'a']){
                        used[last - 'a']--;
                        sb.deleteCharAt(sb.length() - 1);
                    }else {
                        break;
                    }
                }

                sb.append(c);
                used[c - 'a']++;
            }
            rem[c - 'a']--;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseShuffleMerge("eggegg"));
        System.out.println(reverseShuffleMerge("abcdefgabcdefg"));
        System.out.println(reverseShuffleMerge("aeiouuoiea"));
    }
}
