/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aejecutador;

import controlador.ControladorProducto;
import modelo.productosCRUD;
import vista.VistaGUIDrogueriaTic;

public class ejecutador {
    public static void main(String[] args) {
        VistaGUIDrogueriaTic vista=new VistaGUIDrogueriaTic();
        productosCRUD Modelo=new productosCRUD();
        ControladorProducto Controlador =new ControladorProducto(vista,Modelo);
    }
}
