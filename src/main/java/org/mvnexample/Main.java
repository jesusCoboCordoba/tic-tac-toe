package org.mvnexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InputStream stream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader( inputStreamReader);
        String[][] grid = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        System.out.println(Arrays.toString(grid[0]));
        System.out.println(Arrays.toString(grid[1]));
        System.out.println(Arrays.toString(grid[2]));
        try {
            boolean close = false;
            int counter = 1;

            while (!close){
                turnHuman(grid,reader);
                if(state(grid) ==-1){
                       System.out.println("You win!");
                       break;
                   }
                counter++;
                if (counter>9){
                    System.out.println("tie");
                    break;
                }
                System.out.println("Ai turn:");
                turnAi(grid);
                if(state(grid)==1) {
                    System.out.println("Ai wins!");
                    break;
                }
                counter++;
                if (counter>9){
                    System.out.println("tie");
                    break;
                }
            }

        } catch (IOException e ) {
            throw new RuntimeException(e);
        }




    }
    public static void turnHuman ( String [][] grid,  BufferedReader reader ) throws IOException {
        System.out.println("your turn:");
        int rowMin = Integer.parseInt(reader.readLine());
        int columnMin =Integer.parseInt(reader.readLine());
        grid[rowMin][columnMin] = "O";
        System.out.println(Arrays.toString(grid[0]));
        System.out.println(Arrays.toString(grid[1]));
        System.out.println(Arrays.toString(grid[2]));
    }

    public static void turnAi ( String [][] grid){
        Map.Entry<Integer, Integer> pair = Ai.minMax(grid,1);
        int rowMax = translatorRow(pair) ;
        int columnMax = translatorColumn(pair) ;
        grid[rowMax][columnMax] = "X";
        System.out.println(Arrays.toString(grid[0]));
        System.out.println(Arrays.toString(grid[1]));
        System.out.println(Arrays.toString(grid[2]));
    }

        public static int state ( String [][] grid){
        boolean xWin1 = grid[0][0].equals("X") && grid[0][1].equals("X")
                        &&  grid[0][2].equals("X");
        boolean xWin2 = grid[1][0].equals("X") && grid[1][1].equals("X")
                    &&  grid[1][2].equals("X");
        boolean xWin3 = grid[2][0].equals("X") && grid[2][1].equals("X")
                    &&  grid[2][2].equals("X");
        boolean xWin4 = grid[0][0].equals("X") && grid[1][0].equals("X")
                &&  grid[2][0].equals("X");
        boolean xWin5 = grid[0][1].equals("X") && grid[1][1].equals("X")
                    &&  grid[2][1].equals("X");
        boolean xWin6 = grid[2][0].equals("X") && grid[2][1].equals("X")
                &&  grid[2][2].equals("X");
        boolean xWin7 = grid[0][0].equals("X") && grid[1][1].equals("X")
                    &&  grid[2][2].equals("X");
        boolean xWin8 = grid[0][2].equals("X") && grid[1][1].equals("X")
                    &&  grid[2][0].equals("X");
        if(xWin1 || xWin2 || xWin3 || xWin4 || xWin5 || xWin6 || xWin7 || xWin8 ){
            return 1;
        }
        boolean oWin1 = grid[0][0].equals("O") && grid[0][1].equals("O")
                    &&  grid[0][2].equals("O");
            boolean oWin2 = grid[1][0].equals("O") && grid[1][1].equals("O")
                    &&  grid[1][2].equals("O");
            boolean oWin3 = grid[2][0].equals("O") && grid[2][1].equals("O")
                    &&  grid[2][2].equals("O");
            boolean oWin4 = grid[0][0].equals("O") && grid[1][0].equals("O")
                    &&  grid[2][0].equals("O");
            boolean oWin5 = grid[0][1].equals("O") && grid[1][1].equals("O")
                    &&  grid[2][1].equals("O");
            boolean oWin6 = grid[2][0].equals("O") && grid[2][1].equals("O")
                    &&  grid[2][2].equals("O");
            boolean oWin7 = grid[0][0].equals("O") && grid[1][1].equals("O")
                    &&  grid[2][2].equals("O");
            boolean oWin8 = grid[0][2].equals("O") && grid[1][1].equals("O")
                    &&  grid[2][0].equals("O");
            if(oWin1 || oWin2 || oWin3 || oWin4 || oWin5 || oWin6 || oWin7 || oWin8 ){
                return -1;
            }
            return 0;
        }

        public static int translatorRow (Map.Entry<Integer, Integer> pair){
        int position = pair.getKey();
        if ( position<= 3) return 0;
        if ( position<= 6) return 1;
        return 2;
        }
        public static int translatorColumn (Map.Entry<Integer, Integer> pair){
        int position = pair.getKey();
        if ( position == 1 || position == 4 ||position == 7 ) return 0;
        if ( position == 2 || position == 5 ||position == 8 ) return 1;
        return 2;
        }

}
