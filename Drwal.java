
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Drwal {

    public static void main(String[] args) {
        if (args.length != 5) {
            klops();
        }
        if (args[2].length() != 1) {
            klops();
        }
        int xStart = Integer.parseInt(args[0]);
        int yStart = Integer.parseInt(args[1]);
        char kolor = args[2].charAt(0);
        int szerokosc = Integer.parseInt(args[3]);
        int wysokosc = Integer.parseInt(args[4]);
        if (szerokosc != wysokosc) {
            klops();
        }
        if (szerokosc > 50) {
            klops();
        }
        String[][] DrwalikFredek = new String[wysokosc][szerokosc];
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                DrwalikFredek[i][j] = " ";
            }
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp ;
        int j = 0;
        try {
            while ((temp = reader.readLine()) != null) {
                for (int i = 0; i < temp.length(); i++) {
                    DrwalikFredek[j][i] = String.valueOf(temp.charAt(i));
                }
                j++;
            }
        } catch (IOException e) {
            klops();
        } catch (Exception ee) {
            klops();
        }
        koloruj(xStart - 1, yStart - 1, kolor, DrwalikFredek, wysokosc, szerokosc);
        System.out.println(Arrays.deepToString(DrwalikFredek).replace("], ", "\n").replace("[[", "").replace("]]", "").replace("[", "").replace(", ", ""));

    }

    private static void klops() {
        System.out.println("klops");
        System.exit(0);
    }

    private static void koloruj(int xStart, int yStart, char kolor, String[][] DrwalikFredek, int wysokosc, int szerokosc) {
        boolean change = true;
        String kolo = String.valueOf(kolor);
        if (" ".equals(DrwalikFredek[xStart][yStart])) {
            DrwalikFredek[xStart][yStart] = String.valueOf(kolo);
        } else {
            klops();
        }
        while (change) {
            change = false;
            for (int i = 0; i < wysokosc; i++) {
                for (int j = 0; j < szerokosc; j++) {
                    if (j < 9) {
                        if (DrwalikFredek[i][j].equals(" ") && DrwalikFredek[i][j + 1].equals(kolo)) {
                            DrwalikFredek[i][j] = kolo;
                            change = true;
                        }
                    }
                    if (j > 0) {
                        if (DrwalikFredek[i][j].equals(" ") && DrwalikFredek[i][j - 1].equals(kolo)) {
                            DrwalikFredek[i][j] = kolo;
                            change = true;
                        }
                    }
                    if (i > 0) {
                        if (DrwalikFredek[i][j].equals(" ") && DrwalikFredek[i - 1][j].equals(kolo)) {
                            DrwalikFredek[i][j] = kolo;
                            change = true;
                        }
                    }
                    if (i < 9) {
                        if (DrwalikFredek[i][j].equals(" ") && DrwalikFredek[i + 1][j].equals(kolo)) {
                            DrwalikFredek[i][j] = kolo;
                            change = true;
                        }
                    }
                }
            }
        }
    }
}
