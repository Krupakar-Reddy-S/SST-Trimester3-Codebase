public class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Krupakar Reddy";
        s1.age = 18;
        s1.rollno = 10086;

        System.out.println(s1);

        Student s2 = s1;
        s2.name = "Gogineni Siva Rama Krishna Choudary";
        System.out.println(s2);

        Student s3 = new Student("Rohith Thirunagari", 17, 10069);
        System.out.println(s3);
    }
}
