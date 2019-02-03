package net.hackerrank.tree;

import java.util.Scanner;

// Hacker Rank Tree 응용 문제
// Tree : Height of a Binary Tree 문제
public class Example01 {
    public static int dfs(Node node, int height) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(node.left != null)
            left = dfs(node.left, height + 1);
        if(node.right != null)
            right = dfs(node.right, height + 1);
        if(node.left == null && node.right == null)
            return height;
        else
            return Math.max(left, right);
    }

    public static int height(Node root) {
        Node cur = root;
        return dfs(cur, 0);
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
        int height = height(root);
        System.out.println(height);
    }
}
