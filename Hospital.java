import javax.print.Doc;
import java.util.Scanner;

public class Hospital{

    private Patient[] patients = new Patient[100];
    private int patientCount = 0;

    private Doctor[] doctors = new Doctor[10];


    private Appointment[] appointments = new Appointment[100];
    private int appointmentCount = 0;


    // ADD 10 DOCTORS
    public void addDoctors() {
        doctors[0] = new Doctor(101, "Dr. Rahman", 45, "Cardiologist", "01711111111", 1500, true, "09:00 AM - 01:00 PM", "05:00 PM - 09:00 PM");
        doctors[1] = new Doctor(102, "Dr. Karim", 50, "Neurologist", "01722222222", 1800, true, "10:00 AM - 02:00 PM", "06:00 PM - 10:00 PM");
        doctors[2] = new Doctor(103, "Dr. Hasan", 42, "Orthopedic", "01733333333", 1200, true, "09:00 AM - 01:00 PM", "05:00 PM - 09:00 PM");
        doctors[3] = new Doctor(104, "Dr. Ahmed", 48, "Medicine Specialist", "01744444444", 1000, true, "08:00 AM - 12:00 PM", "04:00 PM - 08:00 PM");
        doctors[4] = new Doctor(105, "Dr. Sakib", 40, "Dermatologist", "01755555555", 1100, true, "10:00 AM - 02:00 PM", "06:00 PM - 10:00 PM");
        doctors[5] = new Doctor(106, "Dr. Nayeem", 39, "Pediatrician", "01766666666", 1300, true, "09:00 AM - 01:00 PM", "05:00 PM - 09:00 PM");
        doctors[6] = new Doctor(107, "Dr. Fahim", 44, "Dentist", "01777777777", 900, true, "10:00 AM - 02:00 PM", "06:00 PM - 10:00 PM");
        doctors[7] = new Doctor(108, "Dr. Tanvir", 47, "ENT Specialist", "01788888888", 1200, true, "09:00 AM - 01:00 PM", "05:00 PM - 09:00 PM");
        doctors[8] = new Doctor(109, "Dr. Rafi", 52, "Surgeon", "01799999999", 2500, true, "08:00 AM - 12:00 PM", "04:00 PM - 08:00 PM");
        doctors[9] = new Doctor(110, "Dr. Imran", 46, "Urologist", "01811111111", 1600, true, "10:00 AM - 02:00 PM", "06:00 PM - 10:00 PM");
    }



    // ADD PATIENT
    public void addPatient(Scanner input) {
        try {
            System.out.println("\n--- Add New Patient ---");

            System.out.print("Enter Patient ID: ");
            int id = input.nextInt();
            input.nextLine();

            for (int i = 0; i < patientCount; i++) {
                if (patients[i].getId() == id) {
                    throw new Exception("Patient ID already exists!");
                }
            }

            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Enter Gender: ");
            String gender = input.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = input.nextLine();

            System.out.print("Enter Disease: ");
            String disease = input.nextLine();

            System.out.print("Enter Address: ");
            String address = input.nextLine();

            Patient patient = new Patient(id, name, age, gender, phone, disease, address);
            patients[patientCount] = patient;
            patientCount++;

            System.out.println("\nPatient added successfully!");
            System.out.println("Patient Status: Admitted");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Add Patient operation completed.");
        }
    }



    // SEARCH PATIENT
    public Patient searchPatient(int id) {

        for (int i=0; i<patientCount; i++) {

            if (patients[i].getId() == id) {
                return patients[i];
            }
        }

        return null;
    }

