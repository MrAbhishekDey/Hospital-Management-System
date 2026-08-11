import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Hospital hospital = new Hospital();

        // Add 10 doctors automatically
        hospital.addDoctors();

        int choice = 0;


        System.out.println("==========================================");
        System.out.println("       HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("==========================================");


        while (choice != 8) {
            try {
                System.out.println("\n");
                System.out.println("========== MAIN MENU ==========");
                System.out.println("1. Add Patient");
                System.out.println("2. Search Patient");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. View Patient");
                System.out.println("6. Start Treatment & Discharge");
                System.out.println("7. Generate Bill");
                System.out.println("8. Exit");

                System.out.print("\nEnter your choice: ");
                choice = input.nextInt();
                switch (choice) {

                    case 1:
                        hospital.addPatient(input);
                        break;

                    case 2:
                        hospital.searchPatientMenu(input);
                        break;

                    case 3:
                        hospital.viewDoctors();
                        break;

                    case 4:
                        hospital.bookAppointment(input);
                        break;

                    case 5:
                        hospital.viewPatients();
                        break;

                    case 6:
                        hospital.startTreatment(input);
                        break;

                    case 7:
                        hospital.generateBill(input);
                        break;

                    case 8:
                        System.out.println("\nThank you for using " + "Hospital Management System!");
                        break;

                    default:
                        System.out.println("\nInvalid choice!");
                        System.out.println("Please enter 1-8.");

                }
            } catch (Exception e) {

                System.out.println("\nInvalid input!");
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        }

        input.close();
    }
}