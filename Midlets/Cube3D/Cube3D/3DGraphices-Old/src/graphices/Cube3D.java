 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */

package graphices;

import java. util.ArrayList;

/**
 *
 * @author mohamed
 */
public class Cube3D {
    
    /** Creates a new instance of Cube3D */
    public Cube3D() {
        create_cube();
    }
    
    public void create_cube() {
        
        temp=new Polygon3D(new Vector3D[]{
            new Vector3D(0,0,0),
            new Vector3D(100,0,0),
            new Vector3D(100,100,0),
            new Vector3D(0,100,0),
        });
        Polygons.add(temp);//add the Polygon to the cub
        
        temp=new Polygon3D(new Vector3D[]{
            new Vector3D(100,0,0),
            new Vector3D(100,0,-100),
            new Vector3D(100,100,-100),
            new Vector3D(100,100,0),
        });
        Polygons.add(temp);//add the Polygon to the cub
        
        temp=new Polygon3D(new Vector3D[]{
            new Vector3D(0,100,0),
            new Vector3D(0,100,-100),
            new Vector3D(0,0,-100),
            new Vector3D(0,0,0),
        });
        Polygons.add(temp);//add the Polygon to the cub
        
        temp=new Polygon3D(new Vector3D[]{
            new Vector3D(0,0,-100),
            new Vector3D(100,0,-100),
            new Vector3D(100,100,-100),
            new Vector3D(0,100,-100),
        });
        Polygons.add(temp);//add the Polygon to the cub
        
        temp=new Polygon3D(new Vector3D[]{
            new Vector3D(0,100,0),
            new Vector3D(100,100,0),
            new Vector3D(100,100,-100),
            new Vector3D(0,100,-100),
        });
        Polygons.add(temp);//add the Polygon to the cub
        
        
    }
    
    public ArrayList getPolygons() {
        return Polygons;
    }
    
    private ArrayList Polygons=new ArrayList();
    private Polygon3D temp;
    
}
 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */