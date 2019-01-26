package net.coding_test_2019_1;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 2019 상반기 모의고사 문제 No.3
// 빙고(100점)
public class Example03 {
    public static int solution(int[][] board, int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int k=0;k<board.length;k++){
            for(int l=0;l<board[k].length;l++){
                map.put(board[k][l], new int[] { k, l });
            }
        }

        int[] row = new int[board.length];
        int[] col = new int[board.length];

        int leftCross = 0;
        int rightCross = 0;

        for(int k=0;k<nums.length;k++){
            int[] vtx = map.get(nums[k]);
            row[vtx[0]] += 1;
            col[vtx[1]] += 1;
            if(vtx[1] == (board.length - 1) - vtx[0]) {
                rightCross += 1;
            }
            if(vtx[0] == vtx[1]) {
                leftCross += 1;
            }
        }

        int answer = 0;

        answer += leftCross / board.length;
        answer += rightCross / board.length;

        for(int k=0;k<row.length;k++){
            answer += row[k] / board.length;
            answer += col[k] / board.length;
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][] {
            {11,13,15,16}, {12,1,4,3}, {10,2,7,8}, {5,14,6,9}
        }, new int[] { 14,3,2,4,13,1,16,11,5,15 }));
        System.out.println(solution(new int[][] {
            {6,15,17,14,23},{5,12,16,13,25},{21,4,2,1,22},{10,20,3,18,8},{11,9,19,24,7}
        }, new int[] { 15,7,2,25,9,16,12,18,5,4,10,13,20 }));
    }
}
