 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */

package graphices;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author sami
 */
public class MoveManager implements KeyListener {
    
    /** Creates a new instance of MoveManager */
    public MoveManager(Transform3D trans) {
        this.trans=trans;
        v=trans.getLocation();
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==UP) {
            v.setTo(v.x,v.y,v.z+10);
        } else if(e.getKeyCode()==DOWN) {
            v.setTo(v.x,v.y,v.z-10);
        } else if(e.getKeyCode()==e.VK_ESCAPE) {
            System.exit(0);// Exit the Game and Close all Connections
        } else if(e.getKeyChar()=='w') {
            trans.rotateAngleX(0.01f);
        } else if (e.getKeyChar()=='s') {
            trans.rotateAngleX(-0.01f);
        } else if(e.getKeyChar()=='e') {
            trans.rotateAngleY(0.01f);
        } else if(e.getKeyChar()=='d') {
            trans.rotateAngleY(-0.01f);
        } else if(e.getKeyChar()=='q') {
            trans.rotateAngleZ(0.01f);
        } else if(e.getKeyChar()=='a') {
            trans.rotateAngleZ(-0.01f);
        }
        e.consume();
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    private final int UP=38;
    private final int DOWN=40;
    private Transform3D trans;
    private Vector3D v;
}
 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */