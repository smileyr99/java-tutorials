package tutorials.inheritance.Assignment9.problem4;

public class UseRecursion extends Recursion {
    public static void main(String[] args) {
        System.out.println("part 1");
        reverseDisplay(12345);
        System.out.println("\n\n--part 2--");
        hailstone(5);
        System.out.println();
        hailstone(6);
        System.out.println();
        hailstone(8);

        System.out.println("\n\n--part 3--");
        System.out.println(count("Stony Brook"));

        System.out.println("\n--part 4--");
        System.out.println(findTimes10(new int[]{1, 5, 3, 5, 50, 2, 4, 6, 60}));
        System.out.println(findTimes10(new int[]{1, 5, 3, 5, 15, 2, 4, 6, 60}));
        System.out.println(findTimes10(new int[]{1, 5, 3, 5, 15, 2, 4, 6, 5}));

        System.out.println("\n--part 5--");
        replaceMult5(new int[]{4, 3, -8, 33, 2, 4, 6, -61}, 77);
        System.out.println();
        replaceMult5(new int[]{5, 3, -5, 50, 2, 4, 6, -60}, 99);
        System.out.println();
        replaceMult5(new int[]{4, 3, -8, 33, 2, 4, 6, -61}, 44);

        System.out.println("\n\n--part 6--");
        String[] mob = mobius("Hello", "Java");
        for (int i = 0; i < mob.length; i++) {
            System.out.println(mob[i]);
        }
        System.out.println("\n--part 7--");
        System.out.println(teddy(10, 4, 2));
        System.out.println(teddy(9, 5, 3));
        System.out.println(teddy(15, 4, 2));
        System.out.println(teddy(20, 3, 5));
        System.out.println(teddy(40, 5, 6));
        System.out.println(teddy(30, 56, 5));
        System.out.println(teddy(30, 55, 4));

    }

}
