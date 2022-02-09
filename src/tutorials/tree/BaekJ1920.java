package tutorials.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJ1920 {
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
        root = insert(root, key);
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key <= node.key) {
            node.leftChild = insert(node.leftChild, key);
        } else {
            node.rightChild = insert(node.rightChild, key);
        }

        return node;
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
        BaekJ1920 tree = new BaekJ1920();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            tree.insert(nums[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] fineNums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            fineNums[i] = Integer.parseInt(st.nextToken());
            System.out.println(tree.search(fineNums[i]));
        }

    }
}