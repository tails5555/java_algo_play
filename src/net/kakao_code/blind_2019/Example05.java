package net.kakao_code.blind_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Example05 {
    static List<Integer> preResult = new ArrayList<Integer>();
    static List<Integer> postResult = new ArrayList<Integer>();

    static class Node implements Comparable<Node> {
        int value;
        int x;
        int y;
        Node parent;
        Node left;
        Node right;

        public Node(int value, int x, int y){
            this.value = value;
            this.x = x;
            this.y = y;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public void setLeftChild(Node left){
            this.left = left;
        }

        public void setRightChild(Node right){
            this.right = right;
        }

        public void setParent(Node parent){
            this.parent = parent;
        }

        @Override
        public int compareTo(Node node) {
            if(this.y < node.y) return 1;
            else if(this.y > node.y) return -1;
            else return this.x - node.x;
        }

        @Override
        public String toString(){
            return String.format("[v%d (%d, %d) LV%d RV%d PV%d]", this.value, this.x, this.y, this.left != null ? this.left.value : -1, this.right != null ? this.right.value : -1, this.parent != null ? this.parent.value : -1);
        }
    }

    public static void edgeConnection(Node parent, Node child, int left, int right){
        int leftStart = left;
        int leftEnd = parent.x - 1;
        int rightStart = parent.x + 1;
        int rightEnd = right;
        if(child.x >= leftStart && child.x <= leftEnd){
            if(parent.left == null && child.parent == null) {
                parent.setLeftChild(child);
                child.setParent(parent);
                return;
            }
        } else if(child.x >= rightStart && child.x <= rightEnd){
            if(parent.right == null && child.parent == null) {
                parent.setRightChild(child);
                child.setParent(parent);
                return;
            }
        }
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        preResult.add(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        postResult.add(root.value);
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        List<Node> nodes = new ArrayList<>();
        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;
        int maxWidth = Integer.MIN_VALUE;
        int minWidth = Integer.MAX_VALUE;

        for(int k=0;k<nodeinfo.length;k++){
            nodes.add(new Node(k+1, nodeinfo[k][0], nodeinfo[k][1]));
            if(maxHeight < nodeinfo[k][1]) maxHeight = nodeinfo[k][1];
            if(minHeight > nodeinfo[k][1]) minHeight = nodeinfo[k][1];
            if(maxWidth < nodeinfo[k][0]) maxWidth = nodeinfo[k][0];
            if(minWidth > nodeinfo[k][0]) minWidth = nodeinfo[k][0];
        }
        Collections.sort(nodes);

        Map<Integer, PriorityQueue<Node>> graph = new LinkedHashMap<>();
        for(int k=0;k<nodes.size();k++){
            Node node = nodes.get(k);
            PriorityQueue<Node> tmpQueues = graph.get(node.y);
            if(tmpQueues == null) {
                tmpQueues = new PriorityQueue<>();
            }
            tmpQueues.add(node);
            graph.put(node.y, tmpQueues);
        }

        Node startNode = graph.get(maxHeight).poll();
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.add(startNode);
        while(!nodeQueue.isEmpty()){
            Node tmpNode = nodeQueue.poll();
            int tmpLevel = tmpNode.y;
            int leftStart = minWidth;
            int rightEnd = maxWidth;
            if(tmpNode.parent != null){
                if(tmpNode.parent.parent != null) {
                    if (tmpNode.x < tmpNode.parent.parent.x)
                        rightEnd = tmpNode.parent.parent.x - 1;
                    else if (tmpNode.x > tmpNode.parent.parent.x)
                        leftStart = tmpNode.parent.parent.x + 1;
                }
            }
            while(tmpLevel >= minHeight) {
                tmpLevel = tmpLevel - 1;
                if(graph.containsKey(tmpLevel)) break;
            }
            PriorityQueue<Node> childList = graph.get(tmpLevel);
            if(childList != null) {
                for (Node node : childList) {
                    edgeConnection(tmpNode, node, leftStart, rightEnd);
                    nodeQueue.add(node);
                }
            }
        }

        preOrder(startNode);
        for(int k=0;k<answer[0].length;k++){
            answer[0][k] = preResult.get(k);
        }
        postOrder(startNode);
        for(int k=0;k<answer[1].length;k++){
            answer[1][k] = postResult.get(k);
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] answer =
                solution(new int[][]
            {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}
        );
        for(int k=0;k<answer.length;k++){
            System.out.println(Arrays.toString(answer[k]));
        }
    }
}
