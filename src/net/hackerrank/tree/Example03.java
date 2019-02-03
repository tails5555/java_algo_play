package net.hackerrank.tree;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

// Hacker Rank Tree 응용 문제
// Trees: Is This a Binary Search Tree? 이진 탐색 트리 판단 여부 문제
public class Example03 {
    static boolean checkBST(Node root) {
        Set<Integer> elements = new HashSet<>();
        elements.add(root.data);

        Queue<Node[]> queue = new LinkedList<>();
        queue.offer(new Node[] { root, root });

        while(!queue.isEmpty()) {
            Node[] tmp = queue.poll();

            if(tmp[0].left != null) {
                Node left = tmp[0].left;
                if(left.data > tmp[0].data || elements.contains(left.data))
                    return false;
                if(tmp[0].data < root.data && left.data > root.data)
                    return false;
                if(tmp[0].data > root.data && left.data < root.data)
                    return false;
                if(tmp[0].data < tmp[1].data && left.data > tmp[1].data)
                    return false;
                if(tmp[0].data > tmp[1].data && left.data < tmp[1].data)
                    return false;

                queue.offer(new Node[] { left, tmp[0] });
                elements.add(left.data);
            }

            if(tmp[0].right != null) {
                Node right = tmp[0].right;
                if(right.data < tmp[0].data || elements.contains(right.data))
                    return false;
                if(tmp[0].data < root.data && right.data > root.data)
                    return false;
                if(tmp[0].data > root.data && right.data < root.data)
                    return false;
                if(tmp[0].data < tmp[1].data && right.data > tmp[1].data)
                    return false;
                if(tmp[0].data > tmp[1].data && right.data < tmp[1].data)
                    return false;

                queue.offer(new Node[] { right, tmp[0] });
                elements.add(right.data);

            }
        }

        return true;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(checkBST(root));
    }
}
