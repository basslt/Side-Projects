package Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Enter the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Enter the base currency code
        System.out.print("Enter the base currency code (e.g. USD, EUR, GBP): ");
        String baseCurrencyCode = scanner.next().toUpperCase();

        // Enter the target currency code
        System.out.print("Enter the target currency code (e.g. USD, EUR, GBP): ");
        String targetCurrencyCode = scanner.next().toUpperCase();

        // Retrieve the exchange rate data from an API
        URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrencyCode);
        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = reader.readLine();
        reader.close();

        // Parse the JSON data
        double exchangeRate = Double.parseDouble(line.split("\"" + targetCurrencyCode + "\":")[1].split(",")[0]);

        // Convert the amount and display the result
        double result = amount * exchangeRate;
        System.out.printf("%.2f %s = %.2f %s", amount, baseCurrencyCode, result, targetCurrencyCode);
    }
}
