import java.util.Arrays;

public class Galaktyka {

    private static void north(String[][] spiral, int lengthOfSpiral, int size) {
        int value = 0;
        int minCol;
        int maxCol;
        int minRow;
        int maxRow;
        minCol = 1;
        maxCol = size + 1;
        minRow = 0;
        maxRow = size;
        while (value < lengthOfSpiral) {

            for (int i = minRow; i <= maxRow - 1; i++) {
                spiral[i][maxCol] = " ";

                value++;
            }

            for (int i = maxCol; i >= minCol; i--) {
                spiral[maxRow][i] = " ";

                value++;
            }

            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                spiral[i][minCol] = " ";

                value++;
            }
            for (int i = minCol + 1; i <= maxCol - 2; i++) {
                spiral[minRow + 1][i] = " ";

                value++;
            }
            minCol = minCol + 2;
            minRow = minRow + 2;
            maxCol = maxCol - 2;
            maxRow = maxRow - 2;
        }
    }

    private static void west(String[][] spiral, int lengthOfSpiral, int size) {

        int value = 0;
        int minCol;
        int maxCol;
        int minRow;
        int maxRow;
        minCol = 0;
        maxCol = size;
        minRow = 1;
        maxRow = size + 1;
        while (value < lengthOfSpiral) {
            for (int i = minCol; i <= maxCol; i++) {
                spiral[minRow][i] = " ";

                value++;
            }

            for (int i = minRow + 1; i <= maxRow; i++) {
                spiral[i][maxCol] = " ";

                value++;
            }

            for (int i = maxCol - 1; i >= minCol + 1; i--) {
                spiral[maxRow][i] = " ";

                value++;
            }

            for (int i = maxRow - 1; i >= minRow + 2; i--) {
                spiral[i][minCol + 1] = " ";

                value++;
            }

            minCol = minCol + 2;
            minRow = minRow + 2;
            maxCol = maxCol - 2;
            maxRow = maxRow - 2;
        }
    }

    private static void east(String[][] spiral, int lengthOfSpiral, int size) {
        int value = 0;
        int minCol;
        int maxCol;
        int minRow;
        int maxRow;
        minCol = 1;
        maxCol = size + 1;
        minRow = 1;
        maxRow = size;
        while (value < lengthOfSpiral) {

            for (int i = maxCol; i >= minCol; i--) {
                spiral[maxRow + 1][i] = " ";

                value++;
            }

            for (int i = maxRow; i >= minRow; i--) {
                spiral[i][minCol] = " ";

                value++;
            }
            for (int i = minCol + 1; i <= maxCol - 1; i++) {
                spiral[minRow][i] = " ";

                value++;
            }
            for (int i = minRow; i <= maxRow - 1; i++) {
                spiral[i][maxCol - 1] = " ";

                value++;
            }
            minCol = minCol + 2;
            minRow = minRow + 2;
            maxCol = maxCol - 2;
            maxRow = maxRow - 2;
        }
    }

    private static void south(String[][] spiral, int lengthOfSpiral, int size) {
        int value = 0;
        int minCol;
        int maxCol;
        int minRow;
        int maxRow;
        minCol = 1;
        maxCol = size + 1;
        minRow = 1;
        maxRow = size + 1;
        while (value < lengthOfSpiral) {
            for (int i = maxRow; i >= minRow; i--) {
                spiral[i][minCol] = " ";

                value++;
            }
            for (int i = minCol; i <= maxCol; i++) {
                spiral[minRow][i] = " ";

                value++;
            }
            for (int i = minRow + 1; i <= maxRow - 1; i++) {
                spiral[i][maxCol] = " ";

                value++;
            }
            for (int i = maxCol - 1; i >= minCol + 2; i--) {
                spiral[maxRow - 1][i] = " ";

                value++;
            }

            minCol = minCol + 2;
            minRow = minRow + 2;
            maxCol = maxCol - 2;
            maxRow = maxRow - 2;
        }
    }

    private static void klops() {
        System.out.println("klops");
        System.exit(0);
    }

    private static void print(String druk) {
        System.out.print(druk);
    }

    private static void print(int druk) {
        System.out.print(druk);
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int lengthOfSpiral = 0;
                String side = args[0];
                int size = Integer.parseInt(side.substring(0, side.length() - 1));
                if (size > 10000 || size <= 0) {
                    klops();
                }
                for (int i = 0; i <= size + 1; i++) {
                    lengthOfSpiral = lengthOfSpiral + i;
                }
                side = side.substring(side.length() - 1);
                String[][] spiral;
                if ("W".equals(side) || "E".equals(side)) {
                    spiral = new String[size + 3][size + 2];
                } else {
                    spiral = new String[size + 2][size + 3];
                }
                for (int i = 0; i <= spiral.length - 1; i++) {
                    for (int j = 0; j <= spiral[0].length - 1; j++) {
                        spiral[i][j] = "*";
                    }
                }
                switch (side) {
                    case "W":
                        west(spiral, lengthOfSpiral, size);
                        break;
                    case "N":
                        north(spiral, lengthOfSpiral, size);

                        break;
                    case "E":

                        east(spiral, lengthOfSpiral, size);
                        break;
                    case "S":

                        south(spiral, lengthOfSpiral, size);

                        break;
                    default:
                        klops();
                        break;

                }
                System.out.println(Arrays.deepToString(spiral).replace("], ", "\n").replace("[[", "").replace("]]", "").replace("[", "").replace(", ", ""));
                print(lengthOfSpiral);
            } catch (NumberFormatException e) {
                klops();
            }
        } else {
            klops();
        }
        System.exit(0);
    }
}
