public class Chandarayan3 {

    String defaultDirection = "N";
    String prevDirection;
    int x;
    int y;
    int z;
    String direction;

    public Chandarayan3(int x, int y, int z, String direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    public void sendMessage(String[] command) {
        for (String cmd : command) {
            switch (cmd) {
                case "f":
                    forward();
                    break;
                case "b":
                    backward();
                    break;
                case "l":
                    left();
                    break;
                case "r":
                    right();
                    break;
                case "u":
                    up();
                    break;
                case "d":
                    down();
                    break;
                default:
                    System.out.println("Give Valid Command");
            }
        }
    }

    private void down() {
        if (direction != "Up" || direction != "Down")
            prevDirection = direction;
        direction = "Down";
    }

    private void up() {
        if (direction != "Up" || direction != "Down")
            prevDirection = direction;
        direction = "Up";
    }

    private void right() {
        if (direction == "N")
            direction = "E";
        else if (direction == "E")
            direction = "S";
        else if (direction == "S")
            direction = "W";
        else if (direction == "W")
            direction = "N";
        else {
            String temp = prevDirection != null ? prevDirection : defaultDirection;
            if (temp == "N")
                direction = "E";
            else if (temp == "E")
                direction = "S";
            else if (temp == "S")
                direction = "W";
            else
                direction = "N";
        }
    }

    private void left() {
        if (direction == "N")
            direction = "W";
        else if (direction == "E")
            direction = "N";
        else if (direction == "S")
            direction = "E";
        else if (direction == "W")
            direction = "S";
        else {
            String temp = prevDirection != null ? prevDirection : defaultDirection;
            if (temp == "N")
                direction = "W";
            else if (temp == "E")
                direction = "N";
            else if (temp == "S")
                direction = "E";
            else
                direction = "S";
        }
    }

    private void backward() {
        if (direction == "N")
            y--;
        else if (direction == "S")
            y++;
        else if (direction == "W")
            x++;
        else if (direction == "E")
            x--;
        else if (direction == "Up")
            z--;
        else
            z++;
    }

    private void forward() {
        if (direction == "N")
            y++;
        else if (direction == "S")
            y--;
        else if (direction == "W")
            x--;
        else if (direction == "E")
            x++;
        else if (direction == "Up")
            z++;
        else
            z--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getDir() {
        return direction;
    }

    public static void main(String[] args) {
        Chandarayan3 c = new Chandarayan3(1, 1, 1, "Up");
        String[] commands = { "r", "l", "f", "f", "u", "b" };
        ;
        c.sendMessage(commands);
        System.out.println(c.getX() + " " + c.getY() + " " + c.getZ() + " " + c.getDir());
    }
}