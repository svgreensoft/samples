package org.sversh.hw.data.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Entity
@Table(name = "loan_requests")
@NamedQueries({
    @NamedQuery(name = "findAllLoansForPersonAndIp",
        query = "select count(*) from LoanRequest a where a.firstName = :firstName and a.lastName = :lastName and a.ip = :ip and a.date > :date")
})

public class LoanRequest {

    private static final String ID = "id";
    private Long id;
    private Date date;
    private String ip;
    private String firstName;
    private String lastName;
    private Long amount;
    private Long term;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID, nullable = false)
    public Long getId() {
        return id;
    }

    public static LoanRequest create(Date date, String ip, String firstName, 
            String lastName, String amount, String term) {
        LoanRequest req = new LoanRequest();
        req.setAmount(Long.valueOf((amount)));
        req.setDate(date);
        req.setFirstName(firstName);
        req.setLastName(lastName);
        req.setIp(ip);
        req.setTerm(Long.valueOf(term));
        return req;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "ip", length = 255, nullable = true)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "first_name", length = 255, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 255, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "amount", nullable = false)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "term", nullable = false)
    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
