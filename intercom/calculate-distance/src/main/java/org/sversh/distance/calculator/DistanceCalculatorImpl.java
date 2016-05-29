package org.sversh.distance.calculator;

import static java.lang.Math.asin;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.sversh.distance.calculator.model.Customer;
/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since May 29, 2016
 *
 */
public class DistanceCalculatorImpl implements DistanceCalculator {

    final private static String OFFICE_LATITUDE_RAW = "53.3381985";
    final private static String OFFICE_LONGITUDE_RAW = "-6.2592576";
    final private static Double EARTH_RADIUS = 6371d;
    private static final Double LIMIT = 100d;
    
    private static Double OFFICE_LATITUDE;
    private static Double OFFICE_LONGITUDE;
    private static Double COS_OF_LAT;
    
    public DistanceCalculatorImpl() {
        OFFICE_LATITUDE = toRadians(Double.valueOf(OFFICE_LATITUDE_RAW));
        OFFICE_LONGITUDE = toRadians(Double.valueOf(OFFICE_LONGITUDE_RAW));
        COS_OF_LAT = cos(OFFICE_LATITUDE);
    }
    
    @Override
    public String selectCustomers(File input) throws IOException {
        List<Customer> customers = findEligibaleCustomers(input);
        String res = convertCustomersToString(customers);
        return res;
    }
    
    @Override
    public void selectCustomers(File input, File output) throws IOException {
        List<Customer> customers = findEligibaleCustomers(input);
        String res = convertCustomersToString(customers);
        FileUtils.write(output, res, StandardCharsets.UTF_8);
    }


    private List<Customer> findEligibaleCustomers(File input) 
        throws IOException {
        List<String> lines = FileUtils.readLines(input, StandardCharsets.UTF_8);
        List<Customer> customers = new ArrayList<>();
        for (String line : lines) {
            Customer customer = JsonUtils.deSerialize(line, Customer.class);
            boolean isEligible = isEligible(customer);
            if (isEligible) {
                customers.add(customer);
            }
        }
        sort(customers);
        return customers;
    }

    private String convertCustomersToString(List<Customer> customers) {
        StringBuffer sb = new StringBuffer();
        for (Customer customer : customers) {
            sb.append(customer.getUserId());
            sb.append(", ");
            sb.append(customer.getName());
            sb.append(System.lineSeparator());
        }
        String res = removeLastSymbol(sb);
        return res;
    }

    private void sort(List<Customer> customers) {
        Comparator<Customer> comparator = new Comparator<Customer>() {

            @Override
            public int compare(Customer o1, Customer o2) {
                int result = 0;
                if (o1.getUserId() < o2.getUserId()) {
                    result = -1;
                } else if (o1.getUserId() > o2.getUserId()) {
                    result = 1;
                }
                return result;
            }
        };
        Collections.sort(customers, comparator);
    }

    boolean isEligible(Customer customer) {
        Double lat = toRadians(Double.valueOf(customer.getLatitude()));
        Double lon = toRadians(Double.valueOf(customer.getLongitude()));
        Double dist = calculateDistance(lat , lon);
        Double diff = LIMIT - dist;
        return diff >= 0 ? true : false;
    }

    private String removeLastSymbol(StringBuffer sb) {
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
    
    Double calculateDistance(Double lat, Double lon) {
        Double df2 = (OFFICE_LATITUDE - lat)/2;
        Double lf2 = (OFFICE_LONGITUDE - lon)/2;
        Double dist = 2 * asin(sqrt(pow(sin(df2), 2) + COS_OF_LAT * cos(lat) * pow(sin(lf2),2)));
        return EARTH_RADIUS * dist;
        
    }

}
