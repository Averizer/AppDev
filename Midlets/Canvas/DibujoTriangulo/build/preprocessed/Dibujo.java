import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;
public class Dibujo extends MIDlet implements CommandListener {
	Display d;
	Command c;
	Pinta p;
	public Dibujo(){
		d=Display.getDisplay(this);
		c=new Command("Salir", Command.SCREEN,2);
		p=new Pinta();
		p.addCommand(c);
		p.setCommandListener(this);
	}
	public void startApp(){
		d.setCurrent(p);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	public void commandAction(Command co,Displayable di){
		if(c==co){
			destroyApp(false);
			notifyDestroyed();
		}
	}
}

class Pinta extends Canvas{
	public void paint(Graphics g){
            
                int x1,G,f,y1,y2,x2,x3,y3,x4,y4,n, aux,aux1,aux2,aux3,aux4;
                Random rnd = new Random();
                x1=225;
                y1=210;
                x2=0;
                y2=210;
                x3=112;
                y3=0;
                x4=25;
                y4=35;
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(10,200,50);
		//g.drawLine(500,getHeight()/2,500,500);
             //   g.drawRect(100,100,150,150);
                g.fillRect(x4,y4,2,2);
                g.fillRect(x2,y2,2,2);
                g.fillRect(x3,y3,2,2);
                g.fillRect(x1,y1,2,2);
                
                
             
                for(aux=1;aux<1000000;aux++){
                int i = rnd.nextInt(3) + 1;
               if(i==1){
                 aux1=(x1+x4)/2;
                 aux2=(y1+y4)/2;
                 g.fillRect(aux1,aux2,2,2); 
                 x4=aux1;
                 y4=aux2;
               }
                if(i==2){
                 aux1=(x2+x4)/2;
                 aux2=(y2+y4)/2;
                 g.fillRect(aux1,aux2,2,2); 
                 x4=aux1;
                 y4=aux2;
               }
                 if(i==3){
                 aux1=(x3+x4)/2;
                 aux2=(y3+y4)/2;
                 g.fillRect(aux1,aux2,2,2); 
                 x4=aux1;
                 y4=aux2;
               }
               }
                
}
                
               // g.fillRect(getWidth()/2, getHeight()/2,1,1);
                
	}
