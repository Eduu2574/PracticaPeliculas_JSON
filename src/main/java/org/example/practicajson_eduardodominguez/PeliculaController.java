package org.example.practicajson_eduardodominguez;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.util.ArrayList;


public class PeliculaController {


    @FXML
    private TextField directorTf;

    @FXML
    private TextField fechaTf;

    @FXML
    private TextField generoTf;

    @FXML
    private TextField tituloTf;

    @FXML
    private Button Bt_importar;

    @FXML
    private ListView<Pelicula> lv_listadoPeliculas;
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();



    @FXML
    void onImportarClick(ActionEvent event) {
        try {
            // Deserializa el JSON en un ArrayList de objetos Pelicula
            ArrayList<Pelicula> peliculas =
                    JSON_MAPPER.readValue(new File("src/main/resources/Peliculas.json"),
                            JSON_MAPPER.getTypeFactory().constructCollectionType
                                    (ArrayList.class, Pelicula.class));

            // Crea una lista observable para el ListView
            ObservableList<Pelicula> observablePeliculas = FXCollections.observableArrayList(peliculas);

            // Asigna la lista observable al ListView
            lv_listadoPeliculas.setItems(observablePeliculas);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void onMousearClic(MouseEvent event) {
        Pelicula pelicula = lv_listadoPeliculas.getSelectionModel().getSelectedItem(); // OBTENGO LA PELI SELECCIONADA
        if (pelicula != null) {
            directorTf.setText(pelicula.getDirector());
            fechaTf.setText(pelicula.getFecha());
            generoTf.setText(pelicula.getGenero());
            tituloTf.setText(pelicula.getTitulo());
        }
    }
}