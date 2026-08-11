public class Bill{

    private int patientId;
    private String patientName;
    private String doctorName;
    private double doctorFee;

    public Bill(int patientId, String patientName,String doctorName, double doctorFee){
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.doctorFee = doctorFee;
    }

    public void displayBill(){

        System.out.println("\n==========================================");
        System.out.println("              PATIENT BILL");
        System.out.println("==========================================");

        System.out.println("Patient ID      : " + patientId);
        System.out.println("Patient Name    : " + patientName);
        System.out.println("Doctor Name     : " + doctorName);
        System.out.println("Doctor Fee      : " + doctorFee + " BDT");

        System.out.println("------------------------------------------");

        System.out.println("Total Bill      : " + doctorFee + " BDT");

        System.out.println("==========================================");
    }
}