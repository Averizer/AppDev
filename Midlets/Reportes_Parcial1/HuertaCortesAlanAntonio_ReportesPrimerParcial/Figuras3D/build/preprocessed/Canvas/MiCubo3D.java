package Canvas;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MiCubo3D extends MIDlet {
    Perspectiva f;
    Display d;
    
    public MiCubo3D(){
        d=Display.getDisplay(this);
        f=new Perspectiva();
    }
    
    public void startApp() {
        d.setCurrent(f);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
