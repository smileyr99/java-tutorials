package tutorials.inheritance.Assignment8.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeamManager {
    public static Position pos(int posNum){
        if(posNum == 1){
            return Position.Defender;
        }else if(posNum == 2){
            return Position.Midfielder;
        }else if(posNum == 3){
            return Position.Forward;
        }else{
            return null;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Roaster roaster = new Roaster();
        int op;
        String name;
        int posNum;
        do{
            System.out.println("Menu: ");
            System.out.println("1. Print player list.");
            System.out.println("2. Add player to roster.");
            System.out.println("3. Remove player from roster.");
            System.out.println("4. Change player position.");
            System.out.println("5. Quit.");
            System.out.print("Enter menu choice: ");
            op = Integer.parseInt(br.readLine());
            Position p;
            switch (op){
                case 1:
                    roaster.print();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter player name: ");
                    name = br.readLine();
                    System.out.print("Enter player position (1 = defender, 2 = midfielder, 3 = forward): ");
                    posNum = Integer.parseInt(br.readLine());
                    roaster.addPlayer(name, pos(posNum));
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter name of player to remove: ");
                    name = br.readLine();
                    roaster.removePlayer(name);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter name of player to reposition: ");
                    name = br.readLine();
                    System.out.print("Enter player position (1 = defender, 2 = midfielder, 3 = forward): ");
                    posNum = Integer.parseInt(br.readLine());
                    roaster.changePlayer(name, pos(posNum));
                    System.out.println();
                    break;
                case 5:
                    System.exit(5);
            }
        }while(op!=5);

    }
}
