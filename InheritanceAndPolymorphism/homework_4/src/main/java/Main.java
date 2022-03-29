import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company pepsi = new Company(8_000_000);
        for (int i = 0; i < 10; i++) {
            pepsi.hire(new TopManager());
        }
        for (int i = 0; i < 80; i++) {
            pepsi.hire(new Manager());
        }
        for (int i = 0; i < 180; i++) {
            pepsi.hire(new Operator());
        }


        Company cola = new Company(25_000_000);
        List<Employee> listOfApplicants = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfApplicants.add(new TopManager());
        }
        for (int i = 0; i < 80; i++) {
            listOfApplicants.add(new Manager());
        }
        for (int i = 0; i < 180; i++) {
            listOfApplicants.add(new Operator());
        }

        cola.hireAll(listOfApplicants);

        System.out.println("Самые высокие зарплаты в компании Pepsi" + "\n");
        pepsi.getTopSalaryStaff(15).forEach(i -> System.out.println(i.getSalary() + " " + "руб."));
        System.out.println("\n" + "Самые низкие зарплаты в компании Pepsi" + "\n");
        pepsi.getLowestSalaryStaff(30).forEach(i -> System.out.println(i.getSalary() + " " + "руб."));

        for (int i = 0; i < pepsi.getCompanyEmployee().size() / 2; i++) {
            pepsi.fire(pepsi.getCompanyEmployee().get(i));
        }

        System.out.println("Самые высокие зарплаты в компании Pepsi после увольнения" + "\n");
        pepsi.getTopSalaryStaff(15).forEach(i -> System.out.println(i.getSalary() + " " + "руб."));
        System.out.println("\n" + "Самые низкие зарплаты в компании Pepsi после увольнения" + "\n");
        pepsi.getLowestSalaryStaff(30).forEach(i -> System.out.println(i.getSalary() + " " + "руб."));

        System.out.println("Самые высокие зарплаты в компании Cola" + "\n");
        cola.getTopSalaryStaff(15).forEach(i -> System.out.println(i.getSalary() + " " + "руб."));
        System.out.println("\n" + "Самые низкие зарплаты в компании Cola" + "\n");
        cola.getLowestSalaryStaff(30).forEach(i -> System.out.println(i.getSalary() + " " + "руб."));

    }

}

