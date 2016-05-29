package org.sversh.algorithms.binarytree;

import java.util.List;
import java.util.TreeSet;

/**
 * 
 * @author Sergey Vershinin</a>
 * @since Feb 22, 2016
 *
 */
public class BinaryTreeUtils {
    
    private BinaryTreeUtils() {
    }
    
    public static void main(String[] args) {
        BinaryTreeUtils utils = new BinaryTreeUtils();
        TreeSet treemap = createBinaryTree(12);
        utils.flattenBinaryTree(treemap);
    }
    
    private static TreeSet createBinaryTree(int count) {
        TreeSet treemap = new TreeSet<>();
        for (int i = 0; i < 12; i++) {
            treemap.add(Long.valueOf(i));
        }
        return treemap;
    }

    public List flattenBinaryTree(TreeSet treemap) {
        
        
        return null;
        
    }

}
