package tutorials.polynorphism;

public class main {
    public static void main(String[] args){
        Tree tree = new InstanceTree();
        System.out.println(tree.add(1,null,true));
        System.out.println(tree.add(2,4, true));
        System.out.println(tree.add(3,1, false));
        System.out.println(tree.add(1,2, false));
    }
}
