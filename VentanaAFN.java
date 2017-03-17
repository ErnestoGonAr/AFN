import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.*;



public class VentanaAFN extends Application{

    TableView tableView = new TableView();

    Stage stageTemporal;
    Scene scenePantallaPrincipal,scenePantallaTabla;

    Button buttonTablaTransiciones, buttonPrincipal;
    TextField txtQ,txtS,txtF,txtZigma;
    Label lblQ,lblS,lblF,lblZigma;

    @Override
    public void start(Stage stageOrigen) throws Exception{
        stageTemporal = stageOrigen;
        stageTemporal.setOnCloseRequest( e -> stageOrigen.close() );

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        scenePantallaPrincipal = new Scene(gridPane, 800, 600);

        tablaTransiciones(4,6);

        buttonTablaTransiciones = new Button("Llenar Tabla"); //Generar una ventana para llenar la tabla
        //buttonTablaTransiciones.setOnAction(e-> stageTemporal.setScene(scenePantallaTabla) );

        txtQ = new TextField();
        txtS = new TextField();
        txtF = new TextField();
        txtZigma = new TextField();

        lblQ = new Label("Q = ");
        lblS = new Label("s = ");
        lblF = new Label("F = ");
        lblZigma = new Label("Zigma = ");

        GridPane.setConstraints(buttonTablaTransiciones,0,4);
        GridPane.setConstraints(lblQ,0,0);
        GridPane.setConstraints(txtQ,1,0);
        GridPane.setConstraints(lblF,0,2);
        GridPane.setConstraints(txtF,1,2);
        GridPane.setConstraints(lblS,0,1);
        GridPane.setConstraints(txtS,1,1);
        GridPane.setConstraints(lblZigma,0,3);
        GridPane.setConstraints(txtZigma,1,3);
        GridPane.setConstraints(tableView,2,4);

        buttonTablaTransiciones.setOnAction(e-> crearColumnas(Integer.parseInt(txtZigma.getText()) ) );
        //buttonTablaTransiciones.setOnAction(e-> crearFilas(Integer.parseInt(txtZigma.getText())-1) );

        gridPane.getChildren().addAll(
                buttonTablaTransiciones,
                lblQ,
                txtQ,
                lblS,
                txtS,
                lblF,
                txtF,
                lblZigma,
                txtZigma,
                tableView
        );

        stageTemporal.setTitle("Validador de cadenas de AFN");
        stageTemporal.setScene(scenePantallaPrincipal);
        stageTemporal.show();
    }//start

    public void tablaTransiciones(int x, int y){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        buttonPrincipal = new Button("Regresar a la pantalla Principal");
        buttonPrincipal.setOnAction( e -> stageTemporal.setScene(scenePantallaPrincipal));

        GridPane.setConstraints(buttonPrincipal,0,1);

        for(int i=0;i<=4;i++){

        }

        for(int i=0;i<=4;i++){

        }

        gridPane.getChildren().add(
                buttonPrincipal
        );

        scenePantallaTabla = new Scene(gridPane,800,600);
    }//tablaTransiciones

     public void crearColumnas(int valor){
        tableView.getColumns().clear();
        tableView.getItems().clear();
        for(int x=1;x<=valor;x++){
            TableColumn firstNameCol = new TableColumn(" "+x);
            tableView.getColumns().addAll(firstNameCol);
        }//CrearlasColumnas
    }//crearColumnas

    public void crearFilas(int valor){
        for(int y=0;y<=valor;y++){
            tableView.getItems().add(y,"Hola"+y);
        }
    }


    public int columnasTablaTransiciones(String alfabeto){
        return 4;
    }//columnasTablaTransiciones

    public int filasTablaTransiciones(String estados){
        return 6;
    }//columnasTablaTransiciones

    public static void main(String []args){
         launch(args);
    }//main

}//VentanaAFN
