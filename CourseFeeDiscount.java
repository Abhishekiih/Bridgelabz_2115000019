public class CourseFeeDiscount {
    public static void main(String[] args) {
        // Define the course fee and discount percentage
        double fee = 125000;
        double discountPercent = 10;

        // Calculate the discount amount and final fee
        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;

        // Display the results
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }
}
