/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.validtimeproblem;
import java.util.HashSet;
import java.util.Set;

public class ValidTimeProblem {

    public int numOfValidTimes(int a, int b, int c, int d) {
        
        if(!checkIfCanMakeTimeStamps(a, b, c, d)) return 0;
        
        int numOfTimes = 0;
    
        String firstTimeStr = Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d);
        
        Set<String> permutations = getPermutations(firstTimeStr);
        
        for(String s : permutations) {
            
            if(hasValidHours(s) && hasValidMinute(s)) {
                numOfTimes++;
            }
        }
        
        return numOfTimes;
    }
    
    
    public boolean hasValidHours(String timeStr) {
        
        int left = Character.getNumericValue(timeStr.charAt(0));
        int right = Character.getNumericValue(timeStr.charAt(1));
        
        if(left > 2) return false;
        
        if(left == 2) {
            if(right > 3) return false;
        }
        
        return true;
    }
    
    public boolean hasValidMinute(String timeStr) {
        
        int left = Character.getNumericValue(timeStr.charAt(2));

        if(left > 5) return false;
        
        return true;
    }
    
    public Set<String> getPermutations(String str) {
     
        Set<String> perm = new HashSet<String>();
        
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = getPermutations(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }
    
    public String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
    
    public boolean checkIfCanMakeTimeStamps(int a, int b, int c, int d) {
        
        int numOfValidParamsAsHour = 0;
        int numOfValidParamsAsMinute = 0;
        
        if(a <= 2) numOfValidParamsAsHour++;
        if(b <= 2) numOfValidParamsAsHour++;
        if(c <= 2) numOfValidParamsAsHour++;
        if(d <= 2) numOfValidParamsAsHour++;
        
        if(a <= 5) numOfValidParamsAsMinute++;
        if(b <= 5) numOfValidParamsAsMinute++;
        if(c <= 5) numOfValidParamsAsMinute++;
        if(d <= 5) numOfValidParamsAsMinute++;
        
        return numOfValidParamsAsHour >= 1 && numOfValidParamsAsMinute >= 1;
    }
      
    public static void main(String[] args) {
        
        ValidTimeProblem vtp = new ValidTimeProblem();
        
        System.out.println(vtp.numOfValidTimes(4, 4, 8, 1));
    }
    
}
