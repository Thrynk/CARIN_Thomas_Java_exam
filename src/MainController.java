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

    private final GlaciersModel glaciersModel = new GlaciersModel();

    @FXML
    private LineChart temperatureChart;

    @FXML
    private LineChart glaciersChart;

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

            BufferedReader readerGlaciers = Files.newBufferedReader(
                Paths.get("glaciers.txt"),
                charset
            );

            readerGlaciers.readLine();
            while((line = readerGlaciers.readLine()) != null){
                String[] infos = line.split(",");
                glaciersModel.add(infos[0], Double.parseDouble(infos[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        temperatureChart.setTitle("Temperature");
        temperatureChart.getData().add(tempModel.getTemperatureEvolutionData("GISTEMP"));
        temperatureChart.getData().add(tempModel.getTemperatureEvolutionData("GCAG"));

        glaciersChart.setTitle("Glaciers");
        glaciersChart.getData().add(glaciersModel.getData());
    }
}
