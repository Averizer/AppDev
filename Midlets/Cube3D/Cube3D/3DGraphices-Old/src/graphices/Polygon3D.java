 /*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */

package graphices;

/**
 *
 * @author user
 */
public class Polygon3D {
    
    /** Creates a new instance of Polygon3D */
     private Vector3D[] v;
    private int numVertices;

    /**
        Creates an empty polygon that can be used as a "scratch"
        polygon for transforms, projections, etc.
    */
    public Polygon3D() {
        numVertices = 0;
        v = new Vector3D[0];
    }


    /**
       Creates a new Polygon3D with the specified vertices.
    */
    public Polygon3D(Vector3D v0, Vector3D v1, Vector3D v2) {
        this(new Vector3D[] { v0, v1, v2 });
    }


    /**
        Creates a new Polygon3D with the specified vertices. All
        the vertices are assumed to be in the same plane.
    */
    public Polygon3D(Vector3D v0, Vector3D v1, Vector3D v2,
        Vector3D v3)
    {
        this(new Vector3D[] { v0, v1, v2, v3 });
    }


    /**
        Creates a new Polygon3D with the specified vertices. All
        the vertices are assumed to be in the same plane.
    */
    public Polygon3D(Vector3D[] vertices) 
    {
        this.v = vertices;
        numVertices = vertices.length;
    }


    /**
        Sets this polygon to the same vertices as the specified
        polygon.
    */
    public void setTo(Polygon3D polygon) 
    {
        numVertices = polygon.numVertices;

        ensureCapacity(numVertices);
        for (int i=0; i<numVertices; i++) {
            v[i].setTo(polygon.v[i]);
        }
    }


    /**
        Ensures this polygon has enough capacity to hold the
        specified number of vertices.
    */
    protected void ensureCapacity(int length)
    {
        if (v.length < length) {
            System.out.println("GA");
            Vector3D[] newV = new Vector3D[length];
            System.arraycopy(v,0,newV,0,v.length);
            for (int i=v.length; i<newV.length; i++) {
                newV[i] = new Vector3D();
            }
            v = newV;
        }
    }


    /**
        Gets the number of vertices this polygon has.
    */
    public int getNumVertices() {
        return numVertices;
    }


    /**
        Gets the vertex at the specified index.
    */
    public Vector3D getVertex(int index) {
        return v[index];
    }


    /**
        Projects this polygon onto the view window.
    */
    public void project(ViewWindow view) 
    {
        System.out.println("numVertices ="+numVertices);
        for (int i=0; i<numVertices; i++) {
            view.project(v[i]);
        }
    }
    public void add(Transform3D trans)
    {
        for(int i=0;i<numVertices;i++)
        {
            v[i].add(trans);
        }
    }
     

    protected Object clone() throws CloneNotSupportedException
    {
        return new Polygon3D(v);
    }
    
}
 /*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */