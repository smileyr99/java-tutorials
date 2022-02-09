package tutorials.polynorphism;

public class ArrayTree implements Tree {
    Node[] nodes;

    public ArrayTree() {
    }

    public ArrayTree(Integer item) {
        this.nodes = new Node[2];
        this.nodes[1] = new Node(item);
    }

    private int getLevel(int idx) {
        int level = 0, multi = 1;
        while (multi <= idx) {
            level += 1;
            multi *= 2;
        }
        return level;
    }

    @Override
    public boolean add(Integer item, Integer parentItem, boolean isLeft) {
        if (item == null || (nodes == null || nodes[1] == null) && parentItem != null) {
            return false;
        }

        if (nodes == null || nodes[1] == null) {
            this.nodes = new Node[2];
            this.nodes[1] = new Node(item);
        } else {
            int parentIdx = search(new Node(parentItem));
            int childIdx = getChild(parentIdx, isLeft);
            if (parentIdx <= 0 || childIdx > 0) {
                return false;
            }

            if (childIdx < 0) {
                int parentLevel = getLevel(parentIdx);
                Node[] newNodes = new Node[(int) Math.pow(2, parentLevel + 1)];
                for (int i = 1; i < nodes.length; i++) {
                    newNodes[i] = nodes[i];
                }
                nodes = newNodes;
            }

            if (isLeft) {
                nodes[parentIdx * 2] = new Node(item);
            } else {
                nodes[parentIdx * 2 + 1] = new Node(item);
            }
        }

        return true;
    }

    private int search(Node node, int idx) {
        if (idx >= nodes.length || nodes[idx] == null) {
            return 0;
        }

        if (nodes[idx].item.equals(node.item)) {
            return idx;
        }

        int findIdx = search(node, idx * 2);
        if (findIdx <= 0) {
            findIdx = search(node, idx * 2 + 1);
        }

        return findIdx;
    }

    private int search(Node item) {
        return search(item, 1);
    }

    @Override
    public Node search(Integer item) {
        return nodes[search(new Node(item))];
    }

    /*
    범위를 벗어났으면 -1 -> 추후 add에서 array 늘려주기
    그냥 없으면 0
     */
    private int getLeftChild(int parentIdx) {
        int leftChildIdx = parentIdx * 2;
        if (leftChildIdx >= nodes.length) {
            return -1;
        }
        return parentIdx > 0 && nodes[leftChildIdx] != null ? leftChildIdx : 0;
    }

    @Override
    public Node getLeftChild(Node parent) {
        int leftChildIdx = getLeftChild(search(parent));
        if (leftChildIdx < 0) {
            leftChildIdx = 0;
        }
        return nodes[leftChildIdx];
    }

    /*
    범위를 벗어났으면 -1 -> 추후 add에서 array 늘려주기
    그냥 없으면 0
     */
    private int getRightChild(int parentIdx) {
        int rightChildIdx = parentIdx * 2 + 1;
        if (rightChildIdx >= nodes.length) {
            return -1;
        }
        return parentIdx > 0 && nodes[rightChildIdx] != null ? rightChildIdx : 0;
    }

    @Override
    public Node getRightChild(Node parent) {
        int rightChildIdx = getRightChild(search(parent));
        if (rightChildIdx < 0) {
            rightChildIdx = 0;
        }
        return nodes[rightChildIdx];
    }

    private int getChild(int parentIdx, boolean isLeft) {
        return isLeft ? getLeftChild(parentIdx) : getRightChild(parentIdx);
    }
}
