/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.strings;
import java.util.*;
import java.text.DecimalFormat;
/**
 *
 * @author Владислав
 */
public class StringsAsArrayOfSymbols {   
    private String alphabetLowerCase;
    private String alphabetUpperCase;
    private String digits;
    
    public StringsAsArrayOfSymbols(){
        alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        digits = "0123456789";
    }
    
    private boolean isUpperCase(char ch){
        StringBuilder sb = new StringBuilder().append(ch);
        sb.toString();
        if (alphabetUpperCase.contains(sb)){
            return true;
        }
        else return false;
    }
    
    private boolean isLowerCase(char ch){
        StringBuilder sb = new StringBuilder().append(ch);
        sb.toString();
        return alphabetLowerCase.contains(sb);
    }
    
    
    private boolean isLetter(char ch){
        StringBuilder sb = new StringBuilder().append(Character.toLowerCase(ch));  
        sb.toString();        
        return alphabetLowerCase.contains(sb);
    }
    
    private boolean isSpace(char ch){
        return ch == ' ';   
    }
    
    private boolean isDigit(char ch){
        StringBuilder sb = new StringBuilder().append(Character.toLowerCase(ch));  
        sb.toString();        
        return digits.contains(sb);
    }
    
    private String toSnakeCase (String word){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if (isUpperCase(currChar)){
                sb.append('_');
                sb.append(Character.toLowerCase(currChar));
            }
            else {
                sb.append(currChar);
            }
        }
        return sb.toString();
    }
    
        
    private void print(ArrayList<String> al){
        al.forEach(i -> {
            System.out.println(i + " ");
        });
        System.out.println();
    }   
    
    private void printIntArray (ArrayList<Integer> al){
        al.forEach(i -> {
            System.out.println(i + " ");
        });
        System.out.println();
    } 
    
    public void task1 (){
        ArrayList<String> array = new ArrayList<String>();
        array.add("lifeIsGood");
        array.add("myNameIsVlad");
        array.add("theSun3IsMoon");
        for (int i = 0; i < array.size(); i++){
            array.set(i, toSnakeCase(array.get(i)));
        }
        print(array);
    }
    
    public void task2(String s){
        System.out.println(s);
        while (s.indexOf("word") != -1){
            s = s.substring(0, s.indexOf("word")) + "letter" + s.substring(s.indexOf("word") + 4);
        }
        System.out.println(s);
    }
    
    public void task3(String s){
        System.out.println(s);
        int k = 0;
        for (int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if (isDigit(currChar)){
                k++;
            }
        }
        System.out.println("В этой строке " + k + " цифр");
    }
    
    public void task4(String s){
        System.out.println(s);
        int k = 0;
        for (int i = 0; i < s.length()-1; i++){
            char currChar = s.charAt(i);
            if (isDigit(currChar) && !isDigit(s.charAt(i + 1)) || i == s.length() - 2 && isDigit(s.charAt(s.length()-1))){
                k++;
            }
        }
        System.out.println("В этой строке " + k + " чисел");
    }
    
    private String arrayToString(ArrayList<Character> array){
        String s = "";
        for (char ch : array){
            s = s + ch;
        }
        return s;
    }
    
    public void task5(String s){
        System.out.println(s);
        ArrayList<Character> array = new ArrayList<Character>();
        for (int i = 0; i < s.length() - 1; i++){
            if (!isSpace(s.charAt(i)) || isSpace(s.charAt(i)) && !isSpace(s.charAt(i + 1))){
                array.add(s.charAt(i)); 
            }
            if (i == s.length() - 2 && !isSpace(s.charAt(s.length()-1))){
                array.add(s.charAt(i + 1));
            }     
        }
        if (isSpace(array.get(0))){
            array.remove(0);
        }
        System.out.println(arrayToString(array));
        
    }
    
    public void task2_1 (String s){
        ArrayList<Integer> array = new ArrayList<Integer>();
        int k = 0;
        for (int i = 0; i < s.length() - 1; i++){
            if (isSpace(s.charAt(i + 1))  &&  isSpace(s.charAt(i)) && i != s.length() - 2){
                k++;
            }
            else if (isSpace(s.charAt(i))){
                k++;
                if(i == s.length() - 2 && isSpace(s.charAt(i + 1))){
                    k++;
                }
                array.add(k);

                k = 0;
            }

        }
        printIntArray(array);        
    }

    private boolean isA(char ch){
        return Character.toLowerCase(ch) == 'a';   
    }
    
    public void task2_2 (String s){
        StringBuilder sb = new StringBuilder();
        System.out.println(s);
        for (int i = 0; i < s.length(); i++){
            if (isA(s.charAt(i))){
                sb.append('b');
                sb.append(s.charAt(i));
            
            }
            else {
                sb.append(s.charAt(i));                
            }
        }
        System.out.println(sb.toString());
    }

    private String getLowerString(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }
    
    public void task2_3 (String s){
        StringBuilder sb = new StringBuilder();
        System.out.println(s);
        for (int i = s.length() - 1; i >=0; i--){
                sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
        if (getLowerString(sb.toString()).contains(getLowerString(s))){
            System.out.println("Слово является палиндромом");
        }
        else {
            System.out.println("Слово не является палиндромом");
        }        
    }
    
    public void task2_4 (String s){
        StringBuilder sb = new StringBuilder();
        System.out.println(s);
        String subS = s.substring(s.indexOf("ор"), s.indexOf("ор") + 2);
        String sT = s.substring(s.indexOf("т"), s.indexOf("т") + 1);
        System.out.println(sT + subS + sT);                
    }
    
    public void task2_5 (String s){
        System.out.println(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (isA(s.charAt(i))){
                count++;            
            }
        }
        System.out.println(count);
    }
    
    public void task2_6 (String s){
        StringBuilder sb = new StringBuilder();
        System.out.println(s);
        for (int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
   
    public void task2_7 (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = scanner.nextLine();
        String newS = "";
        for (int i = 0; i < s.length(); i++){
            if (!newS.contains("" + s.charAt(i)) && !isSpace(s.charAt(i))){
                newS = newS + s.charAt(i);
            }
        }
        System.out.println(newS);
    }
    
    private String maxWord (HashMap<String, Integer> map){
        int max = 0;
        String word = null;
        for (String s : map.keySet()){
            if (map.get(s) > max){
                max = map.get(s);
                word = s;
            }
        }
        return word;
    }
    
    public void task2_8 (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write some words please");
        String s = scanner.nextLine();
        //System.out.println(s);
        s = s.trim();
        HashMap<String, Integer> map = new HashMap<String, Integer> ();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (!isSpace(s.charAt(i)) && i != s.length() - 1){
                sb.append(s.charAt(i));
                count++;
            }
            else {
                if (i == s.length() - 1 && !isSpace(s.charAt(i))){
                    sb.append(s.charAt(i));
                    map.put(sb.toString(), count);
                }
                map.put(sb.toString(), count);
                sb = new StringBuilder();
                count = 0;
            }
        }
        System.out.println("Самое большое слово: " + maxWord(map));
    }
    
    public void task2_9 (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write some words please");
        String s = scanner.nextLine();
        s = s.trim();
        int iLowerSymb = 0;
        int iUpperSymb = 0;
        for (int i = 0;  i < s.length(); i++){
            if (alphabetLowerCase.indexOf(s.charAt(i)) != -1){
                iLowerSymb++;
            }
            else if (alphabetUpperCase.indexOf(s.charAt(i)) != -1){
                iUpperSymb++;
            }
        }
        System.out.println("Количество прописных букв: " + iUpperSymb);
        System.out.println("Количество строчных букв: " + iLowerSymb);
    }
    
    public void task2_10 (String s){
        String symbols = ".!?";
        System.out.println(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (symbols.indexOf(s.charAt(i)) != -1){
                count++;
            }
        }
        System.out.println("Количество предложений: " + count);
    }
    
}
