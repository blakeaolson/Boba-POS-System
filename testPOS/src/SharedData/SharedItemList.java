package SharedData;
import java.util.ArrayList;

public class SharedItemList {
    private static ArrayList<OrderData> itemList = new ArrayList<>();

    public static ArrayList<OrderData> getItemList() {
        return itemList;
    }

    public static void addItem(String item) {
        OrderData newOrder = new OrderData(619502, "5.00", "8/12/23/", "Blake", "Cash", 8, item);
        itemList.add(newOrder);
    }
    public static void clearList(){
        itemList.clear();
    }
    public static void removeItem(int index){
      itemList.remove(index);
    }
}