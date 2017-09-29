import java.io.*;
import java.util.*;

public class Solution {
    public int numberOfSets = 0;
    
    public int[][] checkset(int[][] matrix, int y, int x){
        matrix[y][x] = 0;
        int[][] neighbors = { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} };
        for (int[] neighbor : neighbors) {
            int new_y = y + neighbor[0];
            int new_x = x + neighbor[1];
            //System.out.println(new_y+"_"+new_x);
            if (new_x >= 0 && new_x < matrix[0].length && new_y >= 0 && new_y < matrix[0].length) {
                if(matrix[new_y][new_x] == 1){
                    checkset(matrix, new_y, new_x);
                }else{
                    
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i_c = 0; i_c < numberOfTestCases; i_c++){
            s.numberOfSets = 0;
            int dimensionOfMatrix = in.nextInt();
            int[][] matrix = new int[dimensionOfMatrix][dimensionOfMatrix];
            for(int i_d_y = 0; i_d_y < dimensionOfMatrix; i_d_y++){
                for(int i_d_x = 0; i_d_x < dimensionOfMatrix; i_d_x++){
                    matrix[i_d_y][i_d_x] = in.nextInt();
                }
            }
            
            //System.out.println("!!!!");
            for(int i_d_y = 0; i_d_y < dimensionOfMatrix; i_d_y++){
                for(int i_d_x = 0; i_d_x < dimensionOfMatrix; i_d_x++){
                    if(matrix[i_d_y][i_d_x] == 0) continue;
                    matrix = s.checkset(matrix, i_d_y, i_d_x);
                    //System.out.println(Arrays.deepToString(matrix));
                    s.numberOfSets++;
                }
            }
            
            System.out.println(s.numberOfSets);
        }
    }
}