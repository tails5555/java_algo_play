package net.hackerrank.tree;

import java.util.*;

// Hacker Rank Tree 응용 문제
// Tree: Huffman Decoding 문제
// 그냥 0이면 왼쪽 탐색, 1이면 오른쪽 탐색에 따른 값을 출력하는 허무한 문제였음.
abstract class QNode implements Comparable<QNode> {
    public int frequency;
    public char data;
    public QNode left, right;
    public QNode(int freq) {
        frequency = freq;
    }
    public int compareTo(QNode tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends QNode {
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends QNode {
    public HuffmanNode(QNode l, QNode r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

class Decoding {
    void decode(String s, QNode root) {
        StringBuilder sb = new StringBuilder();
        QNode c = root;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i) == '1' ? c.right : c.left;
            if (c.left == null && c.right == null) {
                sb.append(c.data);
                c = root;
            }
        }
        System.out.print(sb);
    }
}

public class Example04 {
    public static QNode buildTree(int[] charFreqs) {
        PriorityQueue<QNode> trees = new PriorityQueue<>();
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));

        assert trees.size() > 0;

        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            QNode a = trees.poll();
            QNode b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }

        return trees.poll();
    }

    public static Map<Character,String> mapA = new HashMap<>();

    public static void printCodes(QNode tree, StringBuffer prefix) {

        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String test= input.next();

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        QNode tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);
    }
}