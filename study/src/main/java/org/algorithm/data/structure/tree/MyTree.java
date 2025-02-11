package org.algorithm.data.structure.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyTree {
    static class Node {
        String data;
        Node leftNode;
        Node rightNode;

        public Node(String data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public void add(String parent, String left, String right) {
            if(root == null) {
                root = new Node(parent);

                if(!left.equals(".")) {
                    root.leftNode = new Node(left);
                }

                if(!right.equals(".")) {
                    root.rightNode = new Node(right);
                }
            } else {
                fillNode(root, parent, left, right);
            }
        }

        private void fillNode(Node root, String parent, String left, String right) {
            if(root == null) {
                return;
            } else if(root.data.equals(parent)) {

                if(!left.equals(".")) {
                    root.leftNode = new Node(left);
                }

                if(!right.equals(".")) {
                    root.rightNode = new Node(right);
                }
            } else {
                fillNode(root.leftNode, parent, left, right);
                fillNode(root.rightNode, parent, left, right);
            }
        }

        public void preOrder(Node node) {
            System.out.print(node.data);
            if(node.leftNode != null) {
                preOrder(node.leftNode);
            }
            if(node.rightNode != null) {
                preOrder(node.rightNode);
            }
        }

        public void inOrder(Node node) {

            if(node.leftNode != null) {
                inOrder(node.leftNode);
            }
            System.out.print(node.data);
            if(node.rightNode != null) {
                inOrder(node.rightNode);
            }
        }

        public void postOrder(Node node) {

            if(node.leftNode != null) {
                postOrder(node.leftNode);
            }
            if(node.rightNode != null) {
                postOrder(node.rightNode);
            }
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.add(parent, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
