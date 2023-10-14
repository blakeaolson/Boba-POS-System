public class InventoryData {
    private String itemid = "";
    private String quantity = "";
    private String itemcategory = "";
    private String minimum = "";

    public InventoryData(String itemid, String quantity, String itemcategory, String minimum) {
        this.itemid = itemid;
        this.quantity = quantity;
        this.itemcategory = itemcategory;
        this.minimum = minimum;
    }

    public String getItemid() {
        return itemid;
    }

    public String getQuantity() {
        return quantity;
    }
    public String getItemcategory() {
        return itemcategory;
    }
    public String getMinimum(){
        return minimum;
    }
}
