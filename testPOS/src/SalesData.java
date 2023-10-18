public class SalesData {
    private String itemreport= "";
    private String quantitysold = "";


    public SalesData(String itemreport, String quantitysold) {
        this.itemreport = itemreport;
        this.quantitysold = quantitysold;
    }

    
    /** 
     * @return String
     */
    public String getItemreport() {
        return itemreport;
    }

    
    /** 
     * @return String
     */
    public String getQuantitysold() {
        return quantitysold;
    }

}
