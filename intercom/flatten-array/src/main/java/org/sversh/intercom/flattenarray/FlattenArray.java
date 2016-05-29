package org.sversh.intercom.flattenarray;

/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since May 29, 2016
 *
 */
public interface FlattenArray {
    
    String flatten(String array);
    
    int[] flattenRecursively(Object[] array);
    
    int[] flattenIteratively(Object[] array);

}
