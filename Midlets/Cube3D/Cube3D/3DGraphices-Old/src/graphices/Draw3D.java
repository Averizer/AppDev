 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */

package graphices;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 *
 * @author mohamed
 */
public class Draw3D {
    
    /** Creates a new instance of Draw3D */
    public Draw3D(int width,int height,Transform3D transformer,ViewWindow window) {
        this.width=width;
        this.height=height;
        this.transformer=transformer;
        this.window=window;
    }
    
    public void draw3D(Graphics2D g,ArrayList polygons) {
        draw_Background(g);//draw the background of the screen
        
        
        for(int k=0;k<polygons.size();k++) {
            drawPol.setTo(((Polygon3D)polygons.get(k)));
            
            
            Before_Draw(drawPol);//transform+Project to the polygon
            
            myPath=new GeneralPath();//every time there is a new GeneralPath shape
            
            
            temp=drawPol.getVertex(0);
            myPath.moveTo(temp.x,temp.y);
            
            for(int i=1;i<drawPol.getNumVertices();i++) {
                temp=drawPol.getVertex(i);
                myPath.lineTo(temp.x,temp.y);
                
            }
            temp=drawPol.getVertex(0);
            myPath.lineTo(temp.x,temp.y);
            
            
            g.setColor(polygons_colors[k]);
            g.draw(myPath);
        }
        
        
        
        
        
        
    }
    
    public void draw_Background(Graphics2D g ) {
        
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);
        
    }
    public void Before_Draw(Polygon3D polygon) {
        
        polygon.add(transformer);
        polygon.project(window);
    }
    
    private final int width;
    private final int height;
    private final Transform3D transformer;
    private final ViewWindow window;
    private Polygon3D drawPol=new Polygon3D();
    private  GeneralPath myPath;
    private Color[] polygons_colors=new Color[]{Color.RED,Color.YELLOW,Color.PINK,Color.GREEN,Color.WHITE,
    Color.orange,};
    private Vector3D temp;
}
 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */