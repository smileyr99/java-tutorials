package tutorials.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchTree {
    Node root;

    public class Node {
        int key;
        Node leftChild;
        Node rightChild;

        public Node(int key) {
            this.key = key;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(root, key);
        }
    }

    public void insert(Node node, int key) {
        boolean isLeft = true;
        Node prevNode = root;
        while (node != null) {
            if (node.key > key) {
                prevNode = node;
                node = node.leftChild;
                isLeft = true;
            } else {
                prevNode = node;
                node = node.rightChild;
                isLeft = false;
            }
        }
        if (isLeft) {
            prevNode.leftChild = new Node(key);
        } else {
            prevNode.rightChild = new Node(key);
        }
    }

    public int search(int key) {
        return search(this.root, key);
    }

    public int search(Node current, int key) {
        if (current.key == key) {
            return 1;
        } else if (current.key > key) {
            if (current.leftChild == null) {
                return 0;
            }
            return search(current.leftChild, key);
        } else {
            if (current.rightChild == null) {
                return 0;
            }
            return search(current.rightChild, key);
        }
    }

    public void display(Node root) {
        if (root != null) {
            display((root.leftChild));
            System.out.print(root.key + " ");
            display((root.rightChild));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree tree = new BinarySearchTree();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            tree.insert(nums[i]);
        }
        tree.display(tree.root);

        System.out.println();
        int M = Integer.parseInt(br.readLine());
        int[] fineNums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            fineNums[i] = Integer.parseInt(st.nextToken());
            System.out.println(tree.search(fineNums[i]));
        }
    }
}
