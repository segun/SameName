/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idempotent.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aardvocate
 */
public class SameName {

    public static boolean isSameName(String name1, String name2) {
        //remove spaces
        //remove vowels        
        //score each consonant.
        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();
        int n1Score = score(removeVowels(removeSpaces(name1)));
        System.err.println("N1: " + n1Score);
        int n2Score = score(removeVowels(removeSpaces(name2)));
        System.err.println("N2: " + n2Score);
        
        return n1Score == n2Score;
    }
    
    public static boolean isSameName(String name1, String name2, int confidence) {
        Map<String, Integer> result = getScores(name1, name2);
        System.out.println(result);
        return result.get("confidence") >= confidence;
    }    
    
    public static Map<String, Integer> getScores(String name1, String name2) {
        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();        
        Map<String, Integer> result = new HashMap<>();
        int n1Score = score(removeVowels(removeSpaces(name1)));
        System.err.println("N1: " + n1Score);
        int n2Score = score(removeVowels(removeSpaces(name2)));
        System.err.println("N2: " + n2Score);
        
        result.put(name1, n1Score);
        result.put(name2, n2Score);
        
        int max = n1Score;
        max = max < n2Score ? n2Score : max;
        
        double confidence = (n2Score * 1.0/n1Score) * 100;
        if(max == n2Score) {
            confidence = (n1Score * 1.0/n2Score) * 100;
        }
        result.put("confidence", (int) Math.round(confidence));
        return result;
    }

    public static int score(String name) {
        return name.chars().sum(); 
    }
    
    public static String removeVowels(String name) {
        return name.replaceAll("[AEIOUaeiou]", "");
    }

    public static String order(String name) {
        List<String> nameList = new ArrayList<>();
        name.chars().forEach(x -> {
            nameList.add(((char) x) + "");
        });

        String[] names = nameList.toArray(new String[nameList.size()]);
        Arrays.sort(names);
        return String.join("", names);
    }

    public static String removeSpaces(String name) {
        return name.replaceAll("\\s+", "");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
