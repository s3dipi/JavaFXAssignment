package edu.farmingdale.javafxassignment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField majorField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField imageUrlField;

    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> firstNameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Student, String> departmentColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    private int studentId = 1;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        studentTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            if (newSelection != null) {
                firstNameField.setText(newSelection.getFirstName());
                lastNameField.setText(newSelection.getLastName());
                departmentField.setText(newSelection.getDepartment());
                majorField.setText(newSelection.getMajor());
                emailField.setText(newSelection.getEmail());
            }
        });
    }

    @FXML
    protected void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        departmentField.clear();
        majorField.clear();
        emailField.clear();
        imageUrlField.clear();

        studentTableView.getSelectionModel().clearSelection();
    }

    @FXML
    protected void addStudent() {
        Student student = new Student(
                studentId,
                firstNameField.getText(),
                lastNameField.getText(),
                departmentField.getText(),
                majorField.getText(),
                emailField.getText()
        );

        studentTableView.getItems().add(student);
        studentId++;

        clearFields();
    }

    @FXML
    protected void deleteStudent() {

        Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            studentTableView.getItems().remove(selectedStudent);
            clearFields();
        }
    }

    @FXML
    protected void editStudent() {

        Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();

        if (selectedStudent != null &&
                !firstNameField.getText().isEmpty() &&
                !lastNameField.getText().isEmpty()) {

            selectedStudent.setFirstName(firstNameField.getText());
            selectedStudent.setLastName(lastNameField.getText());
            selectedStudent.setDepartment(departmentField.getText());
            selectedStudent.setMajor(majorField.getText());
            selectedStudent.setEmail(emailField.getText());

            studentTableView.refresh();
        }
    }
}
