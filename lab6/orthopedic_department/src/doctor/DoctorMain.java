package doctor;

public class DoctorMain {
    public static void main(String[] args) {
        doctor.Doctor doctor = new doctor.Doctor("Doctor1");
        try {
            doctor.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Doctor doctor2 = new Doctor("Doctor2");
//        try {
//            doctor2.run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
