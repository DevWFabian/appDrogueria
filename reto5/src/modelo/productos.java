/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
/*

*/
public class productos {
    private int Codigo;
    private String nombre;
    private double precio;
    private String marca;
    private String tipo;
    private String observacion;
    private int CodigoProveedor;
/*
    se crea el constructos que representa a la tabla  productos
    */
    public productos(int Codigo, String nombre, double precio, String marca, String tipo, String observacion, int CodigoProveedor) {
        this.Codigo = Codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.tipo = tipo;
        this.observacion = observacion;
        this.CodigoProveedor = CodigoProveedor;
    }

    
    public int getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getObservacion() {
        return observacion;
    }
    public int getCodigoProveedor() {
        return CodigoProveedor;
    }
    @Override
    public String toString() {
        return Codigo+" "+nombre+" "+precio+" "+marca+" "+tipo+" "+observacion;
    }
    
    
    
}
