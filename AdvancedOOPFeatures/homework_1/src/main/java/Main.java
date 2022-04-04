
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final String STAFF_TXT = "homework_1/data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);


    }

    //TODO: В классе Main реализуйте метод sortBySalaryAndAlphabet(),
    // который должен выполнить сортировку переданного списка сотрудников
    // по заработной плате и алфавиту. То есть в начале списка будут
    // минимальные значения зарплат, если значение зарплат одинаковое
    // у сотрудников, то сотрудники с одинаковой зарплатой должны быть
    // отсортированы по Ф. И. О.
    // Проверьте ваш метод с помощью тестов.

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        List<Employee> sortStaff = staff.stream().sorted(
                Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)
        ).collect(Collectors.toList());


        for (Employee employee : sortStaff) {
            System.out.println(employee);
        }


    }
}