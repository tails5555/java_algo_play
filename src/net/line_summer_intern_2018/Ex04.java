package net.line_summer_intern_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex04 {
    static class BST {
        public Node root;

        static class Node {
            int data;
            Node left;
            Node right;

            Node(int data){
                this.data = data;
                left = null;
                right = null;
            }
        }

        public void insert(int data) {
            Node newNode = new Node(data);
            if(root == null) {
                root = newNode;
                return;
            }

            Node curNode = root;
            Node parentNode;
            while(true){
                parentNode = curNode;
                if(data < curNode.data) {
                    curNode = curNode.left;
                    if(curNode == null) {
                        parentNode.left = newNode;
                        return;
                    }
                } else {
                    curNode = curNode.right;
                    if(curNode == null) {
                        parentNode.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    static class DataTraverser {
        private BST.Node root;

        DataTraverser(BST.Node root) {
            this.root = root;
        }

        public boolean isDone() {
            return this.root == null;
        }

        private BST.Node getRightMinNode(BST.Node rightChildRoot) {
            BST.Node parent = rightChildRoot;
            BST.Node focusNode = rightChildRoot;

            while (focusNode.left != null) {
                parent = focusNode;
                focusNode = focusNode.left;
            }

            parent.left = null;
            return focusNode;
        }

        public boolean deleteNode(int key) {
            BST.Node focusNode = root;
            BST.Node parent = root;

            boolean isLeftChild = true;

            while(focusNode.data != key) {
                parent = focusNode;

                if(key < focusNode.data) {
                    isLeftChild = true;
                    focusNode = parent.left;
                } else {
                    isLeftChild = false;
                    focusNode = parent.right;
                }

                if(focusNode == null) {
                    return false;
                }
            }

            BST.Node replacementNode;
            if(focusNode.left == null && focusNode.right == null) {
                if (focusNode == root)
                    root = null;
                else if (isLeftChild)
                    parent.left = null;
                else
                    parent.right = null;
            } else if(focusNode.right == null) {
                replacementNode = focusNode.left;

                if (focusNode == root)
                    root = replacementNode;
                else if (isLeftChild)
                    parent.left = replacementNode;
                else
                    parent.right = replacementNode;
            } else if (focusNode.left == null) {
                replacementNode = focusNode.right;
                if (focusNode == root)
                    root = replacementNode;
                else if (isLeftChild)
                    parent.left = replacementNode;
                else
                    parent.right = replacementNode;
            } else {
                BST.Node rightSubTree = focusNode.right;
                replacementNode = getRightMinNode(focusNode.right);

                if (focusNode == root)
                    root = replacementNode;
                else if (isLeftChild)
                    parent.left = replacementNode;
                else
                    parent.right = replacementNode;

                replacementNode.right = rightSubTree;
                if (replacementNode == rightSubTree)
                    replacementNode.right = null;

                replacementNode.left = focusNode.left;
            }

            return true;
        }

        public int findNextData() {
            if (this.root.left == null && this.root.right == null) {
                int tmp = this.root.data;
                this.root = null;
                return tmp;
            }

            BST.Node par_node = null;

            int max = this.root.data;
            Queue<BST.Node> queue = new LinkedList<>();
            queue.offer(this.root);

            while (!queue.isEmpty()) {
                BST.Node tmp = queue.poll();
                int tmp_max = Integer.MIN_VALUE;

                if (tmp.left != null) {
                    BST.Node tmp_left = tmp.left;
                    if (max < tmp_left.data) {
                        tmp_max = Math.max(tmp_left.data, tmp_max);
                        queue.offer(tmp_left);
                    }
                }

                if (tmp.right != null) {
                    BST.Node tmp_right = tmp.right;
                    if (max < tmp_right.data) {
                        tmp_max = Math.max(tmp_right.data, tmp_max);
                        queue.offer(tmp_right);
                    }
                }

                if ((tmp.left != null || tmp.right != null) && tmp_max > max) {
                    par_node = tmp;
                    max = Math.max(tmp_max, max);
                }
            }

            if (par_node != null) {
                deleteNode(max);
            }

            return max;
        }
    }

    public static void main(String[] args) throws IOException {
        BST bst = new BST();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            while(st.hasMoreTokens()) {
                bst.insert(Integer.parseInt(st.nextToken()));
            }
        }

        DataTraverser traverser = new DataTraverser(bst.root);
        StringBuilder sb = new StringBuilder();
        while(!traverser.isDone()) {
            int tmp = traverser.findNextData();
            sb.append(tmp);
            if(!traverser.isDone()) {
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());
    }
}
