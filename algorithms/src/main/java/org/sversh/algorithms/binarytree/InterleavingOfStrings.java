package org.sversh.algorithms.binarytree;

/**
 * Interleaving of stringsThree strings say A,B,C are given to you. 
 * Check weather 3rd string is interleaved from string A and B. 
 * Ex: A=”abcd” B=”xyz” C=”axybczd”. answer is yes.
 * 
 * @author Sergey Vershinin</a>
 * @since Feb 23, 2016
 *
 */
public class InterleavingOfStrings {

    public static void main(String[] args) {
        String a = "abcd";
        String b = "xyz";
        String c = "axybczd";
        boolean isInterleaved = isInterleaved(a, b, c);
        System.out.println(isInterleaved);
    }

    private static boolean isInterleaved(String a, String b, String c) {
        int indA = 0;
        int indB = 0;
        boolean result = false;
        try {
            for (int i = 0; i < c.length(); i++) {
                char current = c.charAt(i);
                if (current == a.charAt(indA)) {
                    indA++;
                } else if (current == b.charAt(indB)){
                    indB++;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        if (indA == a.length() && indB == b.length()) {
            result = true;
        }
        return result ;
    }

}
