public class TopManager extends Workers
        implements Employee {
private static int TopManagerSolary;
private static String TopManagerName;
    // TopManager — зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы,
    // если доход компании более 10 млн рублей.


    public TopManager(int solary, String name) {
        TopManagerName = SetName.setName(name);
        if (Company.CompanyIncome() < 10_000_000) {
            TopManagerSolary = solary;
        } else {
            TopManagerSolary = (int) (solary + solary * 1.5);
        }super.Workers(TopManagerSolary, TopManagerName);
    }


    @Override
    public int getMonthSalary() {
        return 0;
    }
}
