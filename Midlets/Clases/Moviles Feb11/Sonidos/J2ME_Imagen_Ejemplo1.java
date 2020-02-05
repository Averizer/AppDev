import javax.microedition.lcdui.*;
public class Imagen extends Canvas implements CommandListener {
    private MoverImagen mi;
    private Image im;
    private Command c;
    private int x, y;
    public Imagen(MoverImagen mid) {
        c = new Command("Salir", Command.EXIT, 1);
        this.mi = mid;
        this.addCommand(c);
        this.setCommandListener(this);
        try {						// Carpeta para la imagen, por ejemplo:
            im = Image.createImage("/foto.png");	//...\NetBeansProjects\MiProyecto\build\compiled\foto.png
        } catch (Exception e) {
            // System.out.println("Error al cargar archivo de imagen");
        }
        x = y = 0;
    }
    public void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(0, 0, 0);
        g.drawImage(im, x, y, Graphics.TOP|Graphics.LEFT);
    }
    protected void keyPressed(int keyCode) {
        switch (getGameAction(keyCode)) {
            case Canvas.DOWN: {
                if ((y + 20) < getHeight()) {
                    y = y + 1;
                }
                break;
            }
            case Canvas.LEFT: {
                if (x > 0) {
                    x = x - 1;
                }
                break;
            }
            case Canvas.UP: {
                if (y > 0) {
                    y = y - 1;
                }
                break;
            }
            case Canvas.RIGHT: {
                if ((x + 20) < getWidth()) {
                    x = x + 1;
                }
                break;
            }
        }
        this.repaint();
    }
    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            mi.salir();
        }
    }
}

/*
//////////////////////////////////////
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class MoverImagen extends MIDlet {
    private Imagen img;
    private Display d;
    public MoverImagen() {
        d = Display.getDisplay(this);
        img = new Imagen(this);
    }
    public void startApp() {
        d.setCurrent(img);
    }
    public void pauseApp() {    }
    public void destroyApp(boolean b) {    }
    public void salir() {
        destroyApp(false);
        notifyDestroyed();
    }
}
*/