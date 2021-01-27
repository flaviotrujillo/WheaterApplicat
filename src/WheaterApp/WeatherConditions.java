package WheaterApp;

import com.google.gson.annotations.SerializedName;
import java.util.Map;


// Part III-01, Create a WeatherConditions class
// It should contain int id, String name, main
public class WeatherConditions {
    int id;
    String name;

    // Part III-02, and 03:
    // Change the name of main member variable to "measurements"
    // Add an annotation to variable to tell GSON that "main"
    // should go with "measurements"
    @SerializedName("main")
    Map<String, Float> measurements;

    public WeatherConditions(){
        this.id = 0;
        this.name = "";
        this.measurements = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

}
