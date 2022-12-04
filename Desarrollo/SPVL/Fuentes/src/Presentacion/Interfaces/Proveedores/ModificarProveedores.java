package Presentacion.Interfaces.Proveedores;

import Presentacion.Interfaces.FramePrincipal;
import Presentacion.Interfaces.TextFieldRedondeado;
import Presentacion.Interfaces.VentanaEmergente;
import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author sortizu
 */
public class ModificarProveedores extends VentanaEmergente{
    
    private TextFieldRedondeado txtRazonSocial;
    private JLabel lblAlertaRazonSocial;
    private TextFieldRedondeado txtCorreo;
    private TextFieldRedondeado txtTelefono;
    private PanelDeProveedores panelPrincipalDeModuloDeProveedores;
    
    public ModificarProveedores(PanelDeProveedores panelPrincipalDeModuloDeProveedores) {
        super("/Presentacion/Imagenes/Paneles/Proveedores/PanelAgregarProveedores.png");
        this.panelPrincipalDeModuloDeProveedores=panelPrincipalDeModuloDeProveedores;
        setTextoTitulo("MODIFICAR PROVEEDOR");
        setColorTitulo(Color.decode("#5F7ECD"));
        JPanel cuerpo = getCuerpo();
        cuerpo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Dimension dimTxt = new Dimension(0,40);
        Insets insetTxt = new Insets(0, 45, 5, 45);
        Insets insetLbl = new Insets(0, 75, 5, 45);
        
        JLabel lblRazonSocial=new JLabel("Razón Social");
        lblRazonSocial.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblRazonSocial.setForeground(Color.decode("#8C8C8C"));
        lblRazonSocial.setHorizontalAlignment(JLabel.LEFT);
        gbc.insets=insetLbl;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1.0;
        cuerpo.add(lblRazonSocial,gbc);
        
        txtRazonSocial=new TextFieldRedondeado(0);
        txtRazonSocial.setGrosorBorde(4);
        txtRazonSocial.setRadioDeBorde(40);
        txtRazonSocial.setColorBorde(Color.decode("#CACACA"));
        txtRazonSocial.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        txtRazonSocial.setForeground(Color.decode("#8C8C8C"));
        txtRazonSocial.setHorizontalAlignment(JLabel.CENTER);
        txtRazonSocial.setBorder( BorderFactory.createEmptyBorder(2, 20, 0, 20) );
        txtRazonSocial.setPreferredSize(dimTxt);
        gbc.insets=insetTxt;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0;
        cuerpo.add(txtRazonSocial,gbc);
        
        lblAlertaRazonSocial = new JLabel("Asegúrese de poner una razón social");
        lblAlertaRazonSocial.setFont(UtilidadesFuentes.InterRegular.deriveFont(17.0f));
        lblAlertaRazonSocial.setForeground(new java.awt.Color(224, 130, 130));
        lblAlertaRazonSocial.setHorizontalAlignment(JLabel.CENTER);
        gbc.insets=new Insets(0, 0, 0, 0);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1;
        cuerpo.add(lblAlertaRazonSocial,gbc);
        
        
        JLabel lblCorreo=new JLabel("Correo");
        lblCorreo.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblCorreo.setForeground(Color.decode("#8C8C8C"));
        lblCorreo.setHorizontalAlignment(JLabel.LEFT);
        gbc.insets = insetLbl;
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1.0;
        cuerpo.add(lblCorreo,gbc);
        
        txtCorreo=new TextFieldRedondeado(0);
        txtCorreo.setGrosorBorde(4);
        txtCorreo.setRadioDeBorde(40);
        txtCorreo.setColorBorde(Color.decode("#CACACA"));
        txtCorreo.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        txtCorreo.setForeground(Color.decode("#8C8C8C"));
        txtCorreo.setHorizontalAlignment(JLabel.CENTER);
        txtCorreo.setBorder( BorderFactory.createEmptyBorder(2, 20, 0, 20) );
        txtCorreo.setPreferredSize(dimTxt);
        gbc.insets=insetTxt;
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=0;
        cuerpo.add(txtCorreo,gbc);
        
        
        JLabel lblTelefono=new JLabel("Teléfono");
        lblTelefono.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblTelefono.setForeground(Color.decode("#8C8C8C"));
        lblTelefono.setHorizontalAlignment(JLabel.LEFT);
        gbc.insets=insetLbl;
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1.0;
        cuerpo.add(lblTelefono,gbc);
        
        txtCorreo=new TextFieldRedondeado(0);
        txtCorreo.setGrosorBorde(4);
        txtCorreo.setRadioDeBorde(40);
        txtCorreo.setColorBorde(Color.decode("#CACACA"));
        txtCorreo.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        txtCorreo.setForeground(Color.decode("#8C8C8C"));
        txtCorreo.setHorizontalAlignment(JLabel.CENTER);
        txtCorreo.setBorder( BorderFactory.createEmptyBorder(2, 20, 0, 20) );
        txtCorreo.setPreferredSize(dimTxt);
        gbc.insets=insetTxt;
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=0;
        cuerpo.add(txtCorreo,gbc);
        
        
        
        PlainDocument documentNombre = (PlainDocument) txtRazonSocial.getDocument();
        documentNombre.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                lblAlertaRazonSocial.setVisible(false);
                super.replace(fb, offset, length, text, attrs);
            }
        });
        lblAlertaRazonSocial.setVisible(false);
        /*Cargando datos del departamento*/
    }

    @Override
    public void btnAceptarPresionado(MouseEvent evt) {
        if(txtRazonSocial.getText().isBlank()){
                lblAlertaRazonSocial.setVisible(true);
        }else{
               
        }
    }

    @Override
    public void btnCancelarPresionado(MouseEvent evt) {
        ((FramePrincipal)((JFrame) SwingUtilities.getWindowAncestor(this))).cerrarPanelesEmergentes();
    }

    
    
}
