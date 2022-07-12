package MayınTarlasi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Satır sayısını giriniz: ");
        int row = input.nextInt();
        System.out.print("Sütün sayısını giriniz: ");
        int col = input.nextInt();

        String[][] area = MineSweeper.mineSweeperArea(row, col);
        String[][] emptyArea = MineSweeper.emptyArea(row, col);
        MineSweeper.print(emptyArea);

        MineSweeper.check(area, emptyArea, row, col);
    }
}
