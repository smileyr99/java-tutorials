package tutorials.polynorphism;

public interface Tree {

    boolean add(Integer item, Integer parent, boolean isLeft);
    Node search(Integer item);
    Node getLeftChild(Node parent);
    Node getRightChild(Node parent);

    default Node getChild(Node parent, boolean isLeft) {
        return isLeft ? getLeftChild(parent) : getRightChild(parent);
    }
}
