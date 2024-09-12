package temperature_converter;

public class TemperatureConverter {

    /**
     * This method calculates the Fahrenheit from Celsius
     * By using this Formulae
     * Fahrenheit = (celsiusValue * 9/5 ) + 32;
     * @see <a href="https://www.rapidtables.com/convert/temperature/celsius-to-fahrenheit.html">Celsius to Fahrenheit conversion</a>
     * @param celsiusValue the celsius {@code double}
     * @return Fahrenheit value {@code double}
     */
    public double celsiusToFahrenheit(double celsiusValue) {
        return (celsiusValue * 9 / 5) + 32;
    }

    /**
     * This method converts the Celsius value into Kelvin
     * it utilizes the formulae
     * Kelvin = celsiusValue + 273.15
     * @see <a href="https://byjus.com/chemistry/celsius-to-kelvin/">Celsius to Kelvin Conversion</a>
     * @param celsiusValue - The celsius value {@code double}
     * @return kelvin {@code double}
     */
    public double celsiusToKelvin(double celsiusValue) {
        return celsiusValue + 273.15;
    }

    /**
     * This method converts the Fahrenheit value into Celsius
     * Formulae :- Celsius=(fahrenheit-32)*5/9;
     * @see <a href="https://byjus.com/fahrenheit-to-celsius-formula/">Fahrenheit to celsius conversion</a>
     * @param fahrenheitValue {@code double}
     * @return fahrenheit {@code double}
     */
    public double fahrenheitToCelsius(double fahrenheitValue) {
        return (fahrenheitValue-32)*5/9;
    }

    /**
     * This method converts the Fahrenheit value into kelvin
     * Formulae -> kelvin = (fahrenheitValue + 459.67) * 5/9;
     * @see <a href="https://www.calculatorsoup.com/calculators/conversions/fahrenheit-to-kelvin.php">Fahrenheit to kelvin</a>
     * @param fahrenheitValue {@code double}
     * @return kelvin {@code double}
     */
    public double fahrenheitToKelvin(double fahrenheitValue) {
        return (fahrenheitValue+459.67)*5/9;
    }

    /**
     * This method converts the kelvinValue into Celsius
     * Formulae -> Celsius = kelvinValue - 273.15
     * @see <a href="https://www.rapidtables.com/convert/temperature/kelvin-to-celsius.html">Kelvin to celsius</a>
     * @param kelvinValue
     * @return celsius {@code double}
     */
    public double kelvinToCelsius(double kelvinValue) {
        return kelvinValue-273.15;
    }

    /**
     * This method converts the kelvin value into Fahrenheit
     * Formulae -> Fahrenheit = (kelvin * 9/5) - 459.67
     * @see <a href="https://www.calculatorsoup.com/calculators/conversions/kelvin-to-fahrenheit.php">Kelvin to Fahrenheit</a>
     * @param kelvinValue
     * @return
     */
    public double kelvinToFahrenheit(double kelvinValue) {
        return (kelvinValue*9/5)-459.67;
    }

}
