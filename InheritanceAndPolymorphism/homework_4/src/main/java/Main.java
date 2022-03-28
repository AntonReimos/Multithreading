public class Main {
    public static void main(String[] args) {

        Company pepsi = new Company();
        pepsi.CompanyIncome();
        for (int i = 0; i < 20; i++) {
            pepsi.hire(new TopManager(120, "Туров А.С."));
        }
        System.out.println(pepsi.getTopSalaryStaff(5));
    }

}

