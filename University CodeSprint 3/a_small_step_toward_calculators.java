/*
Alice has a string of the form x+y or x-y. Here,  and  are single-digit nonnegative integers. Her task is to perform the addition or subtraction accordingly and print the result.
As a newbie programmer, Alice is struggling to finish the task. Can you help her?

Input Format
In a single line, you will be given the string.

Constraints
The string contains exactly  characters of the form x+y or x-y.

Output Format
In a single line, print the result of the operation.

Sample Input 0
0+1

Sample Output 0
1

Sample Input 1
0-3

Sample Output 1
-3
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(String opr) {
        opr = opr.replace("-", "+-");
        String[] oprDigits = opr.split("\\+");
        int res = Integer.parseInt(oprDigits[0])+Integer.parseInt(oprDigits[1]);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opr = in.next();
        int result = solve(opr);
        System.out.println(result);
        in.close();
    }
}