package org.sversh.intercom.flattenarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since May 29, 2016
 *
 */
public class FlattenArrayImpl implements FlattenArray {

    @Override
    public String flatten(String array) {
        String bracketsRemoved = array.replaceAll("[\\[\\]]", "");
        return "[" + bracketsRemoved + "]";
    }

    @Override
    public int[] flattenRecursively(Object[] array) {
        List<Integer> integers = new ArrayList<>();
        for (Object element : array) {
            addElement(integers, element);
        }
        return integers.stream().mapToInt(i->i).toArray();
    }

    private void addElement(List<Integer> integers, Object element) {
        if (element instanceof Integer) {
            integers.add((Integer) element);
        } else {
            Object[] arrElement = (Object[]) element;
            for (Object el : arrElement) {
                addElement(integers, el);
            }
        }
    }

    @Override
    public int[] flattenIteratively(Object[] array) {
        List<Integer> integers = new ArrayList<>();
        Iterator<Object> it = Arrays.asList(array).iterator();
        Stack<Iterator<Object>> stack = new Stack<>();
        stack.push(it);
        while (!stack.isEmpty()) {
            Iterator<Object> iterator = stack.pop();
            if (iterator.hasNext()) {
                Object next = iterator.next();
                stack.push(iterator);
                if (next instanceof Integer) {
                    integers.add((Integer) next);
                } else {
                    Iterator<Object> nextIterator = Arrays.asList((Object[]) next).iterator();
                    stack.push(nextIterator);
                }
            } 
        }
        return integers.stream().mapToInt(i->i).toArray();
    }

}
