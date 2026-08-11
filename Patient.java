public class Patient extends Person{

    private String gender;
    private String disease;
    private String address;
    private String status;

    public Patient(int id, String name, int age, String gender, String phone, String disease, String address){

        super(id, name, age, phone);
        this.gender = gender;
        this.disease = disease;
        this.address = address;

        this.status = "Admitted";
    }

    public String getGender(){
        return gender;
    }

    public String getDisease(){
        return disease;
    }

    public String getAddress(){
        return address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public void display(){
        System.out.println("------------------------------------------");
        System.out.println("Patient ID      : " + id);
        System.out.println("Name            : " + name);
        System.out.println("Age             : " + age);
        System.out.println("Gender          : " + gender);
        System.out.println("Phone Number    : " + phone);
        System.out.println("Disease         : " + disease);
        System.out.println("Address         : " + address);
        System.out.println("Status          : " + status);
        System.out.println("------------------------------------------");

    }
}