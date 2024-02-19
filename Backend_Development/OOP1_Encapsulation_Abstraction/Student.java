public class Student {
    // Properties
    public String name;
    public int age;
    public int rollno;

    private String password;
    private String email;

    private double attendance;
    private double psp;
    
    // Constructors
    public Student() {
        
    }
    
    public Student(String name, int age, int rollno) {
        this.name = name;
        this.age = age;
        this.rollno = rollno;

        this.password = this.name.replaceAll(" *", "").toLowerCase();
        this.email = this.name.replaceAll(" *", "") + ".mail.com";

        this.psp = 100.00;
        this.attendance = 100.00;
    }
    
    public Student(String name, int age, int rollno, String password, String email, double attendance, double psp) {
        this.name = name;
        this.age = age;
        this.rollno = rollno;
        this.password = password;
        this.email = email;
        this.attendance = attendance;
        this.psp = psp;
    }

    public String toString() {
        String StudentDetails = "Name: " + name + "\n" 
                                + "Age: " + age + "\n" 
                                + "RollNo: " + rollno + "\n"
                                + "Email: " + email + "\n"
                                + "Attendance: " + attendance + "\n"
                                + "PSP: " + psp + "\n";
    
        return StudentDetails;
    }
    
    // Getter and Setter methods
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }
    
    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }
    

    // Additional methods
    public void login() {
        System.out.println("Student has been sucessfully logged in");
    }

    public void study() {
        System.out.println(name + " is studying.");
    }
}