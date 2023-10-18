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
    public InventoryData(String itemid, String quantity) {
        this.itemid = itemid;
        this.quantity = quantity;
    }

    
    /** 
     * @return String
     */
    public String getItemid() {
        return itemid;
    }

    
    /** 
     * @return String
     */
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
