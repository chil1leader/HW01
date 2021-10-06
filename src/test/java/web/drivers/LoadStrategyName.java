package web.drivers;

public enum LoadStrategyName {
    NORMAL("normal"),
    EAGER("eager"),
    NONE("none");

    private String loadStrategyName;

    private LoadStrategyName(String loadStrategyName) {this.loadStrategyName = loadStrategyName; }

    @Override
    public String toString() {return String.valueOf(this.loadStrategyName);}

    public static LoadStrategyName fromString(String  loadStrategyName) {
        if (loadStrategyName != null) {
            for (LoadStrategyName l : LoadStrategyName.values()) {
                if (loadStrategyName.equalsIgnoreCase(l.loadStrategyName)) {
                    return l;
                }
            }
        }
        return null;
    }

    public String getLoadStrategyName() { return this.loadStrategyName; }
}

