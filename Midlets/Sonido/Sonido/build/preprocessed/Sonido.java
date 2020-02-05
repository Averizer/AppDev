/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import java.io.*;

/**
 * @author AlanAntonio
 */
public class Sonido extends MIDlet implements CommandListener {

    Display d;
    Form f;
    Command c;
    Command wav, nota, secuencia;
    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The Sonido constructor.
     */
    public Sonido() {
        d	= Display.getDisplay(this); 
		c	= new Command("Salir", Command.EXIT, 1); 
		wav	= new Command("Wav", Command.SCREEN, 2); 
		nota	= new Command("Nota", Command.SCREEN, 2); 
		secuencia = new Command("Secuencia", Command.SCREEN, 2); 
		f	= new Form("Reproducir."); 
		f.addCommand(c); 
		f.addCommand(wav); 
		f.addCommand(nota); 
		f.addCommand(secuencia); 
		f.setCommandListener(this); 
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
        d.setCurrent(f);
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
		if (co == c) {  
			destroyApp(false); 
			notifyDestroyed(); 
		}else{
			if (co == wav)
				playWav(); 
			if (co == nota)
				playNota(); 
			if (co == secuencia) 
				playSecuencia(); 
		} 
	} 
	public void playWav(){
		try { 
			InputStream in = getClass().getResourceAsStream("/risas.wav"); 
			Player p = Manager.createPlayer(in, "audio/x-wav"); 
			p.start(); 
		}catch (Exception e){
			Alert alr = new Alert("Error", "No se reproduce sonido.", null, AlertType.ERROR);
			alr.setTimeout(Alert.FOREVER); 
			d.setCurrent(alr, f); 
		} 
	} 
	public void playNota(){ 
		try {
			Manager.playTone(ToneControl.C4, 100, 80);  
		}catch (Exception e){} 
	} 
	public void playSecuencia() { 
		byte tempo = 30; 
		byte d = 8; 
		byte C4 = ToneControl.C4; // Nota DO
		byte D4 = (byte)(C4 + 2);
		byte E4 = (byte)(C4 + 4); 
		byte F4 = (byte)(C4 + 5); 
		byte G4 = (byte)(C4 + 7); 
		byte silencio = ToneControl.SILENCE; 
		byte[] secuencia = { 
		ToneControl.VERSION, 1, ToneControl.TEMPO, tempo, 
		ToneControl.BLOCK_START, 0, C4,d, F4,d, F4,d, C4,d, F4,d, F4,d, C4,d, F4,d, 
		ToneControl.BLOCK_END, 0,    
		ToneControl.BLOCK_START, 1, C4,d, E4,d, E4,d, C4,d, E4,d, E4,d, C4,d, E4,d, 
		ToneControl.BLOCK_END, 1,
		ToneControl.PLAY_BLOCK, 0,   
		ToneControl.PLAY_BLOCK, 1,   
		ToneControl.PLAY_BLOCK, 0,   
			};
		try{ 
			Player p = Manager.createPlayer(Manager.TONE_DEVICE_LOCATOR); 
			p.realize(); 
			ToneControl c = (ToneControl)p.getControl("ToneControl"); 
			c.setSequence(secuencia); 
			p.start(); 
		} catch (IOException ioe) {}
		catch (MediaException me) {} 
	}

}
