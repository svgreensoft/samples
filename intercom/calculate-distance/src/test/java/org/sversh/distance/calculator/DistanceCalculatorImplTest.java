package org.sversh.distance.calculator;

import static java.lang.Math.abs;
import static java.lang.Math.toRadians;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sversh.distance.calculator.model.Customer;

/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since May 29, 2016
 *
 */
public class DistanceCalculatorImplTest {
    
    private static final Logger LOG = LoggerFactory
            .getLogger(DistanceCalculatorImplTest.class);

    private final static String CHRISTINA_MCARDLE_LON = "-6.043701";
    private final static String CHRISTINA_MCARDLE_LAT = "52.986375";
    private final static Integer CHRISTINA_MCARDLE_ID = 12;
    private final static String CHRISTINA_MCARDLE_NAME = "Christina McArdle";
    
    private DistanceCalculatorImpl calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new DistanceCalculatorImpl();
    }

    @Test
    public void testSelectCustomers() throws Exception {
        InputStream is = this.getClass().getResourceAsStream("/gistfile1.txt");
        File file = Files.createTempFile("calc_dist_", "_tmp").toFile();
        FileUtils.copyToFile(is, file);
        String customers = calculator.selectCustomers(file);
        LOG.info("customers: \n" + customers);
        Assert.assertTrue("", customers.contains(CHRISTINA_MCARDLE_ID + ", " + CHRISTINA_MCARDLE_NAME));
    }
    
    @Test
    public void testSelectCustomersToFile() throws Exception {
        InputStream is = this.getClass().getResourceAsStream("/gistfile1.txt");
        File in = Files.createTempFile("calc_dist_", "_tmp").toFile();
        FileUtils.copyToFile(is, in);
        File out = Files.createTempFile("calc_dist_", "_tmp_out").toFile();
        calculator.selectCustomers(in, out);
        LOG.info("customers output file: \n" + out.getAbsolutePath());
        Assert.assertTrue("", out.exists());
        LOG.info("output file content: \n" + FileUtils.readFileToString(out, StandardCharsets.UTF_8));
    }

    
    @Test
    public void testCalculateDist() throws Exception {
        Double lat = toRadians(Double.valueOf(CHRISTINA_MCARDLE_LAT));
        Double lon = toRadians(Double.valueOf(CHRISTINA_MCARDLE_LON));
        Double actual = calculator.calculateDistance(lat, lon);
        Double expected = 41.68d;
        LOG.info("calculated dist: " + actual);
        double diff = abs(expected - actual);
        LOG.info("diff: " + diff);
        Assert.assertTrue("diff: " + diff, diff  < 0.01);
    }
    
    @Test
    public void testEligibility() throws Exception {
        Customer customer = new Customer();
        customer.setLatitude(CHRISTINA_MCARDLE_LAT);
        customer.setLongitude(CHRISTINA_MCARDLE_LON);
        boolean isEligible = calculator.isEligible(customer);
        LOG.info("isEligible: " + isEligible);
        Assert.assertTrue("", isEligible);
    }



}
