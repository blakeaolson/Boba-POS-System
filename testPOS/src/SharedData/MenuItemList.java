package SharedData;

import java.util.ArrayList;

public class MenuItemList {
  private static ArrayList<String> total = new ArrayList<>();
  private ArrayList<String> classic;
  private ArrayList<String> milk_tea;
  private ArrayList<String> seasonal;
  private ArrayList<String> slush;

  public static void printItems(){
    for (int i = 0; i < total.size(); i++){
      System.out.println(total.get(i));
    }
  }
  public static void addTotalList(String item){
    total.add(item);
  }
}
