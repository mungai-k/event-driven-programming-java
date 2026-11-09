public class TightlyCoupledSystem {
    static class DataModel {
        private int value;
        public void setValue(int value) {
            this.value = value;
            new LabelDisplay().showValue(value);
            new BarChartDisplay().drawBar(value);
        }
    }
    static class LabelDisplay {
        public void showValue(int value) { System.out.println("Label shows: " + value); }
    }
    static class BarChartDisplay {
        public void drawBar(int value) { System.out.println("Bar chart height: " + value); }
    }
    public static void main(String[] args) {
        DataModel model = new DataModel();
        model.setValue(10);
    }
}
