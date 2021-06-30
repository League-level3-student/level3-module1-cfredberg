package _07_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a temperature of 59.01 °F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature °F = 65.0, max temperature °F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather implements ActionListener {
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	JButton city = new JButton("City");
    JButton condition = new JButton("Condition");
    JButton temp = new JButton("Temp");
    void start() {
        
        
        JFrame frame = new JFrame("Weather");
        JPanel panel = new JPanel();
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        panel.add(city);
        panel.add(condition);
        panel.add(temp);
        
        city.addActionListener(this);
        
        condition.addActionListener(this);
        
        temp.addActionListener(this);
        
        frame.pack();
        
        // All city keys have the first letter capitalized of each word
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == city) {
			String cityName = Utilities.capitalizeWords( JOptionPane.showInputDialog("Please enter a city:") );
	        WeatherData datum = weatherData.get(cityName);
	        
	        if( datum == null ) {
	            System.out.println("Unable to find weather data for: " + cityName);
	        } else {
	            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
	        }
		}else if (e.getSource() == condition) {
			Set<String> citiesSet = weatherData.keySet();
			String[] cities = (String[]) citiesSet.toArray();
			ArrayList<String> myCities = new ArrayList<String>();
			
			String condName = Utilities.capitalizeWords( JOptionPane.showInputDialog("Please enter a condition:") );
	        WeatherData datum = weatherData.get(condName);
	        
	        for (int i = 0; i < cities.length; i++) {
	        	String currentCity = cities[i];
	        	WeatherData data = weatherData.get(currentCity);
	        	if (data.weatherSummary.equals(condName)) {
	        		myCities.add(currentCity);
	        	}
	        }
	        
	        if( datum == null ) {
	            System.out.println("Unable to find weather data for: " + condName);
	        } else {
	            System.out.println(myCities.toString());
	        }
		}
	}
}
