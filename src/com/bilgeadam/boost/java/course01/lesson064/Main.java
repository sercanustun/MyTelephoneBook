package com.bilgeadam.boost.java.course01.lesson064;

import java.io.IOException;

import com.bilgeadam.boost.java.course01.lesson064.model.Person;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage      primary;
	private BorderPane rootPane;
	private ObservableList<Person> people;

	private ObservableList<Person> getPeople() {
		if (this.people == null) {
			this.people = FXCollections.observableArrayList(); 
		}
		return this.people;
	}
	
	@Override
	public void start(Stage primaryStage) {
		initPrimaryStage(primaryStage);
		initRootLayout();
		initTelephoneEntries();
		showPersonOverview();
	}

	private void initTelephoneEntries() {
		this.getPeople().add(new Person("Babür", "Somer", "533 437 9929", null, null, 0, null));
		this.getPeople().add(new Person.Builder().firstName("Ali").lastName("Ergül").build());
		this.getPeople().add(new Person.Builder().firstName("Çaðlayan").lastName("Kaya").build());
		this.getPeople().add(new Person.Builder().firstName("Çaðrý").lastName("Türkmen").build());
		this.getPeople().add(new Person.Builder().firstName("Canan").lastName("Havva").build());
		this.getPeople().add(new Person.Builder().firstName("Görkem").lastName("Sönmez").build());
		this.getPeople().add(new Person.Builder().firstName("Gülten").lastName("Ulukal").build());
		this.getPeople().add(new Person.Builder().firstName("Mert Can").lastName("Aydýn").build());
		this.getPeople().add(new Person.Builder().firstName("Melih").lastName("Dumanlý").build());
		this.getPeople().add(new Person.Builder().firstName("Mustafa").lastName("Öztürk").build());
		this.getPeople().add(new Person.Builder().firstName("Onur").lastName("Gündoðdu").build());
		this.getPeople().add(new Person.Builder().firstName("Recep").lastName("Ergan").build());
		this.getPeople().add(new Person.Builder().firstName("Sercan").lastName("Üstün").build());
		this.getPeople().add(new Person.Builder().firstName("Burak").lastName("Güneþ").city("Samatya").build());
		
		for (Person person : people) {
			System.out.println(person);
		}
	}

	private void initPrimaryStage(Stage primaryStage) {
		this.primary = primaryStage;
		this.primary.getIcons().add(new Image(getClass().getResourceAsStream("resources/TelephoneBook.png")));
		this.primary.setTitle("Benim Güzel Telefon Rehberim");
	}

	private void showPersonOverview() {
		FXMLLoader loader = new FXMLLoader();  // herhangi bir scene'i ekranda göstermek için, FXML'ini yüklememiz gerekli
		loader.setLocation(getClass().getResource("view/PersonOverview.fxml"));  // FXML dosyasý nerede belirtiyoruz
		try {
			AnchorPane personOverview = (AnchorPane)loader.load();	// FXML'i okuyoruz
			this.rootPane.setCenter(personOverview);				// RootPane borderpane cinsinden olduðundan ALT/ÜST/SAÐ/SOL/ORTA alanlarý bulunmakta
																	// ORTA'ya personoverview'u ekliyor
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void initRootLayout() {
		try {
			this.rootPane  = (BorderPane) FXMLLoader.load(getClass().getResource("view/TelephoneBook.fxml"));
			Scene      scene = new Scene(this.rootPane, 600, 400);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			this.primary.setScene(scene);
//			primaryStage.initStyle(StageStyle.UNDECORATED);
			this.primary.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
