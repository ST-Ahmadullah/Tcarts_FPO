package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

	public static Properties p;

	public ConfigurationReader() throws Throwable {
		File f = new File(
				"/home/st/eclipse-workspace/Tcarts_FPO/Configuration_Properties/Login_Functionality.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
	}

	public String geturl() {
		String url = p.getProperty("url");
		return url;
	}

	public String getEmail() {
		String email = p.getProperty("email");
		return email;
	}

	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}

	public String getReceiptPaymentPending() {
		String receiptPaymentPending = p.getProperty("receiptPaymentPending");
		return receiptPaymentPending;
	}

	public String getReceiptInProgress() {
		String receiptInProgress = p.getProperty("receiptInProgress");
		return receiptInProgress;
	}

	public String getReceiptFailed() {
		String receiptFailed = p.getProperty("receiptFailed");
		return receiptFailed;
	}

	public String getReceiptCancelled() {
		String receiptCancelled = p.getProperty("receiptCancelled");
		return receiptCancelled;
	}

	public String getReceiptPaid() {
		String receiptPaid = p.getProperty("receiptPaid");
		return receiptPaid;
	}

	public String getOrderNotDelivered() {
		String orderNotDelivered = p.getProperty("orderNotDelivered");
		return orderNotDelivered;
	}

	public String getOrderPartiallyDelivered() {
		String orderPartiallyDelivered = p.getProperty("orderPartiallyDelivered");
		return orderPartiallyDelivered;
	}

	public String getOrderDelivered() {
		String orderDelivered = p.getProperty("orderDelivered");
		return orderDelivered;
	}

	public String getOrderCancelled() {
		String orderCancelled = p.getProperty("orderCancelled");
		return orderCancelled;
	}

	public String getRefundPending() {
		String refundPending = p.getProperty("refundPending");
		return refundPending;
	}

	public String getRefundInitiated() {
		String refundInitiated = p.getProperty("refundInitiated");
		return refundInitiated;
	}

	public String getPartialRefundInitiated() {
		String partialRefundInitiated = p.getProperty("partialRefundInitiated");
		return partialRefundInitiated;
	}

	public String getRefunded() {
		String refunded = p.getProperty("refunded");
		return refunded;

	}

	public String getPartiallyRefunded() {
		String partiallyRefunded = p.getProperty("partiallyRefunded");
		return partiallyRefunded;

	}

	public String getDeclined() {
		String declined = p.getProperty("declined");
		return declined;
	}

	public String getFirstName() {
		String firstName = p.getProperty("firstName");
		return firstName;
	}

	public String getLastName() {
		String lastName = p.getProperty("lastName");
		return lastName;
	}

	public String getStudentEmail() {
		String studentEmail = p.getProperty("studentEmail");
		return studentEmail;
	}

	public String getRegisterNumber() {
		String registerNumber = p.getProperty("registerNumber");
		return registerNumber;
	}

	public String getDepartment() {
		String department = p.getProperty("department");
		return department;
	}

	public String getPrimaryNumber() {
		String primaryNumber = p.getProperty("primaryNumber");
		return primaryNumber;
	}

	public String getAlternateNumber() {
		String alternateNumber = p.getProperty("alternateNumber");
		return alternateNumber;
	}

	public String getStaffName() {
		String staffName = p.getProperty("staffName");
		return staffName;
	}

	public String getStaffEmail() {
		String staffEmail = p.getProperty("staffEmail");
		return staffEmail;
	}

	public String getMobileNumber() {
		String mobileNumber = p.getProperty("mobileNumber");
		return mobileNumber;
	}
	
	public String getCanteenStaffName() {
		String canteenStaffName = p.getProperty("canteenStaffName");
		return canteenStaffName;
	}

	public String getCanteenStaffEmail() {
		String canteenStaffEmail = p.getProperty("canteenStaffEmail");
		return canteenStaffEmail;
	}

}
