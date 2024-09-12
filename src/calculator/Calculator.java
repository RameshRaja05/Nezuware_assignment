package calculator;


public class Calculator {

    /**
     * adds two numbers
     * @param a the first {@code double} number
     * @param b the second {@code double} number
     * @return the addition value of two numbers {@code double} a+b
     */
    public double add(double a ,double b){
        return a+b;
    }

    /**
     * Difference of two numbers
     * @param a the first {@code double} number
     * @param b the second {@code double} number
     * @return the difference of two numbers {@code double} a-b;
     */
    public double subtract(double a,double b){
        return a-b;
    }

    /**
     *
     * @param a the first number {@code double}
     * @param b the second number {@code double}
     * @return the product of two numbers {@code a+b} double
     */
    public double multiply(double a,double b){
        return a*b;
    }

    /**
     *
     * @param dividend The number that is being divided
     * @param divisor The number that is doing the dividing
     * @return the quotient {@code a/b} double
     *
     * @throws IllegalArgumentException
     *         If divisor is zero
     */
    public double divide(double dividend,double divisor){
        if(divisor==0){
            throw new IllegalArgumentException("Divisor Cannot be ZERO");
        }
        return dividend/divisor;
    }

}
