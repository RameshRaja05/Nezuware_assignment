package temperature_converter;

import java.util.Scanner;
import java.util.Set;

public class Main {
    private final static TemperatureConverter tempConverter = new TemperatureConverter();

    /**
     * This method checks if scale is equals to one of the valid values
     * @param scale {@code String}
     * @return {@code boolean}
     */
    private static boolean isValidScale(String scale) {
        return scale.equals("c") || scale.equals("celsius") ||
                scale.equals("f") || scale.equals("fahrenheit") ||
                scale.equals("k") || scale.equals("kelvin");
    }

    private static String getValidContinueOption(Scanner sc){
        String option;
        Set<String> validOptions=Set.of("yes","no","n","y");
        // if user enters valid continue operation then it break out of the loop
        //else it keeps prompts until get a valid operation type
        while(true){
            System.out.print("Do you want to do an another operation: (Yes/No) ");
            option=sc.next().strip().toLowerCase();
            if (validOptions.contains(option)) {
                break;
            }
            System.out.println("Invalid option, Please choose either (Yes/No): ");
        }
        return option;
    }

    private static String getTemperatureScale(Scanner sc, String scaleName) {
        String sourceScale;
        // it keeps asking till it gets a valid scale type
        while (true) {
            System.out.printf("Select the %s scale: Celsius (C), Fahrenheit (F), Kelvin (K): ", scaleName);
            sourceScale = sc.next().trim().toLowerCase();
            if (isValidScale(sourceScale)) {
                break;
            } else {
                System.out.println("Invalid scale. Please enter C, F, or K.");
            }
        }
        return sourceScale;
    }


    private static double convertFromCelsius(double temperature, String targetScale) {
        return switch (targetScale) {
            case "c", "celsius" -> temperature;
            case "f", "fahrenheit" -> tempConverter.celsiusToFahrenheit(temperature);
            case "k", "kelvin" -> tempConverter.celsiusToKelvin(temperature);
            default -> {
                System.out.println("Invalid target scale. Please choose C, F, or K.");
                yield Double.NaN;
            }
        };
    }

    private static double convertFromKelvin(double temperature, String targetScale) {
        return switch (targetScale) {
            case "k", "kelvin" -> temperature;
            case "c", "celsius" -> tempConverter.kelvinToCelsius(temperature);
            case "f", "fahrenheit" -> tempConverter.kelvinToFahrenheit(temperature);
            default -> {
                System.out.println("Invalid target scale. Please choose C, F, or K.");
                yield Double.NaN;
            }
        };
    }

    private static double convertFromFahrenheit(double temperature, String targetScale) {
        return switch (targetScale) {
            case "f", "fahrenheit" -> temperature;
            case "c", "celsius" -> tempConverter.fahrenheitToCelsius(temperature);
            case "k", "kelvin" -> tempConverter.fahrenheitToKelvin(temperature);
            default -> {
                System.out.println("Invalid target scale. Please choose C, F, or K.");
                yield Double.NaN;
            }
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            double temperature;
            System.out.println("Welcome to the Temperature Converter");

            System.out.print("Enter the Temperature Value: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // Clear the invalid input
                System.out.print("Enter the temperature value: ");
            }
            temperature=sc.nextDouble();

            //get a source scale and targetScale from user
            String sourceScale = getTemperatureScale(sc, "source");
            String targetScale = getTemperatureScale(sc, "target");

            // convert the sourceScale into targetScale value
            double convertedTemperature = switch (sourceScale) {
                case "c", "celsius" -> convertFromCelsius(temperature, targetScale);
                case "k", "kelvin" -> convertFromKelvin(temperature, targetScale);
                case "f", "fahrenheit" -> convertFromFahrenheit(temperature, targetScale);
                default -> Double.NaN;
            };

            // handles the isNaN bad return type from conversion process
            if (!Double.valueOf(convertedTemperature).isNaN()) {
                System.out.println(STR."Converted Temperature: \{convertedTemperature}");
            }

            String continueOperation =getValidContinueOption(sc);

            if ("no".equalsIgnoreCase(continueOperation)
                    || "n".equalsIgnoreCase(continueOperation
            )) {
                break;
            }

        }
    }
}
