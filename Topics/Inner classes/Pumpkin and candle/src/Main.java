class Pumpkin {

    boolean forHalloween;

    public Pumpkin(boolean forHalloween) {
        this.forHalloween = forHalloween;
    }

    void addCandle() {
        if (forHalloween) {
            Candle candle = new Candle();
            candle.burning();
        } else {
            System.out.println("We don't need a candle.");
        }
    }

    class Candle {

        void burning() {
            System.out.println("The candle is burning! Boooooo!");
        }
    }

    public static void main(String[] args) {
        Pumpkin pumpkin1 = new Pumpkin(true);
        pumpkin1.addCandle();

        Pumpkin pumpkin2 = new Pumpkin(false);
        pumpkin2.addCandle();
    }
}