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
        try{
            Stream<String> lines = Files.lines(Paths.get("datos.txt"), StandardCharsets.UTF_8);
            lines.forEach(s  -> mapa.add(s));
        }catch(IOException e){
        System.out.println("Error!");
        }

    }
}
