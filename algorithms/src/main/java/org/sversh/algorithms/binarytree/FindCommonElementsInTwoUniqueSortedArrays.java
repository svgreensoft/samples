package org.sversh.algorithms.binarytree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

/**
 * 
 * @author Sergey Vershinin</a>
 * @since Feb 23, 2016
 *
 */
public class FindCommonElementsInTwoUniqueSortedArrays {

    private Integer[] arr1, arr2;

    private int indexArray1 = 0;
    private int indexArray2 = 0;

    public FindCommonElementsInTwoUniqueSortedArrays(Integer[] arr1, Integer[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] { 1, 2, 5, 7, 9, 10, 12, 14, 21 };
        Integer[] arr2 = new Integer[] { 3, 5, 6, 7, 8, 11, 21 };
        FindCommonElementsInTwoUniqueSortedArrays test = new FindCommonElementsInTwoUniqueSortedArrays(arr1, arr2);
        Integer[] common = test.findCommonElements();
        for (Integer el : common) {
            System.out.println(el);
        }
        Assert.assertEquals(3, common.length);
        Assert.assertEquals("5", common[0].toString());
        Assert.assertEquals("7", common[1].toString());
        Assert.assertEquals("21", common[2].toString());
    }

    private Integer[] findCommonElements() {
        Set<Integer> result = new HashSet<>();
        while (!isEndOfArray1() || !isEndOfArray2()) {
            if (arr2[indexArray2].compareTo(arr1[indexArray1]) == 0) {
                result.add(arr1[indexArray1]);
                incrementIndex1();
                incrementIndex2();
            } else if (arr2[indexArray2].compareTo(arr1[indexArray1]) < 0) {
                while (arr2[indexArray2].compareTo(arr1[indexArray1]) < 0) {
                    if (!isEndOfArray2()) {
                        incrementIndex2();
                    }
                }
                if (arr1[indexArray1].equals(arr2[indexArray2])) {
                    result.add(arr1[indexArray1]);
                    incrementIndex1();
                    incrementIndex2();
                }
            } else if (arr2[indexArray2].compareTo(arr1[indexArray1]) > 0) {
                while (arr2[indexArray2].compareTo(arr1[indexArray1]) > 0) {
                    if (!isEndOfArray1()) {
                        incrementIndex1();
                    }
                }
                if (arr1[indexArray1].equals(arr2[indexArray2])) {
                    result.add(arr1[indexArray1]);
                    incrementIndex1();
                    incrementIndex2();
                }
            }
        }
        if (arr2[indexArray2].compareTo(arr1[indexArray1]) == 0) {
            result.add(arr1[indexArray1]);
        }
        Integer[] resArray = new Integer[result.size()];
        
        Integer[] out = result.toArray(resArray);
        Arrays.sort(out);
        return out ;
    }

    private boolean isEndOfArray1() {
        return indexArray1 == arr1.length - 1;
    }

    private boolean isEndOfArray2() {
        return indexArray2 == arr2.length - 1;
    }

    private void incrementIndex2() {
        if (indexArray2 < arr2.length - 1) {
            indexArray2++;
        }
    }

    private void incrementIndex1() {
        if (indexArray1 < arr1.length - 1) {
            indexArray1++;
        }
    }

}
