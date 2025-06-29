package entity;

public class Payment {
    private int paymentId;
    private String paymentDate;
    private double paymentAmount;
    private Client client;

    // Default Constructor
    public Payment() {
    }

    // Parameterized Constructor
    public Payment(int paymentId, String paymentDate, double paymentAmount, Client client) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.client = client;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // toString method
    @Override
    public String toString() {
        return "Payment{" +
               "paymentId=" + paymentId +
               ", paymentDate='" + paymentDate + '\'' +
               ", paymentAmount=" + paymentAmount +
               ", client=" + client +
               '}';
    }
}
