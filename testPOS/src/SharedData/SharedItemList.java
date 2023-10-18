package SharedData;
import java.util.ArrayList;

public class SharedItemList {
    private static ArrayList<OrderData> itemList = new ArrayList<>();
    private static float totalCost;

    /**
     * Get the list of ordered items.
     * @return ArrayList<OrderData> - the list of ordered items.
     */
    public static ArrayList<OrderData> getItemList() {
        return itemList;
    }

    /**
     * Add a new item to the list of ordered items.
     * @param item - the name of the drink.
     * @param sweetness - the sweetness level of the drink.
     * @param boba_level - the boba (pearls) level in the drink.
     * @param drink_size - the size of the drink.
     * @param cost - the cost of the drink.
     */
    public static void addItem(String item, int sweetness, int boba_level, int drink_size, String cost) {
        // Create a new OrderData object representing the ordered item.
        OrderData newOrder = new OrderData(1, item, sweetness, boba_level, drink_size, cost);
        // Update the total cost.
        totalCost += Float.parseFloat(cost);
        // Add the new order to the item list.
        itemList.add(newOrder);
    }

    /**
     * Clear the list of ordered items.
     */
    public static void clearList(){
        itemList.clear();
    }

    /**
     * Remove an item from the list of ordered items based on its index.
     * @param index - the index of the item to remove.
     */
    public static void removeItem(int index){
        itemList.remove(index);
    }

    /**
     * Get the total cost of all ordered items.
     * @return float - the total cost.
     */
    public static float getTotalCost(){
        return totalCost;
    }

    /**
     * Decrease the total cost by a specified amount.
     * @param s - the amount to subtract from the total cost.
     */
    public static void lowerTotalCost(String s){
        totalCost -= Float.parseFloat(s);
    }
}