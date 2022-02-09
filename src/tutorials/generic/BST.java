package tutorials.generic;

class Node<T> {
    T key;
    Node<T> leftChild;
    Node<T> rightChild;

    public Node(T key) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }
}

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T key) {
        insert(root, key);
    }

    public void insert(Node<T> current, T key) {
        if (current == null) {
            current = new Node<T>(key);
        }
        if (current.key.compareTo(key) > 0){
            insert(current.leftChild, key);
        }else{
            insert(current.rightChild, key);
        }
    }

    public boolean  search(T key){
        return search(this.root, key);
    }

    public boolean search(Node<T> current, T key) {
        if(current.key.compareTo(key)==0) {
            return true;
        }
        else if(current.key.compareTo(key) > 0){
            if(current.leftChild == null){
                return false;
            }
            return search(current.leftChild, key);
        }else{
            if(current.rightChild == null){
                return false;
            }
            return search(current.rightChild, key);
        }
    }

    public void print(Node<T> root){
        if(root != null){
            print((root.leftChild));
            System.out.print(" " + root.key);
            print((root.rightChild));
        }
    }


    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(9);
        tree.insert(6);
        tree.print(tree.root);

    }
}
