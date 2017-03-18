import java.util.ArrayList;

public class AFN{

  //Caracteristicas del automata
  public String q[];
  public String s;
  public String f[];
  public String alf[];

  //Inicializa el alfabeto
  public boolean iniAlf(String cadena){
    //Inicializar alf
    //revisar que inicie y termine con corchetes
    if(cadena.charAt(0)!='{') return false;
    int aux = cadena.length();
    if(cadena.charAt(aux-1)!='}') return false;

    //quitar corchetes
    String temp[] = (cadena.substring(1,aux-1)).split(",");
    //validar que no este vacio
    for(int i = 0;i < temp.length;i++){
      if(temp[i].length()!=1 || temp[i].length()==0) return false;
    }
    alf = temp;
    return true;
  }
  //puede inicializar Q
  public boolean iniQ(String cadena){
    //Inicializar alf
    //revisar que inicie y termine con corchetes
    if(cadena.charAt(0)!='{') return false;
    int aux = cadena.length();
    if(cadena.charAt(aux-1)!='}') return false;
    //quitar corchetes
    String temp[] = (cadena.substring(1,aux-1)).split(",");
    //revisar que no halla cadenas vacias.
    for(int i = 0; i < temp.length;i++){
      if(temp[i].length()==0 || temp[i].equals("")) return false;
    }
    this.q = temp;
    return true;
  }
  //puede inicializar f
  public boolean inif(String cadena){
    //Inicializar alf
    //revisar que inicie y termine con corchetes
    if(cadena.charAt(0)!='{') return false;
    int aux = cadena.length();
    if(cadena.charAt(aux-1)!='}') return false;
    //quitar corchetes
    String temp[] = (cadena.substring(1,aux-1)).split(",");
    //revisar que no halla cadenas vacias.
    String aux1 = "";
    int bandera= 0;
    for(int i = 0; i < temp.length;i++){
      if(temp[i].length()==0 || temp[i].equals("")) return false;
      aux1 = temp[i];

      for(int j = 0;j<this.q.length;j++){
        if(this.q[j].equals(aux1))bandera = 1;
      }

    }
    if(bandera==0)return false;
    this.f = temp;
    return true;
  }
  //puede inicializar s
  public boolean iniS(String s){
    for(int i = 0;i<this.q.length;i++){
      if(this.q[i].equals(s))return true;
    }
    return false;
  }
  //se supone que para cuando se ejecute esto ya tiene que tener bien
  //el alfabeyo y los estados.
  public String[][] tablaTran(){
    //Metodo para inicializar la tabla de transiciones
    int a = alf.length;
    int b = q.length;
    return new String[a][b];
  }




  //Pruebas locochonas
  public static void main(String[] args) {
    AFN a = new AFN();
    System.out.println(a.iniQ("{q1,q2}"));
    System.out.println(a.iniS("q1"));
    System.out.println(a.inif("{q2}"));
    System.out.println(a.iniAlf("{a,b}"));

  }


}
