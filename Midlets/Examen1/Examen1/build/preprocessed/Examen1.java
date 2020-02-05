
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;

public class Examen1 extends MIDlet implements CommandListener {

    Display d;
    Command c, c2;
    public Pinta p;

    public Examen1() {
        d = Display.getDisplay(this);
        c = new Command("Especificaciones", Command.SCREEN, 1);
        c2 = new Command("Regresar", Command.BACK, 2);
        p = new Pinta();
        p.addCommand(c);
        p.addCommand(c2);
        p.setCommandListener(this);
    }

    public void startApp() {
        d.setCurrent(p);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Displayable d) {
        if (c == co) {
            destroyApp(false);
            notifyDestroyed();
        }
        if (c2 == co) {

        }

    }
}

class Pinta extends Canvas {

    public void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(255, 0, 0);
        g.drawRect(1, 32, getWidth() - 3, getHeight() - 63);
        g.setColor(0, 0, 255);
        g.drawArc(1, 32, getWidth() - 3, getHeight() - 63, 0, 360); //x,y,ancho,alto,startangulo,endangulo
        
        g.drawLine(1, 32, getWidth()-3, getHeight()-32);
        g.drawLine(1, getHeight()-32, getWidth()-3, 32);
        
        
        
        g.setColor(255, 0, 0);
        g.drawRect(1, 32, getWidth() - 3, getHeight() - 63);
        g.setColor(0, 0, 255);
        g.drawArc(1, 32, getWidth() - 3, getHeight() - 63, 0, 360); //x,y,ancho,alto,startangulo,endangulo

        //System.out.println("El ancho es: " + getWidth() + " El alto es: " + getHeight());  // 240 y 302

    }

}
