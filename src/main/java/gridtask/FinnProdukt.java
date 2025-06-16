package gridtask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinnProdukt {

    public static int[][] lesGridFraFil(String filnavn) throws IOException {
        int[][] grid = new int[20][20];
        BufferedReader reader = new BufferedReader(new FileReader(filnavn));
        String linje;
        int rad = 0;

        while ((linje = reader.readLine()) != null && rad < 20) {
            String[] tall = linje.trim().split("\\s+");
            for (int kolonne = 0; kolonne < 20; kolonne++) {
                grid[rad][kolonne] = Integer.parseInt(tall[kolonne]);
            }
            rad++;
        }
        reader.close();
        return grid;
    }

    public static int[] horisontaltProdukt(int[][] grid) {
        int maksProdukt = 0;
        int startRad = -1;
        int startKol = -1;

        for (int rad = 0; rad < 20; rad++) {
            for (int kolonne = 0; kolonne <= 20 - 4; kolonne++) {
                int produkt = grid[rad][kolonne] * grid[rad][kolonne + 1] * grid[rad][kolonne + 2] * grid[rad][kolonne + 3];
                if (produkt > maksProdukt) {
                    maksProdukt = produkt;
                    startRad = rad;
                    startKol = kolonne;
                }
            }
        }
        return new int[]{maksProdukt, startRad, startKol};
    }

    public static int[] vertikaltProdukt(int[][] grid) {
        int maksProdukt = 0;
        int startRad = -1;
        int startKol = -1;

        for (int kolonne = 0; kolonne < 20; kolonne++) {
            for (int rad = 0; rad <= 20 - 4; rad++) {
                int produkt = grid[rad][kolonne] * grid[rad + 1][kolonne] * grid[rad + 2][kolonne] * grid[rad + 3][kolonne];
                if (produkt > maksProdukt) {
                    maksProdukt = produkt;
                    startRad = rad;
                    startKol = kolonne;
                }
            }
        }
        return new int[]{maksProdukt, startRad, startKol};
    }

    public static int[] diagonaltHProdukt(int[][] grid) {
        int maksProdukt = 0;
        int startRad = -1;
        int startKol = -1;

        for (int rad = 0; rad <= 20 - 4; rad++) {
            for (int kolonne = 0; kolonne <= 20 - 4; kolonne++) {
                int produkt = grid[rad][kolonne] * grid[rad + 1][kolonne + 1] * grid[rad + 2][kolonne + 2] * grid[rad + 3][kolonne + 3];
                if (produkt > maksProdukt) {
                    maksProdukt = produkt;
                    startRad = rad;
                    startKol = kolonne;
                }
            }
        }
        return new int[]{maksProdukt, startRad, startKol};
    }

    public static int[] diagonaltVProdukt(int[][] grid) {
        int maksProdukt = 0;
        int startRad = -1;
        int startKol = -1;

        for (int rad = 3; rad < 20; rad++) {
            for (int kolonne = 0; kolonne <= 20 - 4; kolonne++) {
                int produkt = grid[rad][kolonne] * grid[rad - 1][kolonne + 1] * grid[rad - 2][kolonne + 2] * grid[rad - 3][kolonne + 3];
                if (produkt > maksProdukt) {
                    maksProdukt = produkt;
                    startRad = rad;
                    startKol = kolonne;
                }
            }
        }
        return new int[]{maksProdukt, startRad, startKol};
    }

    public static void main(String[] args){
        try {
            int[][] grid = lesGridFraFil("src/main/resources/grid.txt");

            int[] horisontalt = horisontaltProdukt(grid);
            int[] vertikalt = vertikaltProdukt(grid);
            int[] diagonaltH = diagonaltHProdukt(grid);
            int[] diagonaltV = diagonaltVProdukt(grid);

            int[] maks = horisontalt;
            String retning = "Horisontalt";

            if (vertikalt[0] > maks[0]) {
                maks = vertikalt;
                retning = "Vertikalt";
            }
            if (diagonaltH[0] > maks[0]) {
                maks = diagonaltH;
                retning = "Diagonalt Høyre";
            }
            if (diagonaltV[0] > maks[0]) {
                maks = diagonaltV;
                retning = "Diagonalt Venstre";
            }
           
            System.out.println("Det største produktet er: " + maks[0]);
            System.out.println("Retning: " + retning);

            int rad = maks[1];
            int kolonne = maks[2];

            int dRad = 0, dKol = 0;
            switch (retning) {
                case "Horisontalt":
                    dRad = 0; dKol = 1;
                    break;
                case "Vertikalt":
                    dRad = 1; dKol = 0;
                    break;
                case "Diagonalt Høyre":
                    dRad = 1; dKol = 1;
                    break;
                case "Diagonalt Venstre":
                    dRad = -1; dKol = 1;
                    break;
            }

            System.out.print("Indeks i grid: ");
            for (int i = 0; i < 4; i++) {
                int r = rad + i * dRad;
                int k = kolonne + i * dKol;
                System.out.print("[" + r + ", " + k + "]");
                if (i < 3) System.out.print(", ");
            }

            System.out.println();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}