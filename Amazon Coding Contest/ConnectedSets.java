/*
Given a 2–d matrix , which has only 1’s and 0’s in it. Find the total number of connected sets in that matrix.

Explanation:
Connected set can be defined as group of cell(s) which has 1 mentioned on it and have at least one other cell in that set with which they share the neighbor relationship. A cell with 1 in it and no surrounding neighbor having 1 in it can be considered as a set with one cell in it. Neighbors can be defined as all the cells adjacent to the given cell in 8 possible directions ( i.e N , W , E , S , NE , NW , SE , SW direction ). A cell is not a neighbor of itself.

Input format :
First line of the input contains T , number of test-cases.
Then follow T testcases. Each testcase has given format.
N [ representing the dimension of the matrix N X N ].
Followed by N lines , with N numbers on each line.

Ouput format :
For each test case print one line ,  number of connected component it has.

Sample Input :
4
4
0 0 1 0
1 0 1 0
0 1 0 0
1 1 1 1
4
1 0 0 1
0 0 0 0
0 1 1 0
1 0 0 1
5
1 0 0 1 1
0 0 1 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
8
0 0 1 0 0 1 0 0
1 0 0 0 0 0 0 1
0 0 1 0 0 1 0 1
0 1 0 0 0 1 0 0
1 0 0 0 0 0 0 0
0 0 1 1 0 1 1 0
1 0 1 1 0 1 1 0
0 0 0 0 0 0 0 0

Sample output :
1
3
3
9

Constraint :
0 < T < 6 
0 < N < 1009 
*/

import java.io.*;
import java.util.*;

public class Solution {
    public int numberOfSets = 0;
    
    public int[][] checkset(int[][] matrix, int y, int x){
        matrix[y][x] = 0;
        int[][] neighbors = { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} };
        for (int[] neighbor : neighbors) {
            int newY = y + neighbor[0];
            int newX = x + neighbor[1];
            //System.out.println(newY+"_"+newX);
            if (newX >= 0 && newX < matrix[0].length && newY >= 0 && newY < matrix[0].length) {
                if(matrix[newY][newX] == 1){
                    checkset(matrix, newY, newX);
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
        for(int ic = 0; ic < numberOfTestCases; ic++){
            s.numberOfSets = 0;
            int dimensionOfMatrix = in.nextInt();
            int[][] matrix = new int[dimensionOfMatrix][dimensionOfMatrix];
            for(int idy = 0; idy < dimensionOfMatrix; idy++){
                for(int idx = 0; idx < dimensionOfMatrix; idx++){
                    matrix[idy][idx] = in.nextInt();
                }
            }
            
            //System.out.println("!!!!");
            for(int idy = 0; idy < dimensionOfMatrix; idy++){
                for(int idx = 0; idx < dimensionOfMatrix; idx++){
                    if(matrix[idy][idx] == 0) continue;
                    matrix = s.checkset(matrix, idy, idx);
                    //System.out.println(Arrays.deepToString(matrix));
                    s.numberOfSets++;
                }
            }
            
            System.out.println(s.numberOfSets);
        }
    }
}