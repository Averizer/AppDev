/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author AlanAntonio
 */
public class ListME extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    public static final int CONECTAR = 0;
    public static final int ESTADO = 1;
    public static final int INSERTAR = 2;
    public static final int DESCONECTAR = 3;
    public static final int MENU = 4;
    private Display d;
    private List l;
    private TextBox tb;
    private Form f;
    private TextField ts;
    private TextField tf;
    private ChoiceGroup cr;
    private Command cs;
    private Command cc;
    private int n;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The ListME constructor.
     */
    public ListME() {
        n = MENU;
        d = Display.getDisplay(this);
        ts = new TextField("Servidor:", "", 10, TextField.URL);
        tb = new TextBox("Estado", "Sin Conexion", 400, TextField.ANY);
        tf = new TextField("Area ID", "0", 10, TextField.NUMERIC);
        cr = new ChoiceGroup("Riesgo:", ChoiceGroup.EXCLUSIVE);
        cr.append("Bajo", null);
        cr.append("Normal", null);
        cr.append("Alto", null);
        l = new List("Seleccionar opción:", List.EXCLUSIVE);
        l.append("Conectar", null);
        l.append("Solicitar Datos", null);
        l.append("Ingresar Datos", null);
        l.append("Desconectar", null);
        f = new Form("Menu Conectar");
        cs = new Command("Salir", Command.SCREEN, 3);
        cc = new Command("Continuar", Command.SCREEN, 1);
        l.addCommand(cc);
        l.addCommand(cs);
        l.setCommandListener(this);
        f.addCommand(cc);
        f.addCommand(cs);
        f.setCommandListener(this);
        tb.addCommand(cs);
        tb.setCommandListener(this);

    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
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
    public void startApp() {
        d.setCurrent(l);

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

    public void commandAction(Command co, Displayable di) {
        if (n == MENU) {

            if (co == cs) {
                destroyApp(true);
                notifyDestroyed();
            } else if (co == cc) {
                switch (l.getSelectedIndex()) {
                    case CONECTAR:
                        conectar();
                        break;
                    case ESTADO:
                        listar();
                        break;
                    case INSERTAR:
                        insertar();
                        break;
                    case DESCONECTAR:
                        desconectar();
                        break;
                }
            }
            d.setCurrent(new Alert("", "Otro comando digitado...", null,
                    AlertType.ERROR));
        } else {
            if (co == cs) {
                muestraMenu();
            } else if (co == cc) {
                switch (n) {
                    case CONECTAR:
                        listar();
                        break;
                    case ESTADO:
                        muestraMenu();
                        break;
                    case INSERTAR:
                        listar();
                        break;
                    case DESCONECTAR:
                        muestraMenu();
                        break;
                }
            }
            d.setCurrent(new Alert("", "Otro comando digitado...", null,
                    AlertType.ERROR));
        }
    }

    public void conectar() {
        n = CONECTAR;
        f.setTitle("Menu Conectar");
        while (f.size() > 0) {
            f.delete(0);
        }
        f.append(ts);
        d.setCurrent(f);
    }

    public void insertar() {
        n = INSERTAR;
        f.setTitle("Menu Insertar");
        while (f.size() > 0) {
            f.delete(0);
        }
        f.append(tf);
        f.append(cr);
        d.setCurrent(f);
    }

    public void desconectar() {
        d.setCurrent(new Alert("Desconectar", "No está conectado a un servidor.",
                null, AlertType.ERROR));
        n = DESCONECTAR;
        n = MENU;
    }

    public void listar() {
        n = ESTADO;
        d.setCurrent(tb);
    }

    public void muestraMenu() {
        n = MENU;
        d.setCurrent(l);
    }

}
