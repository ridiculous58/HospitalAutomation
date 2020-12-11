/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.UI;

import com.hospitalautomation.Business.*;
import com.hospitalautomation.Entities.*;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Monster
 */
public class PersonalProcessings extends javax.swing.JFrame {
   
    // <editor-fold defaultstate="collapsed" desc="Fields">
    // <editor-fold defaultstate="collapsed" desc="Service Fields">
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);  
    final IDoctorService doctorService = context.getBean("doctorService",IDoctorService.class);
    final IExpertiseService expertiseService = context.getBean("expertiseService",IExpertiseService.class);
    final IPatientService patientService = context.getBean("patientService",IPatientService.class);
    final IPersonalService personalService = context.getBean("personalService",IPersonalService.class);
    final IPositionService positionService = context.getBean("positionService",IPositionService.class);
    final IPatientAppointmentService patientAppointmentService = context.getBean("patientAppointmentService",IPatientAppointmentService.class);
    DefaultTableModel model; 
    // </editor-fold>
    
    List<Expertise> doctorPanelExpertises; 
    List<Position> personalPanelPositions;
    List<Doctor> patientAppointmentDoctors; 
    List<Patient> patientAppointmentPatients; 
    List<Position> myProfilePositions; 
    // <editor-fold defaultstate="collapsed" desc="List Field">
    List<Expertise> expertises;
    List<Patient> patients;
    List<Doctor> doctors;
    List<Personal> personals;
    List<PatientAppointment> patientAppointments;
    List<Position> positions;
    // </editor-fold>   
    // </editor-fold>   
    
    // <editor-fold defaultstate="collapsed" desc="Ctor">
    public PersonalProcessings() {
        initComponents();
        myProfileFiil();
        DoctorPn.setVisible(false);
        ExpertisePn.setVisible(false);
        PatientPn.setVisible(false);
        PersonalPn.setVisible(false);
        PatientAppointment.setVisible(false);
        PositionPn.setVisible(false);
        MyProfile.setVisible(true);
        
    }
     // </editor-fold>  
    
    // <editor-fold defaultstate="collapsed" desc="Table Fill">
    public void doctorsTableFill(){
        model.setRowCount(0);
        doctors = doctorService.getList();
        for (Doctor doctor :doctors ) {
            Object[] object = new Object[]{
         doctor.getId(),doctor.getName(),doctor.getSurname(),doctor.getBirthdate(),doctor.getExpertiseId(),doctor.getUserName(),doctor.getPassword()
            };
            model.addRow(object);
        }
    }
    public void expertisesTableFill(){
        model.setRowCount(0);
        expertises = expertiseService.getList();
        for (Expertise expertise :expertises ) {
            Object[] object = new Object[]{
                expertise.getId(),
                expertise.getName()
            };
            model.addRow(object);
        }
    }
     public void patientsTableFill(){
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
     public void personalTableFill(){
        model.setRowCount(0);
        personals = personalService.getList();
        
        for (Personal personal :personals ) {
         Object[] object = new Object[]{
             personal.getId(),
             personal.getName(),
             personal.getSurname(),
             personal.getBirthdate(),
             personal.getPositionId()
            };
            model.addRow(object);
        }
    }
      public void patientAppointmentTableFill(){
        model.setRowCount(0);
        patientAppointments = patientAppointmentService.getList();
        
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
       public void positionTableFill(){
        model.setRowCount(0);
        positions = positionService.getList();
        
        for (Position position :positions ) {
            Object[] object = new Object[]{
                position.getId(),
                position.getName()
            };
            model.addRow(object);
        }
    }
     // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="ComboBox Fill">
    public void doctorPanelComboBoxFill(){
        doctorPanelExpertises = expertiseService.getList();
        cbxDoctorExpertiseIdAdd.removeAllItems();
        cbxDoctorExpertiseIdUpdate.removeAllItems();
        for (Expertise expertise : doctorPanelExpertises) {
            cbxDoctorExpertiseIdAdd.addItem(expertise.getName());
            cbxDoctorExpertiseIdUpdate.addItem(expertise.getName());
        }
    }
    public void personalPanelComboBoxFill(){
        personalPanelPositions = positionService.getList();
        cbxPersonalPositionIdAdd.removeAllItems();
        cbxPersonalPositionIdUpdate.removeAllItems();
        for (Position position : personalPanelPositions) {
            cbxPersonalPositionIdAdd.addItem(position.getName());
            cbxPersonalPositionIdUpdate.addItem(position.getName());
        }
    }
     public void patientAppointmentDoctorComboBoxFill(){
        patientAppointmentDoctors = doctorService.getList();
        cbxPatientAppointmentDoctorIdAdd.removeAllItems();
        cbxPatientAppointmentDoctorIdUpdate.removeAllItems();
        for (Doctor doctor : patientAppointmentDoctors) {
            String id = String.valueOf(doctor.getId());
            cbxPatientAppointmentDoctorIdAdd.addItem(doctor.getName());
            cbxPatientAppointmentDoctorIdUpdate.addItem(doctor.getName());
        }
    }
     public void patientAppointmentpatientComboBoxFill(){
         patientAppointmentPatients = patientService.getList();
         cbxPatientAppointmentPatientIdAdd.removeAllItems();
         cbxPatientAppointmentPatientIdUpdate.removeAllItems();
         for (Patient patient : patientAppointmentPatients) {
            String id = String.valueOf(patient.getId());
            cbxPatientAppointmentPatientIdAdd.addItem(patient.getName());
            cbxPatientAppointmentPatientIdUpdate.addItem(patient.getName());
        }
     }
     public void myProfileComboBoxFill(){
         myProfilePositions = positionService.getList();
         cbxMyProfilePositionIdUpdate.removeAllItems();
         for (Position position : myProfilePositions) {
            cbxMyProfilePositionIdUpdate.addItem(position.getName());
        }
     }
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Try">
    // </editor-fold> 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnWelcome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDoctor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnPatient = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnExpertise = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        btnPatientAppoiment = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnPosition = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnPersonal = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        DoctorPn = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDoctors = new javax.swing.JTable();
        btnDoctorAdd = new javax.swing.JButton();
        tbxDoctorNameAdd = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        tbxDoctorSurnameAdd = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        tbxDoctorBirthdateAdd = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        tbxDoctorBirthdateUpdate = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        btnDoctorUpdate = new javax.swing.JButton();
        tbxDoctorNameUpdate = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        tbxDoctorSurnameUpdate = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        tbxDoctorIdUpdateDoctorPanel = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        btnDoctorDelete = new javax.swing.JButton();
        tbxDoctorIdDelete = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        tbxDoctorUserNameAdd = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        tbxDoctorPasswordAdd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tbxDoctorPasswordUpdate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        tbxDoctorUserNameUpdate = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        cbxDoctorExpertiseIdAdd = new javax.swing.JComboBox<>();
        cbxDoctorExpertiseIdUpdate = new javax.swing.JComboBox<>();
        ExpertisePn = new javax.swing.JPanel();
        btnExpertiseUpdate = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tbxExpertiseIdDelete = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnExpertiseDelete = new javax.swing.JButton();
        tbxExpertiseNameAdd = new javax.swing.JTextField();
        btnExpertiseAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpertises = new javax.swing.JTable();
        tbxExpertiseIdUpdateExpertisePanel = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tbxExpertiseNameUpdate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        PatientPn = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tbxPatientSurnameAdd = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tbxPatientBirthdateAdd = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        btnPatientAdd = new javax.swing.JButton();
        tbxPatientNameAdd = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        tbxPatientUserNameAdd = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        tbxPatientPasswordAdd = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        tbxPatientIdUpdatePatientPanel = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tbxPatientBirthdateUpdate = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btnUpdate2 = new javax.swing.JButton();
        tbxPatientNameUpdate = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        tbxPatientSurnameUpdate = new javax.swing.JTextField();
        tbxPatientPasswordUpdate = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        tbxPatientUserNameUpdate = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        tbxPatientIdDelete = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        btnDelete2 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        PersonalPn = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPersonals = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        tbxPersonalSurnameUpdate = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        tbxPersonalNameUpdate = new javax.swing.JTextField();
        btnPersonalUpdate = new javax.swing.JButton();
        tbxPersonalIdUpdatePersonalPanel = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        tbxPersonalBirthdateUpdate = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        cbxPersonalPositionIdUpdate = new javax.swing.JComboBox<>();
        tbxPersonalPasswordUpdate = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        tbxPersonalUserNameUpdate = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btnPersonalAdd = new javax.swing.JButton();
        tbxPersonalBirthdateAdd = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        tbxPersonalNameAdd = new javax.swing.JTextField();
        tbxPersonalSurnameAdd = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        cbxPersonalPositionIdAdd = new javax.swing.JComboBox<>();
        tbxPersonalPasswordAdd = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        tbxPersonalUserNameAdd = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        btnPersonalDelete = new javax.swing.JButton();
        tbxPersonalIdDelete = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        PatientAppointment = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatientAppointments = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btnPatientAppointmentAdd = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tbxPatientAppointmentAppointmentDateTimeAdd = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cbxPatientAppointmentDoctorIdAdd = new javax.swing.JComboBox<>();
        cbxPatientAppointmentPatientIdAdd = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnPatientAppointmentUpdate = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        tbxPatientAppointmentIdUpdateAppointmentPanel = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbxPatientAppointmentDoctorIdUpdate = new javax.swing.JComboBox<>();
        tbxPatientAppointmentAppointmentDateTimeUpdate = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        cbxPatientAppointmentPatientIdUpdate = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        tbxPatientAppointmentIdDelete = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        btnPatientAppointmentDelete = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        PositionPn = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPositions = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        tbxPositionNameAdd = new javax.swing.JTextField();
        btnPositionAdd = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnPositionUpdate = new javax.swing.JButton();
        tbxPositionNameUpdate = new javax.swing.JTextField();
        tbxPositionIdUpdatePositionPanel = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnPositionDelete = new javax.swing.JButton();
        tbxPositionIdDelete = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        MyProfile = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        tbxMyProfileSurnameUpdate = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        tbxMyProfileNameUpdate = new javax.swing.JTextField();
        btnMyProfileUpdate = new javax.swing.JButton();
        tbxMyProfilelIdUpdate = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        tbxMyProfileBirthdateUpdate = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        cbxMyProfilePositionIdUpdate = new javax.swing.JComboBox<>();
        jLabel109 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        tbxMyProfilePasswordUpdate = new javax.swing.JTextField();
        tbxMyProfileUserNameUpdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(54, 33, 89));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnWelcome.setBackground(new java.awt.Color(85, 65, 118));
        btnWelcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWelcomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnWelcomeMousePressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_user_25px_2.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("My Profile");

        javax.swing.GroupLayout btnWelcomeLayout = new javax.swing.GroupLayout(btnWelcome);
        btnWelcome.setLayout(btnWelcomeLayout);
        btnWelcomeLayout.setHorizontalGroup(
            btnWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        btnWelcomeLayout.setVerticalGroup(
            btnWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnWelcomeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(btnWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 390, -1));

        btnDoctor.setBackground(new java.awt.Color(64, 43, 100));
        btnDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoctorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDoctorMousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_doctor_male_25px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Doctor");

        javax.swing.GroupLayout btnDoctorLayout = new javax.swing.GroupLayout(btnDoctor);
        btnDoctor.setLayout(btnDoctorLayout);
        btnDoctorLayout.setHorizontalGroup(
            btnDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        btnDoctorLayout.setVerticalGroup(
            btnDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDoctorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnDoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(btnDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 390, -1));

        BtnPatient.setBackground(new java.awt.Color(64, 43, 100));
        BtnPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPatientMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnPatientMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_patient_oxygen_mask_25px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Patient");

        javax.swing.GroupLayout BtnPatientLayout = new javax.swing.GroupLayout(BtnPatient);
        BtnPatient.setLayout(BtnPatientLayout);
        BtnPatientLayout.setHorizontalGroup(
            BtnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        BtnPatientLayout.setVerticalGroup(
            BtnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnPatientLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BtnPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(BtnPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 390, -1));

        btnExpertise.setBackground(new java.awt.Color(64, 43, 100));
        btnExpertise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExpertiseMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExpertiseMousePressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_neutral_trading_25px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Expertise");

        javax.swing.GroupLayout btnExpertiseLayout = new javax.swing.GroupLayout(btnExpertise);
        btnExpertise.setLayout(btnExpertiseLayout);
        btnExpertiseLayout.setHorizontalGroup(
            btnExpertiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExpertiseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        btnExpertiseLayout.setVerticalGroup(
            btnExpertiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExpertiseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnExpertiseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(btnExpertise, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 390, -1));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 300, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Hospital ETFC");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, 30));

        btnPatientAppoiment.setBackground(new java.awt.Color(64, 43, 100));
        btnPatientAppoiment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPatientAppoimentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPatientAppoimentMousePressed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_development_skill_25px.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Patient Appointment");

        javax.swing.GroupLayout btnPatientAppoimentLayout = new javax.swing.GroupLayout(btnPatientAppoiment);
        btnPatientAppoiment.setLayout(btnPatientAppoimentLayout);
        btnPatientAppoimentLayout.setHorizontalGroup(
            btnPatientAppoimentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPatientAppoimentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        btnPatientAppoimentLayout.setVerticalGroup(
            btnPatientAppoimentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPatientAppoimentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnPatientAppoimentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(btnPatientAppoiment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 390, -1));

        btnPosition.setBackground(new java.awt.Color(64, 43, 100));
        btnPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPositionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPositionMousePressed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_profile_25px.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Personal Position");

        javax.swing.GroupLayout btnPositionLayout = new javax.swing.GroupLayout(btnPosition);
        btnPosition.setLayout(btnPositionLayout);
        btnPositionLayout.setHorizontalGroup(
            btnPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPositionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        btnPositionLayout.setVerticalGroup(
            btnPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPositionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnPositionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(btnPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 390, -1));

        btnPersonal.setBackground(new java.awt.Color(64, 43, 100));
        btnPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPersonalMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPersonalMousePressed(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_name_tag_25px_1.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Personals");

        javax.swing.GroupLayout btnPersonalLayout = new javax.swing.GroupLayout(btnPersonal);
        btnPersonal.setLayout(btnPersonalLayout);
        btnPersonalLayout.setHorizontalGroup(
            btnPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        btnPersonalLayout.setVerticalGroup(
            btnPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPersonalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(btnPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 390, -1));

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DoctorPn.setAutoscrolls(true);
        DoctorPn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DoctorPn.setEnabled(false);
        DoctorPn.setPreferredSize(new java.awt.Dimension(968, 972));
        DoctorPn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDoctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Surname", "Birthdate", "ExpertiseId", "UserName", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDoctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoctorsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDoctors);

        DoctorPn.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 800, 300));

        btnDoctorAdd.setText("Ekle");
        btnDoctorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorAddActionPerformed(evt);
            }
        });
        DoctorPn.add(btnDoctorAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, 194, 34));
        DoctorPn.add(tbxDoctorNameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 194, 28));

        jLabel82.setText("Adi :");
        DoctorPn.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));
        DoctorPn.add(tbxDoctorSurnameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 194, 28));

        jLabel83.setText("Soyad :");
        DoctorPn.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));

        jLabel84.setText("Expertise Id :");
        DoctorPn.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));
        DoctorPn.add(tbxDoctorBirthdateAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 194, 30));

        jLabel85.setText("Doğum Tarihi");
        DoctorPn.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));

        jLabel86.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel86.setText("Silme İşlemi");
        DoctorPn.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 790, -1, -1));
        DoctorPn.add(tbxDoctorBirthdateUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 740, 194, 30));

        jLabel87.setText("Doğum Tarihi :");
        DoctorPn.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 750, -1, -1));

        btnDoctorUpdate.setText("Update");
        btnDoctorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorUpdateActionPerformed(evt);
            }
        });
        DoctorPn.add(btnDoctorUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 750, 194, 36));
        DoctorPn.add(tbxDoctorNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, 194, 32));

        jLabel88.setText("Adi :");
        DoctorPn.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 670, -1, -1));
        DoctorPn.add(tbxDoctorSurnameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 700, 194, 31));

        jLabel89.setText("Soyad :");
        DoctorPn.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 700, -1, -1));

        jLabel90.setText("Expertise Id :");
        DoctorPn.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 630, -1, -1));

        tbxDoctorIdUpdateDoctorPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxDoctorIdUpdateDoctorPanelActionPerformed(evt);
            }
        });
        DoctorPn.add(tbxDoctorIdUpdateDoctorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 620, 194, 32));

        jLabel91.setText("Id :");
        DoctorPn.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, -1, -1));

        btnDoctorDelete.setText("Delete");
        btnDoctorDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorDeleteActionPerformed(evt);
            }
        });
        DoctorPn.add(btnDoctorDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 870, 152, 32));
        DoctorPn.add(tbxDoctorIdDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 830, 152, 32));

        jLabel92.setText("Id : ");
        DoctorPn.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 830, 64, 32));
        DoctorPn.add(tbxDoctorUserNameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 194, 33));

        jLabel93.setText("Kullanıcı Adi");
        DoctorPn.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, -1, -1));
        DoctorPn.add(tbxDoctorPasswordAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 194, 33));

        jLabel13.setText("Parola");
        DoctorPn.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, -1, -1));
        DoctorPn.add(tbxDoctorPasswordUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 700, 194, 33));

        jLabel14.setText("Parola :");
        DoctorPn.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 710, 70, 20));

        jLabel94.setText("Kullanıcı Adi :");
        DoctorPn.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 670, 70, 30));
        DoctorPn.add(tbxDoctorUserNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 660, 194, 33));

        jLabel95.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel95.setText("Ekleme İşlemi");
        DoctorPn.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        jLabel96.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel96.setText("Güncelleme İşlemi");
        DoctorPn.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, -1, -1));

        cbxDoctorExpertiseIdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDoctorExpertiseIdAddActionPerformed(evt);
            }
        });
        DoctorPn.add(cbxDoctorExpertiseIdAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 190, 30));

        cbxDoctorExpertiseIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDoctorExpertiseIdUpdateActionPerformed(evt);
            }
        });
        DoctorPn.add(cbxDoctorExpertiseIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 620, 190, 30));

        jPanel12.add(DoctorPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 950));

        ExpertisePn.setPreferredSize(new java.awt.Dimension(830, 950));

        btnExpertiseUpdate.setText("Update");
        btnExpertiseUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpertiseUpdateActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel21.setText("Silme İşlemi");

        jLabel22.setText("Id : ");

        jLabel23.setText("Uzmanlık Adi :");

        btnExpertiseDelete.setText("Delete");
        btnExpertiseDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpertiseDeleteActionPerformed(evt);
            }
        });

        btnExpertiseAdd.setText("Ekle");
        btnExpertiseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpertiseAddActionPerformed(evt);
            }
        });

        tblExpertises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblExpertises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExpertisesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblExpertises);

        tbxExpertiseIdUpdateExpertisePanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxExpertiseIdUpdateExpertisePanelActionPerformed(evt);
            }
        });

        jLabel24.setText("Uzmanlık Adi :");

        jLabel12.setText("Id :");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel25.setText("Ekleme İşlemi");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel26.setText("Güncelleme İşlemi");

        javax.swing.GroupLayout ExpertisePnLayout = new javax.swing.GroupLayout(ExpertisePn);
        ExpertisePn.setLayout(ExpertisePnLayout);
        ExpertisePnLayout.setHorizontalGroup(
            ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpertisePnLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExpertisePnLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(ExpertisePnLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ExpertisePnLayout.createSequentialGroup()
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnExpertiseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ExpertisePnLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(tbxExpertiseNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel12))
                                .addGap(39, 39, 39)
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tbxExpertiseNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxExpertiseIdUpdateExpertisePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExpertiseUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpertisePnLayout.createSequentialGroup()
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExpertiseDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpertisePnLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tbxExpertiseIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpertisePnLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(66, 66, 66))))))
            .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ExpertisePnLayout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addComponent(jLabel25)
                    .addContainerGap(653, Short.MAX_VALUE)))
        );
        ExpertisePnLayout.setVerticalGroup(
            ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpertisePnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExpertisePnLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbxExpertiseNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExpertiseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ExpertisePnLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExpertisePnLayout.createSequentialGroup()
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel21))
                                .addGap(16, 16, 16)
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbxExpertiseIdUpdateExpertisePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbxExpertiseNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)))
                            .addGroup(ExpertisePnLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbxExpertiseIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExpertiseDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnExpertiseUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(448, Short.MAX_VALUE))
            .addGroup(ExpertisePnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ExpertisePnLayout.createSequentialGroup()
                    .addGap(328, 328, 328)
                    .addComponent(jLabel25)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );

        jPanel12.add(ExpertisePn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 950));

        PatientPn.setPreferredSize(new java.awt.Dimension(830, 950));

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
        jScrollPane3.setViewportView(tblPatients);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 36, -1, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel35.setText("Ekleme İşlemi");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 12, -1, -1));

        jLabel36.setText("Adi :");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel3.add(tbxPatientSurnameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 194, 28));

        jLabel37.setText("Soyad :");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        jPanel3.add(tbxPatientBirthdateAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 194, 30));

        jLabel38.setText("Doğum Tarihi :");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        btnPatientAdd.setText("Ekle");
        btnPatientAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnPatientAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 194, 34));
        jPanel3.add(tbxPatientNameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 194, 28));

        jLabel97.setText("Kullanıcı Adi :");
        jPanel3.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));
        jPanel3.add(tbxPatientUserNameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 194, 30));

        jLabel98.setText("Parola :");
        jPanel3.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, -1, -1));
        jPanel3.add(tbxPatientPasswordAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 194, 30));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel39.setText("Güncelleme İşlemi");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 12, -1, -1));

        tbxPatientIdUpdatePatientPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPatientIdUpdatePatientPanelActionPerformed(evt);
            }
        });
        jPanel7.add(tbxPatientIdUpdatePatientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 53, 194, 32));

        jLabel40.setText("Id :");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 62, -1, -1));

        jLabel41.setText("Soyad :");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, 20));
        jPanel7.add(tbxPatientBirthdateUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 194, 30));

        jLabel42.setText("Doğum Tarihi :");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        btnUpdate2.setText("Update");
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });
        jPanel7.add(btnUpdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 194, 36));
        jPanel7.add(tbxPatientNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 91, 194, 32));

        jLabel43.setText("Adi :");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 100, -1, -1));
        jPanel7.add(tbxPatientSurnameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 194, 31));
        jPanel7.add(tbxPatientPasswordUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 194, 30));

        jLabel100.setText("Parola :");
        jPanel7.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));
        jPanel7.add(tbxPatientUserNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 194, 30));

        jLabel99.setText("Kullanıcı Adi :");
        jPanel7.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, -1));

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel44.setText("Id : ");

        btnDelete2.setText("Sil");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel45.setText("Silme İşlemi");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(tbxPatientIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addGap(10, 10, 10)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxPatientIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PatientPnLayout = new javax.swing.GroupLayout(PatientPn);
        PatientPn.setLayout(PatientPnLayout);
        PatientPnLayout.setHorizontalGroup(
            PatientPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PatientPnLayout.setVerticalGroup(
            PatientPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPnLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 110, Short.MAX_VALUE))
        );

        jPanel12.add(PatientPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 950));

        PersonalPn.setPreferredSize(new java.awt.Dimension(830, 950));

        tblPersonals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Surname", "Birthdate", "PositionId"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPersonals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonalsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPersonals);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setText("Soyad :");
        jPanel6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));
        jPanel6.add(tbxPersonalSurnameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 194, 31));

        jLabel48.setText("Adi :");
        jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel47.setText("Id :");
        jPanel6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));
        jPanel6.add(tbxPersonalNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 194, 32));

        btnPersonalUpdate.setText("Update");
        btnPersonalUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalUpdateActionPerformed(evt);
            }
        });
        jPanel6.add(btnPersonalUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 194, 36));

        tbxPersonalIdUpdatePersonalPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPersonalIdUpdatePersonalPanelActionPerformed(evt);
            }
        });
        jPanel6.add(tbxPersonalIdUpdatePersonalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 194, 32));

        jLabel46.setText("Position Id :");
        jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        jLabel56.setText("Doğum Tarihi :");
        jPanel6.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        jPanel6.add(tbxPersonalBirthdateUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 194, 30));

        jLabel102.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel102.setText("Güncelleme İşlemi");
        jPanel6.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jPanel6.add(cbxPersonalPositionIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 190, 30));
        jPanel6.add(tbxPersonalPasswordUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 194, 33));

        jLabel64.setText("Parola :");
        jPanel6.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel111.setText("Kullanıcı Adi :");
        jPanel6.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));
        jPanel6.add(tbxPersonalUserNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 194, 33));

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPersonalAdd.setText("Ekle");
        btnPersonalAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalAddActionPerformed(evt);
            }
        });
        jPanel14.add(btnPersonalAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 194, 34));
        jPanel14.add(tbxPersonalBirthdateAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 124, 194, 30));

        jLabel54.setText("Doğum Tarihi");
        jPanel14.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 132, -1, -1));

        jLabel50.setText("Soyad :");
        jPanel14.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 93, -1, -1));

        jLabel49.setText("Adi :");
        jPanel14.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 54, -1, -1));
        jPanel14.add(tbxPersonalNameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 47, 194, 28));
        jPanel14.add(tbxPersonalSurnameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 86, 194, 28));

        jLabel53.setText("Position Id :");
        jPanel14.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        jLabel101.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel101.setText("Ekleme İşlemi");
        jPanel14.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 17, -1, -1));

        jPanel14.add(cbxPersonalPositionIdAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 190, 30));
        jPanel14.add(tbxPersonalPasswordAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 194, 33));

        jLabel63.setText("Parola :");
        jPanel14.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel110.setText("Kullanıcı Adi :");
        jPanel14.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));
        jPanel14.add(tbxPersonalUserNameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 194, 33));

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPersonalDelete.setText("Delete");
        btnPersonalDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalDeleteActionPerformed(evt);
            }
        });
        jPanel16.add(btnPersonalDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 152, 32));
        jPanel16.add(tbxPersonalIdDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 152, 32));

        jLabel52.setText("Id : ");
        jPanel16.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, 32));

        jLabel55.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel55.setText("Silme İşlemi");
        jPanel16.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        javax.swing.GroupLayout PersonalPnLayout = new javax.swing.GroupLayout(PersonalPn);
        PersonalPn.setLayout(PersonalPnLayout);
        PersonalPnLayout.setHorizontalGroup(
            PersonalPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PersonalPnLayout.setVerticalGroup(
            PersonalPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalPnLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.add(PersonalPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 950));

        PatientAppointment.setPreferredSize(new java.awt.Dimension(830, 950));

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
        jScrollPane2.setViewportView(tblPatientAppointments);

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPatientAppointmentAdd.setText("Ekle");
        btnPatientAppointmentAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientAppointmentAddActionPerformed(evt);
            }
        });
        jPanel15.add(btnPatientAppointmentAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 194, 30));
        jPanel15.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 36, -1, -1));

        jLabel10.setText("Patient Id :");
        jPanel15.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 55, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel27.setText("Ekleme İşlemi");
        jPanel15.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 1, -1, -1));

        jLabel28.setText("Randevu Tarihi");
        jPanel15.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));
        jPanel15.add(tbxPatientAppointmentAppointmentDateTimeAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 194, 30));

        jLabel29.setText("Docktor Id :");
        jPanel15.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jPanel15.add(cbxPatientAppointmentDoctorIdAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 84, 194, 28));

        jPanel15.add(cbxPatientAppointmentPatientIdAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 194, 28));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPatientAppointmentUpdate.setText("Güncelle");
        btnPatientAppointmentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientAppointmentUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnPatientAppointmentUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 126, 194, 30));

        jLabel30.setText("Patient Id :");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 100, -1, -1));

        tbxPatientAppointmentIdUpdateAppointmentPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPatientAppointmentIdUpdateAppointmentPanelActionPerformed(evt);
            }
        });
        jPanel2.add(tbxPatientAppointmentIdUpdateAppointmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 53, 194, 32));

        jLabel31.setText("Id :");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 62, -1, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel32.setText("Güncelleme İşlemi");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 12, -1, -1));

        jPanel2.add(cbxPatientAppointmentDoctorIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 190, 28));
        jPanel2.add(tbxPatientAppointmentAppointmentDateTimeUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 194, 30));

        jLabel33.setText("Doctor Id :");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, 20));

        jLabel103.setText("Randevu Tarihi");
        jPanel2.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jPanel2.add(cbxPatientAppointmentPatientIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 194, 28));

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel104.setText("Id : ");

        btnPatientAppointmentDelete.setText("Sil");
        btnPatientAppointmentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientAppointmentDeleteActionPerformed(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel105.setText("Silme İşlemi");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel105)
                .addGap(317, 317, 317))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel104)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPatientAppointmentDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxPatientAppointmentIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel105)
                .addGap(10, 10, 10)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxPatientAppointmentIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPatientAppointmentDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PatientAppointmentLayout = new javax.swing.GroupLayout(PatientAppointment);
        PatientAppointment.setLayout(PatientAppointmentLayout);
        PatientAppointmentLayout.setHorizontalGroup(
            PatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAppointmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PatientAppointmentLayout.setVerticalGroup(
            PatientAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientAppointmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jPanel12.add(PatientAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 950));

        PositionPn.setPreferredSize(new java.awt.Dimension(960, 950));

        tblPositions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPositions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPositionsMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblPositions);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setText("Pozisyon Adi :");
        jPanel4.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));
        jPanel4.add(tbxPositionNameAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 194, 28));

        btnPositionAdd.setText("Ekle");
        btnPositionAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPositionAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnPositionAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 194, 34));

        jLabel106.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel106.setText("Ekleme İşlemi");
        jPanel4.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPositionUpdate.setText("Update");
        btnPositionUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPositionUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(btnPositionUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 200, 36));
        jPanel8.add(tbxPositionNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 104, 194, 32));

        tbxPositionIdUpdatePositionPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPositionIdUpdatePositionPanelActionPerformed(evt);
            }
        });
        jPanel8.add(tbxPositionIdUpdatePositionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 66, 194, 32));

        jLabel81.setText("Id :");
        jPanel8.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 75, -1, -1));

        jLabel79.setText("Pozisyon Adi :");
        jPanel8.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 113, -1, -1));

        jLabel107.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel107.setText("Güncelleme İşlemi");
        jPanel8.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPositionDelete.setText("Delete");
        btnPositionDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPositionDeleteActionPerformed(evt);
            }
        });
        jPanel9.add(btnPositionDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 152, 32));
        jPanel9.add(tbxPositionIdDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 152, 32));

        jLabel77.setText("Id : ");
        jPanel9.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, 32));

        jLabel78.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel78.setText("Silme İşlemi");
        jPanel9.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        javax.swing.GroupLayout PositionPnLayout = new javax.swing.GroupLayout(PositionPn);
        PositionPn.setLayout(PositionPnLayout);
        PositionPnLayout.setHorizontalGroup(
            PositionPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addGroup(PositionPnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PositionPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PositionPnLayout.setVerticalGroup(
            PositionPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PositionPnLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        jPanel12.add(PositionPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 950));

        MyProfile.setPreferredSize(new java.awt.Dimension(968, 972));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setText("Soyad :");
        jPanel10.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));
        jPanel10.add(tbxMyProfileSurnameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 194, 31));

        jLabel58.setText("Adi :");
        jPanel10.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel59.setText("Id :");
        jPanel10.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));
        jPanel10.add(tbxMyProfileNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 194, 32));

        btnMyProfileUpdate.setText("Update");
        btnMyProfileUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileUpdateActionPerformed(evt);
            }
        });
        jPanel10.add(btnMyProfileUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 194, 36));

        tbxMyProfilelIdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxMyProfilelIdUpdateActionPerformed(evt);
            }
        });
        jPanel10.add(tbxMyProfilelIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 194, 32));

        jLabel60.setText("Position Id :");
        jPanel10.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jLabel61.setText("Doğum Tarihi :");
        jPanel10.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        jPanel10.add(tbxMyProfileBirthdateUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 194, 30));

        jLabel108.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel108.setText("Güncelleme İşlemi");
        jPanel10.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jPanel10.add(cbxMyProfilePositionIdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 190, 30));

        jLabel109.setText("Kullanıcı Adi :");
        jPanel10.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        jLabel62.setText("Parola :");
        jPanel10.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));
        jPanel10.add(tbxMyProfilePasswordUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 194, 33));
        jPanel10.add(tbxMyProfileUserNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 194, 33));

        javax.swing.GroupLayout MyProfileLayout = new javax.swing.GroupLayout(MyProfile);
        MyProfile.setLayout(MyProfileLayout);
        MyProfileLayout.setHorizontalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );
        MyProfileLayout.setVerticalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(577, Short.MAX_VALUE))
        );

        jPanel12.add(MyProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 950));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(954, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 401, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnWelcomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWelcomeMouseClicked
        PatientPn.setVisible(false);
        DoctorPn.setVisible(false);
        ExpertisePn.setVisible(false);
        PersonalPn.setVisible(false);
        PatientAppointment.setVisible(false);
        PositionPn.setVisible(false);
        MyProfile.setVisible(true);
    }//GEN-LAST:event_btnWelcomeMouseClicked

    private void btnWelcomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWelcomeMousePressed
        setColor(btnWelcome);
        resetColor(BtnPatient);
        resetColor(btnExpertise);
        resetColor(btnDoctor);
        resetColor(btnPosition);
        resetColor(btnPersonal);
        resetColor(btnPatientAppoiment);
    }//GEN-LAST:event_btnWelcomeMousePressed

    private void btnDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoctorMouseClicked
        doctorPanelComboBoxFill();
        model = (DefaultTableModel)tblDoctors.getModel();
        doctorsTableFill();
        PersonalPn.setVisible(false);
        ExpertisePn.setVisible(false);
        PatientPn.setVisible(false);
        MyProfile.setVisible(false);
        PatientAppointment.setVisible(false);
        PositionPn.setVisible(false);
        DoctorPn.setVisible(true);
    }//GEN-LAST:event_btnDoctorMouseClicked

    private void btnDoctorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoctorMousePressed
        setColor(btnDoctor);
        resetColor(btnWelcome);
        resetColor(BtnPatient);
        resetColor(btnExpertise);
        resetColor(btnPosition);
        resetColor(btnPersonal);
        resetColor(btnPatientAppoiment);
    }//GEN-LAST:event_btnDoctorMousePressed

    private void BtnPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPatientMouseClicked
        model = (DefaultTableModel)tblPatients.getModel();
        patientsTableFill();
        PersonalPn.setVisible(false);
        ExpertisePn.setVisible(false);
        DoctorPn.setVisible(false);
        MyProfile.setVisible(false);
        PatientAppointment.setVisible(false);
        PositionPn.setVisible(false);
        PatientPn.setVisible(true);
    }//GEN-LAST:event_BtnPatientMouseClicked

    private void BtnPatientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPatientMousePressed
        setColor(BtnPatient);
        resetColor(btnWelcome);
        resetColor(btnExpertise);
        resetColor(btnDoctor);
        resetColor(btnPosition);
        resetColor(btnPersonal);
        resetColor(btnPatientAppoiment);
    }//GEN-LAST:event_BtnPatientMousePressed

    private void btnExpertiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpertiseMouseClicked
        model = (DefaultTableModel)tblExpertises.getModel();
        expertisesTableFill();
        DoctorPn.setVisible(false);
        PatientPn.setVisible(false);
        MyProfile.setVisible(false);
        PersonalPn.setVisible(false);
        PatientAppointment.setVisible(false);
        PositionPn.setVisible(false);
        ExpertisePn.setVisible(true);
    }//GEN-LAST:event_btnExpertiseMouseClicked

    private void btnExpertiseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpertiseMousePressed
        setColor(btnExpertise);
        resetColor(btnWelcome);
        resetColor(BtnPatient);
        resetColor(btnDoctor);
        resetColor(btnPosition);
        resetColor(btnPersonal);
        resetColor(btnPatientAppoiment);
    }//GEN-LAST:event_btnExpertiseMousePressed

    private void btnPatientAppoimentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientAppoimentMouseClicked
        patientAppointmentDoctorComboBoxFill(); 
        patientAppointmentpatientComboBoxFill();
        model = (DefaultTableModel)tblPatientAppointments.getModel();
        patientAppointmentTableFill();
        DoctorPn.setVisible(false);
        PatientPn.setVisible(false);
        PersonalPn.setVisible(false);
        MyProfile.setVisible(false);
        ExpertisePn.setVisible(false);
        PositionPn.setVisible(false);
        PatientAppointment.setVisible(true);
    }//GEN-LAST:event_btnPatientAppoimentMouseClicked

    private void btnPatientAppoimentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatientAppoimentMousePressed
        setColor(btnPatientAppoiment);
        resetColor(btnWelcome);
        resetColor(BtnPatient);
        resetColor(btnExpertise);
        resetColor(btnDoctor);
        resetColor(btnPosition);
        resetColor(btnPersonal);
    }//GEN-LAST:event_btnPatientAppoimentMousePressed

    private void btnPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPositionMouseClicked
        model = (DefaultTableModel)tblPositions.getModel();
        positionTableFill();
        PatientAppointment.setVisible(false);
        PatientPn.setVisible(false);
        DoctorPn.setVisible(false);
        MyProfile.setVisible(false);
        ExpertisePn.setVisible(false);
        PersonalPn.setVisible(false);
        PositionPn.setVisible(true);
    }//GEN-LAST:event_btnPositionMouseClicked

    private void btnPositionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPositionMousePressed
        setColor(btnPosition);
        resetColor(btnWelcome);
        resetColor(BtnPatient);
        resetColor(btnExpertise);
        resetColor(btnDoctor);
        resetColor(btnPersonal);
        resetColor(btnPatientAppoiment);
    }//GEN-LAST:event_btnPositionMousePressed

    private void btnPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseClicked
        personalPanelComboBoxFill();
        model = (DefaultTableModel)tblPersonals.getModel();
        personalTableFill();
        PatientPn.setVisible(false);
        DoctorPn.setVisible(false);
        MyProfile.setVisible(false);
        ExpertisePn.setVisible(false);
        PatientAppointment.setVisible(false);
        PositionPn.setVisible(false);
        PersonalPn.setVisible(true);
    }//GEN-LAST:event_btnPersonalMouseClicked

    private void btnPersonalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMousePressed
        setColor(btnPersonal);
        resetColor(btnWelcome);
        resetColor(BtnPatient);
        resetColor(btnExpertise);
        resetColor(btnPatientAppoiment);
        resetColor(btnDoctor);
        resetColor(btnPosition);
    }//GEN-LAST:event_btnPersonalMousePressed

    private void tblPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsMouseClicked
        int row=tblPatients.rowAtPoint(evt.getPoint());
        
        tbxPatientIdUpdatePatientPanel.setText(tblPatients.getValueAt(row,0).toString());
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
            tbxPatientUserNameAdd.getText(),
            tbxPatientPasswordAdd.getText()
        );
        patientService.add(patient);
        JOptionPane.showMessageDialog(null,"Hasta Başarıyla Eklendi");
        patientsTableFill();
    }//GEN-LAST:event_btnPatientAddActionPerformed

    private void tbxPatientIdUpdatePatientPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxPatientIdUpdatePatientPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxPatientIdUpdatePatientPanelActionPerformed

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        Patient patient = new Patient
        (
            Integer.parseInt(tbxPatientIdUpdatePatientPanel.getText()),
            tbxPatientNameUpdate.getText(),
            tbxPatientSurnameUpdate.getText(),
            LocalDateTime.parse(tbxPatientBirthdateUpdate.getText()),
            tbxPatientUserNameUpdate.getText(),
            tbxPatientPasswordUpdate.getText()
        );
        patientService.update(patient);
        JOptionPane.showMessageDialog(null,"Hasta Başarıyla Güncellendi");
        patientsTableFill();
    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        patientService.delete(Integer.parseInt(tbxPatientIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Hasta Başarıyla Silindi");
        patientsTableFill();
    }//GEN-LAST:event_btnDelete2ActionPerformed

    
    
    private void tblPersonalsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonalsMouseClicked
        int row=tblPersonals.rowAtPoint(evt.getPoint());
        tbxPersonalIdUpdatePersonalPanel.setText(tblPersonals.getValueAt(row,0).toString());
        tbxPersonalNameUpdate.setText(tblPersonals.getValueAt(row,1).toString());
        tbxPersonalSurnameUpdate.setText(tblPersonals.getValueAt(row,2).toString());
        tbxPersonalBirthdateUpdate.setText(tblPersonals.getValueAt(row,3).toString());

        tbxPersonalIdDelete.setText(tblPersonals.getValueAt(row,0).toString());
    }//GEN-LAST:event_tblPersonalsMouseClicked

    private void tbxPersonalIdUpdatePersonalPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxPersonalIdUpdatePersonalPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxPersonalIdUpdatePersonalPanelActionPerformed

    private void btnPersonalDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalDeleteActionPerformed
        personalService.delete(Integer.parseInt(tbxPersonalIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Personal Başarıyla Silindi");
        personalTableFill();
    }//GEN-LAST:event_btnPersonalDeleteActionPerformed

    private void btnPersonalAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalAddActionPerformed
        Personal personal = new Personal
        (
            tbxPersonalNameAdd.getText(),
            tbxPersonalSurnameAdd.getText(),
            LocalDateTime.parse(tbxPersonalBirthdateAdd.getText()),
            personalPanelPositions.get(cbxPersonalPositionIdAdd.getSelectedIndex()).getId(),
            tbxPersonalUserNameAdd.getText(),
            tbxPersonalUserNameUpdate.getText()
        );
        personalService.add(personal);
        JOptionPane.showMessageDialog(null,"Personal Başarıyla Eklendi");
        personalTableFill();
        
    }//GEN-LAST:event_btnPersonalAddActionPerformed

    private void btnPersonalUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalUpdateActionPerformed
        Personal doctor = new Personal
        (
            Integer.parseInt(tbxPersonalIdUpdatePersonalPanel.getText()),
            tbxPersonalNameUpdate.getText(),
            tbxPersonalSurnameUpdate.getText(),
            LocalDateTime.parse(tbxPersonalBirthdateUpdate.getText()),
            personalPanelPositions.get(cbxPersonalPositionIdUpdate.getSelectedIndex()).getId(),
            tbxPersonalUserNameUpdate.getText(),
            tbxPersonalPasswordUpdate.getText()
        );
        personalService.update(doctor);
        JOptionPane.showMessageDialog(null,"Personal Başarıyla Güncellendi");
        personalTableFill();
    }//GEN-LAST:event_btnPersonalUpdateActionPerformed

    private void tblPositionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPositionsMouseClicked
        int row=tblPositions.rowAtPoint(evt.getPoint());
        tbxPositionIdUpdatePositionPanel.setText(tblPositions.getValueAt(row,0).toString());
        tbxPositionNameUpdate.setText(tblPositions.getValueAt(row,1).toString());

        tbxPositionIdDelete.setText(tblPositions.getValueAt(row,0).toString());
    }//GEN-LAST:event_tblPositionsMouseClicked

    private void btnPositionUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPositionUpdateActionPerformed
        Position position = new Position
        (
            Integer.parseInt(tbxPositionIdUpdatePositionPanel.getText()),
            tbxPositionNameUpdate.getText()
        );
        positionService.update(position);
        JOptionPane.showMessageDialog(null,"Pozisyon Başarıyla Güncellendi");
        positionTableFill();
    }//GEN-LAST:event_btnPositionUpdateActionPerformed

    private void tbxPositionIdUpdatePositionPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxPositionIdUpdatePositionPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxPositionIdUpdatePositionPanelActionPerformed

    private void btnPositionAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPositionAddActionPerformed
        Position position = new Position
        (
            tbxPositionNameAdd.getText()
        );
        positionService.add(position);
        JOptionPane.showMessageDialog(null,"Pozisyon Başarıyla Eklendi");
        positionTableFill();
    }//GEN-LAST:event_btnPositionAddActionPerformed

    private void btnPositionDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPositionDeleteActionPerformed
        positionService.delete(Integer.parseInt(tbxPositionIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Pozisyon Başarıyla Silindi");
        positionTableFill();
    }//GEN-LAST:event_btnPositionDeleteActionPerformed

    private void tblDoctorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoctorsMouseClicked
        int row=tblDoctors.rowAtPoint(evt.getPoint());

        tbxDoctorIdUpdateDoctorPanel.setText(tblDoctors.getValueAt(row,0).toString());
        tbxDoctorNameUpdate.setText(tblDoctors.getValueAt(row,1).toString());
        tbxDoctorSurnameUpdate.setText(tblDoctors.getValueAt(row,2).toString());
        tbxDoctorBirthdateUpdate.setText(tblDoctors.getValueAt(row,3).toString());
        tbxDoctorUserNameUpdate.setText(tblDoctors.getValueAt(row,5).toString());
        tbxDoctorPasswordUpdate.setText(tblDoctors.getValueAt(row,6).toString());
        tbxDoctorIdDelete.setText(tblDoctors.getValueAt(row,0).toString());

    }//GEN-LAST:event_tblDoctorsMouseClicked

    private void btnDoctorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorAddActionPerformed
        Doctor doctor = new Doctor
        (
            tbxDoctorNameAdd.getText(),
            tbxDoctorSurnameAdd.getText(),
                LocalDateTime.parse(tbxDoctorBirthdateAdd.getText()),
            doctorPanelExpertises.get(cbxDoctorExpertiseIdAdd.getSelectedIndex()).getId(),
            tbxDoctorUserNameAdd.getText(),
            tbxDoctorPasswordAdd.getText()
        );
        doctorService.add(doctor);
        JOptionPane.showMessageDialog(null,"Doktor Başarıyla Eklendi");
        doctorsTableFill();
    }//GEN-LAST:event_btnDoctorAddActionPerformed

    private void btnDoctorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorUpdateActionPerformed
        Doctor doctor = new Doctor
        (
            Integer.parseInt(tbxDoctorIdUpdateDoctorPanel.getText()),
            tbxDoctorNameUpdate.getText(),
            tbxDoctorSurnameUpdate.getText(),
            LocalDateTime.parse(tbxDoctorBirthdateUpdate.getText()),
            doctorPanelExpertises.get(cbxDoctorExpertiseIdUpdate.getSelectedIndex()).getId(),
            tbxDoctorUserNameUpdate.getText(),
            tbxDoctorPasswordUpdate.getText()
        );
        doctorService.update(doctor);
        JOptionPane.showMessageDialog(null,"Doktor Başarıyla Güncellendi");
        doctorsTableFill();

    }//GEN-LAST:event_btnDoctorUpdateActionPerformed

    private void tbxDoctorIdUpdateDoctorPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxDoctorIdUpdateDoctorPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxDoctorIdUpdateDoctorPanelActionPerformed

    private void btnDoctorDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorDeleteActionPerformed
        doctorService.delete(Integer.parseInt(tbxDoctorIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Doktor Başarıyla Silindi");
        doctorsTableFill();
    }//GEN-LAST:event_btnDoctorDeleteActionPerformed

    private void cbxDoctorExpertiseIdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDoctorExpertiseIdAddActionPerformed

    }//GEN-LAST:event_cbxDoctorExpertiseIdAddActionPerformed

    private void cbxDoctorExpertiseIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDoctorExpertiseIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDoctorExpertiseIdUpdateActionPerformed

    private void btnExpertiseUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpertiseUpdateActionPerformed
        Expertise expertise = new Expertise
        (
            Integer.parseInt(tbxExpertiseIdUpdateExpertisePanel.getText()),
            tbxExpertiseNameUpdate.getText()
        );
        expertiseService.update(expertise);
        JOptionPane.showMessageDialog(null,"Uzmanlık Başarıyla Güncellendi");
        expertisesTableFill();
    }//GEN-LAST:event_btnExpertiseUpdateActionPerformed

    private void btnExpertiseDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpertiseDeleteActionPerformed
        expertiseService.delete(Integer.parseInt(tbxExpertiseIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Uzmanlik Başarıyla Silindi");
        expertisesTableFill();
    }//GEN-LAST:event_btnExpertiseDeleteActionPerformed

    private void btnExpertiseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpertiseAddActionPerformed
        Expertise expertise = new Expertise
        (
            tbxExpertiseNameAdd.getText()
        );
        expertiseService.add(expertise);
        JOptionPane.showMessageDialog(null,"Uzmanlik Başarıyla Eklendi");
        expertisesTableFill();
    }//GEN-LAST:event_btnExpertiseAddActionPerformed

    private void tblExpertisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExpertisesMouseClicked
        int row=tblExpertises.rowAtPoint(evt.getPoint());
        tbxExpertiseIdUpdateExpertisePanel.setText(tblExpertises.getValueAt(row,0).toString());
        tbxExpertiseNameUpdate.setText(tblExpertises.getValueAt(row,1).toString());
        tbxExpertiseIdDelete.setText(tblExpertises.getValueAt(row,0).toString());
    }//GEN-LAST:event_tblExpertisesMouseClicked

    private void tbxExpertiseIdUpdateExpertisePanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxExpertiseIdUpdateExpertisePanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxExpertiseIdUpdateExpertisePanelActionPerformed

    private void tblPatientAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientAppointmentsMouseClicked
        int row=tblPatientAppointments.rowAtPoint(evt.getPoint());
        tbxPatientAppointmentIdUpdateAppointmentPanel.setText(tblPatientAppointments.getValueAt(row,0).toString());
        //tbxPatientIdUpdate.setText(tblPatientAppointments.getValueAt(row,1).toString());
        tbxPatientAppointmentAppointmentDateTimeUpdate.setText(tblPatientAppointments.getValueAt(row,3).toString());

        tbxPatientAppointmentIdDelete.setText(tblPatientAppointments.getValueAt(row,0).toString());
    }//GEN-LAST:event_tblPatientAppointmentsMouseClicked

    private void btnPatientAppointmentAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientAppointmentAddActionPerformed
        PatientAppointment patientAppointment = new PatientAppointment
        (
            patientAppointmentPatients.get(cbxPatientAppointmentPatientIdAdd.getSelectedIndex()).getId(),
            patientAppointmentDoctors.get(cbxPatientAppointmentDoctorIdAdd.getSelectedIndex()).getId(),
            LocalDateTime.parse(tbxPatientAppointmentAppointmentDateTimeAdd.getText())
        );
        patientAppointmentService.add(patientAppointment);
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Eklendi");
        patientAppointmentTableFill();
    }//GEN-LAST:event_btnPatientAppointmentAddActionPerformed

    private void btnPatientAppointmentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientAppointmentUpdateActionPerformed
        PatientAppointment patientAppointment = new PatientAppointment
        (
            Integer.parseInt(tbxPatientAppointmentIdUpdateAppointmentPanel.getText()),
            patientAppointmentPatients.get(cbxPatientAppointmentPatientIdUpdate.getSelectedIndex()).getId(),
            patientAppointmentDoctors.get(cbxPatientAppointmentDoctorIdUpdate.getSelectedIndex()).getId(),
            LocalDateTime.parse(tbxPatientAppointmentAppointmentDateTimeUpdate.getText())

        );
        patientAppointmentService.update(patientAppointment);
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Güncellendi");
        patientAppointmentTableFill();
    }//GEN-LAST:event_btnPatientAppointmentUpdateActionPerformed

    private void tbxPatientAppointmentIdUpdateAppointmentPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxPatientAppointmentIdUpdateAppointmentPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxPatientAppointmentIdUpdateAppointmentPanelActionPerformed

    private void btnPatientAppointmentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientAppointmentDeleteActionPerformed
        patientAppointmentService.delete(Integer.parseInt(tbxPatientAppointmentIdDelete.getText()));
        JOptionPane.showMessageDialog(null,"Hasta Randevusu Başarıyla Silindi");
        patientAppointmentTableFill();
    }//GEN-LAST:event_btnPatientAppointmentDeleteActionPerformed

    private void btnMyProfileUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileUpdateActionPerformed
        Personal doctor = new Personal
        (
            Integer.parseInt(tbxMyProfilelIdUpdate.getText()),
            tbxMyProfileNameUpdate.getText(),
            tbxMyProfileSurnameUpdate.getText(),
            LocalDateTime.parse(tbxMyProfileBirthdateUpdate.getText()),
            myProfilePositions.get(cbxMyProfilePositionIdUpdate.getSelectedIndex()).getId(),
            tbxMyProfileUserNameUpdate.getText(),
            tbxMyProfilePasswordUpdate.getText()
        );
        personalService.update(doctor);
        JOptionPane.showMessageDialog(null,"Personal Başarıyla Güncellendi");      
    }//GEN-LAST:event_btnMyProfileUpdateActionPerformed
    public void myProfileFiil(){
        myProfileComboBoxFill();
        String userName = Thread.currentThread().getName();
        Personal personal = personalService.getByUserName(userName);
        if (personal != null) {
            tbxMyProfilelIdUpdate.setText(String.valueOf(personal.getId()));
            tbxMyProfileNameUpdate.setText(personal.getName());
            tbxMyProfileSurnameUpdate.setText(personal.getSurname());
            tbxMyProfileBirthdateUpdate.setText(personal.getBirthdate().toString());
            tbxMyProfileUserNameUpdate.setText(personal.getUserName());
            tbxMyProfilePasswordUpdate.setText(personal.getPassword());
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Again Login");
        }
        
    }
    private void tbxMyProfilelIdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxMyProfilelIdUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxMyProfilelIdUpdateActionPerformed
    void setColor(JPanel panel)
    {
        panel.setBackground(new Color(85,55,118));
    }
    void resetColor(JPanel panel)
    {
        panel.setBackground(new Color(64,43,100));
    }
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
            java.util.logging.Logger.getLogger(PersonalProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonalProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonalProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonalProcessings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalProcessings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnPatient;
    private javax.swing.JPanel DoctorPn;
    private javax.swing.JPanel ExpertisePn;
    private javax.swing.JPanel MyProfile;
    private javax.swing.JPanel PatientAppointment;
    private javax.swing.JPanel PatientPn;
    private javax.swing.JPanel PersonalPn;
    private javax.swing.JPanel PositionPn;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JPanel btnDoctor;
    private javax.swing.JButton btnDoctorAdd;
    private javax.swing.JButton btnDoctorDelete;
    private javax.swing.JButton btnDoctorUpdate;
    private javax.swing.JPanel btnExpertise;
    private javax.swing.JButton btnExpertiseAdd;
    private javax.swing.JButton btnExpertiseDelete;
    private javax.swing.JButton btnExpertiseUpdate;
    private javax.swing.JButton btnMyProfileUpdate;
    private javax.swing.JButton btnPatientAdd;
    private javax.swing.JPanel btnPatientAppoiment;
    private javax.swing.JButton btnPatientAppointmentAdd;
    private javax.swing.JButton btnPatientAppointmentDelete;
    private javax.swing.JButton btnPatientAppointmentUpdate;
    private javax.swing.JPanel btnPersonal;
    private javax.swing.JButton btnPersonalAdd;
    private javax.swing.JButton btnPersonalDelete;
    private javax.swing.JButton btnPersonalUpdate;
    private javax.swing.JPanel btnPosition;
    private javax.swing.JButton btnPositionAdd;
    private javax.swing.JButton btnPositionDelete;
    private javax.swing.JButton btnPositionUpdate;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.JPanel btnWelcome;
    private javax.swing.JComboBox<String> cbxDoctorExpertiseIdAdd;
    private javax.swing.JComboBox<String> cbxDoctorExpertiseIdUpdate;
    private javax.swing.JComboBox<String> cbxMyProfilePositionIdUpdate;
    private javax.swing.JComboBox<String> cbxPatientAppointmentDoctorIdAdd;
    private javax.swing.JComboBox<String> cbxPatientAppointmentDoctorIdUpdate;
    private javax.swing.JComboBox<String> cbxPatientAppointmentPatientIdAdd;
    private javax.swing.JComboBox<String> cbxPatientAppointmentPatientIdUpdate;
    private javax.swing.JComboBox<String> cbxPersonalPositionIdAdd;
    private javax.swing.JComboBox<String> cbxPersonalPositionIdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblDoctors;
    private javax.swing.JTable tblExpertises;
    private javax.swing.JTable tblPatientAppointments;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTable tblPersonals;
    private javax.swing.JTable tblPositions;
    private javax.swing.JTextField tbxDoctorBirthdateAdd;
    private javax.swing.JTextField tbxDoctorBirthdateUpdate;
    private javax.swing.JTextField tbxDoctorIdDelete;
    private javax.swing.JTextField tbxDoctorIdUpdateDoctorPanel;
    private javax.swing.JTextField tbxDoctorNameAdd;
    private javax.swing.JTextField tbxDoctorNameUpdate;
    private javax.swing.JTextField tbxDoctorPasswordAdd;
    private javax.swing.JTextField tbxDoctorPasswordUpdate;
    private javax.swing.JTextField tbxDoctorSurnameAdd;
    private javax.swing.JTextField tbxDoctorSurnameUpdate;
    private javax.swing.JTextField tbxDoctorUserNameAdd;
    private javax.swing.JTextField tbxDoctorUserNameUpdate;
    private javax.swing.JTextField tbxExpertiseIdDelete;
    private javax.swing.JTextField tbxExpertiseIdUpdateExpertisePanel;
    private javax.swing.JTextField tbxExpertiseNameAdd;
    private javax.swing.JTextField tbxExpertiseNameUpdate;
    private javax.swing.JTextField tbxMyProfileBirthdateUpdate;
    private javax.swing.JTextField tbxMyProfileNameUpdate;
    private javax.swing.JTextField tbxMyProfilePasswordUpdate;
    private javax.swing.JTextField tbxMyProfileSurnameUpdate;
    private javax.swing.JTextField tbxMyProfileUserNameUpdate;
    private javax.swing.JTextField tbxMyProfilelIdUpdate;
    private javax.swing.JTextField tbxPatientAppointmentAppointmentDateTimeAdd;
    private javax.swing.JTextField tbxPatientAppointmentAppointmentDateTimeUpdate;
    private javax.swing.JTextField tbxPatientAppointmentIdDelete;
    private javax.swing.JTextField tbxPatientAppointmentIdUpdateAppointmentPanel;
    private javax.swing.JTextField tbxPatientBirthdateAdd;
    private javax.swing.JTextField tbxPatientBirthdateUpdate;
    private javax.swing.JTextField tbxPatientIdDelete;
    private javax.swing.JTextField tbxPatientIdUpdatePatientPanel;
    private javax.swing.JTextField tbxPatientNameAdd;
    private javax.swing.JTextField tbxPatientNameUpdate;
    private javax.swing.JTextField tbxPatientPasswordAdd;
    private javax.swing.JTextField tbxPatientPasswordUpdate;
    private javax.swing.JTextField tbxPatientSurnameAdd;
    private javax.swing.JTextField tbxPatientSurnameUpdate;
    private javax.swing.JTextField tbxPatientUserNameAdd;
    private javax.swing.JTextField tbxPatientUserNameUpdate;
    private javax.swing.JTextField tbxPersonalBirthdateAdd;
    private javax.swing.JTextField tbxPersonalBirthdateUpdate;
    private javax.swing.JTextField tbxPersonalIdDelete;
    private javax.swing.JTextField tbxPersonalIdUpdatePersonalPanel;
    private javax.swing.JTextField tbxPersonalNameAdd;
    private javax.swing.JTextField tbxPersonalNameUpdate;
    private javax.swing.JTextField tbxPersonalPasswordAdd;
    private javax.swing.JTextField tbxPersonalPasswordUpdate;
    private javax.swing.JTextField tbxPersonalSurnameAdd;
    private javax.swing.JTextField tbxPersonalSurnameUpdate;
    private javax.swing.JTextField tbxPersonalUserNameAdd;
    private javax.swing.JTextField tbxPersonalUserNameUpdate;
    private javax.swing.JTextField tbxPositionIdDelete;
    private javax.swing.JTextField tbxPositionIdUpdatePositionPanel;
    private javax.swing.JTextField tbxPositionNameAdd;
    private javax.swing.JTextField tbxPositionNameUpdate;
    // End of variables declaration//GEN-END:variables
}
