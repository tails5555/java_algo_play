package net.winter_coding_2018;

// 100점 나왔음
public class Example01 {
    public static int solution(String skill, String[] skill_trees) {
        char[] element = skill.toCharArray();
        int count = 0;
        for(String attack : skill_trees){
            boolean[] successed = new boolean[element.length];
            char[] attackElement = attack.toCharArray();
            boolean notValid = false;
            for(int k=0;k<attackElement.length;k++){
                for(int l=0;l<element.length;l++){
                    if(attackElement[k] == element[l]) {
                        if (l >= 1) {
                            if (!successed[l - 1]) {
                                notValid = true;
                                break;
                            }
                        }
                        successed[l] = true;
                    }
                }
            }
            if(!notValid) count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(solution("CBD", new String[] {"ACDE", "CBADF", "AECB", "BDA"}));
    }
}
