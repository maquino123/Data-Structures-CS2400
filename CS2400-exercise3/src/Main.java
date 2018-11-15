import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String argv[]) throws InvalidExpressionException,IOException
    {
        InfixToPostfixConverter object = new InfixToPostfixConverter();


        String infix;

        //create an input stream object
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));

        //get input from user
        System.out.print("\nEnter the algebraic expression in infix: ");
        infix = keyboard.readLine();

        //output as postfix
        //output as postfix
        System.out.println("The expression in postfix is:" + object.convert(infix));

    }
}