public abstract class Workers {
    protected int solary = 0;
    protected String name = "";

    public void Workers(int solary, String name){
        this.name = SetName.setName(name);
        this.solary = solary;
    }

}
