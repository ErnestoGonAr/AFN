import java.util.ArrayList;

public class AFN{

  //Caracteristicas del automata
  public String q[];
  public String s;
  public String f[];
  public String alf[];

  //Inicializa el alfabeto, se tiene que mandar la cadena del txtfield bien
  public boolean iniAlf(String cadena){
    //Inicializar alf
    //revisar que inicie y termine con corchetes
    if(cadena.substring(0,1)!="{") return false;
    int aux = cadena.length();
    if(cadena.substring(aux-1,aux)!="}") return false;
    //quitar corchetes
    String temp[] = (cadena.substring(1,aux-1)).split(",");
    for(int i = 0;i <= temp.length;i++){
      if(temp[i].length()!=1)return false;
    }
    alf = temp;
    return true;
  }

  //puede inicializar Q y F, se le debe de mandar la cadena y el arreglo al cual esta inicializando

  public boolean iniAlf(String cadena,String arreglo[]){
    //Inicializar alf
    //revisar que inicie y termine con corchetes
    if(cadena.substring(0,1)!="{") return false;
    int aux = cadena.length();
    if(cadena.substring(aux-1,aux)!="}") return false;
    //quitar corchetes
    String temp[] = (cadena.substring(1,aux-1)).split(",");

    for(int i = 0; i <= temp.length;i++){
      if(temp[i].length()!=2)return false;
    }
    arreglo = temp;
    return true;
  }

  //se supone que para cuando se ejecute esto ya tiene que tener bien
  //el alfabeyo y los estados.
  public String[][] tablaTran(){
    //Metodo para inicializar la tabla de transiciones
    int a = alf.length;
    int b = q.length;
    return new String[a][b];
  }


}
