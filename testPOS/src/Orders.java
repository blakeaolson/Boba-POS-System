public class Orders {
    private String orderid = "";
    private String totalamount = "";
    private String cashiername = "";
    private String orderdate = "";
    private String paymentmethod = "";
    private String orderhour = "";




    public Orders(String id, String totalamount, String cashiername, String orderdate, String paymentmethod, String orderhour) {
        this.orderid = id;
        this.totalamount = totalamount;
        this.orderdate = orderdate;
        this.cashiername = cashiername;
        this.paymentmethod = paymentmethod;
        this.orderhour = orderhour;
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
    public String getOrderhour() {
        return orderhour;
    }


}