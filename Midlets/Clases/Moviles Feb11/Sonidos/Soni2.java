import javax.microedition.midlet.*; 
import javax.microedition.lcdui.*; 
import javax.microedition.media.*; 
import javax.microedition.media.control.*; 
import java.io.*; 
public class Sonido extends MIDlet implements CommandListener { 
	Display	d;  
	Form	f;  
	Command	c;  
	Command wav, nota, secuencia;  
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
	public void startApp() { 
		d.setCurrent(f); 
	} 
	public void pauseApp() {} 
	public void destroyApp(boolean unconditional) {} 
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
			InputStream in = getClass().getResourceAsStream("/explosion.wav"); 
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
