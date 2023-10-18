package SharedData;

public class OrderData {
  private int id = 0;
  private String drink_name = "";
  private int sweetness_level = 0;
  private int boba_level = 0;
  private int drink_size = 0;
  private String cost;

  /**
   * Create an OrderData object with the specified drink name.
   * @param drink_name - the name of the drink to be ordered.
   */
  public OrderData(String drink_name){
    this.drink_name = drink_name;
  }

  /**
   * Create an OrderData object with various order details.
   * @param id - the unique identifier for the order.
   * @param drink_name - the name of the drink to be ordered.
   * @param sweetness_level - the sweetness level of the drink.
   * @param boba_level - the boba (pearls) level in the drink.
   * @param drink_size - the size of the drink.
   * @param cost - the cost of the drink.
   */
  public OrderData(int id, String drink_name, int sweetness_level, int boba_level, int drink_size, String cost) {
    this.id = id;
    this.drink_name = drink_name;
    this.sweetness_level = sweetness_level;
    this.boba_level = boba_level;
    this.drink_size = drink_size;
    this.cost = cost;
  }

  /**
   * Get the unique identifier for the order.
   * @return int - the order ID.
   */
  public int getId(){
    return id;
  }

  /**
   * Get the name of the drink in the order.
   * @return String - the name of the drink.
   */
  public String getDrinkName(){
    return drink_name;
  }

  /**
   * Get the sweetness level of the drink in the order.
   * @return int - the sweetness level.
   */
  public int getSweetnessLevel(){
    return sweetness_level;
  }

  /**
   * Get the boba (pearls) level in the drink in the order.
   * @return int - the boba level.
   */
  public int getBobaLevel(){
    return boba_level;
  }

  /**
   * Get the size of the drink in the order.
   * @return int - the drink size.
   */
  public int getDrinkSize(){
    return drink_size;
  }

  /**
   * Get the cost of the drink in the order.
   * @return String - the cost of the drink.
   */
  public String getCost(){
    return cost;
  }

  /**
   * Set the cost of the drink in the order.
   * @param cost - the cost of the drink to set.
   */
  public void setCost(String cost){
    this.cost = cost;
  }

  /**
   * Set the sweetness level of the drink in the order.
   * @param sweetness_level - the sweetness level to set.
   */
  public void setSweetnessLevel(int sweetness_level){
    this.sweetness_level = sweetness_level;
  }

  /**
   * Set the boba (pearls) level in the drink in the order.
   * @param boba_level - the boba level to set.
   */
  public void setBobaLevel(int boba_level){
    this.boba_level = boba_level;
  }

  /**
   * Set the size of the drink in the order.
   * @param drink_size - the drink size to set.
   */
  public void setDrinkSize(int drink_size){
    this.drink_size = drink_size;
  }
}