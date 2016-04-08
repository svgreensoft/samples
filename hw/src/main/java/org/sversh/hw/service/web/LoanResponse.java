package org.sversh.hw.service.web;

import java.util.UUID;

/**
 * 
 * @author Sergey Vershinin</a>
 * @since Apr 8, 2016
 *
 */
public class LoanResponse {
    
    private boolean isGranted;
    private Long amountGranted;
    private Long termGranted;
    private String firstName;
    private String lastName;
    private String rejectDescription;
    private UUID token;
    public boolean isGranted() {
        return isGranted;
    }
    public void setGranted(boolean isGranted) {
        this.isGranted = isGranted;
    }
    public Long getAmountGranted() {
        return amountGranted;
    }
    public void setAmountGranted(Long amountGranted) {
        this.amountGranted = amountGranted;
    }
    public Long getTermGranted() {
        return termGranted;
    }
    public void setTermGranted(Long termGranted) {
        this.termGranted = termGranted;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getRejectDescription() {
        return rejectDescription;
    }
    public void setRejectDescription(String rejectDescription) {
        this.rejectDescription = rejectDescription;
    }
    public void setToken(UUID token) {
        this.token = token;
    }
    public UUID getToken() {
        return token;
    }

}
