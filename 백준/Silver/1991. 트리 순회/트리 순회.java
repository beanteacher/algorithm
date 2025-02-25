import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public void createTree(String parent, String leftChild, String rightChild) {
            // root가 null인 경우 트리가 처음 생성된 경우이므로 root의 값을 채워준다.
            if(root == null) {
                root = new Node(parent);
                if(!leftChild.equals(".")) {
                    root.left = new Node(leftChild);
                }
                if(!rightChild.equals(".")) {
                    root.right = new Node(rightChild);
                }
            } else {
                // root가 null이 아닌 경우 자식들을 채워준다.
                fillTree(root, parent, leftChild, rightChild);
            }
        }

        private void fillTree(Node root, String parent, String leftChild, String rightChild) {
            if (root == null) return;

            // root의 data가 parent값과 같다면 자식들을 생성
            if(root.data.equals(parent)) {
                if(!leftChild.equals(".")) {
                    root.left = new Node(leftChild);
                }
                if(!rightChild.equals(".")) {
                    root.right = new Node(rightChild);
                }
            } else {
                // root의 data와 같지 않다면 왼쪽부터 재귀
                fillTree(root.left, parent, leftChild, rightChild);
                // 왼쪽에도 일치하는 값이 없다면 오른쪽 재귀
                fillTree(root.right, parent, leftChild, rightChild);
            }
        }

        // 전위 순회 : root - left - right
        public void preOrder(Node root) {
            System.out.print(root.data);
            if(root.left != null) {
                preOrder(root.left);
            }
            if(root.right != null) {
                preOrder(root.right);
            }
        }

        // 중위 순회 : left - root - right
        public void inOrder(Node root) {
            if(root.left != null) {
                inOrder(root.left);
            }
            System.out.print(root.data);
            if(root.right != null) {
                inOrder(root.right);
            }
        }

        // 후위 순회 : left - right - root
        public void postOrder(Node root) {
            if(root.left != null) {
                postOrder(root.left);
            }
            if(root.right != null) {
                postOrder(root.right);
            }
            System.out.print(root.data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            // 트리 생성
            tree.createTree(parent, leftChild, rightChild);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}