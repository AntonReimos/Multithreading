import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

    private ArrayList<Employee> companyEmployee;
    private static int companyIncome;

    public Company(int income) {
        companyEmployee = new ArrayList<>();
        companyIncome = income;
    }


    public static List<Employee> setEmployeeList(int countOfTopManager, int countOfManager,
                                                 int countOfOperator) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < countOfTopManager; i++) {
            employeeList.add(new TopManager());
        }
        for (int i = 0; i < countOfManager; i++) {
            employeeList.add(new Manager());
        }
        for (int i = 0; i < countOfOperator; i++) {
            employeeList.add(new Operator());
        }
        return employeeList;
    }

    public static int getCompanyIncome() {
        return companyIncome;
    }

    public ArrayList<Employee> getCompanyEmployee() {
        return companyEmployee;
    }

    public void hire(Employee employee) {
        companyEmployee.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        companyEmployee.addAll(employees);

    }

    public void fire(Employee employee) {
        companyEmployee.remove(employee);

    }

    public List<Employee> getTopSalaryStaff(int count) {
        companyEmployee.sort(Comparator.comparingInt(Employee::getSalary).reversed());
        List<Employee> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            out.add(companyEmployee.get(i));
        }
        return out;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        companyEmployee.sort(Comparator.comparingInt(Employee::getSalary));
        List<Employee> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            out.add(companyEmployee.get(i));
        }
        return out;
    }

}
