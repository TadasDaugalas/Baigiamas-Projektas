package Duomenys;

public class StudentoEgzaminas extends TeisingiAtsakymai{
    private Studentas studentas;

    public StudentoEgzaminas() {
    }

    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }

    @Override
    public String toString() {
        return "StudentoEgzaminas{" +
                "studentas=" + studentas +
                '}' + super.toString();
    }
}