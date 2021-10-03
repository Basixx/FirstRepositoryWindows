package com.kodilla.testing.weather.stub;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double temperatureAverage(){
        double sum =0;
        int quantityOfTemperatures = 0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            sum = sum + temperature.getValue();
            quantityOfTemperatures++;
        }
        return sum/quantityOfTemperatures;
    }

    public double temperatureMedian(){
        double median;
        int quantityOfTemperatures = temperatures.getTemperatures().entrySet().size();
        double[] temperaturesOrder = new double[quantityOfTemperatures];
        quantityOfTemperatures = 0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            temperaturesOrder[quantityOfTemperatures]= temperature.getValue();
            quantityOfTemperatures++;

        }
        Arrays.sort(temperaturesOrder);

        if (quantityOfTemperatures %2 != 0){
            int index = (quantityOfTemperatures +1)/2 -1;
            median = temperaturesOrder[index];
        }
        else {
            int index1 = quantityOfTemperatures/2;
            int index2 = index1-1;
            median = (temperaturesOrder[index1]+temperaturesOrder[index2])/2;
        }

        return median;
    }
}
