package Presentacion.interfaces.Login;

import Datos.DAO.UsuarioDAO;
import Datos.Entidades.Usuario;
import Negocio.ControlLogin;
import Presentacion.interfaces.PanelImagen;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author sortizu
 */
public class LoginUsuarios extends javax.swing.JPanel {

    DefaultTableCellRenderer nuevoCellRenderer = new DefaultTableCellRenderer(){
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            
            if(value instanceof JLabel){
                JLabel lbl=(JLabel)value;
                return lbl;
            }
            
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
    };
    DefaultTableModel modeloListaDeUsuarios;
    ScrollBarCustom scrollCustom;
    
    //Arreglo para almacenar los usuarios cargados de la base de datos
    /*(Propuesta) Se podria usar solo un arreglo para los ID (String)
    Pues es el unico dato que necesitamos, el nombre puede cargarse
    en el metodo mostrarUsuariosEnLista
    */
    Usuario [] usuarios;
    public LoginUsuarios() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        modeloListaDeUsuarios=(DefaultTableModel)ListaDeUsuarios.getModel();
        ListaDeUsuarios.setFont(new Font("Arial",Font.PLAIN,25));
        ListaDeUsuarios.setForeground(Color.decode("#8C8C8C"));
        ListaDeUsuarios.setDefaultRenderer(Object.class, nuevoCellRenderer);
        ListaDeUsuarios.setSelectionBackground(Color.decode("#23A020"));
        ListaDeUsuarios.setSelectionForeground(Color.white);
        ListaDeUsuarios.setIntercellSpacing(new Dimension(0,0));
        
        
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setOpaque(false);
        scrollCustom=new ScrollBarCustom();
        scrollCustom.setUnitIncrement(16);
        jScrollPane1.setVerticalScrollBar(scrollCustom);
        ListaDeUsuarios.getTableHeader().setUI(null);
        //Seleccion de fila para iconos
        ListaDeUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            for (int i = 0; i < ListaDeUsuarios.getRowCount(); i++) {
                JLabel icono=(JLabel)ListaDeUsuarios.getValueAt(i, 0);
                if(i==ListaDeUsuarios.getSelectedRow()){
                    System.out.println(ListaDeUsuarios.getSelectedRow());
                    icono.setBackground(ListaDeUsuarios.getSelectionBackground());
                }else{
                    icono.setBackground(ListaDeUsuarios.getBackground());
                }
                icono.setOpaque(true);
                ListaDeUsuarios.setValueAt(icono, i, 0);
            }
            
        }
    });
        mostrarUsuariosEnLista();
    }
    
    private void mostrarUsuariosEnLista(){
    //Metodo donde se cargaran los usuarios de la BD y se mostraran en la lista
    //Se debe ejecutar al inicio
        Object[][] datosDeUsuario=ControlLogin.mostrarListaDeUsuarios();
        for (int i = 0; i < datosDeUsuario.length; i++) {
            añadirUsuarioALista((String)datosDeUsuario[i][1]);
        }
        /*UsuarioDAO udao=new UsuarioDAO();
        for(Object u:udao.listar()){
            añadirUsuarioALista(((Usuario)u).getNombre());
        }*/
    }
    
    public void añadirUsuarioALista(String nombre){
        JLabel imagenUsuario=new JLabel(new ImageIcon(getClass().getResource("/Presentacion/imagenes/iconoCuenta.png")));
        modeloListaDeUsuarios.addRow(new Object[]{imagenUsuario,nombre});
        //Adaptando el tamaño de la barra de Scroll
        double newScrollBarHeight=Math.pow(jScrollPane1.getHeight(),2)/(
                ListaDeUsuarios.getRowHeight()*ListaDeUsuarios.getRowCount());
        
        scrollCustom.setThumbSize((int)newScrollBarHeight);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eLiquor = new javax.swing.JLabel();
        PanelListaDeUsuarios = new PanelImagen("/Presentacion/imagenes/Paneles/Login/ListaDeUsuarios.png");
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaDeUsuarios = new javax.swing.JTable();
        btnSalir = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1360, 768));

        eLiquor.setFont(new java.awt.Font("Roboto Medium", 1, 140)); // NOI18N
        eLiquor.setForeground(new java.awt.Color(255, 255, 255));
        eLiquor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eLiquor.setText("eLiquor");
        eLiquor.setPreferredSize(new java.awt.Dimension(569, 201));

        PanelListaDeUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        PanelListaDeUsuarios.setPreferredSize(new java.awt.Dimension(435, 768));
        PanelListaDeUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto Thin", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(140, 140, 140));
        jLabel7.setText("USUARIOS");
        PanelListaDeUsuarios.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/imagenes/flecha.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelListaDeUsuarios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 60, 60));

        jSeparator1.setForeground(new java.awt.Color(208, 208, 208));
        jSeparator1.setPreferredSize(new java.awt.Dimension(350, 10));
        PanelListaDeUsuarios.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 370, -1));

        jSeparator2.setForeground(new java.awt.Color(208, 208, 208));
        jSeparator2.setPreferredSize(new java.awt.Dimension(350, 10));
        PanelListaDeUsuarios.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 370, -1));

        ListaDeUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "icono", "nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListaDeUsuarios.setAutoscrolls(false);
        ListaDeUsuarios.setFocusable(false);
        ListaDeUsuarios.setGridColor(new java.awt.Color(255, 255, 255));
        ListaDeUsuarios.setRequestFocusEnabled(false);
        ListaDeUsuarios.setRowHeight(75);
        ListaDeUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListaDeUsuarios.setShowGrid(false);
        jScrollPane1.setViewportView(ListaDeUsuarios);
        if (ListaDeUsuarios.getColumnModel().getColumnCount() > 0) {
            ListaDeUsuarios.getColumnModel().getColumn(0).setResizable(false);
            ListaDeUsuarios.getColumnModel().getColumn(0).setPreferredWidth(300);
            ListaDeUsuarios.getColumnModel().getColumn(1).setResizable(false);
            ListaDeUsuarios.getColumnModel().getColumn(1).setPreferredWidth(800);
        }

        PanelListaDeUsuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 370, 460));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/imagenes/Boton Salir.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalirMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnSalir)
                .addContainerGap(1262, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelListaDeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)
                    .addComponent(eLiquor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(689, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelListaDeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(283, 283, 283)
                            .addComponent(eLiquor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMousePressed
        /*Utilizando utilidades de swing para obtener la ventana principal (FramePrincipal)
        y cerrar todo el programa*/
        ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
    }//GEN-LAST:event_btnSalirMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListaDeUsuarios;
    private javax.swing.JPanel PanelListaDeUsuarios;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel eLiquor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
