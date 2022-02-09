package tutorials.polynorphism;

public class InstanceTree implements Tree {
    Node root;

    public InstanceTree() {
    }

    public InstanceTree(Integer root) {
        this.root = new Node(root);
    }

    @Override
    public Node getLeftChild(Node parent) {
        return parent.leftChild;
    }

    @Override
    public Node getRightChild(Node parent) {
        return parent.rightChild;
    }

    @Override
    public boolean add(Integer item, Integer parentItem, boolean isLeft) {
        if (item == null || root == null && parentItem != null) {
            return false;
        }

        if (root == null) {
            root = new Node(item);
        } else {
            Node parent = search(parentItem);
            if (parent == null || getChild(parent, isLeft) != null) {
                return false;
            }

            if (isLeft) {
                parent.leftChild = new Node(item);
            } else {
                parent.rightChild = new Node(item);
            }
        }
        return true;
    }

    Node search(Node current, Integer item){
        Node node = null;
        if(current != null){
            if(item.equals(current.item)){
                node = current;
            }else{
                node = search(current.leftChild, item);
                if(node == null){
                    node = search(current.rightChild, item);
                }
            }
        }
        return node;
    }

    @Override
    public Node search(Integer item) {
        return search(this.root, item);
    }
}

