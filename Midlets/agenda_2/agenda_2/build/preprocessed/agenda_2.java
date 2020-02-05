import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author AlanAntonio
 */
public class agenda_2 extends MIDlet implements CommandListener {

    Command c;
    Command ventanaVer, ventanaNuevo, ventanaInicio, ventanaLista, guardar;
    Display d;
    Form f, ingresar;
    List lista;
    String sel, contacto[];
    TextField nombre, edad, email;
    ImageItem imgI, img;
    Image img2;
    DateField df;
    ChoiceGroup cg;
    int i, j;
    private boolean midletPaused = false;
    
    //Registros reg;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The agenda_2 constructor.
     */
    public agenda_2() {
        i = 0;
        d = Display.getDisplay(this);
        c = new Command("salir", Command.EXIT, 3);
        ventanaNuevo = new Command("Nvo contacto", Command.SCREEN, 2);
        guardar = new Command("Guardar", Command.SCREEN, 2);
        ventanaInicio = new Command("Regresar", Command.SCREEN, 3);
        ventanaVer = new Command("Ver", Command.OK, 0);
        ventanaLista = new Command("Mi agenda", Command.SCREEN, 0);
        try {
            img2 = Image.createImage("/mifoto.jpg");
        } catch (IOException ioe) {
            System.err.println("Error" + ioe);
        }
        imgI = new ImageItem("HOLA", img2, 1, "hola");
        f = new Form("Mi Agenda");
        ingresar = new Form("Nuevo contacto");
        contacto = new String[5];
        for (j = 0; j < 5; j++) {
            contacto[j] = "";
        }
        df = new DateField("creado", DateField.DATE_TIME);
        String sexo[] = {"Hombre", "Mujer"};
        cg = new ChoiceGroup("", List.EXCLUSIVE, sexo, null);
        nombre = new TextField("Nombre", "", 30, TextField.ANY);
        edad = new TextField("Edad", "", 30, TextField.NUMERIC);
        email = new TextField("E-mail", "", 30, TextField.EMAILADDR);
        ingresar.addCommand(ventanaInicio);
        ingresar.addCommand(guardar);
        ingresar.append(nombre);
        ingresar.append(edad);
        ingresar.append(email);
        ingresar.append(cg);
        ingresar.setCommandListener(this);
        f.addCommand(ventanaLista);
        f.addCommand(c);
        f.addCommand(ventanaNuevo);
        f.setCommandListener(this);
        
        //reg = new Registros ();
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
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() throws MIDletStateChangeException {
         
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Displayable disp) {
        if (co == ventanaNuevo) {
            d.setCurrent(ingresar);
        }
        if (co == ventanaLista) {
            d.setCurrent(lista);
        }
        if (co == guardar) {
            contacto[i] = nombre.getString();
            lista = new List("Contactos", List.IMPLICIT, contacto, null);
            lista.addCommand(c);
            lista.addCommand(ventanaNuevo);
            lista.addCommand(ventanaVer);
            lista.setCommandListener(this);
            Alert alerta = new Alert("", "contacto guardado", img2, AlertType.INFO);
            d.setCurrent(alerta);
            alerta.setTimeout(2000);
            i++;      
            
        }
        if (co == ventanaInicio) {
            if (cg.getSelectedIndex() == 0) {
                sel = "Hombre";
            } else {
                sel = "Mujer";
            }
            StringItem si = new StringItem("", "Nombre: " + nombre.getString() + "\nEdad: " + edad.getString() + "\nE-mail: " + email.getString() + "\n" + "Sexo: " + sel + "\n");
            f.append(si);
            d.setCurrent(lista);
        }
        if (co == ventanaVer) {
            System.out.println("OPCION" + lista.getSelectedIndex());
            d.setCurrent(f);
        }
        if (co == c) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
