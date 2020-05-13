import javafx.scene.chart.XYChart;

public class GlaciersModel {

    private XYChart.Series<String, Number> gl = new XYChart.Series<>();

    public void add(String year, double value){
        gl.getData().add(new XYChart.Data<>(year, value));
    }

    public XYChart.Series<String, Number> getData(){
        return gl;
    }
}
