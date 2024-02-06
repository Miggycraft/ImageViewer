package gui.imageviewer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer extends javax.swing.JFrame {
    CustomImages ci = new CustomImages();
    int index = -1; //selected item index.
    
    public ImageViewer() {
        initComponents();
    }
    
    public void showImageInfo(){
        Thread t = new Thread();
        try{
            JOptionPane.showMessageDialog(this, "Getting Info, please wait after pressing \"OK\"");
            t.sleep(1000);
            
            if (index == -1){
                JOptionPane.showMessageDialog(this, "No image found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, ci.getImage(index).pasteInfo(), 
                    "Image Information", JOptionPane.INFORMATION_MESSAGE);    
        }
        catch(Exception x){
            x.printStackTrace();
        }
    }
    
    public void moveImage(boolean toRight){
        if (!ci.hasInside())
            return;
        
        if (toRight){ // moving to right
            if (index == ci.getSize()-1){
                index = 0;
            }
            else{
                ++index;
            }
        }
        else{ // moving to left
            if (index == 0){
                index = ci.getSize()-1;
            }
            else{
                --index;
            }
        }
        
        updateImageView(index);
    }

    public void updateImageView(int index){
        //[788, 425]
        if (index == -1){ // clear image
            imageLabel.setIcon(null);
            return;
        }
        
        String path = ci.getImage(index).getFileDir();
        ImageIcon tempImage = new ImageIcon(path);
        tempImage = new ImageIcon(tempImage.getImage().getScaledInstance(788, 425, Image.SCALE_SMOOTH));
        imageLabel.setIcon(tempImage);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();
        rightButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        supportItem = new javax.swing.JMenuItem();
        infoItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Selector");
        setName("Image Viewer"); // NOI18N
        setResizable(false);

        imageLabel.setPreferredSize(new java.awt.Dimension(788, 425));

        rightButton.setText("Right");
        rightButton.setFocusable(false);
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        leftButton.setText("Left");
        leftButton.setFocusable(false);
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        openItem.setText("Open Directory");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        fileMenu.add(openItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        optionsMenu.setText("Options");

        supportItem.setText("Supported Formats");
        supportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supportItemActionPerformed(evt);
            }
        });
        optionsMenu.add(supportItem);

        infoItem.setText("Image Info");
        infoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoItemActionPerformed(evt);
            }
        });
        optionsMenu.add(infoItem);

        jMenuBar1.add(optionsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(leftButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightButton)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void infoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoItemActionPerformed
        // TODO add your handling code here:
        showImageInfo();
    }//GEN-LAST:event_infoItemActionPerformed

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        // TODO add your handling code here
        if (ci.hasInside()){ // finding new dir and clearing curr img
            ci.clearImages();
            index = -1;
            updateImageView(index);
        }
        JFileChooser dir = new JFileChooser();
        dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dir.setCurrentDirectory(new File("\\"));
        dir.showOpenDialog(dir);
        ci.getLists(dir.getSelectedFile().toString());
        if (ci.hasInside()){
            index = 0;
            updateImageView(index);
        }
        else{
            index = -1;
        }
    }//GEN-LAST:event_openItemActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        // TODO add your handling code here:
        moveImage(false);
    }//GEN-LAST:event_leftButtonActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        // TODO add your handling code here:
        moveImage(true);
    }//GEN-LAST:event_rightButtonActionPerformed

    private void supportItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, Arrays.toString(ci.supportedTypes), "Supported Formats", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_supportItemActionPerformed

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
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JMenuItem infoItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton leftButton;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JButton rightButton;
    private javax.swing.JMenuItem supportItem;
    // End of variables declaration//GEN-END:variables
}
