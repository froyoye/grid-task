package gridtask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinnProdukt {

    public static int[][] lesGridFraFil(String filnavn) throws IOException {
        int[][] grid = new int[20][20];
        BufferedReader leser = new BufferedReader(new FileReader(filnavn));
        String linje;
        int rad = 0;

        while ((linje = leser.readLine()) != null && rad < 20) {
            String[] tall = linje.trim().split("\\s+");
            for (int kolonne = 0; kolonne < 20; kolonne++) {
                grid[rad][kolonne] = Integer.parseInt(tall[kolonne]);
            }
            rad++;
        }
        leser.close();
        return grid;
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}