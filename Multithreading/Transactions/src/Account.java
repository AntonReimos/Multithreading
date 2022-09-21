public class Account {

    private long money;
    private Integer accNumber;
    private boolean isBlock = false;

    public Account(Integer num, long money) {
        this.accNumber = num;
        this.money = money;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Integer getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(Integer accNumber) {
        this.accNumber = accNumber;
    }
}
