package com.mindyourlovedone.healthcare.model;

//Nikita#Sub
public class SubscrptionData {
     int UserId;
     String Source = "Source";
     String TransactionID = "TransactionID";
     String StartDate= "StartDate";
     String EndDate= "EndDate";
     String Status= "Status";
     String Email = "Email";

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        TransactionID = transactionID;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getUpload() {
        return Upload;
    }

    public void setUpload(int upload) {
        Upload = upload;
    }

    int Upload=0;
}
