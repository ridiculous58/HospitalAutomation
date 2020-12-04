create table Doctors
(
Id int primary key AUTO_INCREMENT,
Name varchar(50),
Surname varchar(50),
Birthdate datetime ,
ExpertiseId int,
FOREIGN KEY (ExpertiseId) REFERENCES Expertises(Id)

)
create table Expertises
(
Id int primary key AUTO_INCREMENT,
Name varchar(50) null
)
create table Patients
(
Id int primary key AUTO_INCREMENT,
Name varchar(50),
Surname varchar(50),
Birthdate datetime 
)
create table PatientAppointments
(
Id int primary key AUTO_INCREMENT,
PatientId int,
AppointmentId int,
FOREIGN KEY (PatientId) REFERENCES Patients(Id),
FOREIGN KEY (AppointmentId) REFERENCES Appointments(Id)
)
create table Appointments
(
Id int primary key AUTO_INCREMENT,
DoctorId int,
AppointmentDateTime Datetime,
FOREIGN KEY (DoctorId) REFERENCES Doctors(Id)
)

create table Personals
(
Id int primary key AUTO_INCREMENT,
Name varchar(50),
Surname varchar(50),
Birthdate datetime ,
PositionId int,
FOREIGN KEY (PositionId) REFERENCES Positions(Id)
)
create table Positions
(
Id int primary key AUTO_INCREMENT,
Name varchar(50)
)
insert into Doctors(Name,surname,Birthdate,ExpertiseId) values('Fatih','Fatih','1999-11-07',1)
insert into Doctors(Name,surname,Birthdate,ExpertiseId) values('Emirhan','Fatih','1999-11-07',1)
insert into Expertises(Name) values('Dahiliye')

select * from personals

truncate table doctors

insert into Personals(Name,surname,Birthdate,PositionId) values('Tolga','Şahin','2000-03-27',2)
insert into Personals(Name,surname,Birthdate,PositionId) values('Emirhan','Fatih','1999-11-07',1)

insert into Positions(Name) values('Hademe'),('Danışan')

Select * from Patients



