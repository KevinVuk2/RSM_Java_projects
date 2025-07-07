package Assignment_3;

// Total Revenue in 2024: 1307750.0
// Projected Revenue in 2035: 1717100.0

public class OrangeIncRevenue {

	public static void main(String[] args) {
		// Define arrays
        String[] productNames = {"oComputer", "oTablet", "oCall", "oStream", "oClock"};
        double[] productPrice = {1825, 670, 880, 1910, 485};
        int[] productSales2024 = {320, 140, 530, 45, 160};
        double[] growthRate = {2.25, 3.5, 2.5, 4.3, 0.8}; // Growth rate in percentage
        double[] productRevenue2024 = new double[5];

        // Calculate total revenue in 2024
        double totalRevenue2024 = 0;
        for (int i = 0; i < productPrice.length; i++) {
            productRevenue2024[i] = productPrice[i] * productSales2024[i];
            totalRevenue2024 += productRevenue2024[i];
        }
        System.out.println("Total Revenue in 2024: " + totalRevenue2024);

        // Calculate projected sales in 2035
        int years = 2035 - 2024;
        int[] productSales2035 = ProjSales(productSales2024, growthRate, years);

        // Calculate projected revenue in 2035
        double totalRevenue2035 = 0;
        double[] productRevenue2035 = new double[5];
        for (int i = 0; i < productPrice.length; i++) {
            productRevenue2035[i] = productPrice[i] * productSales2035[i];
            totalRevenue2035 += productRevenue2035[i];
        }
        System.out.println("Projected Revenue in 2035: " + totalRevenue2035);
    }

    // Method to calculate projected sales
    public static int[] ProjSales(int[] baseSales, double[] growthRate, int years) {
        int[] projectedSales = new int[baseSales.length];
        for (int i = 0; i < baseSales.length; i++) {
            projectedSales[i] = (int) Math.round(baseSales[i] * Math.pow((1 + growthRate[i] / 100), years));
        }
        return projectedSales;
    }
}
