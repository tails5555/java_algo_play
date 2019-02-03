package net.hackerrank.tree;

import java.util.Scanner;

// Hacker Rank Tree 응용 문제
// BST : Lowest Common Ancestor 제일 작은 조상 찾기 문제
class Example02 {
    public static Node lca(Node root, int v1, int v2) {
        Node cur = root;
        while((cur.data < v1 && cur.data < v2) || (cur.data > v1 && cur.data > v2)) {
            if(cur.data < v1 && cur.data < v2)
                cur = cur.right;
            else
                cur = cur.left;
        }
        return cur;
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}