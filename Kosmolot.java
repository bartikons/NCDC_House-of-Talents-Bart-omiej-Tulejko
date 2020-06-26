public class Kosmolot {

    public static void no(int sizeOfShield) {
        int i = 0;
        for (; i < sizeOfShield; i++) {
            System.out.println();
            for (int j = 0; j < sizeOfShield * (i + 1); j++) {
                System.out.print("*");
                if ((j + 1) % (i + 1) == 0) {
                    for (int k = i; k < sizeOfShield - 1; k++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        i = i - 2;
        for (; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j < sizeOfShield * (i + 1); j++) {
                System.out.print("*");
                if ((j + 1) % (i + 1) == 0) {
                    for (int k = i; k < sizeOfShield - 1; k++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void yes(int sizeOfShield) {
        int i = 0;
        for (; i < sizeOfShield; i++) {
            for (int j = 0; j < sizeOfShield * (i + 1); j++) {

                if (j == 0) {
                    System.out.print(">");
                } else if (i == sizeOfShield - 1 || j % (i + 1) != i && (i + 1) != 1) {
                    System.out.print("*");
                } else {
                    System.out.print("\\");
                }
                if ((j + 1) % (i + 1) == 0) {
                    for (int k = i; k < sizeOfShield - 1; k++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        i = i - 2;
        for (; i >= 0; i--) {
            for (int j = 0; j < sizeOfShield * (i + 1); j++) {
                if (j == 0) {
                    System.out.print(">");
                } else if (i == sizeOfShield - 1 || j % (i + 1) != i && (i + 1) != 1) {
                    System.out.print("*");
                } else {
                    System.out.print("/");
                }
                if ((j + 1) % (i + 1) == 0) {
                    for (int k = i; k < sizeOfShield - 1; k++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

    }

    public static void Klops() {
        System.out.println("klops");
        System.exit(0);
    }

    public static void main(String[] args) {
        int sizeOfShield;
        if (args.length == 2) {
            try {
                char shield = args[1].charAt(0);

                sizeOfShield = Integer.parseInt(args[0]);
                if (sizeOfShield > 75 || sizeOfShield <= 0) {
                    Klops();
                } else {
                }
                switch (shield) {
                    case 'N':
                        no(sizeOfShield);
                        break;
                    case 'Y':
                        yes(sizeOfShield);
                        break;
                    default:
                        Klops();
                        break;
                }
            } catch (NumberFormatException e) {
                Klops();
            }

        } else {
            Klops();
        }
        System.exit(0);
    }
}
