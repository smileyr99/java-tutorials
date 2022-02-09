package tutorials.inheritance.Assignment8.problem4;

enum Position {Midfielder, Forward, Defender};

class Player {
    String name;
    Position position;

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
// You will need to write this method.
        return name + ": " + position;
    }
}