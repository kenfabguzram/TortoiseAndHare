/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;


import static java.awt.Color.WHITE;
import static java.awt.Color.gray;
import static java.awt.Color.green;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author kenda
 */
public class GUI extends javax.swing.JFrame {

    private static final int TILE_AMOUNT = 14;
    private static final int MAX_SPEED = 3000;

    private JLabel[] tortoiseBoard;
    private JLabel[] hareBoard;
    private Animal hare;
    private Animal tortoise;

    public GUI() {
        initComponents();
        initializeUI();
    }

    private void initializeUI() {
        tortoiseBoard = new JLabel[TILE_AMOUNT];
        hareBoard = new JLabel[TILE_AMOUNT];

        for (int i = 0; i < TILE_AMOUNT; i++) {
            tortoiseBoard[i] = new JLabel();
            tortoiseBoard[i].setOpaque(true);
            hareBoard[i] = new JLabel();
            hareBoard[i].setOpaque(true);
            principalPane.add(tortoiseBoard[i]);
        }
        
        for (int i = 0; i < TILE_AMOUNT; i++) {    
            principalPane.add(hareBoard[i]);
        }

        tortoise = new Animal(0, 0, "tortoise", tortoiseBoard);
        hare = new Animal(0, 0, "hare", hareBoard);

        tortoiseBoard[0].setIcon(tortoise.getImageAnimal());
        hareBoard[0].setIcon(hare.getImageAnimal());
        tortoiseBoard[11].setIcon(tortoise.getGoal());
        hareBoard[11].setIcon(hare.getGoal());

        tortoiseSlider.addChangeListener(e -> tortoise.setSpeed(MAX_SPEED - tortoiseSlider.getValue()));
        hareSlider.addChangeListener(e -> hare.setSpeed(MAX_SPEED - hareSlider.getValue()));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalPane = new javax.swing.JPanel();
        tortoiseSlider = new javax.swing.JSlider();
        tortoiseSpeedLabel = new javax.swing.JLabel();
        hareSpeedLabel = new javax.swing.JLabel();
        hareSlider = new javax.swing.JSlider();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(657, 107));
        setSize(new java.awt.Dimension(657, 107));

        principalPane.setLayout(new java.awt.GridLayout(2, 14));

        tortoiseSlider.setMaximum(3000);
        tortoiseSlider.setValue(1850);

        tortoiseSpeedLabel.setText("Tortoise speed:");

        hareSpeedLabel.setText("Hare speed:");

        hareSlider.setMaximum(3000);
        hareSlider.setValue(2750);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(principalPane, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tortoiseSpeedLabel)
                            .addComponent(hareSpeedLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tortoiseSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                            .addComponent(hareSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(principalPane, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tortoiseSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tortoiseSpeedLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hareSpeedLabel)
                            .addComponent(hareSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        hare.start();
        tortoise.start();
    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider hareSlider;
    private javax.swing.JLabel hareSpeedLabel;
    private javax.swing.JPanel principalPane;
    private javax.swing.JButton startButton;
    private javax.swing.JSlider tortoiseSlider;
    private javax.swing.JLabel tortoiseSpeedLabel;
    // End of variables declaration//GEN-END:variables

}