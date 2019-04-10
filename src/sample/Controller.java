package sample;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class Controller {


    public TextArea unosArtikala;
    public TextArea ispisArtikala;
    public void dodajArtikle(ActionEvent actionEvent) {

        ArrayList<Artikal> a = new ArrayList<Artikal>();

        String[] str = unosArtikala.getText().split("\n");

   for (String i : str) {
        a.add(new Artikal(i));

   }

   Artikal.izbaciDuplikate(a);

   String c ="";
   for(Artikal i : a){
       c = c + i + "\n";
   }
   ispisArtikala.setText(c);




    }
}
