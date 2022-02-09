package tutorials.inheritance.Assignment9.problem4;

public class Recursion {

    public static void reverseDisplay(int value) {
        if (value <= 0) {
            return;
        }
        System.out.print(value % 10);
        reverseDisplay(value / 10);
    }

    public static int hailstone(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return 1;
        }
        if (n % 2 == 0) {
            System.out.print(n + " ");
            return hailstone(n / 2);
        } else {
            System.out.print(n + " ");
            return hailstone(n * 3 + 1);
        }
    }

    public static int count(String str) {
        return count(str, 0);
    }

    public static int count(String str, int high) {
        if (high == str.length()) {
            return 0;
        }
        if (str.charAt(high) >= 'A' && str.charAt(high) <= 'Z') {
            return 1 + count(str, high + 1);
        } else {
            return count(str, high + 1);
        }
    }

    public static int findTimes10(int[] nums) {
        return findTimes10(nums, 0);
    }

    public static int findTimes10(int[] nums, int index) {
        if (index == nums.length) {
            return -1;
        }
        if (nums[index] % 10 == 0) {
            return index - 1;
        } else
            return findTimes10(nums, index + 1);
    }

    public static void replaceMult5(int[] nums, int newVal) {
        replaceMult5(nums, newVal, 0);
        System.out.print("changes the argument to {");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i] + "}");
            } else {
                System.out.print(nums[i] + ", ");
            }
        }
    }

    public static void replaceMult5(int[] nums, int newVal, int index) {
        if (index == nums.length) {
            return;
        }
        if (nums[index] % 5 == 0) {
            nums[index] = newVal;
        }
        replaceMult5(nums, newVal, index + 1);
    }

    public static String[] mobius(String s1, String s2) {
        String str = s1.concat(s2);
        String[] mob = new String[str.length()];
        mob = mobius1(mob, str, 0);
        return mob;
    }

    public static String[] mobius1(String[] mob, String str, int index) {
        if (index == str.length()) {
            return mob;
        }
        mob[index] = mobius2(str, index, 0);
        return mobius1(mob, str, index + 1);
    }

    public static String mobius2(String str, int index, int cnt) {
        if (cnt == str.length()) {
            return "";
        }
        return str.charAt((cnt + index) % str.length()) + mobius2(str, index, cnt + 1);
    }

    public static int teddy(int initial, int goal, int increment){
        return teddy1(initial, goal, increment, -1);
    }

    public static int teddy1(int initial, int goal, int increment, int step){

        if(step == 10){
            return -1;
        }
        if(teddy2(initial,goal,increment,step+1)){
            return step+1;
        }else{
            return teddy1(initial,goal,increment,step+1);
        }


    }

    public static boolean teddy2(int initial, int goal, int increment, int cnt){
        if (initial == goal) {
            return true;
        }else if(cnt<=0){ //스탭수 초과
            return false;
        }else if(teddy2(initial+increment, goal, increment, cnt-1)){
            return true;
        }else if(teddy2(initial-increment, goal, increment, cnt-1)) {
            return true;
        }else if((initial % 2 == 0) && teddy2(initial-(initial/2),goal,increment,cnt-1)){
            return true;
        }else if((initial % 2 == 0) && teddy2(initial+(initial/2),goal,increment,cnt-1)) {
            return true;
        }else {
            return false;
        }

    }



}
