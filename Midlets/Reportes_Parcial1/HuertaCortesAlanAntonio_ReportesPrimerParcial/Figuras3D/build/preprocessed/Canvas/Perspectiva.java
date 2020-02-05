package Canvas;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
class Perspectiva extends Canvas{
    
    Form f;
    int centerX=0, centerY=0, maxX=0, maxY=0, minMaxXY=0;
    int inicio = 0;
    int x,y;
    Obj obj = new Obj();
    
    public Perspectiva(){
        x=100;
        y=100;
        centerX = maxX/2;
	centerY = maxY/2;
    }
    
    int iX(float x){
	return centerX + (int)x;
    }
    int iY(float y){
    	return centerY - (int)y;
    }
    
    void line(Graphics g, int i, int j){
        Point2D p = obj.vScr[i], q = obj.vScr[j];
        g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
    }
    
    void arc(Graphics g, int i, int j){
        Point2D p = obj.vScr[i], q = obj.vScr[j];
        int xC = (iX(p.x) + iX(q.x))/2;
        int yC = (iX(p.y) + iX(q.y))/2;
    	int r = (int)Math.sqrt((iX(p.x)-xC)*(iX(p.x)-xC) + (iY(p.y)-yC)*(iY(p.y)-yC));
        int xl = xC-r;
        int yl = yC-r;
        int width = 2*r;
        int height = 2*r;
        int startAngle = (int) (180/Math.PI*TrigMath.atan2(iY(p.y)-yC, iX(p.x)-xC));
        int endAngle = (int) (180/Math.PI*TrigMath.atan2(iY(q.y)-yC, iX(q.x)-xC));
        g.drawArc(xl, yl, width, height, startAngle, endAngle + 90);
    } 
    public void paint(Graphics g) {
        g.setColor(0,0,0);
        g.fillRect(0, 0, getWidth(),getHeight());
        g.setColor(3,252,244);
        maxX=getWidth()-1; maxY=getHeight()-1; minMaxXY=Math.min(maxX,maxY);
	centerX = maxX/2;
	centerY = maxY/2;
	obj.d = obj.rho*minMaxXY/obj.objSize;
	obj.eyeAndScreen();
        line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
	line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores  
	line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
    }
    
    public void keyPressed(int keyCode){ // sustituye la interfaz de MouseListeer de la Java aplication
        if(keyCode == getKeyCode(DOWN))
            y-=2;
        if(keyCode == getKeyCode(RIGHT))
            x-=2;
        if(keyCode == getKeyCode(LEFT))
            x+=2;
        if(keyCode == getKeyCode(UP))
            y+=2;
        obj.theta   = (float) getWidth()/x;
	obj.phi     = (float) getHeight()/y;
	obj.rho     = (obj.phi/obj.theta)*getHeight();
	centerX     = x;
	centerY     = y;
	repaint();
    }
}
