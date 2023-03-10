/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import models.Chambre;
import models.Hotel;
import models.Maison;
import services.ServiceChambre;
import services.ServiceMaison;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
//import javax.swing.text.Document;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.nio.file.Files;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Ghassen Chamakh
 */
public class InterfaceMaisonController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private TextField prix;
    @FXML
    private TextField adresse;
    private TextField image;
    private TextField nombre_chambre;
    @FXML
    private ComboBox<String> status;
    @FXML
    private Button supprimer;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Afficher;
    @FXML
    private Button modifier;
    @FXML
    private TableView<Maison> table3;
    @FXML
    private TableColumn<Maison, String> c1;
    @FXML
    private TableColumn<Maison, Float> c2;
    @FXML
    private TableColumn<Maison, String> c3;
    @FXML
    private TableColumn<Maison, String> c4;
    @FXML
    private TableColumn<Maison, String> c5;
    @FXML
    private TableColumn<Maison, Integer> c6;
    @FXML
    private Button Retour;
    @FXML
    private TextField eChercher;
    @FXML
    private Button bchercher;
    @FXML
    private Button getPdf;
    @FXML
    private ComboBox<Integer> chambre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String[]items = {"Reservé ","Non reservé"};
          status.getItems().addAll(items);
          status.setOnAction(event->{String data= status.getSelectionModel().getSelectedItem().toString();});
         
          Integer []item = {1,2,3,4,5,6};
          chambre.getItems().addAll(item);
          chambre.setOnAction(event->{String data= chambre.getSelectionModel().getSelectedItem().toString();});
       ActionEvent event = null;
        
          
         afficherMison(event);
    }    


    

   
    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePrincipal.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) Retour.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    
    }

    @FXML
    private void supprimerMaison(ActionEvent event) {
             ServiceMaison sm = new ServiceMaison();
        Maison m = table3.getSelectionModel().getSelectedItem();
        

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);// alert de confirmation suppression
        alert.setTitle("ALERT SUPPRESSION");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER LA MAISON ?");
         // Jouer le son
            String soundFile = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\projet\\src\\com\\travolta\\utils\\son\\good.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.dispose());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sm.supprimer(m);

            JOptionPane.showMessageDialog(null, " Maison supprimer ");
            
        } else {
            JOptionPane.showMessageDialog(null, " Maison non supprimer ");
        }
        sm.afficher();
        
    }

    @FXML
    private void ajouterMison(ActionEvent event) throws IOException {
        ServiceMaison sm = new ServiceMaison();
          String tit = titre.getText();
          Float px = Float.parseFloat(prix.getText());
       String desc = description.getText();
       String add = adresse.getText();
           String stat =status.getSelectionModel().getSelectedItem().toString();

//       String stat = status.getText();
    int chambres =chambre.getSelectionModel().getSelectedItem();

    //int chambre = Integer.parseInt(nombre_chambre.getText());
  
    // Créer un objet Cmaison avec les valeurs récupérées
   Maison maison = new Maison( tit,px ,desc, add, stat,chambres);
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        // Convertir le fichier en tableau d'octets et l'affecter à l'attribut image
    byte[] imageBytes = Files.readAllBytes(file.toPath());
        
    maison.setImage(imageBytes);
    }
    sm.ajouter(maison);
    // Afficher un message de confirmation
    JOptionPane.showMessageDialog(null, "maison ajoutée !");

        
    
    }

    @FXML
    private void afficherMison(ActionEvent event) {
         ServiceMaison sm = new ServiceMaison();
        ObservableList<Maison> list = FXCollections.observableList(sm.afficher());
        c1.setCellValueFactory(new PropertyValueFactory<>("titre"));
        c2.setCellValueFactory(new PropertyValueFactory<>("prix"));
        c3.setCellValueFactory(new PropertyValueFactory<>("description"));
        c4.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        c5.setCellValueFactory(new PropertyValueFactory<>("status_hebergement"));
        c6.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
       // c7.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        
        //table3.setItems(list);
            // Créez une instance de SortedList en utilisant votre liste observable
    SortedList<Maison> sortedList = new SortedList<>(list);

// Définissez le comparateur pour trier les éléments par ordre alphabétique du titre
    sortedList.setComparator((Maison m1, Maison m2) -> m1.getTitre().compareTo(m2.getTitre()));

// Utilisez la liste triée pour afficher les éléments dans votre table
    table3.setItems(sortedList);
    }

    @FXML
    private void modifierMaison(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierMaison.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) modifier.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    private void Chercherevent(ActionEvent event) {
         
         ServiceMaison sm = new ServiceMaison();
        ObservableList<Maison> list = FXCollections.observableList(sm.afficher());
        c1.setCellValueFactory(new PropertyValueFactory<>("titre"));
        c2.setCellValueFactory(new PropertyValueFactory<>("prix"));
        c3.setCellValueFactory(new PropertyValueFactory<>("description"));
        c4.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        c5.setCellValueFactory(new PropertyValueFactory<>("status_hebergement"));
        c6.setCellValueFactory(new PropertyValueFactory<>("nombre_chambre"));
        //c7.setCellValueFactory(new PropertyValueFactory<>("image"));       
        table3.setItems(list);

        sm.afficher();
      table3.setItems(list);

        FilteredList<Maison> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Maison> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table3.comparatorProperty());
        table3.setItems(sortedData);
    }

    @FXML
    private void getPdf(ActionEvent event) {
       

        try {

            OutputStream file = new FileOutputStream(new File("C:\\Users\\DELL\\Desktop\\Activite PDF\\Maison.pdf"));
          Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            ServiceMaison sm = new ServiceMaison();
            //get from table
            Maison maison = table3.getSelectionModel().getSelectedItem();

          

            document.add(new Paragraph("************************Liste De Maison ************************\n\n\n\n\n\n\n"));

            document.add(new Paragraph(" ___________________________________________________________________________\n"));
            document.add(new Paragraph(" Titre :  " + maison.getTitre() + "  \n"));
            document.add(new Paragraph(" Prix  :  " + maison.getPrix() + "  \n"));
            document.add(new Paragraph(" Description  :  " + maison.getDescription() + "  \n"));
            document.add(new Paragraph(" Addresse :  " + maison.getAdresse() + "  \n"));
            document.add(new Paragraph(" Status Hebergement :  " + maison.getStatus_hebergement() + "  \n"));
            document.add(new Paragraph(" Nombre de Chambre :  " + maison.getChambre() + "  \n"));
            document.add(new Paragraph(" Image :  " + maison.getImage() + "  \n"));


            document.add(new Paragraph(" _________________________________________________________________________"));

            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());

        }

    }
     private void ajoutImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    // définir les filtres pour n'afficher que les fichiers image
    fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
    );
        // ouvrir la boîte de dialogue de sélection de fichier
        File imageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
         
        
    }
    }
    
    

