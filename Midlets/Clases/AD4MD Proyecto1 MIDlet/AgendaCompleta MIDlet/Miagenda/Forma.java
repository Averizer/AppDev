import java.io.*;
import javax.microedition.lcdui.*;
  public class Forma extends Form implements CommandListener { 
      Command g, s, lista,select;
      TextField nom, ape, tel, cel, dom; 
      Principal p; 
      Alert a; 
      String foto = "0.png";
      public Forma(Principal mid) {
           super("Agenda"); 
            p = mid;
            foto = "";
            nom = new TextField("Nombre:", "", 30, TextField.ANY);
            ape = new TextField("Apellido:", "", 30, TextField.ANY);
            tel = new TextField("Telefono:", "", 30, TextField.ANY);
            cel = new TextField("Celular:", "", 30, TextField .ANY);
            dom = new TextField("Domicilio:", "", 30, TextField.ANY); 
            s = new Command("Salir", Command.EXIT, 1); 
            g = new Command("Guardar", Command.EXIT, 1); 
            lista = new Command("Contactos", Command.EXIT, 1); 
            select = new Command("Seleccionar Foto", Command.EXIT, 1); 
            append(nom); 
            append(ape); 
            append(tel); 
            append(cel); 
            append(dom); 
            addCommand(g); 
            addCommand(s); 
            addCommand(lista);
            addCommand(select);
            setCommandListener(this); 
            setRegistro();
} 
public void commandAction(Command co, Displayable di) { 
    if (co == s) { 
        p.destroyApp(true); 
    }
    else if (co == g) {
        RMSOps rmso = new RMSOps();
        rmso.abrir("ZonaJavaZone"); 
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            DataOutputStream dos = new DataOutputStream(baos); 
            dos.writeUTF(foto); 
            dos.writeUTF(nom.getString()); 
            dos.writeUTF(ape.getString()); 
            dos.writeUTF(tel.getString()); 
            dos.writeUTF(cel.getString()); 
            dos.writeUTF(dom.getString()); 
            dos.close(); 
            rmso.adicionarRegistro(baos); 
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
    else if(co == lista){
        p.lc.constructList();
        p.d.setCurrent(p.lc);
    }
    else if(co == select){
        p.d.setCurrent(p.lf);
    }
    }
    public void setRegistro(){
        RMSOps rmso = new RMSOps();
        rmso.abrir("ZonaJavaZone"); 
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            DataOutputStream dos = new DataOutputStream(baos); 
            dos.writeUTF("0.png");
            dos.writeUTF(""); 
            dos.writeUTF(""); 
            dos.writeUTF(""); 
            dos.writeUTF(""); 
            dos.writeUTF(""); 
            dos.close(); 
            rmso.adicionarRegistro(baos); 
            rmso.cerrar();   
            } catch (Exception ioe) { 
                ioe.printStackTrace(); 
            }
    }
}
