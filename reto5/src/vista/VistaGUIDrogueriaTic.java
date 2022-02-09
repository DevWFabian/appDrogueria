
package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import modelo.productos;


public class VistaGUIDrogueriaTic extends JFrame {
    

 
    private JPanel panelArriba,panelCentro,panelAbajo,panelLado,pTab1,pTab2,pTab3,pTab4;//Paneles Ingresar    
    private JPanel panelA,panelA_centro;//Paneles Actualizar
    private JPanel panelM,panelM_Centro;//Paneles Mostrar
    private JPanel panel1b_norte,panelB_centro;
    
    private JTabbedPane tab; 
    
    private JLabel jlCodigo_p,jlCodigo_proveedor,jlNombre_p, jlPrecio,jlMarca,jlTipo,jlObservaciones;//Etiquetas Ingresar
    private JLabel jlCodigo_pA,jlNombre_pA;//Etiquetas Actualizar
    private JLabel jlCodigo_pB;//Etiqueta borrar
    
    
    private JTextField tfcodigo_p,tfcodigo_proveedor,tf_nombre,tfPrecio,tfMarca,tfTipo,tfobservaciones;//Text Ingresar
    private JTextField tfcodigo_pA,tf_nombreA;//Text Actualizar
    private JTextField tfcodigo_pB;//Text borrar
    
    private JButton b1,b2,b3,b4;
    
    
    private JTable tabla;
    JScrollPane barraM;
    
    
    public void intiComponents(){
        
//creacion de cada uno de los componenetes
        
        //margen de las pestañas
        tab = new JTabbedPane();
        //paneles para las pestañas
        pTab1=new JPanel();
        pTab2=new JPanel();
        pTab3=new JPanel();
        pTab4=new JPanel();
        
//-----------------Componentes pestaña Ingresar-----------------------------        
               
        
        //botones
        b1= new JButton("Ingresar");
        
                
        //Etiquetas
        jlCodigo_p=new JLabel("Codigo producto");
        jlCodigo_proveedor=new JLabel("Codigo prooveedor");
        jlNombre_p=new JLabel("Nombre");
        jlPrecio=new JLabel("Precio");
        jlMarca=new JLabel("Marca");
        jlTipo=new JLabel("Tipo");
        jlObservaciones=new JLabel("Observaciones");
        
        
        //Campos de texto
        tfcodigo_p=new JTextField(10);
        tfcodigo_proveedor=new JTextField(10);
        tf_nombre=new JTextField(10);
        tfPrecio=new JTextField(15);
        tfMarca=new JTextField(15);
        tfTipo=new JTextField(15);
        tfobservaciones=new JTextField(15);
//-------------------Componentes pestaña Mostrar-----------------------------
//------configuracion para crear una tabla para mostrar 
        b2= new JButton("Mostrar");
        Vector encabezados = new Vector();
        encabezados.add("Codigo"); encabezados.add("Nombre");
        encabezados.add("Precio");encabezados.add("Marca");
        encabezados.add("tipo");encabezados.add("Observacion");
        encabezados.add("codigo proveedor");
        Vector contenidoT = new Vector();
        tabla = new JTable(contenidoT, encabezados);
        barraM = new JScrollPane(tabla);
        
        
        
        
       
//-------------------Componentes pestaña Actualizar-----------------------------       
        
        b3= new JButton("Actualizar");
        jlCodigo_pA=new JLabel("Codigo producto");
        jlNombre_pA=new JLabel("Nombre producto");
        tfcodigo_pA=new JTextField(10);
        tf_nombreA=new JTextField(10);
        

//-------------------Componentes pestaña Actualizar-----------------------------

        b4= new JButton("Borrar");
        jlCodigo_pB= new JLabel("Codigo producto");
        tfcodigo_pB= new JTextField(10);
        
//---------------------- paneles de la pestaña ingresar---------------------       
        panelArriba = new JPanel();
        panelArriba.setBorder(BorderFactory.createTitledBorder("Datos Basicos"));
        panelArriba.setLayout(new GridLayout(3,2));
        panelArriba.add(jlCodigo_p);panelArriba.add(tfcodigo_p);
        panelArriba.add(jlNombre_p);panelArriba.add(tf_nombre);
        panelArriba.add(jlCodigo_proveedor);panelArriba.add(tfcodigo_proveedor);
        
        
        panelCentro= new JPanel();
        panelCentro.setBorder(BorderFactory.createTitledBorder("Descripcion producto"));
        panelCentro.setLayout(new GridLayout(3,3));        
        panelCentro.add(jlPrecio);panelCentro.add(tfPrecio);
        panelCentro.add(jlMarca);panelCentro.add(tfMarca);
        panelCentro.add(jlTipo);panelCentro.add(tfTipo);
//        
        panelLado= new JPanel();
        panelLado.setBorder(BorderFactory.createTitledBorder("Comentarios"));
        panelLado.setLayout(new GridLayout(2,1));
        panelLado.add(jlObservaciones);panelLado.add(tfobservaciones);
       
        panelAbajo=new JPanel();
        panelAbajo.add(b1);
      
        

        
        pTab1.setLayout(new BorderLayout());
        pTab1.setPreferredSize(new Dimension(600,250));
        pTab1.add(panelArriba,BorderLayout.NORTH);
        pTab1.add(panelCentro,BorderLayout.CENTER);
        pTab1.add(panelLado,BorderLayout.EAST);
        pTab1.add(panelAbajo,BorderLayout.SOUTH);
        
//----------------paneles pestaña mostrar---------------------------

        panelM=new JPanel();
        panelM.setBorder(BorderFactory.createTitledBorder("Consultar"));
        panelM.add(b2);
        
        panelM_Centro=new JPanel();
        panelM_Centro.setLayout(new BorderLayout());
        panelM_Centro.setBorder(BorderFactory.createTitledBorder("Productos en inventario"));
        panelM_Centro.add(barraM);
        
        
        pTab2.setLayout(new BorderLayout());
        pTab2.setPreferredSize(new Dimension(900,300));
        pTab2.add(panelM,BorderLayout.NORTH);
        pTab2.add(panelM_Centro,BorderLayout.CENTER);
        
//-----------------paneles pestaña Actualizar-------------------------
        
        panelA_centro=new JPanel();
        panelA_centro.setBorder(BorderFactory.createTitledBorder("Actualizar productos"));
        panelA_centro.setLayout(new GridLayout(2,2));
        panelA_centro.add(jlCodigo_pA);panelA_centro.add(jlNombre_pA);
        panelA_centro.add(tfcodigo_pA);panelA_centro.add(tf_nombreA);

        panelA=new JPanel();
        panelA.setBorder(BorderFactory.createTitledBorder("Actualizar productos"));
        panelA.add(b3);
        
        pTab3.setLayout(new BorderLayout());
        pTab3.setPreferredSize(new Dimension(300,200));
        pTab3.add(panelA,BorderLayout.CENTER);
        pTab3.add(panelA_centro,BorderLayout.NORTH);
       
//----------------paneles pestaña borrar------------------------------
        
        panel1b_norte=new JPanel();
        panel1b_norte.setBorder(BorderFactory.createTitledBorder("Datos a ingresar"));
        panel1b_norte.setLayout(new GridLayout(1,2));
        panel1b_norte.add(jlCodigo_pB);panel1b_norte.add(tfcodigo_pB);

        panelB_centro=new JPanel();
        panelB_centro.setBorder(BorderFactory.createTitledBorder("Borrar productos"));
        panelB_centro.add(b4);
        
        pTab4.setLayout(new BorderLayout());
        pTab4.setPreferredSize(new Dimension(300,200));
        pTab4.add(panel1b_norte,BorderLayout.NORTH);
        pTab4.add(panelB_centro,BorderLayout.CENTER);
        

        //Construccion Frame
        tab.add(pTab1, "Ingreso");
        tab.add(pTab2, "Mostrar");
        tab.add(pTab3, "Actualizar");
        tab.add(pTab4, "Borrar");
        
//--------------------configuracion para  cambio de pestañas no modifique tamaño ---------------
        tab.addChangeListener(new ChangeListener(){    
        @Override
        public void stateChanged(ChangeEvent arg0) {
            Component mCompo=tab.getSelectedComponent();
            tab.setPreferredSize(mCompo.getPreferredSize());
            pack();
        }   
        });
        
        
        add(tab);        
        setTitle("Dogueria Tic");
        pack();
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                //CON IMAGEN PERSONALIZADA
                
                JOptionPane.showMessageDialog(null,"!Adios","Finalizacion",JOptionPane.QUESTION_MESSAGE);
                System.exit(0);                
            }        
        });
       
       
        
    }
    
    
    public VistaGUIDrogueriaTic(){
        intiComponents(); 
            
        

    }
