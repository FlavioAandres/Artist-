package artista;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ShowAlbumes extends javax.swing.JFrame {

    /**
     * Creates new form ShowAlbumes
     */
    public NodosA.Artistas artSeleccionado; 
    public String ArtistSelected;
    public ShowAlbumes() {
        initComponents();
        cargarAlbums();
    }
    
    public void cargarcanciones(){
        NodosA.Artistas copy = NodosA.Principal.ptrArtistas;
        DefaultListModel model = new DefaultListModel();
        while(copy!=null){
            if (copy.getInfo().equals(ArtistSelected)) {
                NodosA.Albums calb = copy.getAlbum();
                while(calb!=null){
                    if (calb.getNombre().equals(Albumes.getSelectedValue())) {
                        NodosA.Canciones ccan = calb.getCancion();
                        while(ccan!=null){
                            model.addElement(ccan.getNombre());
                            System.out.println(ccan.getNombre());
                            ccan = ccan.getSiguienteC();
                        }
                    }
                    calb = calb.getSiguienteAl();
                }
            }
            copy = copy.getSiguienteA();
        }
        canciones.setModel(model);
    }
    
    public void cargarAlbums(){
        //temporalAlbum = artSeleccionado.getAlbum();
         //Artista.Albums copy = artSeleccionado.getAlbum();
         System.out.println("Artista: " + ArtistSelected);
         NodosA.Albums al;
        DefaultListModel model  = new DefaultListModel();
        model.clear();
        NodosA.Artistas copy = NodosA.Principal.ptrArtistas;
         while(copy !=null){
            if (copy.getInfo().equals(ArtistSelected)) {
                al = copy.getAlbum();
                while(al!=null){
                    System.out.println("Album: " + al.getNombre());
                    model.addElement(al.getNombre());
                    al = al.getSiguienteAl();
                }
            }
            copy = copy.getSiguienteA();
        }
        
        this.Albumes.setModel(model);
        cargarcanciones();
    }
    public void agregarCanciones(){
        String NombreSong = JOptionPane.showInputDialog(this,"Ingrese El nombre de la nueva cancion",
                                                            "Agregar Cancion",JOptionPane.QUESTION_MESSAGE);
        
        NodosA.Canciones ccan = new NodosA.Canciones(NombreSong);
        NodosA.Principal.ptrArtistas = NodosA.Albums.AgregarCancion(NodosA.Principal.ptrArtistas, ArtistSelected, Albumes.getSelectedValue(), ccan);
        cargarcanciones();
    
    }
    public void addAlbum(){
    String NombreAlbum = JOptionPane.showInputDialog(this,"Ingrese El nombre del nuevo Album",
                                                            "Agregar Album",JOptionPane.QUESTION_MESSAGE);
    NodosA.Albums a = new NodosA.Albums(NombreAlbum);
    //SWITCHCONTROL
    //CAMBIOS
        NodosA.Principal.ptrArtistas = NodosA.Artistas.A�adirAlbum(NodosA.Principal.ptrArtistas,ArtistSelected, a);
        
    //FIN CAMBIOS
    //Artista.Principal.ptrArtistas = NodosA.Artistas.A�adirAlbum(artSeleccionado, a);
    //Artista.Principal.cargarlistaartistas();
    cargarAlbums();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Albumes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        canciones = new javax.swing.JList<>();
        PanelAdministracion = new javax.swing.JPanel();
        addAlbum = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        PanelUsuario = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        Albumes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                AlbumesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Albumes);

        jScrollPane2.setViewportView(canciones);

        addAlbum.setText("AddAlbum");
        addAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlbumActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar Caratula");

        jButton2.setText("Agregar Informaci�n");

        jButton3.setText("Agregar Canciones");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAdministracionLayout = new javax.swing.GroupLayout(PanelAdministracion);
        PanelAdministracion.setLayout(PanelAdministracionLayout);
        PanelAdministracionLayout.setHorizontalGroup(
            PanelAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdministracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelAdministracionLayout.setVerticalGroup(
            PanelAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdministracionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(40, 40, 40))
        );

        jButton4.setText("Comprar");

        javax.swing.GroupLayout PanelUsuarioLayout = new javax.swing.GroupLayout(PanelUsuario);
        PanelUsuario.setLayout(PanelUsuarioLayout);
        PanelUsuarioLayout.setHorizontalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        PanelUsuarioLayout.setVerticalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(PanelAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlbumActionPerformed
        // TODO add your handling code here:
        
        addAlbum();
    }//GEN-LAST:event_addAlbumActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        agregarCanciones();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AlbumesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AlbumesValueChanged
        // TODO add your handling code here:
        cargarcanciones();
    }//GEN-LAST:event_AlbumesValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowAlbumes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowAlbumes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowAlbumes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowAlbumes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowAlbumes().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Albumes;
    private javax.swing.JPanel PanelAdministracion;
    private javax.swing.JPanel PanelUsuario;
    private javax.swing.JButton addAlbum;
    private javax.swing.JList<String> canciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}