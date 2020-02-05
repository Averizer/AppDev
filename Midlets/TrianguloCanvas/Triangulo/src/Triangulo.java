 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.Random;

/**
 * @author AlanAntonio
 */
public class Triangulo extends MIDlet implements CommandListener {

    Display d;
    Command c;
    Pinta p;

    private boolean midletPaused = false;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The Triangulo constructor.
     */
    public Triangulo() {
        d = Display.getDisplay(this);
        c = new Command("Salir", Command.SCREEN, 2);
        p = new Pinta();
        p.addCommand(c);
        p.setCommandListener(this);
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
    public void startApp() {
        d.setCurrent(p);
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

    public void commandAction(Command c, Displayable d) {

    }

}

class Pinta extends Canvas {

    int ejex, ejey;

    int[][] arreglo_vectores;			//Arreglo que contiene los puntos de los vectores
    int[] valores_vectores;		//Arreglo que contiene los puntos de las iteraciones recursivas 
    int contador = 1;								//Contador auxiliar que cuenta el numero de iteraciones
    String color;

    public Pinta() {

        valores_vectores = new int[10];
        
    }

    public void paint(Graphics g) {        

        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 1; i <= 3; i++) {
            arreglo_vectores = new int[i][i - 1];
        }
        //Vector 1	
        arreglo_vectores[0][0] = 120;

        arreglo_vectores[0][1] = 100;
        //Vector 2	

        arreglo_vectores[1][0] = 170;

        arreglo_vectores[1][1] = 186;
        //Vector 3	

        arreglo_vectores[2][0] = 70;

        arreglo_vectores[2][1] = 186;

        // Vertice 1
        //g.drawLine(UP, UP, UP, UP);
        g.setColor(255, 0, 0);
        g.drawLine(120, 100, 170, 186);
        //g.drawLine(675, 6, 317, 626);

        // Vertice 2
        g.setColor(0, 255, 0);
        g.drawLine(170, 186, 70, 186);

        // Vertice 3
        g.setColor(0, 0, 255);
        g.drawLine(70, 186, 120, 100);

        //punto P aleatorio
        // Punto aleatorio
        int x = punto_aleatoriox();
        int y = punto_aleatorioy();
        g.setColor(0, 0, 0);
       // g.drawString("Punto_P", x, y, 100);

        valores_vectores[contador] = x;
        valores_vectores[contador + 1] = y;

        int posicion_vector = vector_aleatorio();//Se obtiene de forma aleatoria cualquier vector

        for (int i = 1; i <= 10; i++) {

            posicion_vector = vector_aleatorio();//Se obtiene de forma aleatoria cualquier vector
            float nuevo_x = (float)((valores_vectores[contador] + arreglo_vectores[posicion_vector][1]) / 2); 		 //Punto medio entre puntos x
            float nuevo_y = (float)((valores_vectores[contador + 1] + arreglo_vectores[posicion_vector][2]) / 2); //Punto medio entre puntos x

            g.drawLine((int)nuevo_x, (int)nuevo_y, (int)nuevo_x + 1,(int) nuevo_y + 1);
            contador += 2;
            valores_vectores[contador] = (int) nuevo_x;
            valores_vectores[contador + 1] = (int)nuevo_y;
            //color = colores(posicion_vector);

        }
    }

    public int punto_aleatoriox() {

        Random random = new Random();
        
        int rango = (int)Math.floor(1 + random.nextInt() * 2);
        System.out.print(rango);
        int limite = 0;
        
        if (rango == 1) {
            limite = (int)Math.floor((random.nextInt() * 10) + 1);
        } else if (rango == 2) {
            limite = (int)Math.floor((random.nextInt() * 10) + 1);
        }
        return limite;
    }

    public int punto_aleatorioy() {
        Random random = new Random();
        return (int)Math.floor(1 + random.nextInt() * 10);
    }

    public int vector_aleatorio() {
        Random random = new Random();
        return (int)Math.floor(1 + random.nextInt() * 3);
    }

}
