package entity;

public class Policy {
    private int policyId;
    private String policyNumber;
    private String policyType;
    private double coverageAmount;
    private double premium;
    private String startDate;
    private String endDate;

    // Default Constructor
    public Policy() {
    }

    // Parameterized Constructor
    public Policy(int policyId, String policyNumber, String policyType, double coverageAmount,
                  double premium, String startDate, String endDate) {
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // toString method
    @Override
    public String toString() {
        return "Policy{" +
               "policyId=" + policyId +
               ", policyNumber='" + policyNumber + '\'' +
               ", policyType='" + policyType + '\'' +
               ", coverageAmount=" + coverageAmount +
               ", premium=" + premium +
               ", startDate='" + startDate + '\'' +
               ", endDate='" + endDate + '\'' +
               '}';
    }
}
