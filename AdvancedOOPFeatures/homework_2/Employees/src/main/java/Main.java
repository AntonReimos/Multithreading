import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        return staff.stream()
                .filter(employee -> employee.getWorkStart()
                        .toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDate().getYear() == year)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }
}