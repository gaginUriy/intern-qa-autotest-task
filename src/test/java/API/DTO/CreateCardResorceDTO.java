
public class CreateCardResorceDTO {
        private long sellerID  ;
        private String name;
        private long price;
        private SudClassStatictis statistics;

    public CreateCardResorceDTO(long price, String name, long sellerID, SudClassStatictis statistics) {
        this.statistics = statistics;
        this.price = price;
        this.name = name;
        this.sellerID = sellerID;
    }

    public long getSellerID() {
            return sellerID;
        }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
            return name;
        }

        public long getPrice() {
            return price;
        }

        public SudClassStatictis getStatistics() {
            return statistics;
        }




}