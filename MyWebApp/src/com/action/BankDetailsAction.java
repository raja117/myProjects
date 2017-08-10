package com.action;

import java.sql.SQLException;
import java.sql.Statement;

public class BankDetailsAction {

    private String bankName;
    private String AccountNo;
    private String ssn;
    private int userId;

    private String insert_user_bank_details = "insert into user_bank_details(bank_name,acc_no,ssn,fk_user_id) values ('"
	    					+ bankName + "','" + AccountNo + "','" + ssn + "','" + userId + "')";

    public String getBankName() {
	return bankName;
    }

    public void setBankName(String bankName) {
	this.bankName = bankName;
    }

    public String getAccountNo() {
	return AccountNo;
    }

    public void setAccountNo(String accountNo) {
	AccountNo = accountNo;
    }

    public String getSsn() {
	return ssn;
    }

    public void setSsn(String ssn) {
	this.ssn = ssn;
    }

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public boolean createBankDetailsForUser(Statement stmt) {
	try {
	    stmt.executeUpdate(insert_user_bank_details);
	    return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
    }

}
