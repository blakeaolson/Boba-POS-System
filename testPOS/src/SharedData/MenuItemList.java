package SharedData;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuItemList {
  // Define ArrayLists to store different types of menu items.
  private static ArrayList<String> total = new ArrayList<>();
  private static ArrayList<String> display = new ArrayList<>();
  private static ArrayList<String> classic = new ArrayList<>();
  private static ArrayList<String> milktea = new ArrayList<>();
  private static ArrayList<String> seasonal = new ArrayList<>();
  private static ArrayList<String> slush = new ArrayList<>();
  
  // Define a HashMap to store item names and their corresponding costs.
  private static HashMap<String, String> costMap = new HashMap<>();

  /**
   * Get the display list of menu items, which can be customized based on user preferences.
   * @return ArrayList<String> - the current display list.
   */
  public static ArrayList<String> getDisplayList(){
    return display;
  }

  /**
   * Parse and categorize items from the 'total' list into specific item categories.
   */
  public static void parseItems() {
    for (String item : total) {
        if (item.contains("Milk Tea")) {
            milktea.add(item);
        } else if (item.contains("Seasonal")) {
            seasonal.add(item);
        } else if (item.contains("Slush")) {
            slush.add(item);
        } else {
            classic.add(item);
        }
    }
    // Set the 'display' list to 'milktea' by default.
    display = milktea;
  }

  /**
   * Change the currently displayed menu list based on user selection.
   * @param s - a String representing the category to display (e.g., "classic", "milktea").
   */
  public static void changeDisplay(String s){
    if (s == "classic") {
        display = classic;
    } else if (s == "milktea") {
        display = milktea;
    } else if (s == "seasonal") {
        display = seasonal;
    } else if (s == "slush") {
        display = slush;
    }
  }

  /**
   * Print all items in the 'total' list.
   */
  public static void printItems(){
    for (int i = 0; i < total.size(); i++){
      System.out.println(total.get(i));
    }
  }

  /**
   * Add an item to the 'total' list.
   * @param item - the item to add to the 'total' list.
   */
  public static void addTotalList(String item){
    total.add(item);
  }

  /**
   * Clear all the ArrayLists to reset the menu data.
   */
  public static void clearLists(){
    total.clear();
    display.clear();
    classic.clear();
    milktea.clear();
    seasonal.clear();
    slush.clear();
  }

  /**
   * Add an item and its cost to the cost map.
   * @param name - the name of the item.
   * @param cost - the cost of the item.
   */
  public static void addCostMap(String name, String cost){
    costMap.put(name, cost);
  }

  /**
   * Get the cost map, which contains item names and their corresponding costs.
   * @return HashMap<String, String> - the cost map.
   */
  public static HashMap<String, String> getCostMap(){
    return costMap;
  }

  /**
   * Get the 'total' list of all menu items.
   * @return ArrayList<String> - the 'total' list.
   */
  public static ArrayList<String> getTotalArray(){
    return total;
  }
}