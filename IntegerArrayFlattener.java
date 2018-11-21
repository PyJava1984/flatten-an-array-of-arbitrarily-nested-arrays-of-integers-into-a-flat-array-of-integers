package com.rana.flattener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Flatten-an-array-of-arbitrarily-nested-arrays-of-integers-into-a-flat-array-of-integers
 * @author rana
 */
public class IntegerArrayFlattener {

    public static Integer[] flatten(Object[] inputArray) throws IllegalArgumentException {

        if (inputArray == null) return null;

        List<Integer> flatList = new ArrayList<Integer>();

        for (Object element : inputArray) {
            if (element instanceof Integer) {
                flatList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flatten((Object[]) element)));
            } else {
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }
        return flatList.toArray(new Integer[flatList.size()]);
    }
}
