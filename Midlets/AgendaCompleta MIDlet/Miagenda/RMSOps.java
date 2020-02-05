import java.io.*; 
import javax.microedition.rms.*; 
public class RMSOps {
     RecordStore rs; 
     public RMSOps() {     } 
     public boolean abrir(String nombreZona) { 
         try { 
             rs = RecordStore.openRecordStore(nombreZona, true); 
             return true; 
         } catch (RecordStoreException e) { 
             e.toString(); 
             return false; 
         }
     }
public boolean adicionarRegistro(ByteArrayOutputStream baos){
     byte[] mensaje; mensaje = baos.toByteArray(); 
     try {  
         rs.addRecord(mensaje, 0, mensaje.length); 
         return true; 
        } catch (RecordStoreException e) { 
            e.toString(); return false; 
        }
    }
public boolean adicionarRegistro(String valor) { 
    byte[] mensaje;
     mensaje = valor.getBytes(); 
     try { 
         rs.addRecord(mensaje, 0, mensaje.length); 
         return true; 
        } catch (RecordStoreException e) { 
            e.toString(); return false;
        }
    } 
public String listarRegistro() { 
    byte[] reg = new byte[120]; 
    int tam; 
    String buffer = ""; 
    try { 
        for (int i = 1; i <= rs.getNumRecords(); i++){
            tam = rs.getRecordSize(i); 
            reg = rs.getRecord(i); 
            buffer += "\n" + i + new String(reg , 0 , tam);
        }
        }catch (RecordStoreException e) {        }
        return buffer;
    }
    public String[] listarRegistro(int r){
            byte[] reg = new byte[120];
            ByteArrayInputStream bais; 
            DataInputStream dis;
            String[] datos= new String[6];
            try{   
                 reg= rs.getRecord(r);
                 bais = new ByteArrayInputStream(reg);
                 dis = new DataInputStream(bais);
                 datos[0] = dis.readUTF();
                 datos[1] = dis.readUTF();
                 datos[2] = dis.readUTF();
                 datos[3] = dis.readUTF();
                 datos[4] = dis.readUTF();
                 datos[5] = dis.readUTF();
            } catch (RecordStoreException e){
            } catch (IOException e){
                e.printStackTrace();
            }
            return datos;
        }
        public boolean cerrar(){
            try{
                rs.closeRecordStore();
                return true;
            } catch (RecordStoreException e){
                e.toString();
                return false;
            }
        }
        public boolean eliminar(int registro){
            try{
                rs.deleteRecord(registro);
                return true;
            } catch (RecordStoreException e){
                e.toString();
                return false;
            }
        }
        public boolean check(int registro){
            try{
                rs.getRecord(registro);
                return true;
            } catch (RecordStoreException e){
                e.toString();
                return false;
            }
        }
        public boolean editRegistro(ByteArrayOutputStream baos,int indice){
        byte[] mensaje; mensaje = baos.toByteArray(); 
        try {  
            rs.setRecord(indice,mensaje, 0, mensaje.length); 
            return true; 
           } catch (RecordStoreException e) { 
               e.toString(); return false; 
           }
    }
}
