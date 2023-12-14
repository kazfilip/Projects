package GUI.Projekt2;



import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

       SwingUtilities.invokeLater(() -> {
           try {
               new Projekt2.GameFrame();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });



    }
}
