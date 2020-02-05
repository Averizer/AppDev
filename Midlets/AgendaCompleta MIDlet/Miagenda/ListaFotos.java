import javax.microedition.lcdui.*;
import java.util.Vector;
import javax.microedition.lcdui.Image;
public class ListaFotos extends List implements CommandListener{
    Command ok;
    Principal p; 
    public ListaFotos(Principal mid) {
        super("Galeria", Choice.EXCLUSIVE);
        p = mid;
        ok = new Command("OK", Command.OK, 1); 
        addCommand(ok); 
        setCommandListener(this);
        try{
        append("Foto 1",Image.createImage("1.jpg"));
        append("Foto 2",Image.createImage("2.jpg"));
        append("Foto 3",Image.createImage("3.jpg"));
        append("Foto 4",Image.createImage("4.png"));
        append("Foto 5",Image.createImage("5.png"));
        append("Foto 6",Image.createImage("6.jpg"));
        append("Foto 7",Image.createImage("7.jpg"));
        append("Foto 8",Image.createImage("8.png"));
        append("Foto 9",Image.createImage("9.png"));
        append("Foto 10",Image.createImage("10.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void commandAction(Command cg, Displayable d) {
        if(cg == ok){
            String img = "";
            int imagen = getSelectedIndex();
            switch(imagen){
                case 0: img = "1.jpg"; break;
                case 1: img = "2.jpg"; break;
                case 2: img = "3.jpg"; break;
                case 3: img = "4.png"; break;
                case 4: img = "5.png"; break;
                case 5: img = "6.jpg"; break;
                case 6: img = "7.jpg"; break;
                case 7: img = "8.png"; break;
                case 8: img = "9.png"; break;
                case 9: img = "10.jpg"; break;
                default: img = "5.png"; break;
            }
            p.f.foto = img;
            p.d.setCurrent(p.f);
        }
    }
}
