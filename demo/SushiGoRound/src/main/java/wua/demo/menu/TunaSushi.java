package wua.demo.menu;

public class TunaSushi extends MenuItem{
    private static final String NAME = "マグロ";
    private static final String DESCRIPTION = "インド洋マグロ";
    private static final int PRICE = 150;

    public TunaSushi() {
        super(NAME, DESCRIPTION,PRICE);
    }

    @Override
    void make() throws InterruptedException {
        Thread.sleep(1000);  // 3 secs to make
    }
}


