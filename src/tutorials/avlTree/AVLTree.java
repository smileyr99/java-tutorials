package tutorials.avlTree;

class Node {
    Node left;
    Node right;
    Node parent;
    int data;
    int height;

    Node(int data) {
        this.data = data;
        this.height = 1;
    }

    Node setLeft(Node newNode) {
        this.left = newNode;
        if (newNode != null) {
            newNode.parent = this;
        }
        updateHeight();
        return this;
    }

    Node setRight(Node newNode) {
        this.right = newNode;
        if (newNode != null) {
            newNode.parent = this;
        }
        updateHeight();
        return this;
    }

    int getBalanceFactor() {
        return (left != null ? left.height : 0) - (right != null ? right.height : 0);
    }

    void updateHeight() {
        this.height = Math.max(left != null ? left.height : 0, right != null ? right.height : 0) + 1;
    }
}

public class AVLTree {
    Node root;

    public AVLTree() {
    }

    public AVLTree(Node root) {
        this.root = root;
    }

    private void reSetGrandGrandParent(Node newRoot, Node grandGrandParent) {
        if (grandGrandParent == null) {
            this.root = newRoot;
            newRoot.parent = null;
        } else {
            if (grandGrandParent.data >= newRoot.data) {
                grandGrandParent.setLeft(newRoot);
            } else {
                grandGrandParent.setRight(newRoot);
            }
        }
    }

    private void rightRotation(Node parent, Node grandParent, Node grandGrandParent) {
        grandParent.setLeft(parent.right);
        parent.setRight(grandParent);
        reSetGrandGrandParent(parent, grandGrandParent);
    }

    private void leftRotation(Node parent, Node grandParent, Node grandGrandParent) {
        grandParent.setRight(parent.left);
        parent.setLeft(grandParent);
        reSetGrandGrandParent(parent, grandGrandParent);
    }

    private void rebalance(Node node, Node parent, Node grandParent) {
        int bf = grandParent.getBalanceFactor();
        if (bf > 1 && parent.data >= node.data) {
            rightRotation(parent, grandParent, grandParent.parent);
        } else if (bf < -1 && parent.data < node.data) {
            leftRotation(parent, grandParent, grandParent.parent);
        } else if (bf < -1 && grandParent.data < parent.data) {
            rightRotation(node, parent, grandParent);
            leftRotation(node, grandParent, grandParent.parent);
        } else if (bf > 1 && grandParent.data >= parent.data) {
            leftRotation(node, parent, grandParent);
            rightRotation(node, grandParent, grandParent.parent);
        }
    }

    private Node insert(Node node, Node newNode) {
        Node parent;
        if (newNode.data < node.data) {
            parent = node.left != null ? insert(node.left, newNode) : node.setLeft(newNode);
        } else {
            parent = node.right != null ? insert(node.right, newNode) : node.setRight(newNode);
        }
        return parent;
    }

    public void insert(int data) {
        Node parent = null;
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            parent = insert(this.root, newNode);
        }

        int bf;
        Node grandParent = parent != null ? parent.parent : null;
        Node node = newNode;
        while (grandParent != null) {
            grandParent.updateHeight();
            bf = grandParent.getBalanceFactor();
            if (Math.abs(bf) > 1) {
                break;
            } else {
                node = parent;
                parent = parent.parent;
                grandParent = grandParent.parent;
            }
        }

        if (grandParent != null) {
            rebalance(node, parent, grandParent);
        }
    }

    public int search(int data){
        return search(this.root, data);
    }

    public int search(Node current, int data) {
        if(current.data == data){
            return 1;
        }else if(current.data > data) {
            if (current.left == null) {
                return 0;
            }
            return search(current.left, data);
        }else{
            if(current.right == null){
                return 0;
            }
            return search(current.right, data);
        }
    }

    public void delete(int data){

    }

    public void display(Node root) {
        if (root != null) {
            display((root.left));
            System.out.print(root.data + " ");
            display((root.right));
        }
    }
}