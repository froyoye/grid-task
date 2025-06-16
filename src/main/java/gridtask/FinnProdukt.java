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
    public static void main(String[] args){
        try {
            int[][] grid = lesGridFraFil("src/main/resources/grid.txt");

            for (int[] rad : grid) {
                for (int verdi : rad) {
                    System.out.printf("%5d", verdi);
                }
                System.out.println();
            }
            int[] horisontalMaks = horisontaltProdukt(grid);
            System.out.println("Største horisontale produkt: " + horisontalMaks[0]);
            
            int hRad = horisontalMaks[1];
            int hKol = horisontalMaks[2];

            System.out.println("Posisjon for tallene er: [" + hRad + ", " + hKol + "], [" + hRad + ", " + (hKol + 1) + "], [" + hRad + ", " + (hKol + 2) + "], [" + hRad + ", " + (hKol + 3) + "]");
            
            int[] vertikalMaks = vertikaltProdukt(grid);
            System.out.println("Største vertikale produkt: " + vertikalMaks[0]);
            
            int vRad = vertikalMaks[1];
            int vKol = vertikalMaks[2];

            System.out.println("Posisjon for tallene er: [" + vRad + ", " + vKol + "], [" + vRad + ", " + (vKol + 1) + "], [" + vRad + ", " + (vKol + 2) + "], [" + vRad + ", " + (vKol + 3) + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}