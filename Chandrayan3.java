import java.util.*;

public class Chandrayan3 {
    String dir = "N";
    String prev;
    int[] coordinates = { 0, 0, 0 };

    private final Map<String, int[]> directionToCoordinateChange = new HashMap<>();

    public Chandrayan3(String initialDir, int[] initialCor) {

        this.dir = initialDir;
        this.coordinates = initialCor;

        directionToCoordinateChange.put("N", new int[] { 0, 1, 0 });
        directionToCoordinateChange.put("S", new int[] { 0, -1, 0 });
        directionToCoordinateChange.put("E", new int[] { 1, 0, 0 });
        directionToCoordinateChange.put("W", new int[] { -1, 0, 0 });
        directionToCoordinateChange.put("Up", new int[] { 0, 0, 1 });
        directionToCoordinateChange.put("Down", new int[] { 0, 0, -1 });
    }

    public void handleMove(char[] commands) {
        for (char comm : commands) {
            switch (comm) {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'r':
                    turnRight();
                    break;
                case 'l':
                    turnLeft();
                    break;
                case 'd':
                    setDown();
                    break;
                case 'u':
                    setUp();
                    break;
            }
        }
    }

    public void moveForward() {
        int[] coordinateChange = directionToCoordinateChange.get(dir);
        if (coordinateChange != null) {
            for (int i = 0; i < 3; i++) {
                coordinates[i] += coordinateChange[i];
            }
        }
    }

    public void moveBackward() {
        int[] coordinateChange = directionToCoordinateChange.get(dir);
        if (coordinateChange != null) {
            for (int i = 0; i < 3; i++) {
                coordinates[i] -= coordinateChange[i];
            }
        }
    }

    public void turnLeft() {
        if (dir.equals("Up") || dir.equals("Down")) {
            dir = prev.equals("N") ? "W" : prev.equals("S") ? "E" : prev.equals("E") ? "N" : "S";
        } else {
            dir = dir.equals("N") ? "W" : dir.equals("S") ? "E" : dir.equals("E") ? "N" : "S";
        }
    }

    public void turnRight() {
        if (dir.equals("Up") || dir.equals("Down")) {
            dir = prev.equals("N") ? "E" : prev.equals("S") ? "W" : prev.equals("E") ? "S" : "N";
        } else {
            dir = dir.equals("N") ? "E" : dir.equals("S") ? "W" : dir.equals("E") ? "S" : "N";
        }
    }

    public void setUp() {
        if (!dir.equals("Up")) {
            prev = dir;
            dir = "Up";
        }
    }

    public void setDown() {
        if (!dir.equals("Down")) {
            prev = dir;
            dir = "Down";
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the initial facing dir:- ");
        String initialDir = sc.nextLine();

        int[] initialCor = new int[3];
        System.out.print("Enter the starting cordinates:- ");
        for (int i = 0; i < 3; i++) {
            initialCor[i] = sc.nextInt();
        }

        System.out.print("Enter commands (separated by spaces): ");
        sc.nextLine(); 
        String commandsLine = sc.nextLine();
        char[] commands = commandsLine.toCharArray();

        Chandrayan3 chandryaan = new Chandrayan3(initialDir, initialCor);

        chandryaan.handleMove(commands);
        System.out.println("Final dir:- " + chandryaan.dir);
        System.out.println(java.util.Arrays.toString(chandryaan.coordinates));
        sc.close();
    }
}