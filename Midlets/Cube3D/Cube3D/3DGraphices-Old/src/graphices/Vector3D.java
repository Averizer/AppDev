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
public class Vector3D {
    
    /** Creates a new instance of Vector3D */
    
    public float x;
    public float y;
    public float z;
    public float oldX;
    public float oldY;
    
    
    /**
     * Creates a new Vector3D at (0,0,0).
     */
    public Vector3D() {
        this(0,0,0);
    }
    
    
    /**
     * Creates a new Vector3D with the same values as the
     * specified Vector3D.
     */
    public Vector3D(Vector3D v) {
        this(v.x, v.y, v.z);
    }
    
    
    /**
     * Creates a new Vector3D with the specified (x, y, z) values.
     */
    public Vector3D(float x, float y, float z) {
        setTo(x, y, z);
    }
    
    
    /**
     * Checks if this Vector3D is equal to the specified Object.
     * They are equal only if the specified Object is a Vector3D
     * and the two Vector3D's x, y, and z coordinates are equal.
     */
    public boolean equals(Object obj) {
        Vector3D v = (Vector3D)obj;
        return (v.x == x && v.y == y && v.z == z);
    }
    
    
    /**
     * Checks if this Vector3D is equal to the specified
     * x, y, and z coordinates.
     */
    public boolean equals(float x, float y, float z) {
        return (this.x == x && this.y == y && this.z == z);
    }
    
    
    /**
     * Sets the vector to the same values as the specified
     * Vector3D.
     */
    public void setTo(Vector3D v) {
        setTo(v.x, v.y, v.z);
    }
    
    
    /**
     * Sets this vector to the specified (x, y, z) values.
     */
    public void setTo(float x, float y, float z) {
        
        this.x =x;
        this.y =y;
        this.z = z;
        System.out.println("--------X=  "+x+"  Y="+y+" Z "+z );
    }
    
    
    /**
     * Adds the specified (x, y, z) values to this vector.
     */
    public void add(float x, float y, float z) {
        this.x+=x;
        this.y+=y;
        this.z+=z;
        oldX=x;
        oldY=y;
    }
    
    
    /**
     * Subtracts the specified (x, y, z) values to this vector.
     */
    public void subtract(float x, float y, float z) {
        add(-x, -y, -z);
    }
    
    
    /**
     * Adds the specified vector to this vector.
     */
    public void add(Vector3D v) {
        add(v.x, v.y, v.z);
    }
    
    
    /**
     * Subtracts the specified vector from this vector.
     */
    public void subtract(Vector3D v) {
        add(-v.x, -v.y, -v.z);
    }
    
    
    /**
     * Multiplies this vector by the specified value. The new
     * length of this vector will be length()*s.
     */
    public void multiply(float s) {
        x*=s;
        y*=s;
        z*=s;
        oldX=x;
        oldY=y;
    }
    
    
    /**
     * Divides this vector by the specified value. The new
     * length of this vector will be length()/s.
     */
    public void divide(float s) {
        x/=s;
        y/=s;
        z/=s;
        oldX=x;
        oldY=y;
    }
    
    
    /**
     * Returns the length of this vector as a float.
     */
    public float length() {
        return (float)Math.sqrt(x*x + y*y + z*z);
    }
    
    
    /**
     * Converts this Vector3D to a unit vector, or, in other
     * words, a vector of length 1. Same as calling
     * v.divide(v.length()).
     */
    public void normalize() {
        divide(length());
    }
    
    
    /**
     * Converts this Vector3D to a String representation.
     */
    /**
     * Rotate this vector around the x-axis the specified amount,
     * using precomputed cosine and sine values of the angle to
     * rotate.
     */
    public void rotateX(float cosAngle, float sinAngle) {
        float newY = y*cosAngle - z*sinAngle;
        float newZ = y*sinAngle + z*cosAngle;
        y = newY;
        z = newZ;
        
    }
    
    
    /**
    Rotate this vector around the y-axis the specified amount,
    using precomputed cosine and sine values of the angle to
    rotate.
     */
    public void rotateY(float cosAngle, float sinAngle) {
        float newX = z*sinAngle + x*cosAngle;
        float newZ = z*cosAngle - x*sinAngle;
        x = newX;
        z = newZ;
        
    }
    
    
    /**
    Rotate this vector around the y-axis the specified amount,
    using precomputed cosine and sine values of the angle to
    rotate.
     */
    public void rotateZ(float cosAngle, float sinAngle) {
        float newX = x*cosAngle - y*sinAngle;
        float newY = x*sinAngle + y*cosAngle;
        x = newX;
        y = newY;
        
        System.out.println(" X= "+x+" Y="+y);
    }
    
    
    /**
    Adds the specified transform to this vector. This vector
    is first rotated, then translated.
     */
    public void add(Transform3D xform) {
        
        // rotate
        addRotation(xform);
        
        // translate
        add(xform.getLocation());
    }
    
    
    /**
    Subtracts the specified transform to this vector. This
    vector is translated, then rotated.
     */
    public void subtract(Transform3D xform) {
        
        // translate
        subtract(xform.getLocation());
        
        // rotate
        subtractRotation(xform);
    }
    
    
    /**
    Rotates this vector with the angle of the specified
    transform.
     */
    public void addRotation(Transform3D xform) {
        rotateX(xform.getCosAngleX(), xform.getSinAngleX());
        rotateZ(xform.getCosAngleZ(), xform.getSinAngleZ());
        rotateY(xform.getCosAngleY(), xform.getSinAngleY());
    }
    
    
    /**
    Rotates this vector with the opposite angle of the
    specified transform.
     */
    public void subtractRotation(Transform3D xform) {
        // note that sin(-x) == -sin(x) and cos(-x) == cos(x)
        rotateY(xform.getCosAngleY(), -xform.getSinAngleY());
        rotateZ(xform.getCosAngleZ(), -xform.getSinAngleZ());
        rotateX(xform.getCosAngleX(), -xform.getSinAngleX());
    }
    
    
    
}
 /*
  *   *       Please Visit us at www.codemiles.com     *
  *  This Program was Developed by www.codemiles.com forums Team
  *  *           Please Don't Remove This Comment       *
  */