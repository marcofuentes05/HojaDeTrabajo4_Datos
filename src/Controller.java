import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Controller {
    @FXML
    Button load;

    @FXML
    Button calculate;

    @FXML
    Label file;

    @FXML
    Label resultado;

    ArrayList<String> mapa =  new ArrayList<String>();
    CalculatorImp calculadora = new CalculatorImp();
    Fila<String> operadores = new Fila<>();
    Fila<Integer> operandos = new Fila<>();
    String [] m;
    public void loadActionListener(Event e ){
        FileChooser f = new FileChooser();
        f.setTitle("Buscar Archivo de Texto");
        f.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Texto plano", "*.txt")
        );

        File txtFile = f.showOpenDialog(null);


        try{
            Stream<String> lines = Files.lines(Paths.get(txtFile.getAbsolutePath()), StandardCharsets.UTF_8);
            lines.forEach(s  -> mapa.add(s));
            m = mapa.get(0).split("");
            String a = "";
            for  (int i = 0; i < m.length;i++){
                a = a + m[i];
            }
            file.setText(a);

        }catch(IOException e0){
            JOptionPane.showMessageDialog(null, "Algo salio mal con el archivo... revisalo y prueba de nuevo","Alerta",  JOptionPane.WARNING_MESSAGE);
            }
    }

    public void calculateActionListener(){

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
                        JOptionPane.showMessageDialog(null, "Error! Division por 0 no definida","Alerta",  JOptionPane.WARNING_MESSAGE);
                        break;
                    } else {
                        try {
                            operandos.push(calculadora.calculate(operandos.pop(), operandos.pop(), operadores.pop()));
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Esta calculadora no soporta los decimales!","Alerta",  JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }
                }
            }
        }
        if (!operandos.empty()) resultado.setText("El resultado es: " + operandos.peek());
        else{
            resultado.setText("Algo salio mal...");
        }
    }
}
