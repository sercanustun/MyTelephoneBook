module MyTelephoneBook {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens com.bilgeadam.boost.java.course01.lesson64 to javafx.graphics, javafx.fxml;
}
