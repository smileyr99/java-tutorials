package tutorials.inheritance.Assignment8.problem4;

public class Roaster {
    private int playerCnt = 0;
    private Player[] players;

    public void print() {
        for (int i = 0; i < playerCnt; i++) {
            System.out.println(players[i].name + " : " + players[i].position);
        }
    }


    public boolean existPlayer(String name) {
        for (int i = 0; i < playerCnt; i++) {
            if (players[i] != null && players[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addPlayer(String name, Position position) {
        if (players == null || playerCnt + 1 > players.length) {
            Player[] nPlayers = new Player[(playerCnt + 1) * 2];
            for (int i = 0; i < playerCnt; i++) {
                nPlayers[i] = players[i];
            }
            players = nPlayers;
        }
        players[playerCnt] = new Player(name, position);
        playerCnt++;
    }

    public void removePlayer(String name) {
        boolean result = false;

        for (int i = 0; i < playerCnt; i++) {
            if (players[i] != null && players[i].getName().equals(name)) {
                players[i] = null;
                result = true;
            }
        }
        if (result) {
            Player[] nPlayers = new Player[players.length];
            int cnt = 0;
            for (int i = 0; i < playerCnt; i++) {
                if (players[i] != null) {
                    players[i] = nPlayers[cnt];
                    cnt++;
                }
            }
            players = nPlayers;
            playerCnt--;
        }
    }

    public void changePlayer(String name, Position position) {
        for (int i = 0; i < playerCnt; i++) {
            if (players[i] != null && players[i].getName().equals(name)) {
                players[i].setPosition(position);
            }
        }
    }


}
