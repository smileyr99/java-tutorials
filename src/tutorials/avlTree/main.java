package tutorials.avlTree;

public class main {
    static public void searchPrint(AVLTree tree, int data){
        if(tree.search(data) == 0){
            System.out.println("no data");
        }else{
            System.out.println("find data");
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(3);
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(8);
        searchPrint(tree, 3);
        tree.display(tree.root);
    }
}
