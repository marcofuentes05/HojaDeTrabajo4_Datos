import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
/**
 *El programa asimila los comportamientos de una calculadora
 * @author Marco Fuente 18188 y Cristina Bautista 161260
 * @version 01/02/2019
 */
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Es la clase que controla la interfaz
 */
public class Controller {
    @FXML
    Button load;

    @FXML
    Button calculate;

    @FXML
    Label file;

    @FXML
    Label resultado;
    //Se creo para leer el archivo .txt
    ArrayList<String> mapa =  new ArrayList<String>();
    //Instancia de la calculadora
    CalculatorImp calculadora = new CalculatorImp();
    //Instancia de los operadores
    Pila<String> operadores = new Pila<>();
    //Instancia de los operandos
    Pila<Integer> operandos = new Pila<>();
    String [] m;
    File txtFile;

    /**
     * Es el action listener que lanza la ventana donde se puede escoger el archivo que se quiere leer
     * @param e
     */
    public void loadActionListener(Event e ){
        FileChooser f = new FileChooser();
        f.setTitle("Buscar Archivo de Texto");
        f.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Texto plano", "*.txt")
        );

        txtFile = f.showOpenDialog(null);

        try{
            Stream<String> lines = Files.lines(Paths.get(txtFile.getAbsolutePath()), StandardCharsets.UTF_8);
            lines.forEach(s  -> mapa.add(s));
            String a = "";
            for (int z = 0;z<mapa.size();z++){
                a = a +mapa.get(z) + "\n";
            }
            //file.setText(a);

        }catch(IOException e0){
            JOptionPane.showMessageDialog(null, "Algo salio mal con el archivo... revisalo y prueba de nuevo","Alerta",  JOptionPane.WARNING_MESSAGE);
            }
    }

    /**
     * Es el action listener que lanza la ventana donde se calcula y da el resultado final de toda la operacion
     */
    public void calculateActionListener(){
        System.out.println(mapa.size());
        for(int z = 0;z<mapa.size();z++){
            m = mapa.get(z).split("");
            int size = m.length;
            String res = "";
            System.out.println();
            for (int i = 0;i <size;i++) {
                System.out.print(m[i] + "|");
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
                            //Por si se da una division entre 0
                            JOptionPane.showMessageDialog(null, "Error! Division por 0 no definida","Alerta",  JOptionPane.WARNING_MESSAGE);
                            break;
                        } else {
                            try {
                                operandos.push(calculadora.calculate(operandos.pop(), operandos.pop(), operadores.pop()));

                            } catch (Exception e) {
                                //Por si se encuentra alguna division que tiene un decimal
                                JOptionPane.showMessageDialog(null, "Esta calculadora no soporta los decimales!","Alerta",  JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                    }
                }
               // res = res + "El resultado es : "+operandos.peek().toString()+"\n";
            }
            JOptionPane.showMessageDialog(null, "El resultado es "+operandos.pop(),"Alerta",  JOptionPane.WARNING_MESSAGE);

            if (!operandos.empty()) resultado.setText(res);
            else{
                resultado.setText("Algo salio mal...");
            }
        }
    }
}