//------------------gets de botones -------------------------------
    public JButton getB1Ingresar() {
        return b1;
    }

    public JButton getB2Mostrar() {
        return b2;
    }

    public JButton getB3Actualizar() {
        return b3;
    }

    public JButton getB4Borrar() {
        return b4;
    }
//--------------------gets de campos de texto  pestaña ingreso  ------------------
    public String getTfcodigo_p() {
        return tfcodigo_p.getText().trim();
    }

    public String getTfcodigo_proveedor() {
        return tfcodigo_proveedor.getText().trim();
    }

    public String getTf_nombre() {
        return tf_nombre.getText().trim();
    }

    public String getTfPrecio() {
        return tfPrecio.getText().trim();
    }

    public String getTfMarca() {
        return tfMarca.getText().trim();
    }

    public String getTfTipo() {
        return tfTipo.getText().trim();
    }

    public String getTfobservaciones() {
        return tfobservaciones.getText().trim();
    }

    
    
    
    //--------------------------mostrar-------------------------

    
    

    //-------------------------- gets Actualizar----------------------
    public String getTf_nombreA() {
        return tf_nombreA.getText().trim();
    }
    public String getTfcodigo_pA() {
        return tfcodigo_pA.getText().trim();
    }
    //-------------------------gets borrar---------------------------
    public String getTfcodigo_pB() {
        return tfcodigo_pB.getText().trim();
    }
    
    
    //----------------pestaña mostrar  en tabla --------------
    public void mostarCamposTabla(List<productos> lista){
        //para borrar las filas que habia en la tabla
        borrarFilasTabla();
        
        DefaultTableModel modeloT = (DefaultTableModel)tabla.getModel();
        Object[] fila = new Object[modeloT.getColumnCount()];
        
        for(Object unRegistro : lista)
        {
            fila[0] = ((productos)unRegistro).getCodigo();
            fila[1] = ((productos)unRegistro).getNombre();
            fila[2] = ((productos)unRegistro).getPrecio();
            fila[3] = ((productos)unRegistro).getMarca();
            fila[4] = ((productos)unRegistro).getTipo();
            fila[5] = ((productos)unRegistro).getObservacion();
            fila[6] = ((productos)unRegistro).getCodigoProveedor();
            modeloT.addRow(fila);
        }
    }
    
    public void borrarFilasTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        int cantFilas = modelo.getRowCount();
        if(cantFilas > 0)
        {
            for (int i = cantFilas-1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }
        
    }
    public void asignarEscuchas(ActionListener evento)
    {
        b1.addActionListener(evento);
        b2.addActionListener(evento);
        b3.addActionListener(evento);
        b4.addActionListener(evento);
        
    }
}
    

