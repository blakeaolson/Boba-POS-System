package SharedData;
public class OrderData{ 
  private int id = 0;
  private String TotalAmount = "";
  private String OrderDate = "";
  private String CashierName = "";
  private String PaymentMethod = "";
  private String DrinkName = "";
  private int OrderHour = 0;

  public OrderData(String DrinkName){
    this.DrinkName = DrinkName;
  }

  public OrderData(int id, String TotalAmount, String OrderDate, String CashierName, String PaymentMethod, int OrderHour, String DrinkName) {
    this.id = id;
    this.TotalAmount = TotalAmount;
    this.OrderDate = OrderDate;
    this.CashierName = CashierName;
    this.PaymentMethod = PaymentMethod;
    this.OrderHour = OrderHour;
    this.DrinkName = DrinkName;
  }

  public int getId(){
    return id;
  }
  public String getTotalAmount(){
    return TotalAmount;
  }
  public String getOrderDate(){
    return OrderDate;
  }
  public String getCashierName(){
    return CashierName;
  }
  public String getPaymentMethod(){
    return PaymentMethod;
  }
  public int getOrderHour(){
    return OrderHour;
  }
  public String getDrinkName(){
    return DrinkName;
  }

}