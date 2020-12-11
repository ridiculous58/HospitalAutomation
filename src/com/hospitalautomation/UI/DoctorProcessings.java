/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.UI;

import com.hospitalautomation.Business.*;
import com.hospitalautomation.Business.IPatientService;
import com.hospitalautomation.Business.IocConfig;
import com.hospitalautomation.Entities.Doctor;
import com.hospitalautomation.Entities.Expertise;

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
public class DoctorProcessings extends javax.swing.JFrame {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);       
      
    IPatientService patientService = context.getBean("patientService",IPatientService.class);  
    List<Patient> patients;
    final IPatientAppointmentService patientAppointmentService = context.getBean("patientAppointmentService",IPatientAppointmentService.class);
    final IDoctorService doctorService = context.getBean("doctorService",IDoctorService.class);
    final IExpertiseService expertiseService = context.getBean("expertiseService",IExpertiseService.class);
    final List<Doctor> doctors; 
    final List<Expertise> expertises; 
    DefaultTableModel model;   
    List<PatientAppointment> patientAppointments;
    Doctor doctor;
    public DoctorProcessings() {
        initComponents();
        expertises = expertiseService.getList();
        patients = patientService.getList();
        patientAppointments = patientAppointmentService.getList();
        doctors = doctorService.getList();
        PatientAppointmentPn.setVisible(false);
        PatientPn.setVisible(false);
        MyProfileFieldsFill();
        
    }
    public void TableFillPatientAppointment(){
        model.setRowCount(0);
        doctorComboBoxFill();
        patientComboBoxFill();
        patientAppointments = patientAppointmentService.getByDoctorIdList(doctor.getId());
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
    public void TableFillPatient(){
        model.setRowCount(0);
        patients = patientService.getList();
        for (Patient patient :patients ) {
         Object[] object = new Object[]{
             patient.getId(),
             patient.getName(),
             patient.getSurname(),
             patient.getBirthdate()
            };
            model.addRow(object);
        }
    }
     public void doctorComboBoxFill(){
         cbxAppointmentDoctorIdAdd.removeAllItems();
         cbxAppointmentDoctorIdUpdate.removeAllItems();
        for (Doctor doctor : doctors) {
            String id = String.valueOf(doctor.getId());
            cbxAppointmentDoctorIdAdd.addItem(doctor.getName());
            cbxAppointmentDoctorIdUpdate.addItem(doctor.getName());
        }
    }
    public void expertiseComboBoxFill(){
        cbxMyProfileExpertiseIdUpdate.removeAllItems();
        for (Expertise expertise : expertises) {
            cbxMyProfileExpertiseIdUpdate.addItem(expertise.getName());
        }
    }
     public void patientComboBoxFill(){
         cbxAppointmentPatientIdAdd.removeAllItems();
         cbxAppointmentPatientIdUpdate.removeAllItems();
         for (Patient patient : patients) {
            String id = String.valueOf(patient.getId());
            cbxAppointmentPatientIdAdd.addItem(patient.getName());
            cbxAppointmentPatientIdUpdate.addItem(patient.getName());
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnDoctor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAppointment = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPatient = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btnExit = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        PatientPn = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tbxPatientSurnameAdd = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tbxPatientBirthdateAdd = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnPatientAdd = new javax.swing.JButton();
        tbxPatientNameAdd = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        tbxPatientIdUpdate = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tbxPatientBirthdateUpdate = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnPatientUpdate = new javax.swing.JButton();
        tbxPatientNameUpdate = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tbxPatientSurnameUpdate = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        tbxPatientIdDelete = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnPatientDelete = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        PatientAppointmentPn = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientAppointments = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAppointmentAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tbxAppointmentDateTimeAdd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxAppointmentDoctorIdAdd = new javax.swing.JComboBox<>();
        cbxAppointmentPatientIdAdd = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnAppointmentUpdate = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tbxAppointmentIdUpdate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxAppointmentDoctorIdUpdate = new javax.swing.JComboBox<>();
        tbxAppointmentDateTimeUpdate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbxAppointmentPatientIdUpdate = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        tbxAppointmentIdDelete = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnAppointmentDelete = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        MyProfile = new javax.swing.JPanel();
        tbxMyProfileBirthdateUpdate = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        btnMyProfileUpdate = new javax.swing.JButton();
        tbxMyProfileNameUpdate = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        tbxMyProfileSurnameUpdate = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        tbxMyProfileIdUpdate = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        tbxMyProfilePasswordUpdate = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        tbxMyProfileUserNameUpdate = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        cbxMyProfileExpertiseIdUpdate = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDoctor.setBackground(new java.awt.Color(85, 65, 118));
        btnDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoctorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDoctorMousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_profile_25px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("My Profile");

        javax.swing.GroupLayout btnDoctorLayout = new javax.swing.GroupLayout(btnDoctor);
        btnDoctor.setLayout(btnDoctorLayout);
        btnDoctorLayout.setHorizontalGroup(
            btnDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        btnDoctorLayout.setVerticalGroup(
            btnDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDoctorLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(btnDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 50));

        btnAppointment.setBackground(new java.awt.Color(64, 43, 100));
        btnAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAppointmentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAppointmentMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_recurring_appointment_exception_25px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Appointment");

        javax.swing.GroupLayout btnAppointmentLayout = new javax.swing.GroupLayout(btnAppointment);
        btnAppointment.setLayout(btnAppointmentLayout);
        btnAppointmentLayout.setHorizontalGroup(
            btnAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAppointmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        btnAppointmentLayout.setVerticalGroup(
            btnAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAppointmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel1.add(btnAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 340, 50));

        btnPatient.setBackground(new java.awt.Color(64, 43, 100));
        btnPatient.setPreferredSize(new java.awt.Dimension(292, 47));
        btnPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPatientMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPatientMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_patient_care_25px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Add a Patient");

        javax.swing.GroupLayout btnPatientLayout = new javax.swing.GroupLayout(btnPatient);
        btnPatient.setLayout(btnPatientLayout);
        btnPatientLayout.setHorizontalGroup(
            btnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(174, 174, 174))
        );
        btnPatientLayout.setVerticalGroup(
            btnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPatientLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel1.add(btnPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 340, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Doctor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

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

        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 340, 50));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PatientPn.setPreferredSize(new java.awt.Dimension(780, 920));

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Surname", "Birthdate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPatients);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel33.setText("Ekleme İşlemi");

        jLabel34.setText("Adi :");

        jLabel19.setText("Soyad :");

        jLabel20.setText("Doğum Tarihi");

        btnPatientAdd.setText("Ekle");
        btnPatientAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel18)
                .addGap(242, 242, 242)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel34))
                .addGap(68, 68, 68)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxPatientNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxPatientSurnameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(tbxPatientBirthdateAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPatientAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33)))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbxPatientBirthdateAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPatientAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbxPatientNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbxPatientSurnameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel21.setText("Güncelleme İşlemi");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 12, -1, -1));

        tbxPatientIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPatientIdUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(tbxPatientIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 53, 194, 32));

        jLabel22.setText("Id :");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 62, -1, -1));

        jLabel23.setText("Soyad :");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 62, -1, -1));
        jPanel8.add(tbxPatientBirthdateUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 92, 194, 30));

        jLabel24.setText("Doğum Tarihi :");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 100, -1, -1));

        btnPatientUpdate.setText("Update");
        btnPatientUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(btnPatientUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 129, 194, 36));
        jPanel8.add(tbxPatientNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 91, 194, 32));

        jLabel25.setText("Adi :");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 100, -1, -1));
        jPanel8.add(tbxPatientSurnameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 54, 194, 31));

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setText("Id : ");

        btnPatientDelete.setText("Sil");
        btnPatientDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientDeleteActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel32.setText("Silme İşlemi");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(374, 374, 374))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPatientDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxPatientIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(348, 348, 348))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel32)
                .addGap(10, 10, 10)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxPatientIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPatientDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PatientPnLayout = new javax.swing.GroupLayout(PatientPn);
        PatientPn.setLayout(PatientPnLayout);
        PatientPnLayout.setHorizontalGroup(
            PatientPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PatientPnLayout.setVerticalGroup(
            PatientPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPnLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(PatientPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 856));

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

        btnAppointmentAdd.setText("Ekle");
        btnAppointmentAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAppointmentAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 194, 30));
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 36, -1, -1));

        jLabel9.setText("Patient Id :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 55, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel12.setText("Ekleme İşlemi");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 1, -1, -1));

        jLabel10.setText("Randevu Tarihi");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));
        jPanel4.add(tbxAppointmentDateTimeAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 194, 30));

        jLabel11.setText("Docktor Id :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jPanel4.add(cbxAppointmentDoctorIdAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 84, 194, 28));

        jPanel4.add(cbxAppointmentPatientIdAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 194, 28));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAppointmentUpdate.setText("Güncelle");
        btnAppointmentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnAppointmentUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 126, 194, 30));

        jLabel13.setText("Patient Id :");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 100, -1, -1));

        tbxAppointmentIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxAppointmentIdUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(tbxAppointmentIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 53, 194, 32));

        jLabel14.setText("Id :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 62, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel15.setText("Güncelleme İşlemi");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 12, -1, -1));

        jPanel5.add(cbxAppointmentDoctorIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 190, 28));
        jPanel5.add(tbxAppointmentDateTimeUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 194, 30));

        jLabel16.setText("Doctor Id :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, 20));

        jLabel17.setText("Randevu Tarihi");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jPanel5.add(cbxAppointmentPatientIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 194, 28));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setText("Id : ");

        btnAppointmentDelete.setText("Sil");
        btnAppointmentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentDeleteActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel35.setText("Silme İşlemi");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(317, 317, 317))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAppointmentDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxAppointmentIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxAppointmentIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAppointmentDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PatientAppointmentPnLayout = new javax.swing.GroupLayout(PatientAppointmentPn);
        PatientAppointmentPn.setLayout(PatientAppointmentPnLayout);
        PatientAppointmentPnLayout.setHorizontalGroup(
            PatientAppointmentPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAppointmentPnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientAppointmentPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PatientAppointmentPnLayout.setVerticalGroup(
            PatientAppointmentPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientAppointmentPnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.add(PatientAppointmentPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, -1, -1));

        jLabel41.setText("Doğum Tarihi :");

        btnMyProfileUpdate.setText("Update");
        btnMyProfileUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileUpdateActionPerformed(evt);
            }
        });

        jLabel42.setText("Adi :");

        jLabel43.setText("Soyad :");

        jLabel44.setText("Expertise Id :");

        tbxMyProfileIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxMyProfileIdUpdateActionPerformed(evt);
            }
        });

        jLabel45.setText("Id :");

        jLabel46.setText("Parola :");

        jLabel47.setText("Kullanıcı Adi :");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel48.setText("Güncelleme İşlemi");

        cbxMyProfileExpertiseIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMyProfileExpertiseIdUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MyProfileLayout = new javax.swing.GroupLayout(MyProfile);
        MyProfile.setLayout(MyProfileLayout);
        MyProfileLayout.setHorizontalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel48))
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel45)
                .addGap(93, 93, 93)
                .addComponent(tbxMyProfileIdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel44)
                .addGap(15, 15, 15)
                .addComponent(cbxMyProfileExpertiseIdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel42)
                .addGap(88, 88, 88)
                .addComponent(tbxMyProfileNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tbxMyProfileUserNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel43)
                .addGap(73, 73, 73)
                .addComponent(tbxMyProfileSurnameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tbxMyProfilePasswordUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel41)
                .addGap(41, 41, 41)
                .addComponent(tbxMyProfileBirthdateUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166)
                .addComponent(btnMyProfileUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MyProfileLayout.setVerticalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel48)
                .addGap(30, 30, 30)
                .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxMyProfileIdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMyProfileExpertiseIdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MyProfileLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44))))
                .addGap(8, 8, 8)
                .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxMyProfileNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxMyProfileUserNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MyProfileLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(tbxMyProfileSurnameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MyProfileLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbxMyProfilePasswordUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxMyProfileBirthdateUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MyProfileLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(btnMyProfileUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel2.add(MyProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 270, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoctorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoctorMousePressed
        setColor(btnDoctor);
        resetColor(btnAppointment);
        resetColor(btnPatient);
    }//GEN-LAST:event_btnDoctorMousePressed

    private void btnAppointmentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAppointmentMousePressed
        setColor(btnAppointment);
        resetColor(btnDoctor);
        resetColor(btnPatient);
    }//GEN-LAST:event_btnAppointmentMousePressed

    private void btnPatientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientMousePressed
        setColor(btnPatient);
        resetColor(btnDoctor);
        resetColor(btnAppointment);
    }//GEN-LAST:event_btnPatientMousePressed

    private void btnAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAppointmentMouseClicked

        model = (DefaultTableModel)tblPatientAppointments.getModel();
        TableFillPatientAppointment();
        PatientPn.setVisible(false);
        PatientAppointmentPn.setVisible(true);
         MyProfile.setVisible(false);
    }//GEN-LAST:event_btnAppointmentMouseClicked

    private void tblPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsMouseClicked
        int row=tblPatients.rowAtPoint(evt.getPoint());
        
        tbxPatientIdUpdate.setText(tblPatients.getValueAt(row,0).toString());
        tbxPatientNameUpdate.setText(tblPatients.getValueAt(row,1).toString());
        tbxPatientSurnameUpdate.setText(tblPatients.getValueAt(row,2).toString());
        tbxPatientBirthdateUpdate.setText(tblPatients.getValueAt(row,3).toString());

        tbxPatientIdDelete.setText(tblPatients.getValueAt(row,0).toString());
    }//GEN-LAST:event_tblPatientsMouseClicked

    private void btnPatientAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientAddActionPerformed
        
        Patient patient = new Patient
        (
            tbxPatientNameAdd.getText(),
            tbxPatientSurnameAdd.getText(),
            LocalDateTime.parse(tbxPatientBirthdateAdd.getText()),
            null,
            null
        );
        patientService.add(patient);
        JOptionPane.showMessageDialog(null,"Hasta Başarıyla Eklendi");
        TableFillPatient();
    }//GEN-LAST:event_btnPatientAddActionPerformed

    private void tbxPatientIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxPatientIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxPatientIdUpdateActionPerformed

    private void btnPatientUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientUpdateActionPerformed
        Patient patient = new Patient
        (
            Integer.parseInt(tbxPatientIdUpdate.getText()),
            tbxPatientNameUpdate.getText(),
            tbxPatientSurnameUpdate.getText(),
            LocalDateTime.parse(tbxPatientBirthdateUpdate.getText()),
            null,
            null
        );
        patientService.update(patient);
        JOptionPane.showMessageDialog(null,"Hasta Başarıyla Güncellendi");
        TableFillPatient();
    }//GEN-LAST:event_btnPatientUpdateActionPerformed

    private void btnPatientDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientDeleteActionPerformed
        patientService.delete(Integer.parseInt(tbxPatientIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Hasta Başarıyla Silindi");
        TableFillPatient();
    }//GEN-LAST:event_btnPatientDeleteActionPerformed

    private void btnDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoctorMouseClicked
        PatientAppointmentPn.setVisible(false);
        PatientPn.setVisible(false);
        MyProfile.setVisible(true);
    }//GEN-LAST:event_btnDoctorMouseClicked

    private void btnPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientMouseClicked
        model = (DefaultTableModel)tblPatients.getModel();
        TableFillPatient();
        PatientAppointmentPn.setVisible(false);
         MyProfile.setVisible(false);
        PatientPn.setVisible(true);
    }//GEN-LAST:event_btnPatientMouseClicked

    private void tblPatientAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientAppointmentsMouseClicked
        int row=tblPatientAppointments.rowAtPoint(evt.getPoint());
        tbxAppointmentIdUpdate.setText(tblPatientAppointments.getValueAt(row,0).toString());
        //tbxPatientIdUpdate.setText(tblPatientAppointments.getValueAt(row,1).toString());
        tbxAppointmentDateTimeUpdate.setText(tblPatientAppointments.getValueAt(row,3).toString());
        
        tbxAppointmentIdDelete.setText(tblPatientAppointments.getValueAt(row,0).toString());
    }//GEN-LAST:event_tblPatientAppointmentsMouseClicked

    private void btnAppointmentAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentAddActionPerformed
        PatientAppointment patientAppointment = new PatientAppointment
        (
            patients.get(cbxAppointmentPatientIdAdd.getSelectedIndex()).getId(),
            doctors.get(cbxAppointmentDoctorIdAdd.getSelectedIndex()).getId(),
            LocalDateTime.parse(tbxAppointmentDateTimeAdd.getText())
        );
        patientAppointmentService.add(patientAppointment);
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Eklendi");
        TableFillPatientAppointment();
    }//GEN-LAST:event_btnAppointmentAddActionPerformed

    private void btnAppointmentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentUpdateActionPerformed
        PatientAppointment patientAppointment = new PatientAppointment
        (
            Integer.parseInt(tbxAppointmentIdUpdate.getText()),
            patients.get(cbxAppointmentPatientIdUpdate.getSelectedIndex()).getId(),
            doctors.get(cbxAppointmentDoctorIdUpdate.getSelectedIndex()).getId(),
            LocalDateTime.parse(tbxAppointmentDateTimeUpdate.getText())

        );
        patientAppointmentService.update(patientAppointment);
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Güncellendi");
        TableFillPatientAppointment();
    }//GEN-LAST:event_btnAppointmentUpdateActionPerformed

    private void tbxAppointmentIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxAppointmentIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxAppointmentIdUpdateActionPerformed

    private void btnAppointmentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentDeleteActionPerformed
        patientAppointmentService.delete(Integer.parseInt(tbxAppointmentIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Silindi");
        TableFillPatientAppointment();
    }//GEN-LAST:event_btnAppointmentDeleteActionPerformed
    public void MyProfileFieldsFill(){
        expertiseComboBoxFill();
        String name = Thread.currentThread().getName();
        doctor = doctorService.getByUserName(name);
        if(doctor != null){
        tbxMyProfileIdUpdate.setText(String.valueOf(doctor.getId()));
        tbxMyProfileNameUpdate.setText(doctor.getName());
        tbxMyProfileSurnameUpdate.setText(doctor.getSurname());
        tbxMyProfileBirthdateUpdate.setText(doctor.getBirthdate().toString());
        tbxMyProfileUserNameUpdate.setText(doctor.getUserName());
        tbxMyProfilePasswordUpdate.setText(doctor.getPassword());
        }
       
    }
    private void btnMyProfileUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileUpdateActionPerformed
        Doctor doctor = new Doctor
        (
            Integer.parseInt(tbxMyProfileIdUpdate.getText()),
            tbxMyProfileNameUpdate.getText(),
            tbxMyProfileSurnameUpdate.getText(),
            LocalDateTime.parse(tbxMyProfileBirthdateUpdate.getText()),
            expertises.get(cbxMyProfileExpertiseIdUpdate.getSelectedIndex()).getId(),
            tbxMyProfileUserNameUpdate.getText(),
            tbxMyProfilePasswordUpdate.getText()
        );
        doctorService.update(doctor);
        JOptionPane.showMessageDialog(null,"Doktor Başarıyla Güncellendi");

    }//GEN-LAST:event_btnMyProfileUpdateActionPerformed

    private void tbxMyProfileIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxMyProfileIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxMyProfileIdUpdateActionPerformed

    private void cbxMyProfileExpertiseIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMyProfileExpertiseIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMyProfileExpertiseIdUpdateActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
       this.setVisible(false);
       Thread.currentThread().setName("");
       AccessMain accessMain = new AccessMain();
       accessMain.setVisible(true);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitMousePressed

   
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
            java.util.logging.Logger.getLogger(DoctorProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorProcessings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MyProfile;
    private javax.swing.JPanel PatientAppointmentPn;
    private javax.swing.JPanel PatientPn;
    private javax.swing.JPanel btnAppointment;
    private javax.swing.JButton btnAppointmentAdd;
    private javax.swing.JButton btnAppointmentDelete;
    private javax.swing.JButton btnAppointmentUpdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JPanel btnDoctor;
    private javax.swing.JPanel btnExit;
    private javax.swing.JButton btnMyProfileUpdate;
    private javax.swing.JPanel btnPatient;
    private javax.swing.JButton btnPatientAdd;
    private javax.swing.JButton btnPatientDelete;
    private javax.swing.JButton btnPatientUpdate;
    private javax.swing.JComboBox<String> cbxAppointmentDoctorIdAdd;
    private javax.swing.JComboBox<String> cbxAppointmentDoctorIdUpdate;
    private javax.swing.JComboBox<String> cbxAppointmentPatientIdAdd;
    private javax.swing.JComboBox<String> cbxAppointmentPatientIdUpdate;
    private javax.swing.JComboBox<String> cbxMyProfileExpertiseIdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblPatientAppointments;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField tbxAppointmentDateTimeAdd;
    private javax.swing.JTextField tbxAppointmentDateTimeUpdate;
    private javax.swing.JTextField tbxAppointmentIdDelete;
    private javax.swing.JTextField tbxAppointmentIdUpdate;
    private javax.swing.JTextField tbxIdDelete;
    private javax.swing.JTextField tbxIdDelete2;
    private javax.swing.JTextField tbxMyProfileBirthdateUpdate;
    private javax.swing.JTextField tbxMyProfileIdUpdate;
    private javax.swing.JTextField tbxMyProfileNameUpdate;
    private javax.swing.JTextField tbxMyProfilePasswordUpdate;
    private javax.swing.JTextField tbxMyProfileSurnameUpdate;
    private javax.swing.JTextField tbxMyProfileUserNameUpdate;
    private javax.swing.JTextField tbxPatientBirthdateAdd;
    private javax.swing.JTextField tbxPatientBirthdateUpdate;
    private javax.swing.JTextField tbxPatientIdDelete;
    private javax.swing.JTextField tbxPatientIdUpdate;
    private javax.swing.JTextField tbxPatientNameAdd;
    private javax.swing.JTextField tbxPatientNameUpdate;
    private javax.swing.JTextField tbxPatientSurnameAdd;
    private javax.swing.JTextField tbxPatientSurnameUpdate;
    // End of variables declaration//GEN-END:variables
}
