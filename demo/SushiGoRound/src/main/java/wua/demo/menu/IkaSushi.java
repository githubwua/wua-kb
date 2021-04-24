package wua.demo.menu;

public class IkaSushi extends MenuItem{
    private static final String NAME = "ヤリイカ";
    private static final String DESCRIPTION = "四国産槍烏賊";
    private static final int PRICE = 110;

    public IkaSushi() {
        super(NAME, DESCRIPTION,PRICE);
    }

    @Override
    void make() throws InterruptedException {
        Thread.sleep(3000);  // 3 secs to make
    }
}


