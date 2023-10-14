package SharedData;
import java.util.ArrayList;

public class SharedItemList {
    private static ArrayList<OrderData> itemList = new ArrayList<>();

    public static ArrayList<OrderData> getItemList() {
        return itemList;
    }

    public static void addItem(String item, int sweetness, int boba_level, int drink_size) {
        OrderData newOrder = new OrderData(1, item, sweetness, boba_level, drink_size);
        itemList.add(newOrder);
    }
    public static void clearList(){
        itemList.clear();
    }
    public static void removeItem(int index){
      itemList.remove(index);
    }
}