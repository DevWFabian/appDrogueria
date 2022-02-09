/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
/*
esta es la coneccion  con la base  de  datos Drogueria tic en SQL 
*/
public class conexionBD {
    public static Connection ObtenerConexion(){
        Connection conect=null;
        String URL = "jdbc:mysql://localhost:3306/bd_drogueriatic";
        String user ="root";
        String Password="south12";
        try{
            conect= DriverManager.getConnection(URL, user, Password);
            if (conect != null) {
                System.out.println("Conexion exitosa");
            }
        }catch(SQLException exc){
            System.out.println("Conexion fallida"+exc.getMessage());
        }
        return conect;
    }
}
