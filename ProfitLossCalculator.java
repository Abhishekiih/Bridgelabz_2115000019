public class ProfitLossCalculator {
    public static void main(String[] args) {
        // Define the cost price and selling price
        int costPrice = 129;
        int sellingPrice = 191;

        // Calculate profit and profit percentage
        int profit = sellingPrice - costPrice;
        double profitPercentage = (double) profit / costPrice * 100;

        // Display the results
        System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+sellingPrice);
		System.out.println("The Profit is INR "+profit+" and the Profit Percentage is "+profitPercentage);

    }
}
