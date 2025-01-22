package org.example.spravahracu;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SpravaHracuController {

    @FXML
    private ListView<Hrac> hraci;
    @FXML
    private TextField vyhledavaciPole;
    @FXML
    private Label detailLabel;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d. M. yyyy");


    // Inicializace aplikace
    public void initialize() {
        hraci.getItems().add(new Hrac("ShadowHunter99", 75, "Bojovník", "shadow.hunter@email.com", LocalDate.of(2020, 1, 1)));
        hraci.getItems().add(new Hrac("FireMage77", 30, "Mág", "fire.mage@email.com", LocalDate.of(2021, 5, 15)));
        hraci.getItems().add(new Hrac("ArrowMaster23", 10, "Střelec", "arrow.master@email.com", LocalDate.of(2022, 3, 10)));

    }

    // Smazání vybraného hráče
    @FXML
    private void smazatHrace() {
        int index = hraci.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            hraci.getItems().remove(index);
        }
    }

    // Vyhledání a zobrazení hráče
    @FXML
    private void hledatHrace() {
        String hledanyText = vyhledavaciPole.getText().toLowerCase();
        Hrac hledanyHrac = null;
        for (Hrac hrac : hraci.getItems()) {
            if (hrac.getLogin().toLowerCase().equals(hledanyText)) {
                hledanyHrac = hrac;
                break;
            }
        }
        if (hledanyHrac != null) {
            vytvorLabelSDatailemHrace(hledanyHrac);
        } else {
            detailLabel.setText("Hrac s timto loginem neexistuje");
            detailLabel.setStyle("-fx-text-fill: black;");
        }

    }

    private void vytvorLabelSDatailemHrace(Hrac vybranyHrac) {

        detailLabel.setText(
                "Login: " + vybranyHrac.getLogin() + "\n" +
                        "Level: " + vybranyHrac.getLevel() + "\n" +
                        "Role: " + vybranyHrac.getRole() + "\n" +
                        "Email: " + vybranyHrac.getEmail() + "\n" +
                        "Registrace: " + vybranyHrac.getRegistrace().format(DATE_FORMATTER)
        );

        if (vybranyHrac.jeZacatecnik()) {
            detailLabel.setStyle("-fx-text-fill: green;");
        } else if (vybranyHrac.jePokrocily()) {
            detailLabel.setStyle("-fx-text-fill: blue;");
        } else {
            detailLabel.setStyle("-fx-text-fill: red;");
        }
    }

    // Zobrazení detailů vybraného hráče
    @FXML
    private void zobrazDetailHrace() {
        System.out.println("debug");
        int index = hraci.getSelectionModel().getSelectedIndex();
        if (index >= 0 && index < hraci.getItems().size()) {
            Hrac vybranyHrac = hraci.getItems().get(index);
            vytvorLabelSDatailemHrace(vybranyHrac);

        } else {
            detailLabel.setText("Vyberte hráče pro zobrazení detailů.");
        }
    }

    @FXML
    private void pridatHrace() {
        try {
            FXMLLoader loader = new FXMLLoader(SpravaHracuApplication.class.getResource("PlayerForm.fxml"));
            //DialogPane dialogPane = loader.load();
            VBox form = loader.load(); // VBox odpovídá kořenovému prvku v FXML

            HracFormularController controller = loader.getController();
            // Nastavení okna (Stage)
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Přidat hráče");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setScene(new Scene(form));

            // Zobrazit dialog a počkat na zavření
            dialogStage.showAndWait();
            // Získat data z formuláře
            Hrac newPlayer = controller.getHrac();
            if (newPlayer != null) {
                hraci.getItems().add(newPlayer); // Přidání hráče do seznamu
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Úprava vybraného hráče
    @FXML
    private void upravitHrace() {
        int index = hraci.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            Hrac vybranyHrac = hraci.getItems().get(index);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerForm.fxml"));
            try {
                VBox form = loader.load();
                HracFormularController formUpravenyHrac = loader.getController();
                formUpravenyHrac.setHrac(vybranyHrac);

                // Nastavení okna (Stage)
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Upravit hráče");
                dialogStage.initModality(Modality.APPLICATION_MODAL);
                dialogStage.setScene(new Scene(form));

                dialogStage.showAndWait();

                Hrac upravenyHrac = formUpravenyHrac.getHrac();
                if (upravenyHrac != null) {
                    hraci.getItems().set(index, upravenyHrac);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    public void zavritAplikaci() {
        Platform.exit();
    }

    @FXML
    public void oApliaci() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Aplikace pro správů hráčů online hry.", ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    public void copyRight() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "©2025, Gasos, Jitka Fürbacherová", ButtonType.OK);
        alert.showAndWait();
    }
}
