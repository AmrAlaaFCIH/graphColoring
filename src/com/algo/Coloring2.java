package com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Coloring2 {
    private HashMap<Integer, ArrayList<Integer>> vertex=new HashMap<>();
    private boolean[] availableColors;
    private int[] listOfColors;
    private int numberOfColors;
    private int[] colors;


    public Coloring2(int[][] matrix,int numberOfColors){
        this.availableColors=new boolean[numberOfColors];
        this.listOfColors=new int[numberOfColors];
        this.colors=new int[matrix.length];
        this.numberOfColors=numberOfColors;
        for (int i=0;i<numberOfColors;i++){
            listOfColors[i]=i+1;
        }
        for (int i=0;i<matrix.length;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    temp.add(j);
                }
            }
            vertex.put(i,temp);
        }
    }
    private boolean canBeColoredWith(int[] colors){
        for (int color:colors){
            if(color==0){
                return false;
            }
        }
        return true;
    }
    public int[] greedyColoring(){
        Arrays.fill(availableColors,true);  //m
        Arrays.fill(colors,0); //m
        for (int currentVertex: vertex.keySet()){  //v
            for(int i=0;i<vertex.get(currentVertex).size();i++){ //v
                ArrayList<Integer> temp=vertex.get(currentVertex);
                if(colors[temp.get(i)]!=0){
                    availableColors[colors[temp.get(i)]-1]=false;
                }
            }
            for (int j=0;j<numberOfColors;j++){  //m
                if (availableColors[j]){
                    colors[currentVertex]=listOfColors[j];
                    break;
                }
            }
            Arrays.fill(availableColors,true);
        }
        if (canBeColoredWith(colors)){
            return colors;
        }else {
            return new int[]{};
        }

    }
}
