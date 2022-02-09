package tutorials.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char item;
    Node left;
    Node right;

    public Node(char item) {
        this.item = item;
    }
}

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void add(char item, char leftItem, char rigntItem) {
        if (root == null) {
            root = new Node(item);
            if (leftItem != '.') {
                root.left = new Node(leftItem);
            }
            if (rigntItem != '.') {
                root.right = new Node(rigntItem);
            }
        } else {
            Node node = search(root, item);
            if (node.left == null) {
                if (leftItem != '.') {
                    node.left = new Node(leftItem);
                }
            }
            if (node.right == null) {
                if (rigntItem != '.') {
                    node.right = new Node(rigntItem);
                }
            }
        }
    }

    Node search(Node current, char item) {
        Node node = null;
        if (current != null) {
            if (item == current.item) {
                node = current;
            } else {
                node = search(current.left, item);
                if (node == null) {
                    node = search(current.right, item);
                }
            }
        }
        return node;
    }

    public Node search(char item) {
        return search(this.root, item);
    }

    public void preorder(Node root) {
        System.out.print(root.item);
        if (root.left != null) {
            preorder(root.left);
        }
        if (root.right != null) {
            preorder(root.right);
        }
    }

    public void inorder(Node root) {
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.item);
        if (root.right != null) {
            inorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root.left != null) {
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        System.out.print(root.item);
    }
}

public class BaekJ1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N];
        char item, left, right;
        int nodeCnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            item = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);

            boolean exist = true;
            int idx = 0;
            for (int j = 0; j < nodeCnt; j++) {
                if(item == node[j].item ){
                    idx = j;
                    exist = false;
                    break;
                }
            }
            if(exist) {
                idx = nodeCnt;
                node[nodeCnt] = new Node(item);
                nodeCnt++;
            }

            for(int j = 0; j <nodeCnt; j++){
                if(left == node[j].item){
                    node[idx].left = node[j];
                }
                if(right == node[j].item){
                    node[idx].right = node[j];
                }
            }

            if(node[idx].left == null && left != '.'){
                node[nodeCnt++] = new Node(left);
                node[idx].left = node[nodeCnt-1];
            }

            if(node[idx].right == null && right != '.'){
                node[nodeCnt++] = new Node(right);
                node[idx].right = node[nodeCnt-1];
            }
        }

        Tree tree = new Tree(node[0]);
        tree.preorder(tree.root);
        System.out.println();

        tree.inorder(tree.root);
        System.out.println();

        tree.postorder(tree.root);
        System.out.println();

    }
}