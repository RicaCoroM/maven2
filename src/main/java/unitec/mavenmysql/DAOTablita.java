
package unitec.mavenmysql;

import java.sql.*;
public class DAOTablita {
    /**
     * 
     * @param t Este argumento es el objeto de tipo tablita que deseas guardar
     * @throws Exception 
     */
    public static void guardar(Tablita t)throws Exception{
        //paso 1 conectarnos a sql
        Connection con= Conexion.conectarse("root", null);
        //paso 2 Generar el Statement de sql con la conexion
        PreparedStatement pr=con.prepareStatement("Insert into tablita(nombre,sueldo) values(?,?)");
        pr.setString(1,t.getNombre());
        pr.setFloat(2,t.getSuelo());
        pr.execute();
        System.out.println("Objeto Tablita guardado con exito");
    }
    public static Tablita buscarPorId(int id) throws Exception{
        
        Connection con = Conexion.conectarse("root", null);
        Statement st = con.createStatement();
        Tablita t=new Tablita();
        ResultSet res = st.executeQuery("select * from tablita where id ="+id);
         while(res.next()){
             //a esto se le llama mapeo
             t.setId(res.getInt("id"));
             t.setNombre(res.getString("nombre"));
             t.setSuelo(res.getFloat("sueldo"));
         }   
         return t;
    }
}
