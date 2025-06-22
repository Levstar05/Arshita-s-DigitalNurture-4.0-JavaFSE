public class w1_DSA_Ex7_FinancialForecasting {
    public static void main(String[] args) {
        double initialValue = 10000;     // Starting capital or revenue
        double growthRate = 0.10;        // 10% growth per year
        int years = 5;                   // Forecast for 5 years

        double futureValue = forecastRecursive(initialValue, growthRate, years);
        System.out.println("📈 Forecasted Value after " + years + " years: ₹" + futureValue);
    }

    // 1. Recursive Method to Forecast Future Value
    public static double forecastRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue; // Base case: no more years to grow
        }
        // Recursive case: apply growth rate and move to next year
        return forecastRecursive(currentValue * (1 + growthRate), growthRate, years - 1);
    }
}
