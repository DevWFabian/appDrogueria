/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**Constructor de la calse 
     * va a inicializar la conexion de nuestra BaseDatos
     */
public class productosCRUD {
    Connection conectarBD;
    public productosCRUD(){
        conectarBD = conexionBD.ObtenerConexion();
    }
    /**Metodo para ingresar productos a la base de datos
     * Recibe un objeto productos llamado unProducto
     * devolvera una variable de tipo String en este caso la variable notificacion
     * @param unProducto
    **/ 
    public void IngresarProductos(productos unProducto){
        
        String  sql ="INSERT INTO producto VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement sentencia= conectarBD.prepareStatement(sql);
            sentencia.setInt(1, unProducto.getCodigo());
            sentencia.setString(2, unProducto.getNombre());
            sentencia.setDouble(3, unProducto.getPrecio());
            sentencia.setString(4, unProducto.getMarca());
            sentencia.setString(5, unProducto.getTipo());
            sentencia.setString(6, unProducto.getObservacion());
            sentencia.setInt(7, unProducto.getCodigoProveedor());
            int filasinsertadas = sentencia.executeUpdate();
            if (filasinsertadas >0){
                JOptionPane.showMessageDialog(null, "Se ingreso con exito");
            }
            
        }catch(SQLException exc){
            JOptionPane.showMessageDialog(null, "no se  ingreso");
        }
        
    }
    /**
     * Metodo encargado de mostrar aquellos productos que se encuentran
     * en el inventario, devolvioendo una lista de dichos productos
     * sin necesesidad de pasarle algun parametro  
     * @return 
     */
    public List<productos> mostrarProductos(){
        List<productos> registros=new ArrayList<>();
        String sql="select * from producto";
        try {
            Statement sentencia = conectarBD.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
                int codigo =resultado.getInt(1);
                String nombre=resultado.getString(2);
                double precio=resultado.getDouble(3);
                String marca= resultado.getString(4);
                String tipo = resultado.getString(5);
                String observacion = resultado.getString(6);
                int codigoProv= resultado.getInt(7);
                registros.add(new productos(codigo,nombre,precio,marca,tipo,
                                            observacion,codigoProv));
            }
        }catch(SQLException exc){
            JOptionPane.showMessageDialog(null, "No se pudo traer Datos ");
            
        }return registros;
    }
    /**
     * Metodo encargado de actualizar algun producto del inventario
     * @param codigo
     * @param nombre
     * @return un String llamado salida
     */
    public String actualizarRegistro(int codigo,String nombre) {
        String salida = "";
        String sql = "UPDATE producto "
                + "SET pro_nombre=?"
                + "WHERE  pro_id=?";
        try {
            PreparedStatement sentencia = conectarBD.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setInt(2, codigo);            
            
            int rowsUpdated = sentencia.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Se Actualizo con exito");
            }
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
        return salida;
    }

    /**
     * Metodo encargado de borrar algun producto del inventario
     * @param codigoProducto de tipo long
     * @return un String llamado salida
     */
    public String borrarRegistro(int codigoProducto) {
        String borrar ="";        
        String sql = "DELETE FROM producto WHERE pro_id=?";
        PreparedStatement sentencia;
        try {
            sentencia = conectarBD.prepareStatement(sql);
            sentencia.setLong(1, codigoProducto);
            int rowsDeleted = sentencia.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo eliminar");
        }
        return borrar;
    }
}
