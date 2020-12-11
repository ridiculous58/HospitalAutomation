/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.UI;

import com.hospitalautomation.Business.IDoctorService;
import com.hospitalautomation.Business.IPatientAppointmentService;
import com.hospitalautomation.Business.IPatientService;
import com.hospitalautomation.Business.IocConfig;
import com.hospitalautomation.Entities.Doctor;
import com.hospitalautomation.Entities.Patient;
import com.hospitalautomation.Entities.PatientAppointment;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Tolga
 */
public class PatientProcessings extends javax.swing.JFrame {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);        
    IPatientAppointmentService patientAppointmentService = context.getBean("patientAppointmentService",IPatientAppointmentService.class);  
    IPatientService patientService = context.getBean("patientService",IPatientService.class);  
    final IDoctorService doctorService = context.getBean("doctorService",IDoctorService.class);
    final List<Doctor> doctors; 
    List<PatientAppointment> patientAppointments;
    List<Patient> patients;
    DefaultTableModel model; 
    Patient patient;
    public PatientProcessings() {
        initComponents();
        PatientAppointment.setVisible(false);
        patients = patientService.getList();
        doctors = doctorService.getList();
        MyProfileFill();
        
    }
    public void TableFillPatientAppointment(){
        model.setRowCount(0);
        patientAppointments = patientAppointmentService.getByPatientIdList(patient.getId());
        
        for (PatientAppointment patientAppointment :patientAppointments ) {
            Object[] object = new Object[]{
                patientAppointment.getId(),
                patientAppointment.getPatientId(),
                patientAppointment.getDoctorId(),
                patientAppointment.getAppointmentDateTime()
            };
            model.addRow(object);
        }
    }
    public void MyProfileFill(){
        String userName = Thread.currentThread().getName();
        patient = patientService.getByUserName(userName);
        if (patient != null) {
            
        tbxPatientIdUpdate.setText(String.valueOf(patient.getId()));
        tbxPatientNameUpdate.setText(patient.getName());
        tbxPatientSurnameUpdate.setText(patient.getSurname());
        tbxPatientBirthdateUpdate.setText(patient.getBirthdate().toString());
        tbxPatientUserNameUpdate.setText(patient.getUserName());
        tbxPatientPasswordUpdate.setText(patient.getPassword());
        }
        else{
            PatientLoginPage patientLoginPage = new PatientLoginPage();
            patientLoginPage.setVisible(true);
        }
    }
     public void doctorComboBoxFill(){
         cbxDoctorIdAdd.removeAllItems();
         cbxDoctorIdUpdate.removeAllItems();
        for (Doctor doctor : doctors) {
            String id = String.valueOf(doctor.getId());
            cbxDoctorIdAdd.addItem(doctor.getName());
            cbxDoctorIdUpdate.addItem(doctor.getName());
        }
    }
    void setColor(JPanel panel)
    {
        panel.setBackground(new Color(85,55,118));
    }
    void resetColor(JPanel panel)
    {
        panel.setBackground(new Color(64,43,100));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        tbxIdDelete = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPatient = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnPatientAppointment = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnExit = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PatientAppointment = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientAppointments = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tbxAppointmentDateTimeAdd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxDoctorIdAdd = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        tbxIdUpdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxDoctorIdUpdate = new javax.swing.JComboBox<>();
        tbxAppointmentDateTimeUpdate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        tbxAppointmentIdDelete = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        MyProfile = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        tbxPatientIdUpdate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tbxPatientBirthdateUpdate = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnPatientUpdate = new javax.swing.JButton();
        tbxPatientNameUpdate = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tbxPatientSurnameUpdate = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tbxPatientUserNameUpdate = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        tbxPatientPasswordUpdate = new javax.swing.JTextField();

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setText("Id : ");

        btnDelete.setText("Sil");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel15.setText("Silme İşlemi");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(317, 317, 317))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));

        btnPatient.setBackground(new java.awt.Color(85, 65, 118));
        btnPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPatientMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPatientMousePressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_patient_oxygen_mask_25px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("My Profile");

        javax.swing.GroupLayout btnPatientLayout = new javax.swing.GroupLayout(btnPatient);
        btnPatient.setLayout(btnPatientLayout);
        btnPatientLayout.setHorizontalGroup(
            btnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPatientLayout.setVerticalGroup(
            btnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnPatientLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Patient");

        btnPatientAppointment.setBackground(new java.awt.Color(64, 43, 100));
        btnPatientAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPatientAppointmentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPatientAppointmentMousePressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_appointment_scheduling_25px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Appointment");

        javax.swing.GroupLayout btnPatientAppointmentLayout = new javax.swing.GroupLayout(btnPatientAppointment);
        btnPatientAppointment.setLayout(btnPatientAppointmentLayout);
        btnPatientAppointmentLayout.setHorizontalGroup(
            btnPatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPatientAppointmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPatientAppointmentLayout.setVerticalGroup(
            btnPatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPatientAppointmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPatientAppointmentLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        btnExit.setBackground(new java.awt.Color(64, 43, 100));
        btnExit.setPreferredSize(new java.awt.Dimension(292, 47));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExitMousePressed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 102, 51));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("X");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setText("Exit");

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addGap(174, 174, 174))
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPatientAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPatientAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PatientAppointment.setPreferredSize(new java.awt.Dimension(871, 781));

        tblPatientAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "PatientId", "DoctorId", "AppointmentDateTime"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPatientAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientAppointmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPatientAppointments);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setText("Ekle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 194, 30));
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 36, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel12.setText("Ekleme İşlemi");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 1, -1, -1));

        jLabel8.setText("Randevu Tarihi");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));
        jPanel4.add(tbxAppointmentDateTimeAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 194, 30));

        jLabel9.setText("Docktor Id :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jPanel4.add(cbxDoctorIdAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 194, 28));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdate.setText("Güncelle");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 194, 30));

        tbxIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxIdUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(tbxIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 53, 194, 32));

        jLabel11.setText("Id :");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 62, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel13.setText("Güncelleme İşlemi");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 12, -1, -1));

        jPanel5.add(cbxDoctorIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 190, 28));
        jPanel5.add(tbxAppointmentDateTimeUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 194, 30));

        jLabel16.setText("Doctor Id :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 20));

        jLabel17.setText("Randevu Tarihi");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbxAppointmentIdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxAppointmentIdDeleteActionPerformed(evt);
            }
        });

        jLabel18.setText("Id : ");

        btnDelete1.setText("Sil");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel19.setText("Silme İşlemi");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(317, 317, 317))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxAppointmentIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxAppointmentIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PatientAppointmentLayout = new javax.swing.GroupLayout(PatientAppointment);
        PatientAppointment.setLayout(PatientAppointmentLayout);
        PatientAppointmentLayout.setHorizontalGroup(
            PatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientAppointmentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );
        PatientAppointmentLayout.setVerticalGroup(
            PatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAppointmentLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel20.setText("My Profile");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        tbxPatientIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPatientIdUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(tbxPatientIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 194, 32));

        jLabel21.setText("Id :");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel22.setText("Soyad :");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));
        jPanel8.add(tbxPatientBirthdateUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 194, 30));

        jLabel23.setText("Doğum Tarihi :");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 64, -1, 20));

        btnPatientUpdate.setText("Update");
        btnPatientUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(btnPatientUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 194, 36));
        jPanel8.add(tbxPatientNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 194, 32));

        jLabel24.setText("Adi :");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));
        jPanel8.add(tbxPatientSurnameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 194, 31));

        jLabel25.setText("UserName");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, 20));
        jPanel8.add(tbxPatientUserNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 194, 30));

        jLabel26.setText("Password :");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, 20));
        jPanel8.add(tbxPatientPasswordUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 194, 30));

        javax.swing.GroupLayout MyProfileLayout = new javax.swing.GroupLayout(MyProfile);
        MyProfile.setLayout(MyProfileLayout);
        MyProfileLayout.setHorizontalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MyProfileLayout.setVerticalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PatientAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(MyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PatientAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(MyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPatientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientMousePressed
        setColor(btnPatient);
        resetColor(btnPatientAppointment);
    }//GEN-LAST:event_btnPatientMousePressed

    private void btnPatientAppointmentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientAppointmentMousePressed
        setColor(btnPatientAppointment);
        resetColor(btnPatient);
    }//GEN-LAST:event_btnPatientAppointmentMousePressed

    private void btnPatientAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientAppointmentMouseClicked
        MyProfile.setVisible(false);
        doctorComboBoxFill();
        model = (DefaultTableModel)tblPatientAppointments.getModel();
        TableFillPatientAppointment();
        PatientAppointment.setVisible(true);
    }//GEN-LAST:event_btnPatientAppointmentMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        patientAppointmentService.delete(Integer.parseInt(tbxIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Silindi");
        TableFillPatientAppointment();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        this.setVisible(false);
        Thread.currentThread().setName("");
        AccessMain accessMain = new AccessMain();
        accessMain.setVisible(true);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitMousePressed

    private void tblPatientAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientAppointmentsMouseClicked
        int row=tblPatientAppointments.rowAtPoint(evt.getPoint());
        tbxIdUpdate.setText(tblPatientAppointments.getValueAt(row,0).toString());
        //tbxPatientIdUpdate.setText(tblPatientAppointments.getValueAt(row,1).toString());
        tbxAppointmentDateTimeUpdate.setText(tblPatientAppointments.getValueAt(row,3).toString());

        tbxAppointmentIdDelete.setText(tblPatientAppointments.getValueAt(row,0).toString());
    }//GEN-LAST:event_tblPatientAppointmentsMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        PatientAppointment patientAppointment = new PatientAppointment
        (
            patient.getId(),
            doctors.get(cbxDoctorIdAdd.getSelectedIndex()).getId(),
            LocalDateTime.parse(tbxAppointmentDateTimeAdd.getText())
        );
        patientAppointmentService.add(patientAppointment);
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Eklendi");
        TableFillPatientAppointment();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        PatientAppointment patientAppointment = new PatientAppointment
        (
            Integer.parseInt(tbxIdUpdate.getText()),
            patient.getId(),
            doctors.get(cbxDoctorIdUpdate.getSelectedIndex()).getId(),
            LocalDateTime.parse(tbxAppointmentDateTimeUpdate.getText())

        );
        patientAppointmentService.update(patientAppointment);
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Güncellendi");
        TableFillPatientAppointment();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbxIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxIdUpdateActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        patientAppointmentService.delete(Integer.parseInt(tbxAppointmentIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Silindi");
        TableFillPatientAppointment();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void tbxAppointmentIdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxAppointmentIdDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxAppointmentIdDeleteActionPerformed

    private void btnPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientMouseClicked
        
        PatientAppointment.setVisible(false);
        MyProfile.setVisible(true);
    }//GEN-LAST:event_btnPatientMouseClicked

    private void tbxPatientIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxPatientIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxPatientIdUpdateActionPerformed

    private void btnPatientUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientUpdateActionPerformed
        Patient patient = new Patient
        (
            Integer.parseInt(tbxIdUpdate.getText()),
            tbxPatientNameUpdate.getText(),
            tbxPatientSurnameUpdate.getText(),
            LocalDateTime.parse(tbxPatientBirthdateUpdate.getText()),
            tbxPatientUserNameUpdate.getText(),
            tbxPatientPasswordUpdate.getText()
        );
        patientService.update(patient);
        JOptionPane.showMessageDialog(null,"Hasta Başarıyla Güncellendi");
    }//GEN-LAST:event_btnPatientUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(PatientProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientProcessings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MyProfile;
    private javax.swing.JPanel PatientAppointment;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnPatient;
    private javax.swing.JPanel btnPatientAppointment;
    private javax.swing.JButton btnPatientUpdate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxDoctorIdAdd;
    private javax.swing.JComboBox<String> cbxDoctorIdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblPatientAppointments;
    private javax.swing.JTextField tbxAppointmentDateTimeAdd;
    private javax.swing.JTextField tbxAppointmentDateTimeUpdate;
    private javax.swing.JTextField tbxAppointmentIdDelete;
    private javax.swing.JTextField tbxIdDelete;
    private javax.swing.JTextField tbxIdUpdate;
    private javax.swing.JTextField tbxPatientBirthdateUpdate;
    private javax.swing.JTextField tbxPatientIdUpdate;
    private javax.swing.JTextField tbxPatientNameUpdate;
    private javax.swing.JTextField tbxPatientPasswordUpdate;
    private javax.swing.JTextField tbxPatientSurnameUpdate;
    private javax.swing.JTextField tbxPatientUserNameUpdate;
    // End of variables declaration//GEN-END:variables
}
