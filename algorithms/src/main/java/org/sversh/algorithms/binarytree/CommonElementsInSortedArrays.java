package org.sversh.algorithms.binarytree;

public class CommonElementsInSortedArrays {
 
    public static void main(String[] args) {
        int a[] = { 1, 3, 4, 5, 7, 21 };
        int b[] = { 2, 3, 5, 6, 10, 12, 14, 15, 21 };
 
        commonEleemntsInArray(a, b);
    }
 
    private static void commonEleemntsInArray(int[] a, int[] b) {
        int i = 0, j = 0;
 
        while (i < a.length && j < b.length) {
 
            if (a[i] > b[j]) {
                j++;
            } else if (b[j] > a[i]) {
                i++;
            } else {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }
 
    }
}