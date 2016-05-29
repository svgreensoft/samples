package org.sversh.distance.calculator.model;

import java.math.BigInteger;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since May 29, 2016
 *
 */
public class Customer {

    @SerializedName("user_id")
    private Integer userId;
    private String name;
    private String latitude;
    private String longitude;
    
    public Integer getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
}
