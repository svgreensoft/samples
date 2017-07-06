package org.sversh.superhero.web.presentation;

import java.io.Serializable;

/**
 * 
 * @author Sergey Vershinin
 *
 */
public class ErrorResult implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String errorType;
    private String errorDesription; 

    public ErrorResult() {
    }
    
    public ErrorResult(Exception ex) {
        errorDesription = ex.getLocalizedMessage();
        errorType = ex.getClass().getName();
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDesription() {
        return errorDesription;
    }

    public void setErrorDesription(String errorDesription) {
        this.errorDesription = errorDesription;
    }

}