    // SEARCH PATIENT MENU
    public void searchPatientMenu(Scanner input) {

        try {

            System.out.println("\n========== SEARCH PATIENT ==========");
            System.out.print("Enter Patient ID: ");
            int id = input.nextInt();

            Patient patient = searchPatient(id);

            if (patient == null) {
                throw new Exception("Patient not found!");
            }
            patient.display();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // VIEW DOCTORS
    public void viewDoctors() {

        System.out.println("\n========== DOCTOR LIST ==========");
        for (int i=0; i<doctors.length; i++) {
            doctors[i].display();
        }
    }


    // FIND DOCTOR
    public Doctor findDoctor(int id) {

        for (int i=0; i<doctors.length; i++) {

            if (doctors[i].getId() == id) {
                return doctors[i];
            }
        }

        return null;
    }


    // BOOK APPOINTMENT
    public void bookAppointment(Scanner input) {

        try {

            System.out.println("\n========== BOOK APPOINTMENT ==========");

            // Patient ID
            System.out.print("Enter Patient ID: ");
            int patientId = input.nextInt();
            Patient patient = searchPatient(patientId);

            if (patient == null) {
                throw new Exception("Patient not found!");
            }

            // Doctor ID
            System.out.print("Enter Doctor ID: ");
            int doctorId = input.nextInt();
            Doctor doctor = findDoctor(doctorId);

            if (doctor == null) {
                throw new Exception("Doctor not found!");
            }


            System.out.println("\nDoctor Name : " + doctor.getName());
            System.out.println("Specialization : " + doctor.getSpecialization());
            System.out.println("Doctor Fee : " + doctor.getDoctorFee() + " BDT");


            // Shift
            System.out.println("\nAvailable Shifts:");
            System.out.println("1. " + doctor.getShift1());
            System.out.println("2. " + doctor.getShift2());

            System.out.print("Choose Shift: ");
            int choice = input.nextInt();
            String selectedShift;

            if (choice == 1) {
                selectedShift = doctor.getShift1();

            }
            else if (choice == 2) {
                selectedShift = doctor.getShift2();
            }
            else {
                throw new Exception("Invalid shift!");
            }

            // Create Appointment

            Appointment appointment = new Appointment(patientId, doctorId, patient.getName(), doctor.getName(), selectedShift, doctor.getDoctorFee());

            appointments[appointmentCount] = appointment;
            appointmentCount++;
            appointment.bookAppointment();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // FIND APPOINTMENT

    public Appointment findAppointment(int patientId) {

        for (int i=0; i<appointmentCount; i++) {

            if (appointments[i].getPatientId() == patientId) {
                return appointments[i];
            }
        }

        return null;
    }


    // VIEW PATIENTS
    public void viewPatients() {

        System.out.println("\n========== ALL PATIENTS ==========");

        if (patientCount == 0) {
            System.out.println("No patient found.");
            return;
        }

        for (int i=0; i<patientCount; i++) {
            patients[i].display();
        }
    }


    // START TREATMENT + FINISH + DISCHARGE
    public void startTreatment(Scanner input) {

        try {
            System.out.println("\n========== START TREATMENT ==========");

            // Patient ID
            System.out.print("Enter Patient ID: ");
            int patientId = input.nextInt();

            // Find Patient
            Patient patient = searchPatient(patientId);
            if (patient == null) {
                throw new Exception("Patient not found!");
            }

            // Find Appointment
            Appointment appointment = findAppointment(patientId);
            if (appointment == null) {
                throw new Exception("Patient has no appointment!");
            }


            // Check patient status
            if (patient.getStatus().equals("Under Treatment")) {
                throw new Exception("Treatment already started!");
            }

            if (patient.getStatus().equals("Discharged")) {
                throw new Exception("Patient already discharged!");
            }


            // START TREATMENT

            patient.setStatus("Under Treatment");
            System.out.println("\nTreatment started successfully!");
            System.out.println("Patient ID : " + patient.getId());
            System.out.println("Patient    : " + patient.getName());
            System.out.println("Doctor     : " + appointment.getDoctorName());
            System.out.println("Status     : Under Treatment");

            // 10 SECOND COUNTDOWN
            System.out.println("\nTreatment is in progress...");

            for (int i=10; i>=1; i--) {
                System.out.println("Treatment Time Remaining: " + i + " seconds");
                Thread.sleep(1000);
            }

            // FINISH TREATMENT
            // ==========================================

            patient.setStatus("Discharged");


            System.out.println("\nTreatment finished!");


            System.out.println("Patient ID : " + patient.getId());


            System.out.println("Patient    : " + patient.getName());


            System.out.println("Status     : Discharged");


        } catch (InterruptedException e) {

            System.out.println("Treatment was interrupted!");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    // GENERATE BILL
    public void generateBill(Scanner input) {

        try {
            System.out.println("\n========== GENERATE BILL ==========");
            System.out.print("Enter Patient ID: ");
            int patientId = input.nextInt();
            Patient patient = searchPatient(patientId);

            if (patient == null) {
                throw new Exception("Patient not found!");
            }

            Appointment appointment = findAppointment(patientId);
            if (appointment == null) {
                throw new Exception("No appointment found!");
            }

            Bill bill = new Bill(patient.getId(), patient.getName(), appointment.getDoctorName(), appointment.getDoctorFee());
            bill.displayBill();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}