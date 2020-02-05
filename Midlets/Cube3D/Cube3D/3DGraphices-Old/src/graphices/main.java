 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */

package graphices;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class main extends JFrame{
    
    /** Creates a new instance of main */
    public main() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIgnoreRepaint(true);
        
        
        myDevice.setFullScreenWindow(this);
        myDevice.setDisplayMode(myMode);
        createBufferStrategy(2);
        addKeyListener(mover);
        setCursor( getToolkit().getDefaultToolkit().createCustomCursor(new ImageIcon(" ").getImage(),new Point(0,0)
        ,"invisble"));
        
        Loop();
        
    }
    
    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        main m= new main();
        
    }
    public void Loop() {
        BufferStrategy myBuffer=getBufferStrategy();
        while(true) {
            
            Graphics2D g=(Graphics2D)myBuffer.getDrawGraphics();
            draw(g) ;
            myBuffer=getBufferStrategy();
            g.dispose();
            
            myBuffer.show();
            try {
                
                
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    public void draw(Graphics2D g2d) {
        GeneralPath myP=new GeneralPath();
        
        
        
        
        myDrawer.draw3D(g2d,myCube.getPolygons());
        
        
        
        
        
        
        
        g2d.setColor(Color.WHITE);
        
        g2d.drawString("Press UP  /  DOWN / ESC ",20.0f,20.0f);
        g2d.drawString("Press  Q/A Rotation Z  ",20.0f,40.0f);
        g2d.drawString("Press  W/S Rotation X  ",20.0f,60.0f);
        g2d.drawString("Press  E/D Rotation Y  ",20.0f,80.0f);
        g2d.drawString("Shape: Cube  ",20.0f,100.0f);
        
    }
    private final int width=800;
    private final int height=600;
    private GraphicsEnvironment myenv=GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice myDevice=myenv.getDefaultScreenDevice();
    private DisplayMode myMode=new DisplayMode(width,height,32,DisplayMode.REFRESH_RATE_UNKNOWN);
    private Vector3D[] v=new Vector3D[]{new Vector3D(0, 0, 0),new Vector3D(100, 0, 0),new Vector3D(100, 150,0),new Vector3D(0, 150,0)};
    private Polygon3D myPol=new Polygon3D(v);
    private Polygon3D drawPol=new Polygon3D();
    private Transform3D trans=new Transform3D(0.0f,-100.0f,-400.0f);
    private ViewWindow myWindow=new ViewWindow(0,0,width,height,  (float)Math.toRadians(75));
    private MoveManager mover=new MoveManager(trans);
    private Draw3D myDrawer=new Draw3D(width,height,trans,myWindow);
    private Cube3D myCube=new Cube3D();
    
    
    
    
     /*
      *   *       Please Visit us at www.codemiles.com     *
      *  This Program was Developed by www.codemiles.com forums Team
      *  *           Please Don't Remove This Comment       *
      */
    
    
}
