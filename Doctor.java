import javax.print.Doc;

public class Doctor extends Person{

    private String specialization;
    private double doctorFee;
    private boolean available;

    private String shift1;
    private String shift2;

    public Doctor(int id,String name, int age, String specialization, String phone, double doctorFee, boolean available, String shift1, String shift2){

        super(id, name, age, phone);
        this.specialization = specialization;
        this.doctorFee = doctorFee;
        this.available = available;
        this.shift1 = shift1;
        this.shift2 = shift2;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getShift1() {
        return shift1;
    }

    public String getShift2() {
        return shift2;
    }

    @Override
    public void display(){
        System.out.println("------------------------------------------");
        System.out.println("Doctor ID       : " + id);
        System.out.println("Name            : " + name);
        System.out.println("Age             : " + age);
        System.out.println("Specialization  : " + specialization);
        System.out.println("Phone Number    : " + phone);
        System.out.println("Doctor Fee      : " + doctorFee + " BDT");

        if(available){
            System.out.println("Available       : Yes");
        }
        else{
            System.out.println("Available       : No");
        }

        System.out.println("Shift 1         : " + shift1);
        System.out.println("Shift 2         : " + shift2);
        System.out.println("------------------------------------------");
    }

}