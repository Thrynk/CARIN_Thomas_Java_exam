import javafx.scene.chart.LineChart;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.fxml.FXML;

public class MainController {

    private final TemperatureModel tempModel = new TemperatureModel();

    @FXML
    private LineChart temperatureChart;

    @FXML
    private LineChart temperatureGCAGChart;

    public MainController(){

        Charset charset = StandardCharsets.UTF_8;
        try{
            BufferedReader reader = Files.newBufferedReader(
                    Paths.get("temperature.txt"),
                    charset
            );
            String line = null;
            reader.readLine(); // skip first line
            while((line = reader.readLine()) != null){
                /* System.out.println(line); */
                String[] infos = line.split(",");
                Temperature temp = new Temperature(infos[0], infos[1], Double.parseDouble(infos[2]));
                tempModel.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        temperatureChart.setTitle("GISTEMP Temperature");
        temperatureChart.getData().add(tempModel.getTemperatureEvolutionData("GISTEMP"));

        temperatureGCAGChart.setTitle("GCAC Temperature");
        temperatureGCAGChart.getData().add(tempModel.getTemperatureEvolutionData("GCAG"));
    }
}
