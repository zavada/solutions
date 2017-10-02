/*
Given a paragraph of text, write a program to find the first shortest sub-segment that contains each of the given k words at least once. A segment is said to be shorter than other if it contains less number of words.
Ignore characters other than [a-z][A-Z] in the text. Comparison between the strings should be case-insensitive. 
If no sub-segment is found, then the program should display “NO SUBSEGMENT FOUND”.

Input format :
First line of the input contains the text.
Next line contains k , the number of words to be searched.
Each of the next k lines contains a word.

Output format :
Print first shortest sub-segment that contains given k words , ignore special characters, numbers. If no sub-segment is found, print “NO SUBSEGMENT FOUND”

Sample Input :
This is a test. This is a programming test. This is a programming test in any language.
4
this
a
test
programming

Sample Output :
a programming test This

Explanation :
Here, segment "a programming test. This" contains given four words. You have to print without special characters or numbers. So output is "a programming test This".  Another segment "This is a programming test." also contains the given four words, but has more number of words. 

Constraint :
Total number of characters in a paragraph will not be more than 200,000. 
0 < k <= no. of words in paragraph. 
0 < Each word length < 15
*/

import java.io.*;
import java.util.*;

public class Solution {
    static Hashtable<String, Integer> decrementNumber(Hashtable<String, Integer> table, String key){
        int number = table.get(key);
        table.put(key, --number);
        return table;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        in.nextLine();
        Hashtable<String, Integer> words = new Hashtable<String, Integer>();
        int wordsNumber = 0;
        for(int i=0; i<n; i++){
            String word = in.nextLine().toLowerCase();
            int count = (words.containsKey(word))? words.get(word)+1 : 1;
            words.put(word, count);
            if(count == 1) wordsNumber++;
        }
        String strClean = str.replaceAll("[^a-zA-Z|\\s]","");
        //System.out.println(strClean.toString());
        
        String[] strSplited = strClean.split("\\s+");
        
        if(n > strSplited.length) return;
        
        int numberWordsInSegment = -1;
        //List<String> result = new ArrayList<String>();
        String result_string = "";
        for(int i=0; i<strSplited.length; i++){
            if(words.containsKey(strSplited[i].toLowerCase())){
                Hashtable<String, Integer> wordsCheck = (Hashtable<String, Integer>)words.clone();
                int wordsNumberCheck = wordsNumber;

                wordsCheck = decrementNumber(wordsCheck, strSplited[i].toLowerCase());
                wordsNumberCheck--;
                
                for(int j=i+1; j<strSplited.length; j++){
                    if(wordsCheck.containsKey(strSplited[j].toLowerCase()) && wordsCheck.get(strSplited[j].toLowerCase()) > 0){
                        if(wordsCheck.get(strSplited[j].toLowerCase()) == words.get(strSplited[j].toLowerCase())) wordsNumberCheck--;
                        wordsCheck = decrementNumber(wordsCheck, strSplited[j].toLowerCase());
                        if(wordsNumberCheck == 0){
                            //numberWordsInSegment = (numberWordsInSegment == null || j-i+1 < numberWordsInSegment )? j-i+1 : numberWordsInSegment
                            if(numberWordsInSegment == -1 || j-i+1 < numberWordsInSegment ){
                                numberWordsInSegment = j-i+1;
                                result_string = String.join(" ", Arrays.copyOfRange(strSplited, i, j+1) );
                            }
                            //result.add( String.join(" ", Arrays.copyOfRange(strSplited, i, j+1) ) );
                            break;
                        }
                    }else{
                        //System.out.println(strSplited[j].toLowerCase());
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(result.toArray()));
        
        if(numberWordsInSegment != -1) System.out.println(result_string); else System.out.println("NO SUBSEGMENT FOUND");
    }
}