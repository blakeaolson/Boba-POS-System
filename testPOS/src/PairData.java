public class PairData {
    private final String item1;
    private final String item2;
    private final Integer frequency;

    public PairData(String item1, String item2, Integer frequency) {
        this.item1 = item1;
        this.item2 = item2;
        this.frequency = frequency;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    public Integer getFrequency() {
        return frequency;
    }
}