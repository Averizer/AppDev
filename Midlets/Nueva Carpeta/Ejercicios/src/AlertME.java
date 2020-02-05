

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
public class AlertME extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private Display d;
    private Alert a;
    private Form f;
    private TextField tt;
    private TextField tx;
    private ChoiceGroup ct;
    private ChoiceGroup cg;
    private Gauge g;
    private Command cc;
    private Command cs;
    private int s = 2;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The AlertME constructor.
     */
    public AlertME() {
        d = Display.getDisplay(this);
        tt = new TextField("Titulo:", "Un título", 10, TextField.ANY);
        tx = new TextField("", "...texto del Alert...", 50, TextField.ANY);
        ct = new ChoiceGroup("Seleccionar tipo:", ChoiceGroup.EXCLUSIVE);
        ct.append("ALARM", null);
        ct.append("CONFIRMATION", null);
        ct.append("ERROR", null);
        ct.append("INFO", null);
        ct.append("WARNING", null);
        ct.setSelectedIndex(0, true);
        cg = new ChoiceGroup("Tiempo:", ChoiceGroup.EXCLUSIVE);
        cg.append("Forever", null);
        cg.append("Temporal", null);
        cg.setSelectedIndex(0, true);
        g = new Gauge("Gauge (min=0 max=20)", true, 20, s);
        f = new Form("Ejemplo Alert");
        f.append(tt);
        f.append(tx);
        f.append(ct);
        f.append(cg);
        f.append(g);
        cc = new Command("Continuar", Command.OK, 0);
        cs = new Command("Salir", Command.EXIT, 3);
        f.addCommand(cc);
        f.addCommand(cs);
        f.setCommandListener(this);
       // f.setItemStateListener((ItemStateListener) this);

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
        d.setCurrent(new Alert("", "En estado Activo", null, AlertType.ERROR));
        d.setCurrent(f);

    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        d.setCurrent(new Alert("", "En estado pausado...", null,
                AlertType.ERROR));

        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
        d.setCurrent(new Alert("", "En estado terminado.", null,
                AlertType.ERROR));

    }

    public void commandAction(Command co, Displayable di) {
        if (co == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else if (co == cc) {
            switch (ct.getSelectedIndex()) {
                case 0:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.ALARM);
                    break;
                case 1:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.CONFIRMATION);
                    break;

                case 2:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.ERROR);
                    break;
                case 3:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.INFO);
                    break;
                case 4:

                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.WARNING);
                    break;

                default:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.INFO);
            }
            if ((cg.getSelectedIndex() == 0) || (g.getValue() == 0)) {
                a.setTimeout(Alert.FOREVER);
            } else {
                a.setTimeout(g.getValue() * 1000);
            }
            d.setCurrent(a);
        } else {
            d.setCurrent(new Alert("", "Otro comando digitado...", null,
                    AlertType.ERROR));
        }

    }

    public void itemStateChanged(Item item) {
        if (item == cg) {
            if (cg.getSelectedIndex() == 0) {
                s = g.getValue();
                g.setValue(0);
            } else {
                g.setValue(s);
            }
        } else if (item == g) {
            if (g.getValue() == 0) {
                cg.setSelectedIndex(0, true);
            } else {
                cg.setSelectedIndex(1, true);
            }
        } else {
            d.setCurrent(new Alert("", "Otro item seleccionado...", null,
                    AlertType.ERROR));
        }
    }
}
