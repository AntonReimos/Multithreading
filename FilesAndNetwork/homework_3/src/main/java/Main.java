public class Main {
    public static void main(String[] args) {


        String operationFile = "FilesAndNetwork/files/movementList.csv";
        Movements movements = new Movements(operationFile);
        System.out.println("Суммарно расходов: " + movements.getExpenseSum());
        System.out.println("Суммарно доходов: " + movements.getIncomeSum());
        movements.getSumCompany();

    }

}






