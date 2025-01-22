package org.example.spravahracu;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class HracFormularController {

    @FXML
    private TextField usernameField;

    @FXML
    private Spinner<Integer> levelSpinner;

    @FXML
    private ToggleGroup roleToggleGroup;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker datePicker;

    private Hrac hrac; // Hráč, který se přidává nebo upravuje
    private boolean isEditMode;

    @FXML
    public void initialize() {
        // Inicializace spinneru pro level
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        levelSpinner.setValueFactory(valueFactory);
    }

    public void setHrac(Hrac hrac) {
        this.hrac = hrac;
        this.isEditMode = hrac != null;

        // Pokud je úprava, naplň formulář daty hráče
        if (isEditMode) {
            usernameField.setText(hrac.getLogin());
            levelSpinner.getValueFactory().setValue(hrac.getLevel());
            RadioButton selectedRole = null;
            for (Toggle toggle : roleToggleGroup.getToggles()) {
                if (((RadioButton) toggle).getText().equals(hrac.getRole())) {
                    selectedRole = (RadioButton) toggle;
                    break;
                }
            }
            //Radio button odpovidající roli hráče nastavim jako zaškrnutý
            if (selectedRole != null) {
                selectedRole.setSelected(true);
            }
            emailField.setText(hrac.getEmail());
            datePicker.setValue(hrac.getRegistrace());
        }
    }

    @FXML
    private void onSave() {
        // Validace vstupů
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        LocalDate date = date = datePicker.getValue();

        RadioButton selectedRole = (RadioButton) roleToggleGroup.getSelectedToggle();

        if (username.isEmpty() || email.isEmpty() || date == null || selectedRole == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vyplňte prosím všechna pole!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        int level = levelSpinner.getValue();
        String role = selectedRole.getText();

        if (isEditMode) {
            // Aktualizace dat hráče
            hrac.setLogin(username);
            hrac.setLevel(level);
            hrac.setRole(role);
            hrac.setEmail(email);
            hrac.setRegistrace(date);
        } else {
            // Vytvoření nového hráče
            hrac = new Hrac(username, level, role, email, date);
        }

        closeDialog();
    }

    @FXML
    private void onCancel() {
        closeDialog();
    }

    private void closeDialog() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.close();
    }

    public Hrac getHrac() {
        return hrac;
    }
}
