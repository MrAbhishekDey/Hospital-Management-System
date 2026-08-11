import java.util.SplittableRandom;

public class Appointment implements Bookable{

    private int patientId;
    private int doctorId;

    private String patientName;
    private String doctorName;

    private String shift;
    private double doctorFee;

    public Appointment(int patientId, int doctorId, String patientName, String doctorName,String shift, double doctorFee){

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.shift = shift;
        this.doctorFee = doctorFee;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getShift() {
        return shift;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    @Override
    public void bookAppointment(){
        System.out.println("\n==========================================");
        System.out.println("          APPOINTMENT BOOKED");
        System.out.println("==========================================");

        System.out.println("Patient ID      : " + patientId);
        System.out.println("Patient Name    : " + patientName);
        System.out.println("Doctor ID       : " + doctorId);
        System.out.println("Doctor Name     : " + doctorName);
        System.out.println("Selected Shift  : " + shift);
        System.out.println("Doctor Fee      : " + doctorFee + " BDT");

        System.out.println("==========================================");
    }
}