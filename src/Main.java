import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        List<String> mapa =  new ArrayList<String>();
        CalculatorImp calculadora = new CalculatorImp();
        Fila <String> operadores = new Fila<>();
        Fila <Integer> operandos = new Fila<>();

        try{
            Stream<String> lines = Files.lines(Paths.get("datos.txt"), StandardCharsets.UTF_8);
            lines.forEach(s  -> mapa.add(s));
        }catch(IOException e){
            System.out.println("Error!");
            e.printStackTrace();
        }

        int size = mapa.size();

        for (int i = 0;i <size;i++){

            System.out.println(mapa.get(i) + " ");

            if (mapa.get(i).equals("0")){
                operandos.push(0);
            }else if(mapa.get(i).equals("1")){
                operandos.push(1);
            }else if (mapa.get(i).equals("2")){
                operandos.push(2);
            }else if(mapa.get(i).equals("3")){
                operandos.push(3);
            }else if(mapa.get(i).equals("4")){
                operandos.push(4);
            }else if(mapa.get(i).equals("5")){
                operandos.push(5);
            }else if(mapa.get(i).equals("6")){
                operandos.push(6);
            }else if(mapa.get(i).equals("7")){
                operandos.push(7);
            }else if(mapa.get(i).equals("8")){
                operandos.push(8);
            }else if(mapa.get(i).equals("9")){
                operandos.push(9);
            }else if(mapa.get(i).equals("+")){
                operadores.push("+");
            }else if(mapa.get(i).equals("-")){
                operadores.push("-");
            }else if(mapa.get(i).equals("*")){
                operadores.push("*");
            }else if(mapa.get(i).equals("/")){
                operadores.push("/");
            }

            if (operandos.size() == 2 && operadores.size()==1){
                int num1 = operandos.pop();
                int num2 = operandos.pop();
                String op = operadores.pop();
                if (op.equals("/") && num2 == 0){
                    System.out.println("Error! Division por 0 no definida");
                    break;
                }else{
                    try{
                        int resultado = calculadora.calculate(num1,num2,op);
                        operandos.push(resultado);
                    }catch(Exception e){
                        System.out.println("Esta calculadora no soporta los decimales!");
                        break;
                    }

                }
            }
        }
        if (!operandos.empty()){
            System.out.println("El resultado es: "+operandos.peek());
        }else{
            System.out.println("Algo salio mal...");
        }


    }
}
