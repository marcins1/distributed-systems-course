package technician;

public class TechnicianMain {
    public static void main(String[] args) {
        technician.Technician technician = new technician.Technician("Technician1", "Knee", "Hip");
        try {
            technician.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        technician.Technician technician2 = new technician.Technician("Technician2", "Hip", "Elbow");
//        try {
//            technician2.run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
