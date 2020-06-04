package com.algo;

import java.util.Arrays;

public class Coloring {
    private int[][] matrix;
    private int numberOfColors;
    private int[] colors;

    public Coloring(int[][] matrix,int m){
        this.matrix=matrix;
        this.numberOfColors=m;
        colors=new int[matrix.length];
    }

    private boolean isValid(int currentVertex,int currentColor){
        for (int i=0;i<matrix.length;i++){
            if(matrix[currentVertex][i]==1&&currentColor==colors[i]){
                return false;
            }
        }
        return true;
    }

    private boolean canBeColoredWith(int currentVertex){

        if(currentVertex==matrix.length){
            return true;
        }
        for (int i=1;i<=numberOfColors;i++){
            if (isValid(currentVertex,i)){
                colors[currentVertex]=i;
                if (canBeColoredWith(currentVertex+1)){
                    return true;
                }
                colors[currentVertex]=0;
            }
        }
        return false;
    }

    public int[] colorIt(){
        Arrays.fill(colors,0);
        if (!canBeColoredWith(0)){
            return new int[]{};
        }
        return colors;
    }

}
