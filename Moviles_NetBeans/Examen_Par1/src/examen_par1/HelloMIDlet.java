/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_par1;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.PrintStream;
import javax.microedition.midlet.MIDlet;

/**
 * @author Juan Carlos Cordero
 */
public class HelloMIDlet extends MIDlet implements CommandListener, ItemCommandListener {
  private Display d;
  private Command c;
  private Command c1;
  private Form f;
  private StringItem t;
  private TextField txt1;
  private TextField txt2;
  private TextField txt3;
  private int numI;
  private int aux;
  boolean valor = true;
  public  int v1x = 0, v1y =0, v2x = 0, v2y = 0, v3x = 0, v3y = 0;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public HelloMIDlet() {
    this.d = Display.getDisplay(this);
    this.c = new Command("Calcular", 7, 2);
    this.c1 = new Command("Calc", 4, 2);
    this.f = new Form("Triangulo");
    this.txt1 = new TextField("Vértice 1:", "", 30, 0);
    this.txt2 = new TextField("Vértice 2:", "", 30, 0);
    this.txt3 = new TextField("Vértice 3:", "", 30, 0);
    
    this.f.append(this.txt1);
    this.f.append(this.txt2);
    this.f.append(this.txt3);
    
    this.f.addCommand(this.c);
    this.f.setCommandListener(this);
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|





    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        this.d.setCurrent(this.f);
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Item item) { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void commandAction(Command c, Displayable d) {
        Alert message;
        if(c == this.c){
            if(txt1.getString().indexOf(',')== -1 || txt1.getString().indexOf(',') ==  (txt1.getString().length()-1)){
                message = new Alert("Error");
                message.setString("Ingrese correctamente el vértice 1. Ejemplo: 1,2");
                message.setTimeout(Alert.FOREVER);
                this.d.setCurrent(message);
            }
            else if(txt2.getString().indexOf(',')==-1 || txt2.getString().indexOf(',') ==  (txt2.getString().length()-1)){
                message = new Alert("Error");
                message.setString("Ingrese correctamente el vértice 2. Ejemplo: 1,2");
                message.setTimeout(Alert.FOREVER);
                this.d.setCurrent(message);
            }
            else if(txt3.getString().indexOf(',')==-1 || txt3.getString().indexOf(',') ==  (txt3.getString().length()-1)){
                message = new Alert("Error");
                message.setString("Ingrese correctamente el vértice 3. Ejemplo: 1,2");
                message.setTimeout(Alert.FOREVER);
                this.d.setCurrent(message);
            }
            else{
                System.out.println("coma = "+txt1.getString().indexOf(',')+"  tamaño = "+txt1.getString().length());
                crearTriangulo();
            }
        }
    }
    public void crearTriangulo(){
       
        v1x = Integer.parseInt(txt1.getString().substring(0, txt1.getString().indexOf(',')));
        v1y = Integer.parseInt(txt1.getString().substring(txt1.getString().indexOf(',')+1,txt1.getString().length()));
        
        v2x = Integer.parseInt(txt2.getString().substring(0, txt2.getString().indexOf(',')));
        v2y = Integer.parseInt(txt2.getString().substring(txt2.getString().indexOf(',')+1,txt2.getString().length()));
        
        v3x = Integer.parseInt(txt3.getString().substring(0, txt3.getString().indexOf(',')));
        v3y = Integer.parseInt(txt3.getString().substring(txt3.getString().indexOf(',')+1,txt3.getString().length()));
        
        /*
        System.out.println("v1 = "+v1x+","+v1y);
        System.out.println("v2 = "+v2x+","+v2y);
        System.out.println("v3 = "+v3x+","+v3y);
        */
        this.f.deleteAll(); 
        Display.getDisplay (this).setCurrent(new DrawingDemoCanvas ());
        
    }
    class DrawingDemoCanvas extends Canvas {
        protected void paint(Graphics g) {
             g.setColor(0, 0, 0);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(0,0,255);
             g.drawLine((getWidth()/2)+(v1x*10),(getHeight()/2)+(v1y*10), (getWidth()/2)+(v2x*10), (getHeight()/2)+(v2y*10));
             g.drawLine((getWidth()/2)+(v2x*10), (getHeight()/2)+(v2y*10), (getWidth()/2)+(v3x*10), (getHeight()/2)+(v3y*10));
             g.drawLine((getWidth()/2)+(v3x*10), (getHeight()/2)+(v3y*10), (getWidth()/2)+(v1x*10), (getHeight()/2)+(v1y*10));
            }
        }
    
}
