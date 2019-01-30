public class CalculatorImp implements Calculator {
    public int calculate(int num1, int num2, String op){
        int resultado = 0;
        if (op.equals("+")){
            resultado = num1 + num2;
        }
        else if (op.equals("-")){
            resultado = num1 - num2;
        }
        else if (op.equals("*")){
            resultado = num1 * num2;
        }
        else if (op.equals("/")){
            resultado = num1 / num2;
        }
        return resultado;
    }
}
