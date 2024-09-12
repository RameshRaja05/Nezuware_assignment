package calculator;

import java.util.Scanner;
import java.util.Set;

public class Main {

    private static int getValidOperation(Scanner sc){
        System.out.print("Please select an operation (1 to 5): ");
        //it keeps prompt until user enters a valid operation type (int)
        while(!sc.hasNextInt()){
            System.out.println("Invalid operation, Please Enter the valid operation");
            //move the buffer to next line
            sc.next();
            System.out.println("Please select an operation (1 to 5): ");
        }
        return sc.nextInt();
    }
    private static double getValidNum(Scanner sc,String label){
        System.out.print(STR."Enter the \{label} Number: ");
        //it keeps prompt until user enters a valid number type (double)
        while(!sc.hasNextDouble()){
            System.out.print("Invalid Number, Please Enter the valid Number: ");
            sc.next();
            System.out.print(STR."Enter the \{label} Number: ");
        }
        return sc.nextDouble();
    }

    private static String getValidContinueOption(Scanner sc){
        String option;
        Set<String> validOptions= Set.of("yes","no","n","y");
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

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Welcome to the Simple Calculator!");
                System.out.println("Operations");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exit");

                int operationChoice = getValidOperation(sc);

                // if user enters invalid option it'll restart the process again
                if(operationChoice>5 || operationChoice<1){
                    System.out.println("Invalid operation.");
                    continue;
                }

                //for exit the calculator
                if (operationChoice == 5) {
                    System.out.println("Exiting the Calculator, Bye");
                    break;
                }

                double firstNum = getValidNum(sc,"first");
                double secondNum = getValidNum(sc,"second");


                // calculate the result
                double result = switch (operationChoice) {
                    case 1 -> calc.add(firstNum, secondNum);
                    case 2 -> calc.subtract(firstNum, secondNum);
                    case 3 -> calc.multiply(firstNum, secondNum);
                    case 4 -> calc.divide(firstNum, secondNum);
                    default -> 0;
                };

                System.out.println(STR."Result: \{result}");


                String continueOperation=getValidContinueOption(sc);

                // for exit operation
                if ("no".equalsIgnoreCase(continueOperation)
                        || "n".equalsIgnoreCase(continueOperation
                )) {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
