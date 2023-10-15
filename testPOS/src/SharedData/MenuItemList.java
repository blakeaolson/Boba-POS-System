package SharedData;

import java.util.ArrayList;

public class MenuItemList {
  private static ArrayList<String> total = new ArrayList<>();
  private static ArrayList<String> display = new ArrayList<>();

  public static ArrayList<String> getDisplayList(){
    return total;
  }

  public static void printItems(){
    for (int i = 0; i < total.size(); i++){
      System.out.println(total.get(i));
    }
  }
  public static void addTotalList(String item){
    total.add(item);
  }

}
