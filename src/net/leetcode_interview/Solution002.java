package net.leetcode_interview;

// Leetcode Interview Question No. 2
// 링크드리스트 덧셈
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}

public class Solution002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        ListNode res = new ListNode((l1.val + l2.val) % 10);
        int top = (l1.val + l2.val) / 10;

        ListNode add = res;
        tmp1 = tmp1.next;
        tmp2 = tmp2.next;

        while(true){
            int digit = top;
            if(tmp1 != null && tmp2 != null){
                digit += (tmp1.val + tmp2.val);
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            } else if(tmp1 != null){
                digit += tmp1.val;
                tmp1 = tmp1.next;
            } else if(tmp2 != null){
                digit += tmp2.val;
                tmp2 = tmp2.next;
            } else {
                if(top > 0){
                    add.next = new ListNode(top);
                }
                break;
            }

            add.next = new ListNode(digit % 10);
            top = digit / 10;
            add = add.next;
        }

        return res;
    }

    public static void main(String[] args){
        ListNode tmp1_0 = new ListNode(2);
        ListNode tmp1_1 = new ListNode(4);
        ListNode tmp1_2 = new ListNode(3);

        tmp1_0.next = tmp1_1;
        tmp1_1.next = tmp1_2;

        ListNode tmp2_0 = new ListNode(5);
        ListNode tmp2_1 = new ListNode(6);
        ListNode tmp2_2 = new ListNode(4);

        tmp2_0.next = tmp2_1;
        tmp2_1.next = tmp2_2;

        ListNode result = addTwoNumbers(tmp1_0, tmp2_0);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

        ListNode tmp3_0 = new ListNode(7);
        ListNode tmp3_1 = new ListNode(8);
        ListNode tmp3_2 = new ListNode(9);
        ListNode tmp3_3 = new ListNode(1);

        tmp3_0.next = tmp3_1;
        tmp3_1.next = tmp3_2;
        tmp3_2.next = tmp3_3;

        ListNode tmp4_0 = new ListNode(4);
        ListNode tmp4_1 = new ListNode(3);
        ListNode tmp4_2 = new ListNode(2);

        tmp4_0.next = tmp4_1;
        tmp4_1.next = tmp4_2;

        ListNode result2 = addTwoNumbers(tmp3_0, tmp4_0);
        while(result2 != null){
            System.out.println(result2.val);
            result2 = result2.next;
        }

        ListNode tmp5 = new ListNode(5);
        ListNode tmp6 = new ListNode(6);

        ListNode result3 = addTwoNumbers(tmp5, tmp6);
        while(result3 != null){
            System.out.println(result3.val);
            result3 = result3.next;
        }
     }
}
