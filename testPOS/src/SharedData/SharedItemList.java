package SharedData;
import java.util.ArrayList;

public class SharedItemList {
    private static ArrayList<OrderData> itemList = new ArrayList<>();

    public static ArrayList<OrderData> getItemList() {
        return itemList;
    }

    public static void addItem(String item) {
        OrderData newOrder = new OrderData(1, item, 0, 0, 0);
        itemList.add(newOrder);
    }
    public static void clearList(){
        itemList.clear();
    }
    public static void removeItem(int index){
      itemList.remove(index);
    }
}