import java.util.ArrayList;

public class AFN{

  //Caracteristicas del automata
  public String q[];
  public String s;
  public String f[];
  public String alf[];
  public ArrayList trans[][];

  //Inicializa el alfabeto, se tiene que mandar la cadena del txtfield bien
  public boolean iniAlf(String cadena){
    //Inicializar alf
    //revisar que inicie y termine con corchetes
    if(cadena.chartAt(0)!='{') return false;
    if(cadena.charAt(cadena.length()-1)!='}') return false;
    //quitar corchetes
    String temp[] = (cadena.substring(1,cadena.length()-1)).split(",");
    for(int i = 0, i <= temp.length(),i++){
      if(temp[i].lengt()!=1)return false;
    }
    alf = temp;
    return true;
  }

  //puede inicializar Q y F, se le debe de mandar la cadena y el arreglo al cual esta inicializando
  public boolean iniAlf(String cadena,String arreglo[]){
    //Inicializar alf
    //revisar que inicie y termine con corchetes
    if(cadena.chartAt(0)!='{') return false;
    if(cadena.charAt(cadena.length()-1)!='}') return false;
    //quitar corchetes
    String temp[] = (cadena.substring(1,cadena.length()-1)).split(",");
    for(int i = 0, i <= temp.length(),i++){
      if(temp[i].lengt()!=2)return false;
    }
    arreglo = temp;
    return true;
  }

  private void iniTran(){
    //Metodo para inicializar la tabla de transiciones
    int a = alf.length();
    int b = q.length();
    int x = 0;
    if(a>b) x = a;
    else x = b;

    t = new String[a][b][x];
  }


}
