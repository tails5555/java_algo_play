package net.kakao_code.blind_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 카카오 5번문제 풀이 완료
// 코딩은 김만기 선배님이 작성하신 코드를 보고 학습을 목적으로 사용하였습니다. 감사드립니다.
// 100점 만점을 맞았는데, 트리 생성 add 메소드만 잘 작성하면 풀 수 있었던 문제였음... 생각보다 너무 허무했던 문제라 할까...
public class Example05_1 {
    static class Node implements Comparable<Node>{
        int value;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int value, int x, int y){
            this.value = value;
            this.x = x;
            this.y = y;
        }

        public void setLeftChild(Node left){
            this.left = left;
        }

        public void setRightChild(Node right){
            this.right = right;
        }

        @Override
        public int compareTo(Node node) {
            if(this.y < node.y) return 1;
            else if(this.y > node.y) return -1;
            else return this.x - node.x;
        }

        @Override
        public String toString(){
            return String.format("[v%d (%d, %d) LV%d RV%d]", this.value, this.x, this.y, this.left != null ? this.left.value : -1, this.right != null ? this.right.value : -1);
        }
    }

    static class BinaryTree {
        Node root;
        List<Integer> preList;
        List<Integer> postList;

        public BinaryTree(Node root){
            this.root = root;
            this.preList = new ArrayList<Integer>();
            this.postList = new ArrayList<Integer>();
        }

        public void makePreOrder(Node node){
            if(node == null) return;
            this.preList.add(node.value);
            makePreOrder(node.left);
            makePreOrder(node.right);
        }

        public void makePostOrder(Node node){
            if(node == null) return;
            makePostOrder(node.left);
            makePostOrder(node.right);
            this.postList.add(node.value);
        }

        public void add(Node newNode){
            Node tmp = root;
            while(true){
                if(newNode.x < tmp.x) {
                    if (tmp.left != null) {
                        tmp = tmp.left;
                    } else {
                        tmp.setLeftChild(newNode);
                        break;
                    }
                } else {
                    if (tmp.right != null) {
                        tmp = tmp.right;
                    } else {
                        tmp.setRightChild(newNode);
                        break;
                    }
                }
            }
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Queue<Node> nodeQueue = new PriorityQueue<Node>();
        for(int k=0;k<nodeinfo.length;k++){
            nodeQueue.offer(new Node(k + 1, nodeinfo[k][0], nodeinfo[k][1]));
        }
        BinaryTree binaryTree = new BinaryTree(nodeQueue.poll());
        while(!nodeQueue.isEmpty()){
            Node tmpNode = nodeQueue.poll();
            binaryTree.add(tmpNode);
        }
        binaryTree.makePreOrder(binaryTree.root);
        binaryTree.makePostOrder(binaryTree.root);
        for(int k=0;k<answer[0].length;k++){
            answer[0][k] = binaryTree.preList.get(k);
        }
        for(int k=0;k<answer[1].length;k++){
            answer[1][k] = binaryTree.postList.get(k);
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] answer = solution(new int[][]
            {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}
        );
        for(int k=0;k<answer.length;k++){
            System.out.println(Arrays.toString(answer[k]));
        }
    }
}
