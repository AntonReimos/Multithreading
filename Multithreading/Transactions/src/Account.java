
public class Account {

    private long money;
    private String accNumber;
    private boolean isBlock = false;

    public Account(String num, long money) {
        this.accNumber = num;
        this.money = money;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }
    public boolean getBlock(){return isBlock;}

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public long describe(long amount){
        this.money = this.money - amount;
        return this.money;
    }

    public long enrollment(long amount){
        this.money = this.money + amount;
        return this.money;
    }
}
