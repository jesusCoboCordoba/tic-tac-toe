package org.mvnexample;

import java.util.HashMap;
import java.util.Map;

public class experiments {
    public static void main(String[] args) {
        String[][] grid = {
                {" ", "O", "O"},
                {"O", "X", "X"},
                {"X", " ", " "}};
        lol();
    }

    public static HashMap<Integer,Integer> lol (){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            entry.setValue(4);
        }
        System.out.println(map.get(1));
        return map;
    }
}
