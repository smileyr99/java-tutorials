package tutorials.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekJ5639 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

        public void add(int data) {
            if (data < this.data) {
                if(this.left == null){
                    this.left = new Node(data);
                }else{
                    this.left.add(data);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(data);
                }else{
                    this.right.add(data);
                }
            }
        }
    }

    static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Node node = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            node.add(Integer.parseInt(input));
        }
        postOrder(node);

        br.close();
    }
}
