public class Orders {
    private String orderid = "";
    private String totalamount = "";
    private String cashiername = "";
    private String orderdate = "";
    private String paymentmethod = "";
    private String time = "";




    public Orders(String id, String totalamount, String cashiername, String orderdate, String paymentmethod, String time) {
        this.orderid = id;
        this.totalamount = totalamount;
        this.orderdate = orderdate;
        this.cashiername = cashiername;
        this.paymentmethod = paymentmethod;
        this.time = time;
    }


    public String getOrderid() {
        return orderid;
    }


    public String getTotalamount() {
        return totalamount;
    }
    public String getOrderdate() {
        return orderdate;
    }
    public String getCashiername() {
        return cashiername;
    }
    public String getPaymentmethod() {
        return paymentmethod;
    }
    public String getTime() {
        return time;
    }


}