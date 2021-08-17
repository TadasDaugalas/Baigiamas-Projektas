package Duomenys;

public class StudentoAtsakymas extends TeisingiAtsakymai{
    private Studentas studentas;

    public StudentoAtsakymas() {
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