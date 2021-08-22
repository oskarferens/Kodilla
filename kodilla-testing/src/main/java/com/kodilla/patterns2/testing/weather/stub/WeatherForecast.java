// Rozbudowac WeatherForecast o 2 dodatkowe metody, klasy i testy.
// 1.Napisz metode, ktora obliczy srednia temp. + test
// 2.Napisz metode, ktora obliczy mediane temp. + test

package com.kodilla.patterns2.testing.weather.stub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {

    private Temperatures temperatures;
    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Double averageTemperature() {
        Map<String,Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue());
        }
        Collection<Double> values = resultMap.values();
        ArrayList<Double> listAverage = new ArrayList<>(values);

        Double allTemperatures = 0.0;

        for (int i = 0; i < listAverage.size(); i++) {
            allTemperatures = (allTemperatures + listAverage.get(i));
        }
        Double result = allTemperatures/listAverage.size();
        return result;
    }

    public Double temperatureMedian() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue());
        }

        Collection <Double> values = resultMap.values();
        ArrayList <Double> listTemperatures = new ArrayList<>(values);

        Double allTemperatures = 0.0;

        for (int i = 0; i < listTemperatures.size(); i++) {
            allTemperatures = (allTemperatures + listTemperatures.get(i));
        }

        Double median = 0.0;
        if (listTemperatures.size() % 2 == 1) {
            median = (double)(listTemperatures.size()+1)/2-1;
        }else {
            median = (double)(listTemperatures.size()/2-1 + listTemperatures.size()/2) - 2;
        }
        return median;
    }

}
