import java.util.Stack;

public class InfixToPostfixConverter implements ExpressionConverterInterface {
    private StackInterface<Character> stackInterfaceObject;

    public InfixToPostfixConverter() {
        this(new LinkedStack<Character>());
    }

    public InfixToPostfixConverter(StackInterface<Character> parameter) {
        stackInterfaceObject = parameter;
    }

    private static int getPrecedence(char c){
        switch (c){
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static boolean isCharacter(char c){
        return Character.isLetter(c);
    }

    private static boolean isNumber(int c){
        return Character.isDigit(c);
    }


    public String convert(String expression) throws InvalidExpressionException{
        Stack<Character> operatorStack = new Stack<Character>();
        String postfix = "";
        expression = expression.replace(" ","");
        char topOfStack;

        if (expression.length() == 0){

            throw new InvalidExpressionException();
        }


        for (int i = 0; i < expression.length(); i++) {
            boolean isFinished = false;
            char nextCharacter = expression.charAt(i);

            if (isCharacter(nextCharacter) || isNumber(nextCharacter)) {

                postfix = postfix + nextCharacter;

            }if (!expression.matches("[a-zA-Z0-9+-/*^()]+?")) {

                throw new InvalidExpressionException();
            }      else {
                switch (nextCharacter) {
                    case '^':
                        operatorStack.push(nextCharacter);
                        break;

                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while (!isFinished && !operatorStack.isEmpty()) {
                            topOfStack = operatorStack.peek();
                            if (getPrecedence(nextCharacter) <= getPrecedence(topOfStack)) {
                                postfix = postfix + topOfStack;
                                operatorStack.pop();
                            } else {
                                isFinished = true;
                            }
                        }
                        operatorStack.push(nextCharacter);
                        break;

                    case '(':
                        operatorStack.push(nextCharacter);
                        break;

                    case ')':
                        topOfStack = operatorStack.pop();
                        while (topOfStack != '(') {
                            postfix = postfix + topOfStack;
                            topOfStack = operatorStack.pop();
                        }
                        break;

                    default:
                        break;
                }
            }

        }


        while (!operatorStack.isEmpty()) {
            topOfStack = operatorStack.pop();
            postfix = postfix + topOfStack;
        }

        return postfix;

    }
}
