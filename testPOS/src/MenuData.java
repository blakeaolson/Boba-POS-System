public class MenuData {
    private String itemid = "";
    private String name = "";
    private String itemcost = "";

    public MenuData(String itemid, String name, String itemcost) {
        this.itemid = itemid;
        this.name = name;
        this.itemcost = itemcost;
    }

    public String getItemid() {
        return itemid;
    }

    public String getName() {
        return name;
    }
    public String getItemcost() {
        return itemcost;
    }
}
