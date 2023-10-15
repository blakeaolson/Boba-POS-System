package SharedData;
public class OrderData{ 
  private int id = 0;
  private String drink_name = "";
  private int sweetness_level = 0;
  private int boba_level = 0;
  private int drink_size = 0;
  private String cost;


  public OrderData(String drink_name){
    this.drink_name = drink_name;
  }

  public OrderData(int id, String drink_name, int sweetness_level, int boba_level, int drink_size, String cost) {
    this.id = id;
    this.drink_name = drink_name;
    this.sweetness_level = sweetness_level;
    this.boba_level = boba_level;
    this.drink_size = drink_size;
    this.cost = cost;
  }

  public int getId(){
    return id;
  }
  public String getDrinkName(){
    return drink_name;
  }
  public int getSweetnessLevel(){
    return sweetness_level;
  }
  public int getBobaLevel(){
    return boba_level;
  }
  public int getDrinkSize(){
    return drink_size;
  }
  public String getCost(){
    return cost;
  }

  public void setCost(String cost){
    this.cost = cost;
  }
  public void setSweetnessLevel(int sweetness_level){
    this.sweetness_level = sweetness_level;
  }
  public void setBobaLevel(int boba_level){
    this.boba_level = boba_level;
  }
  public void setDrinkSize(int drink_size){
    this.drink_size = drink_size;
  }

}