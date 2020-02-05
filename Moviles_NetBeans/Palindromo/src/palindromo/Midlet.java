
package palindromo;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.PrintStream;
import javax.microedition.midlet.MIDlet;

/**
 * @author Miguel
 */
public class Midlet extends MIDlet implements CommandListener, ItemCommandListener {
  private Display d;
  private Command c;
  private Command c1;
  private Form f;
  private StringItem t;
  private TextField txtU;
  private TextBox txtC;
  private int numI;
  private int aux;
  boolean valor = true;
  
  public Midlet()
  {
    String[] cad = { "America", "Asia", "Africa", "Europa" };
    this.d = Display.getDisplay(this);
    this.c = new Command("Calcular", 7, 2);
    this.c1 = new Command("Calc", 4, 2);
    this.f = new Form("Palindromo");
    this.txtU = new TextField("Cadena:", "", 30, 0);
    this.t = new StringItem("Respuesta", "R: ");
    
    this.f.append(this.txtU);
    this.f.append(this.t);
    
    this.f.addCommand(this.c);
    this.f.setCommandListener(this);
  }

 public void startApp()
  {
    this.d.setCurrent(this.f);
  }
  
  public void pauseApp() {}
  
  public void destroyApp(boolean unconditional) {}
  
  public void commandAction(Command co, Displayable di)
  {
    if (co == this.c) {
      palindromo();
    }
  }
  
  public void palindromo()
  {
    String cadAux = this.txtU.getString().toLowerCase();
    String cad2 = "";String cadI = "";
    
    int tamC = cadAux.length();
    for (int i = 0; i < tamC; i++) {
      if (cadAux.charAt(i) != ' ') {
        cad2 = cad2 + cadAux.charAt(i);
      }
    }
    for (int i = cad2.length() - 1; i >= 0; i--) {
      cadI = cadI + cad2.charAt(i);
    }
    System.out.println("Cad2: " + cad2);
    System.out.println("cadI: " + cadI);
    if (cad2.equals(cadI)) {
      this.t.setText("Es palindro");
    } else {
      this.t.setText("No es palindromo");
    }
  }
  
  public void commandAction(Command c, Item item)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}