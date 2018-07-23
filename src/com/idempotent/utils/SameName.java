/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idempotent.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aardvocate
 */
public class SameName {

    public static boolean isSameName(String name1, String name2) {
        //remove spaces
        //remove vowels        
        //score each consonant.
        int n1Score = score(removeVowels(removeSpaces(name1)));
        System.err.println("N1: " + n1Score);
        int n2Score = score(removeVowels(removeSpaces(name2)));
        System.err.println("N2: " + n2Score);
        
        return n1Score == n2Score;
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
