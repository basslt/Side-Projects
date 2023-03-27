import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class inflation_calculator {

    public static void main(String[] args) {
        try {
            // Get user input for the year, amount, and target year
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the year: ");
            int year = Integer.parseInt(reader.readLine());
            System.out.print("Enter the amount: ");
            double amount = Double.parseDouble(reader.readLine());
            System.out.print("Enter the target year: ");
            int targetYear = Integer.parseInt(reader.readLine());

            // Get inflation data from the internet using a JSON object
            URL url = new URL("https://api.bls.gov/publicAPI/v2/timeseries/data/CUUR0000SA0?registrationkey=a622ca07969d4f11b4f7376919530cad&startyear="+year+"&endyear="+targetYear);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON object to get the inflation rate for each year
                JSONObject json = new JSONObject(response.toString());
                JSONObject results = json.getJSONObject("Results");
                JSONObject series = results.getJSONArray("series").getJSONObject(0);
                JSONObject data = series.getJSONArray("data").getJSONObject(0);
                double baseValue = data.getDouble("value");
                double[] inflationRates = new double[targetYear - year + 1];
                for (int i = 0; i < inflationRates.length; i++) {
                    data = series.getJSONArray("data").getJSONObject(i);
                    double currentValue = data.getDouble("value");
                    inflationRates[i] = baseValue / currentValue;
                }

                // Calculate the adjusted amount based on the inflation rates
                double adjustedAmount = (amount * inflationRates[targetYear - year]);
                double adjusted = adjustedAmount + amount;

                // Format the output to two decimal places
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println("$" +df.format(amount) + " in " + year + " is equivalent to $" + df.format(adjusted) + targetYear + ".");
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

