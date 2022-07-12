package MayınTarlasi;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    static String[][] mineSweeperArea( int rowCount, int colCount){
         Random rNumber = new Random();
         String[][] area = new String[rowCount][colCount];

         int count = 0;
         int maxRow = rowCount;
         int maxCol = colCount;
         int mine = (rowCount * colCount) / 4;
         int i = 0;

         while (i < mine){
             int randrow = rNumber.nextInt(maxRow - count) + count;
             int randcol = rNumber.nextInt(maxCol - count) + count;
             if(area[randrow][randcol] != " * "){
                 area[randrow][randcol] = " * ";
                 i++;
             }
         }
         for ( i = 0;i<rowCount ; i++){
             for(int j=0;j<colCount;j++){
                 if(area[i][j] != " * "){
                    area[i][j] = " - ";
                 }
             }
         }
         return area;
    }
    static void print(String[][] area){
        for (int i=0; i<area.length;i++){
            for(int j=0; j<area[i].length;j++){
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

    static String[][] emptyArea(int rowCount,int colCount){
        String[][] emptyArea = new String[rowCount][colCount];
        for(int i=0; i<rowCount;i++){
            for(int j=0; j<colCount; j++){
                emptyArea[i][j] = " - ";
            }
        }
        return emptyArea;
    }

    static String[][] check(String[][] area, String[][] emptyArea, int row, int col){
        int mine = (row * col) / 4;
        int kalan = (row * col) - mine;

        boolean durum = true;

        while (durum) {
            Scanner input = new Scanner(System.in);
            System.out.print("Satır seçiniz: ");
            int a = input.nextInt();
            System.out.print("Sütün seçiniz: ");
            int b = input.nextInt();

            if(a < 0 || a>=row || b<0 || b>= col){
                System.out.println("Hatalı değer girdiniz!");
                continue;
            }
                if(area[a][b].equals(" * ")){
                    System.out.println("-----Game Over------");
                    System.out.println("--Mayın Tarlası--");
                    MineSweeper.print(area);
                    durum = false;
                    break;

                }else if (area[a][b].equals(emptyArea[a][b])) {
                    int count2 = 0;
                    for (int i= -1 ; i<=1;i++){
                        if(((a+1)<0) || (a+i >= area.length)){
                            continue;
                        }
                        for (int j = -1; j<= 1 ; j++) {
                            if(((b+j) <0 || (b+j) >= area.length)){
                                continue;
                            }
                            if(area[a+i][b+j].equals(" * ")) {
                                count2++;
                            }
                        }
                    }
                    emptyArea[a][b] = " " + count2 + " ";
                    MineSweeper.print(emptyArea);
                    kalan--;
                }
            System.out.println("Kalan boşluk: " + kalan);
            if(kalan == 0) {
                System.out.println("Win");
                break;
            }
        }
        return area;
    }
}


















