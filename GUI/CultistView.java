/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.Cultist;

/**
 *
 * @author antonio
 */
public class CultistView extends javax.swing.JPanel {

    /**
     * Creates new form CultistView
     */
    private Cultist cultistModel;
    public CultistView() {
        initComponents();
    }
    
    public void setCultist(Cultist c) {
        cultistModel = c;
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SECTARIOS/"+c.getName()+".png")));
//        name.setText(cultistModel.getName());
//        gainedLevels.setText(Integer.toString(cultistModel.getGainedLevels()));
        repaint();
    }
    
    public void vacio() {
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SECTARIOS/vacio.png")));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
