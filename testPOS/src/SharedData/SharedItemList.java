package SharedData;
import java.util.ArrayList;

public class SharedItemList {
    private static ArrayList<String> itemList = new ArrayList<>();

    public static ArrayList<String> getItemList() {
        return itemList;
    }

    public static void addItem(String item) {
        itemList.add(item);
    }
    public static void clearList(){
        itemList.clear();
    }
}