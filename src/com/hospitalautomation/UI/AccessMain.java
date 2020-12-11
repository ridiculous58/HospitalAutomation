/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.UI;

import com.hospitalautomation.Business.IDoctorService;
import com.hospitalautomation.Business.IPatientService;
import com.hospitalautomation.Business.IPersonalService;
import com.hospitalautomation.Business.IocConfig;
import com.hospitalautomation.Entities.Doctor;
import com.hospitalautomation.Entities.Patient;
import com.hospitalautomation.Entities.Personal;
import javax.swing.JFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Monster
 */
public class AccessMain extends javax.swing.JFrame {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        
    final IDoctorService doctorService = context.getBean("doctorService",IDoctorService.class);
    final IPatientService patientService = context.getBean("patientService",IPatientService.class);
    final IPersonalService personalService = context.getBean("personalService",IPersonalService.class);
    public AccessMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPersonalLogin = new javax.swing.JButton();
        btnDoctorLogin1 = new javax.swing.JButton();
        btnPatientLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPersonalLogin.setText("Personal Login");
        btnPersonalLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalLoginActionPerformed(evt);
            }
        });

        btnDoctorLogin1.setText("Doctor Login");
        btnDoctorLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorLogin1ActionPerformed(evt);
            }
        });

        btnPatientLogin.setText("Patient Login");
        btnPatientLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(btnDoctorLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnPatientLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnPersonalLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDoctorLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPatientLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPersonalLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonalLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalLoginActionPerformed
       Personal personal = personalService.getByUserName(Thread.currentThread().getName());
        if (personal != null) {
           PersonalProcessings personalProcessings = new PersonalProcessings();
           personalProcessings.setVisible(true);
        }
        PersonalLoginPage personalLoginPage = new PersonalLoginPage();
        personalLoginPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPersonalLoginActionPerformed

    private void btnDoctorLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorLogin1ActionPerformed
        Doctor doctor = doctorService.getByUserName(Thread.currentThread().getName());
        if (doctor != null) {
           DoctorProcessings doctorProcessings = new DoctorProcessings();
           doctorProcessings.setVisible(true);
        }
        DoctorLoginPage doctorLoginPage = new DoctorLoginPage();
        doctorLoginPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDoctorLogin1ActionPerformed

    private void btnPatientLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientLoginActionPerformed
        Patient patient = patientService.getByUserName(Thread.currentThread().getName());
        if (patient != null) {
           PatientProcessings patientProcessings = new PatientProcessings();
           patientProcessings.setVisible(true);
        }
        PatientLoginPage patientLoginPage = new PatientLoginPage();
        patientLoginPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPatientLoginActionPerformed

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
            java.util.logging.Logger.getLogger(AccessMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccessMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccessMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccessMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccessMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoctorLogin1;
    private javax.swing.JButton btnPatientLogin;
    private javax.swing.JButton btnPersonalLogin;
    // End of variables declaration//GEN-END:variables
}
