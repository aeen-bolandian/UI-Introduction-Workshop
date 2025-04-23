package org.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PricingController {

    @FXML private VBox vbox1;
    @FXML private Label label1;
    @FXML private VBox vbox2;
    @FXML private Label label2;
    @FXML private VBox vbox3;
    @FXML private Label label3;

    private Font originalFont1, originalFont2, originalFont3;

    @FXML
    public void initialize() {
        originalFont1 = label1.getFont();
        originalFont2 = label2.getFont();
        originalFont3 = label3.getFont();
    }

    @FXML
    public void handleShopButtonAction(ActionEvent event) {
        Button source = (Button) event.getSource();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Shop");
        String text = "price : ";
        switch (source.getId()) {
            case "freePlan":
                alert.setHeaderText("free plan");
                alert.setContentText("no price for this plan");
                break;
            case "litePlan":
                text += "65";
                alert.setHeaderText("lite plan");
                alert.setContentText(text);
                break;
            case "proPlan":
                text += "350";
                alert.setHeaderText("pro plan");
                alert.setContentText(text);
                break;
        }
        alert.showAndWait();
    }

    @FXML
    public void hover(MouseEvent event) {
        VBox vbox = (VBox) event.getSource();
        Label label;

        if (vbox == vbox1) {
            label = label1;
        } else if (vbox == vbox2) {
            label = label2;
        } else {
            label = label3;
        }

        Font currentFont = label.getFont();
        double newSize = currentFont.getSize() * 1.2; // Increase font size by 20%
        label.setFont(Font.font(currentFont.getName(), newSize));
    }

    @FXML
    public void unHover(MouseEvent event) {
        VBox vbox = (VBox) event.getSource();
        Label label;

        if (vbox == vbox1) {
            label = label1;
            label.setFont(originalFont1);
        } else if (vbox == vbox2) {
            label = label2;
            label.setFont(originalFont2);
        } else {
            label = label3;
            label.setFont(originalFont3);
        }
    }
}
