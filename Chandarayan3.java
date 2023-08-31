public class Chandarayan3 {

    private String defaultDirection = "N";
    private String prevDirection;
    private int x;
    private int y;
    private int z;
    private String direction;

    public Chandarayan3(int x, int y, int z, String direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    public void sendMessage(String[] commands) {
        for (String cmd : commands) {
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
                    System.out.println("Invalid Command: " + cmd);
            }
        }
    }

    private void down() {
        if (!direction.equals("Up") && !direction.equals("Down"))
            prevDirection = direction;
        direction = "Down";
    }

    private void up() {
        if (!direction.equals("Up") && !direction.equals("Down"))
            prevDirection = direction;
        direction = "Up";
    }

    private void right() {
        if (direction.equals("N"))
            direction = "E";
        else if (direction.equals("E"))
            direction = "S";
        else if (direction.equals("S"))
            direction = "W";
        else if (direction.equals("W"))
            direction = "N";
        else {
            String temp = prevDirection != null ? prevDirection : defaultDirection;
            switch (temp) {
                case "N":
                    direction = "E";
                    break;
                case "E":
                    direction = "S";
                    break;
                case "S":
                    direction = "W";
                    break;
                default:
                    direction = "N";
            }
        }
    }

    private void left() {
        if (direction.equals("N"))
            direction = "W";
        else if (direction.equals("E"))
            direction = "N";
        else if (direction.equals("S"))
            direction = "E";
        else if (direction.equals("W"))
            direction = "S";
        else {
            String temp = prevDirection != null ? prevDirection : defaultDirection;
            switch (temp) {
                case "N":
                    direction = "W";
                    break;
                case "E":
                    direction = "N";
                    break;
                case "S":
                    direction = "E";
                    break;
                default:
                    direction = "S";
            }
        }
    }

    private void backward() {
        switch (direction) {
            case "N":
                y--;
                break;
            case "S":
                y++;
                break;
            case "W":
                x++;
                break;
            case "E":
                x--;
                break;
            case "Up":
                z--;
                break;
            default:
                z++;
        }
    }

    private void forward() {
        switch (direction) {
            case "N":
                y++;
                break;
            case "S":
                y--;
                break;
            case "W":
                x--;
                break;
            case "E":
                x++;
                break;
            case "Up":
                z++;
                break;
            default:
                z--;
        }
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
        c.sendMessage(commands);
        System.out.println(c.getX() + " " + c.getY() + " " + c.getZ() + " " + c.getDir());
    }
}
