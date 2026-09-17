package org.mvnexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Ai {
    public static void main(String[] args) {
        String[][] grid = {
                {" ", " ", "O"},
                {" ", " ", " "},
                {" ", " ", " "}};

        System.out.println(minMax(grid,1));


    }

    public static  Map.Entry<Integer, Integer>  minMax (String [][] grid, int turn){
        ArrayList<Integer> possibleMovements = possibleMovements(grid);
        HashMap<Integer,Integer> map = new HashMap<>();
        Map.Entry<Integer, Integer> pair = null;
        for (int i = 0; i <possibleMovements.size(); i++){

            if(turn%2==0){
                humanTurn(grid,possibleMovements.get(i));
            }
            if(turn%2!=0){
                aiTurn(grid,possibleMovements.get(i));
            }
            if (evaluationFun(grid)==1){
                map.put(possibleMovements.get(i),1);
                undo(grid,possibleMovements.get(i));
                continue;
            }
            if (evaluationFun(grid)==-1){
                map.put(possibleMovements.get(i),-1);
                undo(grid,possibleMovements.get(i));
                continue;
            }
            if (evaluationFun(grid)==0 && possibleMovements.size()==1){
                map.put(possibleMovements.get(i),0);
                undo(grid,possibleMovements.get(i));
                continue;
            }
            pair = minMax(grid,turn+1);
            int uno = possibleMovements.get(i);
            int dos = pair.getValue();
            map.put(possibleMovements.get(i), pair.getValue());
            undo(grid,possibleMovements.get(i));
        }


        return pairResolver(turn , map);
    }



    public static  Map.Entry<Integer, Integer> pairResolver (int turn , HashMap<Integer,Integer> map){
        Map.Entry<Integer, Integer> result1 = null ;
        if(turn%2==0){
            int value = Integer.MAX_VALUE;
            for (Map.Entry<Integer,Integer> pair : map.entrySet()){
                int key = pair.getKey();
                if( pair.getValue() < value ){
                    result1 = pair;
                    value=pair.getValue();
                }
            }
        }
        if(turn%2!=0){
            int value = Integer.MIN_VALUE;
            for (Map.Entry<Integer,Integer> pair : map.entrySet()){
                int key = pair.getKey();
                if( pair.getValue()> value ){
                    result1 = pair;
                    value=pair.getValue();
                }
            }
        }
        return result1;
    }



    public static int evaluationFun(String [][] grid){
       if (Main.state(grid)==1) return 1;
       if (Main.state(grid)==-1) return -1;
       return 0;
    }

    public static ArrayList<Integer> possibleMovements(String [][] grid ){
        ArrayList<Integer>list =  new ArrayList<>();
        int position = 1;
        for (int i =0 ; i< grid.length ; i++){
            for (int j =0 ;j< grid[i].length;j++){
                if (grid[i][j].equalsIgnoreCase(" ") ) {
                   list.add(position);
                }
                position++;
            }
        }
        return list ;
    }
    public static void aiTurn ( String [][] grid, int movement) {
        int searcher = 1;
        boolean foundIt = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (searcher==movement) {
                    grid[i][j]= "X";
                    foundIt=true;
                    break;
                }
                searcher++;
            }
            if (foundIt) break;
        }
    }
    public static void humanTurn ( String [][] grid , int movement) {
        int searcher = 1;
        boolean foundIt = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (searcher==movement) {
                    grid[i][j]= "O";
                    foundIt=true;
                    break;
                }
                searcher++;
            }
            if (foundIt) break;
        }
    }

    public static void undo (String [][] grid , int positionsToUndo){
        int position = 1;
        for (int i = 0 ; i < grid.length;i++){
            for ( int j =0 ; j<grid[i].length;j++){
                if (position == positionsToUndo){
                    grid[i][j]=" ";
                    return;
                }
               position++;
            }
        }

    }


}

