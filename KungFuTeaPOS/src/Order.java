

public class Order {
        private int orderId;
        private float totalAmount;
        private String date;
        private String cashierName;
        private String paymentMethod;
        private int hour;


        public Order(int orderId, float totalAmount, String date, String cashierName, String paymentMethod, int hour) {
            this.orderId = orderId;
            this.totalAmount = totalAmount;
            this.date = date;
            this.cashierName = cashierName;
            this.paymentMethod = paymentMethod;
            this.hour = hour;
        }

        public int getOrderId() {
            return orderId;
        }

        public float getotal() {
            return totalAmount;
        }

        public String getdate() {
            return date;
        }

        public String getName() {
            return cashierName;
        }

        public String getpaymentMethod() {
            return paymentMethod;
        }

        public int getHour() {
            return hour;
        }
        
        // Add getter methods for more columns as needed
    }
