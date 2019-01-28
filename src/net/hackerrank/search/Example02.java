package net.hackerrank.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Hacker Rank 탐색 문제
// Swap Nodes 문제
// 마침 이진 트리에 대하여 공부하고 있었는데 공부하는데 많은 참조 된 문제
public class Example02 {
    static List<Integer> res;

    static class Node {
        int value;
        int level;
        Node left;
        Node right;

        public Node(int value, int level){
            this.value = value;
            this.level = level;
            this.left = null;
            this.right = null;
        }

        public static void inorder(Node node) {
            if(node == null) return;
            inorder(node.left);
            res.add(node.value);
            inorder(node.right);
        }
    }

    static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public Node find(int value) {
            Node tmp = this.root;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(tmp);

            while(!queue.isEmpty()){
                Node cur = queue.poll();
                if(cur.value == value) {
                    tmp = cur;
                    break;
                }

                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }

            return tmp;
        }

        public void swap(int level) {
            Node tmp = this.root;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(tmp);

            while(!queue.isEmpty()) {
                Node cur = queue.poll();
                if(cur.level % level == 0) {
                    Node tmp_tree = cur.left;
                    cur.left = cur.right;
                    cur.right = tmp_tree;
                }
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Tree tree = new Tree(new Node(1, 1));

        for(int k=1;k<=indexes.length;k++){
            Node parent = tree.find(k);
            int[] tmp = indexes[k - 1];
            if(tmp[0] == -1 && tmp[1] == -1) continue;
            if(tmp[0] != -1)
                parent.left = new Node(tmp[0], parent.level + 1);
            if(tmp[1] != -1)
                parent.right = new Node(tmp[1], parent.level + 1);
        }

        int[][] answer = new int[queries.length][indexes.length];
        for(int k=0;k<queries.length;k++){
            tree.swap(queries[k]);
            res = new ArrayList<>();
            Node.inorder(tree.root);
            answer[k] = res.stream().mapToInt(x -> x).toArray();
        }

        return answer;
    }

    public static void main(String[] args){
        int[][] answer1 = swapNodes(new int[][] {
            { 2, 3 }, { -1, -1 }, { -1, -1 }
        }, new int[] { 1, 1 });

        for(int k=0;k<answer1.length;k++){
            System.out.println(Arrays.toString(answer1[k]));
        }

        int[][] answer2 = swapNodes(new int[][] {
            { 2, 3 }, { -1, 4 }, { -1, 5 }, { -1, -1 }, { -1, -1 }
        }, new int[] { 2 });

        for(int k=0;k<answer2.length;k++){
            System.out.println(Arrays.toString(answer2[k]));
        }

        int[][] answer3 = swapNodes(new int[][] {
            { 2, 3 }, { 4, -1 }, { 5, -1 }, { 6, -1 }, { 7, 8 }, { -1, 9 }, { -1, -1 }, { 10, 11 }, { -1, -1 }, { -1, -1 }, { -1, -1 }
        }, new int[] { 2, 4 });

        for(int k=0;k<answer3.length;k++){
            System.out.println(Arrays.toString(answer3[k]));
        }
    }
}
