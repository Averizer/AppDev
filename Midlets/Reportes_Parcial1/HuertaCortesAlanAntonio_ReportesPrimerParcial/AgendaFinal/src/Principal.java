import javax.microedition.lcdui.*; 
import javax.microedition.midlet.*; 
public class Principal extends MIDlet implements CommandListener{
	Display d; 
	Forma f; 
	Editar e;
	ListaContactos lc;
	ListaFotos lf;
	public Principal() {
		d = Display.getDisplay(this); 
		f = new Forma(this); 
		lc = new ListaContactos(this);
		lf = new ListaFotos(this);
		e = new Editar(this);
	} 
	public void startApp() {
	     d.setCurrent(f); 
	} 
	public void pauseApp() {} 
	public void destroyApp(boolean x) {} 
	public void commandAction (Command co, Displayable di){ }
} 
