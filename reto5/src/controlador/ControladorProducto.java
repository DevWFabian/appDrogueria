/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.productosCRUD;
import modelo.productos;
import vista.VistaGUIDrogueriaTic;

public class ControladorProducto implements ActionListener{
    
    productosCRUD modelo;
    VistaGUIDrogueriaTic vista;

    public ControladorProducto(VistaGUIDrogueriaTic vista,productosCRUD modelo ) {
        this.modelo = modelo;
        this.vista = vista;
        vista.asignarEscuchas(this);
    }

    
    
    //-----------------------controlador Vista - Modelo--------------------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //----------------------controlador para  ingresar-----------------------
        if(ae.getSource() == vista.getB1Ingresar())
        {
            int Codigo=Integer.parseInt(vista.getTfcodigo_p());
            String nombre=vista.getTf_nombre();
            double precio=Double.parseDouble(vista.getTfPrecio());
            String marca=vista.getTfMarca();
            String tipo=vista.getTfTipo();
            String observacion=vista.getTfobservaciones();
            int CodigoProveedor=Integer.parseInt(vista.getTfcodigo_proveedor());
            productos unProd=new productos(Codigo,nombre,precio,marca,tipo,observacion,CodigoProveedor);
            modelo.IngresarProductos(unProd);
            
        }//--------------------------controlador  morstrar registros-----------------
        if(ae.getSource() == vista.getB2Mostrar())
        {
            List<productos> producto = modelo.mostrarProductos();
            vista.mostarCamposTabla(producto);
        }
        //-------------------------controlador para Actualizar-----------------
        if(ae.getSource() == vista.getB3Actualizar())
        {
            String no = vista.getTf_nombreA();
            int id = Integer.parseInt(vista.getTfcodigo_pA());
            modelo.actualizarRegistro(id, no);  
        }
        //-------------------------controlador  para borrar-------------------
        if(ae.getSource() == vista.getB4Borrar())
        {
            int id = Integer.parseInt(vista.getTfcodigo_pB());
            modelo.borrarRegistro(id);             
        }
        
    }
    
}
