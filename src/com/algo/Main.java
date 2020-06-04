package com.algo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr={
                {0,1,1,0,0,1},
                {1,0,1,1,0,0},
                {1,1,0,1,0,1},
                {0,1,1,0,1,0},
                {0,0,0,1,0,1},
                {1,0,1,0,1,0}
        };
        Coloring coloring=new Coloring(arr,4);
        Coloring2 coloring2=new Coloring2(arr,4);
        System.out.println(Arrays.toString(coloring2.greedyColoring()));
        System.out.println(Arrays.toString(coloring.colorIt()));
    }


}
