import java.io.*;
import javax.microedition.lcdui.*;
  public class Editar extends Form implements CommandListener { 
      Command g, s;
      TextField nom, ape, tel, cel, dom; 
      Principal p; 
      Alert a;
      int id;
      public Editar(Principal mid) {
           super("Agenda"); 
            p = mid;
            nom = new TextField("Nombre:", "", 30, TextField.ANY);
            ape = new TextField("Apellido:", "", 30, TextField.ANY);
            tel = new TextField("Telefono:", "", 30, TextField.ANY);
            cel = new TextField("Celular:", "", 30, TextField .ANY);
            dom = new TextField("Domicilio:","", 30, TextField.ANY); 
            s = new Command("Cancelar", Command.EXIT, 1); 
            g = new Command("Guardar", Command.EXIT, 1); 
            append(nom); 
            append(ape); 
            append(tel); 
            append(cel); 
            append(dom); 
            addCommand(g); 
            addCommand(s);    
            setCommandListener(this);    
} 
public void commandAction(Command co, Displayable di) { 
    if (co == s) { 
        p.d.setCurrent(p.f); 
    }
    else if (co == g) {
        RMSOps rmso = new RMSOps();
        rmso.abrir("ZonaJavaZone"); 
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            DataOutputStream dos = new DataOutputStream(baos); 
            dos.writeUTF(p.f.foto); 
            dos.writeUTF(nom.getString()); 
            dos.writeUTF(ape.getString()); 
            dos.writeUTF(tel.getString()); 
            dos.writeUTF(cel.getString()); 
            dos.writeUTF(dom.getString()); 
            dos.close(); 
            rmso.editRegistro(baos,id);
            rmso.cerrar(); 
            } catch (Exception ioe) { 
                ioe.printStackTrace(); 
            }
            a = new Alert("NOTA", "Guardado", null, AlertType.CONFIRMATION); 
            a.setTimeout(5000);
            p.d.setCurrent(a, this);
            p.lc.constructList();
            p.d.setCurrent(p.lc);
            nom.setString("");
            ape.setString("");
            tel.setString("");
            cel.setString("");
            dom.setString(""); 
    } 
  }
    public void setData(int indice){
        String datos [] = new String[5];
        id = indice;
        
             try{
                RMSOps rmso = new RMSOps();
                rmso.abrir("ZonaJavaZone"); 
                datos = rmso.listarRegistro(indice);
                nom.setString(datos[1]);
                ape.setString(datos[2]);
                tel.setString(datos[3]);
                cel.setString(datos[4]);
                dom.setString(datos[5]);
                rmso.cerrar();
            }catch(Exception e){
                e.printStackTrace();
            }
    }

}
