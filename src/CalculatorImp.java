/**
 * Esta es la clase que implementa los metodos de la interfaz calculator
 */
public class CalculatorImp implements Calculator {
    /**
     * Este es el metodo que permite que se realicen las operaciones
     * @param num1
     * @param num2
     * @param op
     * @return El resultado final de toda la operacion del archivo .txt
     */
    public int calculate(int num1, int num2, String op){
        //resultado es la variable que al final mostrara el resultado final de toda la operacion del .txt
        int resultado = 0;
        if (op.equals("+")){
            resultado = num1 + num2;
        }
        else if (op.equals("-")){
            resultado = num2 - num1;
        }
        else if (op.equals("*")){
            resultado = num1 * num2;
        }
        else if (op.equals("/")){
            resultado = num2 / num1;
        }
        return resultado;
    }
}
