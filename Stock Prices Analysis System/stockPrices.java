// Create all necessary methods
// Work with data structures to return and as args
// Work more with Javadoc for documentation
// Rewrite code for Optimization
import java.util.List;
import java.util.ArrayList;
/** 
 * Stock Price Analysis System
 * 
 * <p>
 * This class implements a system to analyze stock prices. It helps calculate average and maximum stock prices,
 * occurence of a specific price, and cumulative sum of stock prices.
 * </p>
 * 
 * Features:
 * <ul>
 * <li>Calculate average stock price</li>
 * <li>Find maximum stock price</li>
 * <li>Count occurrences of a specific price</li>
 * <li>Compute cumulative sum of stock prices</li>
 * </ul>
 * 
 * Usage:
 * <p>Run the main method to interact with the program. The system provides examples of stock prices to analyze.</p>
 * 
 * @author Charles Oluwatuase
 * @version 1.0
*/
public class stockPrices {
    /**
     * Calculate the average stock price from an array of stock prices.
     * @return The average stock price.
     * @param stockPrices The array of stock prices.
     */
    public static double calcAveragePrice (int[] stockPrices) {
        int sum = 0;
        for (int price : stockPrices){
            sum += price;
        }
        return (double) sum / stockPrices.length;
    } // end of calcAveragePrice

    /**
     * Calauculates the maximum stock price from an aray of stock pirces.
     * @return The maximum stock price.
     * @param stockPrices The array of stock prices.
     */
    public static int maxStockPrice (int[] stockPrices) {
        int maxPrice = stockPrices[0];
        for (int price : stockPrices) {
            if (maxPrice < price) {
                maxPrice = price;
            }
        }
        return maxPrice;
    } // end of maxStockPrice

    /**
     * Counts the number of occurrences of a specific price in an array of stock prices.
     * @return The number of occurrences of a specific price.
     * @param stockPrices The array of stock prices.
     * @param specificPrice The specific price to count occurrences of.
     */
    public static int countSpecificPrice (int[] stockPrices, int specificPrice){
        int count = 0;
        for (int price : stockPrices){
            if (price ==specificPrice){
                count++;
            }
        }
        return count;
    } // end of countSpecificPrice

    /**
     * Computes the cumulative sum of stock prices from an ArrayList of stock prices.
     * @return The ArrayList of cumulative sum of stock prices.
     * @param stockPrices The ArrayList of stock prices.
     */
    public static ArrayList<Double> cumulativeSum(ArrayList<Double> stockPrices){
        ArrayList<Double> cumSumList = new ArrayList<>();
        double sum = 0.0;
        for (double prices : stockPrices){
            sum += prices;
            // Math is used to combat floating point precision errors
            cumSumList.add(Math.round(sum * 100.0) / 100.0);
        }
        return cumSumList;
    } // end of cumulativeSum

    /**
     * Main method to interact with the stock price analysis system.
     * It provides an interface for users to interact with the system.
     * Predefined data will be used here to demonstrate the system.
     * 
     * Features:
     * <ul>
     * <li> Average Stock Price </li>
     * <li> Maximum Stock Price </li>
     * <li> Specific Price Occurrences </li>
     * <li> Cumulative Sum of Stock Prices </li>
     * </ul>
     * 
     * @param args Strings of arguments can be passed (As of my knowledge, it is not used in this program)
     */
    public static void main(String[] args){
        // Example input for the array of stock prices
        int[] stockPricesArray = {101000, 95500, 94924, 107000, 104000, 102000, 97000, 96500, 96500, 102700};
        // Example input for the ArrayList of stock prices
        ArrayList<Double> stockPricesList = new ArrayList<>(List.of(101000.56, 95500.89, 94924.34, 107000.96, 104000.97, 102000.01, 97000.86, 96500.23, 96500.57, 102700.92));

        // Average stock price
        System.out.println("Average Stock Price is: " + calcAveragePrice(stockPricesArray));

        // Maximum stock price
        System.out.println("Maximum Stock Price is: " + maxStockPrice(stockPricesArray));

        // Specific price occurrences
        int specificPrice = 96500;
        System.out.println("Occurrences of " + specificPrice + " is: " + countSpecificPrice(stockPricesArray, specificPrice));

        // Cumulative sum of stock prices
        System.out.println("Cumulative Sum of Stock Prices is: " + cumulativeSum(stockPricesList));
    }

}
