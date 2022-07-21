import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pswd = "toor";
        try {
            Connection connection = DriverManager.getConnection(url, user, pswd);
            Statement statement = connection.createStatement();
            ResultSet coursesSet = statement.executeQuery("SELECT * FROM Courses");
            while (coursesSet.next()) {
                String cName = coursesSet.getString("name");
                nameList.add(cName);
            }
            coursesSet.close();
            for (String s : nameList) {
                String select = "select count(student_name)  / TIMESTAMPDIFF(MONTH, MIN(subscription_date), MAX(subscription_date)) as average_count FROM purchaselist where course_name=\"" + s + "\";";
                ResultSet rSet = statement.executeQuery(select);
                while (rSet.next()) {
                    String average_count = rSet.getString("average_count");
                    System.out.println(s + " : " + "average_count = " + average_count);
                }
                rSet.close();
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
