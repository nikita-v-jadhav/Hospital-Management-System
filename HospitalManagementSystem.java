import java.util.*;

class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Patient ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Disease: " + disease;
    }
}

class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Doctor ID: " + id +
                ", Name: " + name +
                ", Specialization: " + specialization;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;

    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public String toString() {
        return "Patient: " + patient.getName() +
                " --> Doctor: " + doctor.getName();
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient(sc);
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    addDoctor(sc);
                    break;

                case 4:
                    viewDoctors();
                    break;

                case 5:
                    bookAppointment(sc);
                    break;

                case 6:
                    viewAppointments();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addPatient(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));

        System.out.println("Patient Added Successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No Patients Found!");
            return;
        }

        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    static void addDoctor(Scanner sc) {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors.add(new Doctor(id, name, specialization));

        System.out.println("Doctor Added Successfully!");
    }

    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No Doctors Found!");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    static void bookAppointment(Scanner sc) {

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();

        Patient patient = null;
        Doctor doctor = null;

        for (Patient p : patients) {
            if (p.getId() == patientId) {
                patient = p;
                break;
            }
        }

        for (Doctor d : doctors) {
            if (d.getId() == doctorId) {
                doctor = d;
                break;
            }
        }

        if (patient == null || doctor == null) {
            System.out.println("Patient or Doctor Not Found!");
            return;
        }

        appointments.add(new Appointment(patient, doctor));

        System.out.println("Appointment Booked Successfully!");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No Appointments Found!");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}