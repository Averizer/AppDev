import javax.microedition.lcdui.*;
import java.util.Vector;
public class ListaContactos extends List implements CommandListener {
    Command register,delete,edit;
    Principal p; 
    Vector eliminados = new Vector();
    public ListaContactos(Principal mid){
        super("Contactos",Choice.IMPLICIT);
        p = mid;
        register = new Command("Registrar", Command.EXIT, 1); 
        delete = new Command("Eliminar", Command.EXIT, 1); 
        edit = new Command("Editar", Command.EXIT, 1); 
        addCommand(register); 
        setCommandListener(this); 
        addCommand(delete); 
        setCommandListener(this); 
        addCommand(edit); 
        setCommandListener(this); 
   }
    public void commandAction(Command co, Displayable d) {
        if (co == register) { 
            p.d.setCurrent(p.f);
        }
        if (co == delete) { 
            delete();
        }
        if (co == edit) { 
            edit();
        }
    }
    public void constructList(){
        try{
        deleteAll();
        RMSOps rmso = new RMSOps();
        rmso.abrir("ZonaJavaZone");
        for(int i=1;i<=rmso.rs.getNumRecords();i++){
            String datos [] = new String[6];
            String find = ""+(i-1);
            if(eliminados.indexOf(find) == -1){
                datos = rmso.listarRegistro(i);
                System.out.println("Foto:"+datos[0]);
                Image imagen = Image.createImage(datos[0]);
                append(datos[1]+" "+datos[2],imagen);
            }                     
        }
        rmso.cerrar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void delete(){
        try{

            for(int i = 1;i<size();i++){
                if(isSelected(i)){
                    String find = ""+i;
                    eliminados.addElement(findtodelete(find));                  
                }
            }
            constructList();
            p.d.setCurrent(p.f);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void edit(){
        try{
            String f = "";
            for(int i = 1;i<size();i++){
                if(isSelected(i)){
                    String find = ""+i;
                    f = findtodelete(find);
                }
            }
            p.e.setData((Integer.valueOf(f)).intValue()+1);
            p.d.setCurrent(p.e);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     public String findtodelete(String find){
         try{
            RMSOps rmso = new RMSOps();
            rmso.abrir("ZonaJavaZone");
            int findindice = (Integer.valueOf(find)).intValue();
            int counter = 0;
            for(int i = 1;i<rmso.rs.getNumRecords();i++){
                String finds = ""+i;
                if(eliminados.indexOf(finds)==-1){
                    counter++;
                }
                if(counter == findindice){
                    return i+"";
                }
            }
            rmso.cerrar();
         }catch(Exception e){
             e.printStackTrace();
         }
         return 0+"";
     }
}
