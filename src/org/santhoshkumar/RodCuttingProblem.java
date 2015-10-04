package org.santhoshkumar;

public class RodCuttingProblem {

    public static void main(String[] args) {
	    int[] spotPrices = { 1,	5,	8,	9,	10,	17,	17,	20,	24,	30 };
        int rodLength = 4;
        RodCuttingProblem r = new RodCuttingProblem();
        r.findMaximumProfit(spotPrices,rodLength);
    }

    public void findMaximumProfit(int[] prices, int rodLength){
        int cols = rodLength;
        int rows = rodLength;

        int[][] matrix =  new int[rows+1][cols+1];
        for(int i=0; i <=rows; i++){
            matrix[i][0] = 0;
        }
        for(int i=0; i <=cols; i++){
            matrix[0][i] = 0;
        }

        for(int i=1; i <=rows; i++){
            for(int j=1; j<=cols; j++) {
                if (j >= i){
                    matrix[i][j] = Math.max(matrix[i-1][j],prices[i-1]+matrix[i][j-i]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        for(int i=0; i <=rows; i++){
            for(int j=0; j <=rows; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Best Price for rod of length: "+rodLength+" = "+matrix[rows][cols]);
    }
}
