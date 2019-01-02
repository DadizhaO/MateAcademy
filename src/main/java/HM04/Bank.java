package HM04;


class Bank <T extends BasicInterface> {

    private String address;
    private String name;




    public Bank(String address, String name, T asset) {
        this.address = address;
        this.name = name;
        this.asset = asset;
    }

    private T asset;

    public T getAsset() {
        return asset;
    }

    public void toCheckAssets(T asset){
        asset.toCheck();
    }

    public <T> void toRefillAssets(T asset, int quantity){
        System.out.println("To refill on " +quantity + " of " + asset.getClass().getSimpleName());
    }
    public <T> void toTakeAssets(T asset, int quantity){
        System.out.println("To take " +quantity + " of " + asset.getClass().getSimpleName());
    }

}
