
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ejercicio extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    Command c;
    Command ok,ventanaInicio;
    Display d;
    Form f;
    String sel, contacto[];
    TextField ingresar1, ingresar2, resultado,resultado2,s;
    TextBox tb;
    

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command screenCommand;
    private Command okCommand;
//</editor-fold>//GEN-END:|fields|0|

    public ejercicio() {
        d = Display.getDisplay(this);
        c = new Command("salir", Command.EXIT, 3);
        ok = new Command("Aceptar", Command.OK, 0);
        ventanaInicio = new Command("Regresar", Command.SCREEN, 1);
        f = new Form("Ejercicio 1");
        ingresar1 = new TextField("Ingrese Numero", "", 30, TextField.NUMERIC);
        ingresar2 = new TextField("Ingrese Palabra", "", 30, TextField.ANY);
        resultado = new TextField("Resultado", "", 50, TextField.ANY);
        resultado2 = new TextField("Resultado2", "", 50, TextField.ANY);
        tb = new TextBox("Secuencia","",500,TextField.ANY);
       // s= new TextField("Secuencia","",256,TextField.ANY);
        f.addCommand(c);
        f.addCommand(ok);
        f.append(ingresar1);
        f.append(ingresar2);
        f.append(resultado);
        //f.append(s);
        f.append(resultado2);
        f.setCommandListener(this);
         tb.addCommand(ventanaInicio);
         tb.setCommandListener(this);
       
       
        
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

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: screenCommand ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initialized instance of screenCommand component.
     *
     * @return the initialized component instance
     */
    public Command getScreenCommand() {
        if (screenCommand == null) {
//GEN-END:|17-getter|0|17-preInit
            // write pre-init user code here
screenCommand = new Command("Screen", Command.SCREEN, 0);//GEN-LINE:|17-getter|1|17-postInit
            // write post-init user code here
}//GEN-BEGIN:|17-getter|2|
        return screenCommand;
    }
//</editor-fold>//GEN-END:|17-getter|2|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here

            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|23-getter|1|23-postInit
            // write post-init user code here
}//GEN-BEGIN:|23-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|23-getter|2|

    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }


    public void startApp() {
        d.setCurrent(f);
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    public void pauseApp() {
        midletPaused = true;
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Displayable disp) {
       //try{
        if (co == ok) {

            FPMP fpmp = new FPMP();
            String a = fpmp.NumeroF(Integer.parseInt(ingresar1.getString()));
            String b = fpmp.palindromo(ingresar2.getString());

            resultado.setString(a);
            resultado2.setString(b);
            //s.setString(ingresar1.getString() + fpmp.cadena2);
            d.setCurrent(tb);
            
            tb.setString(ingresar1.getString() + " " + fpmp.cadena2);
        
            //Alert alerta = new Alert("", "OK", null, AlertType.INFO);
            //d.setCurrent(alerta);
            // alerta.setTimeout(2000);

        }
        if(co== ventanaInicio){
           
            d.setCurrent(f);
        }
      // }catch(Exception e){
         //  s.setString("");
       //    s.setString("");
       //}

        if (co == c) {
            destroyApp(false);
            notifyDestroyed();
        }
    }

}
