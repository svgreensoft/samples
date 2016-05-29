package org.sversh.intercom.flattenarray;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since May 29, 2016
 *
 */
public class FlattenArrayTest {

    private FlattenArray flattener;
    
    @Before
    public void setUp() throws Exception {
        flattener = new FlattenArrayImpl();
    }

    @Test
    public void testFlattenStringBase() {
        String actual = flattener.flatten("[[1,2,[3]],4]");
        String expected = "[1,2,3,4]";
        Assert.assertEquals(expected , actual);
    }
    
    @Test
    public void testFlattenStringBaseEmpty() {
        String actual = flattener.flatten("[]");
        String expected = "[]";
        Assert.assertEquals(expected , actual);
    }
    
    @Test
    public void testFlattenStringTheSame() {
        String actual = flattener.flatten("[1,2,3,4]");
        String expected = "[1,2,3,4]";
        Assert.assertEquals(expected , actual);
    }


    /**
     * Test method for {@link org.sversh.intercom.flattenarray.FlattenArrayImpl#flatten(int[])}.
     */
    @Test
    public void testFlattenIntArrayRecursively() {
        Object[] array = new Object[] {new Object[] {Integer.valueOf(1), Integer.valueOf(2), 
                new Object[]{Integer.valueOf(3)}}, Integer.valueOf(4)};
        int[] actual = flattener.flattenRecursively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("1,2,3,4" , actualStr);
    }
    
    @Test
    public void testFlattenIntArrayRecursivelyEmpty() {
        Object[] array = new Object[] {};
        int[] actual = flattener.flattenRecursively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("" , actualStr);
    }

    
    @Test
    public void testFlattenIntArrayRecursivelyTrivial() {
        Object[] array = new Object[] {Integer.valueOf(1)};
        int[] actual = flattener.flattenRecursively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("1" , actualStr);
    }

    @Test
    public void testFlattenIntArrayIteratevely() {
        Object[] array = new Object[] {new Object[] {Integer.valueOf(1), Integer.valueOf(2), 
                new Object[]{Integer.valueOf(3)}}, Integer.valueOf(4)};
        int[] actual = flattener.flattenIteratively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("1,2,3,4" , actualStr);
    }

    @Test
    public void testFlattenIntArrayIteratevelyTrivial() {
        Object[] array = new Object[] {Integer.valueOf(1)};
        int[] actual = flattener.flattenIteratively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("1" , actualStr);
    }
    
    @Test
    public void testFlattenIntArrayIteratevelyFlat() {
        Object[] array = new Object[] {Integer.valueOf(1), Integer.valueOf(2), 
                Integer.valueOf(3), Integer.valueOf(4)};
        int[] actual = flattener.flattenIteratively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("1,2,3,4" , actualStr);
    }

    @Test
    public void testFlattenIntArrayIteratevelyFlatReverse() {
        Object[] array = new Object[] {Integer.valueOf(4), Integer.valueOf(3), 
                Integer.valueOf(2), Integer.valueOf(1)};
        int[] actual = flattener.flattenIteratively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("4,3,2,1" , actualStr);
    }
    
    @Test
    public void testFlattenIntArrayIteratevelyEmpty() {
        Object[] array = new Object[] {};
        int[] actual = flattener.flattenIteratively(array);
        String actualStr = Arrays.stream(actual).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
        Assert.assertEquals("" , actualStr);
    }



}
