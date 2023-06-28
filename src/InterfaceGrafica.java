import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.pipeline.EX;
import models.pipeline.ID;
import models.pipeline.IF;
import models.pipeline.MEM;
import models.pipeline.WB;
import models.utils.Utils;

import java.io.File;

public class InterfaceGrafica extends Application {

    private IF stage1;
    private ID stage2;
    private EX stage3;
    private MEM stage4;
    private WB stage5;

    private TextArea outputTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pipeline App");

        // Create UI components
        Button selectFileButton = new Button("Select File");
        selectFileButton.setOnAction(e -> selectFile());

        Button runPipelineButton = new Button("Run Pipeline");
        runPipelineButton.setOnAction(e -> runPipeline());

        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setPrefRowCount(10);

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(selectFileButton, runPipelineButton, outputTextArea);

        // Scene
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            initializePipeline(selectedFile.getPath());
            outputTextArea.setText("File selected: " + selectedFile.getPath());
        }
    }

    private void runPipeline() {
        if (stage1 != null) {
            while (Utils.getPc() < stage1.getInstructions().size()) {
                stage5.write(stage4.accesses(stage3.execute(stage2.decoding(stage1.search()))));
            }

            outputTextArea.appendText("\nRegister 3: " + Utils.getIndexRegister(3));
            outputTextArea.appendText("\nRegister 4: " + Utils.getIndexRegister(4));
        } else {
            outputTextArea.setText("No file selected.");
        }
    }

    private void initializePipeline(String filePath) {
        stage1 = new IF(filePath);
        stage2 = new ID();
        stage3 = new EX();
        stage4 = new MEM();
        stage5 = new WB();
    }
}
