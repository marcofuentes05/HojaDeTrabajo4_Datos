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
            if (mapa.get(1).equals(" ")){

            }
        }

    }
}
