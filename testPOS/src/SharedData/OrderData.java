package SharedData;
public class OrderData{ 
  private int id = 0;
  private String drink_name = "";
  private String sweetness_level = "";
  private String boba_level = "";
  private String drink_size = "";


  public OrderData(String drink_name){
    this.drink_name = drink_name;
  }

  public OrderData(int id, String drink_name, String sweetness_level, String boba_level, String drink_size) {
    this.id = id;
    this.drink_name = drink_name;
    this.sweetness_level = sweetness_level;
    this.boba_level = boba_level;
    this.drink_size = drink_size;
  }

  public int getId(){
    return id;
  }
  public String getDrinkName(){
    return drink_name;
  }
  public String getSweetnessLevel(){
    return sweetness_level;
  }
  public String getBobaLevel(){
    return boba_level;
  }
  public String getDrinkSize(){
    return drink_size;
  }

  public void setSweetnessLevel(String sweetness_level){
    this.sweetness_level = sweetness_level;
  }
  public void setBobaLevel(String boba_level){
    this.boba_level = boba_level;
  }
  public void setDrinkSize(String drink_size){
    this.drink_size = drink_size;
  }

}