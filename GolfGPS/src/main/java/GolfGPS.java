import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GolfGPS {
    public static void main(String[] args) throws IOException, JSONException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your current location:");
        String currentLocation = input.nextLine();

        JSONObject currentLocationJson = getLocation(currentLocation);
        double currentLatitude = currentLocationJson.getDouble("latitude");
        double currentLongitude = currentLocationJson.getDouble("longitude");

        System.out.println("Enter the name of the golf course:");
        String golfCourseName = input.nextLine();

        JSONObject golfCourseJson = getGolfCourse(golfCourseName);
        JSONArray holesJson = golfCourseJson.getJSONArray("holes");

        int currentHole = getNearestHole(currentLatitude, currentLongitude, holesJson);

        System.out.printf("You are currently on hole %d.%n", currentHole);
    }

    public static JSONObject getLocation(String location) throws IOException, JSONException {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address="
        + location + "&key=AIzaSyB0_VYf6vZikOYtJdIo4HyfkXPdPGd9qAo";

        JSONObject result = null;

        try (InputStream stream = new URL(url).openStream()) {
            Scanner scanner = new Scanner(stream);
            String jsonString = scanner.useDelimiter("\\A").next();
            JSONObject json = new JSONObject(jsonString);
            JSONArray results = json.getJSONArray("results");
            JSONObject geometry = results.getJSONObject(0).getJSONObject("geometry");
            JSONObject locationJson = geometry.getJSONObject("location");
            double latitude = locationJson.getDouble("lat");
            double longitude = locationJson.getDouble("lng");
            result = new JSONObject().put("latitude", latitude).put("longitude", longitude);
        }

        return result;
    }

    public static JSONObject getGolfCourse(String name) throws IOException, JSONException {
        String url = "https://api.example.com/golf-courses?name=" + name;
        JSONObject result = null;

        try (InputStream stream = new URL(url).openStream()) {
            Scanner scanner = new Scanner(stream);
            String jsonString = scanner.useDelimiter("\\A").next();
            JSONObject json = new JSONObject(jsonString);
            JSONArray courses = json.getJSONArray("courses");
            JSONObject course = courses.getJSONObject(0);
            String courseName = course.getString("name");
            double latitude = course.getDouble("latitude");
            double longitude = course.getDouble("longitude");
            JSONArray holes = course.getJSONArray("holes");
            result = new JSONObject().put("name", courseName)
                    .put("latitude", latitude)
                    .put("longitude", longitude)
                    .put("holes", holes);
        }

        return result;
    }

    public static int getNearestHole(double latitude, double longitude, JSONArray holesJson) throws JSONException {
        int nearestHole = 0;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < holesJson.length(); i++) {
            JSONObject holeJson = holesJson.getJSONObject(i);
            double holeLatitude = holeJson.getDouble("latitude");
            double holeLongitude = holeJson.getDouble("longitude");
            double distance = Math.sqrt(Math.pow(holeLatitude -latitude, 2)) + Math.pow(holeLongitude - longitude, 2);

            if(distance < minDistance){
                minDistance = distance;
                nearestHole = holeJson.getInt("number");

            }
        }
        return nearestHole;
    }
}