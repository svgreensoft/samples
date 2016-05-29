package org.sversh.distance.calculator;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since May 29, 2016
 *
 */
public interface DistanceCalculator {

    String selectCustomers(File input) throws IOException;

    void selectCustomers(File input, File output) throws IOException;
}
