import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class TemperatureModel {

    private final ObservableList<Temperature> temperatures = FXCollections.observableArrayList();

    public void add(Temperature temp){
        temperatures.add(temp);
    }

    public XYChart.Series<String, Number> getTemperatureEvolutionData(String type){
        XYChart.Series<String, Number> serie = new XYChart.Series<String, Number>();
        for(Integer i = temperatures.size() - 1; i > 0; i--){
            if(temperatures.get(i).getType().equals(type)) {
                serie.getData().add(new XYChart.Data<>(temperatures.get(i).getDate(), temperatures.get(i).getRaise()));
            }
        }
        serie.setName(type);
        return serie;
    }
}
