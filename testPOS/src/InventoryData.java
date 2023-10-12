public class InventoryData {
    private String itemid = "";
    private String quantity = "";
    private String itemcategory = "";

    public InventoryData(String itemid, String quantity, String itemcategory) {
        this.itemid = itemid;
        this.quantity = quantity;
        this.itemcategory = itemcategory;
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
}
