package SharedData;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuItemList {
  private static ArrayList<String> total = new ArrayList<>();
  private static ArrayList<String> display = new ArrayList<>();
  private static ArrayList<String> classic = new ArrayList<>();
  private static ArrayList<String> milktea = new ArrayList<>();
  private static ArrayList<String> seasonal = new ArrayList<>();
  private static ArrayList<String> slush = new ArrayList<>();

  private static HashMap<String, String> costMap = new HashMap<>();

  
  /** 
   * @return ArrayList<String>
   */
  public static ArrayList<String> getDisplayList(){
    return display;
  }

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
    display = milktea;
  }

  public static void changeDisplay(String s){
    if (s == "classic"){display = classic;}
    else if (s == "milktea"){display = milktea;}
    else if (s == "seasonal"){display = seasonal;}
    else if (s == "slush"){display = slush;}
  }

  public static void printItems(){
    for (int i = 0; i < total.size(); i++){
      System.out.println(total.get(i));
    }
  }
  public static void addTotalList(String item){
    total.add(item);
  }
  public static void clearLists(){
    total.clear();
    display.clear();
    classic.clear();
    milktea.clear();
    seasonal.clear();
    slush.clear();
  }
  public static void addCostMap(String name, String cost){
    costMap.put(name, cost);
  }
  public static HashMap<String, String> getCostMap(){
    return costMap;
  }
  public static ArrayList<String> getTotalArray(){
    return total;
  }

}
