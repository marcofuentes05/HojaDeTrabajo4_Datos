import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
public class Main {
    public static void main(String args[]) {
        ArrayList<String> mapa =  new ArrayList<String>();
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
        String [] m = mapa.get(0).split("");
        int size = m.length;
        for (int i = 0;i <size;i++) {
            switch (m[i]) {
                case "0":
                    operandos.push(0);
                    break;
                case "1":
                    operandos.push(1);
                    break;
                case "2":
                    operandos.push(2);
                    break;
                case "3":
                    operandos.push(3);
                    break;
                case "4":
                    operandos.push(4);
                    break;
                case "5":
                    operandos.push(5);
                    break;
                case "6":
                    operandos.push(6);
                    break;
                case "7":
                    operandos.push(7);
                    break;
                case "8":
                    operandos.push(8);
                    break;
                case "9":
                    operandos.push(9);
                    break;
                case "+":
                    operadores.push("+");
                    break;
                case "-":
                    operadores.push("-");
                    break;
                case "*":
                    operadores.push("*");
                    break;
                case "/":
                    operadores.push("/");
                    break;
            }
            if (operadores.size() == 1){
                if (operandos.size() == 2) {
                    if (operadores.peek().equals("/") && operandos.peek() == 0) {
                        System.out.println("Error! Division por 0 no definida");
                        break;
                    } else {
                        try {
                            operandos.push(calculadora.calculate(operandos.pop(), operandos.pop(), operadores.pop()));
                            System.out.println(operandos.peek());
                        } catch (Exception e) {
                            System.out.println("Esta calculadora no soporta los decimales!");
                            break;
                        }
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