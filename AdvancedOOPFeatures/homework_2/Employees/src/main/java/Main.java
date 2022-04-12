import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.*;

public class Main {

    private static final String STAFF_TXT = "homework_2/Employees/data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        out.println(employeeMaxSalary);

    }

    // TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
    // кто пришёл в году, указанном в переменной year

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, 0);
        return staff.stream().
                filter(employee -> employee.getWorkStart().after(calendar.getTime())).
                max(Comparator.comparing(Employee::getSalary)).get();
    }
}