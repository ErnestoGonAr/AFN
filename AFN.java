import java.util.ArrayList;

public class AFN{

  //Caracteristicas del automata
  public String q[];
  public String s;
  public String f[];
  public String alf[];
  public String tablaT[][];

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
      if(this.q[i].equals(s)){
        this.s = s;
        return true;
      }
    }
    return false;
  }
  //se supone que para cuando se ejecute esto ya tiene que tener bien
  //el alfabeyo y los estados.
  public void tablaTran(){
    //Metodo para inicializar la tabla de transiciones
    int a = alf.length;
    int b = q.length;
    tablaT = new String[a][b];
  }

  public boolean validaTabla(String tran[][]){
    for(int i = 0;i<tran.length;i++){
      for(int j = 0;j<tran[i].length;j++)
      if(validaCelda(tran[i][j]))System.out.println(i+","+j);
    }
    return true;
  }

  private boolean validaCelda(String cadena){
    //revisar si es -
    if(cadena.equals("-")) return true;
    //revisar que inicie y termine con corchetes
    if(cadena.equals(""))return false;
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
        if(this.q[j].equals(aux1))bandera++;
      }

    }
    if(bandera!=temp.length)return false;
    return true;
  }

  public boolean validaCadena(String cadena,String estado){
    //caso base
    if(cadena.equals("")){
      if(esFinal(estado))return true;
      else return false;
    }

    //Nos posicionamos en el primer caracter
    char temp = cadena.charAt(0);

    //revisamos si es un simbolo del alfabeto
    for(int i=0;i<alf.length;i++){
      if(alf[i].equals(""+temp)){
        int a = puntoTransAlf(temp);
        int b = puntoTransQ(estado);
        System.out.println(""+a+"  "+b+"          "+temp+"   "+estado);

        String temp2 = tablaT[a][b];// A donde voy

        if(temp2.equals("-"))return false;
        String temp3[] = temp2.substring(1,temp2.length()-1).split(","); //Arreglo de los estados a donde voy
        for(int j=0;j<temp3.length;j++){
          if(validaCadena(cadena.substring(1,cadena.length()),temp3[j]))return true;
        }
      }
    }
    return false;
  }

  private boolean esFinal(String estado){
    for(int i =0;i<f.length;i++){
      if(f[i].equals(estado))return true;
    }
    return false;
  }

  private int puntoTransAlf(char x){
    int a=0;
    for(a=0;a<alf.length;a++){
      if(alf[a].equals(""+x))return a;
    }
    return -1;
  }

  private int puntoTransQ(String estado){
    int a=0;
    System.out.println(estado);
    for(a=0;a<q.length;a++){

      if(q[a].equals(""+estado)){
      return a;
      }
    }
    return -1;
  }


  //Pruebas locochonas
  public static void main(String[] args) {
    //Creacion del objeto
    AFN a = new AFN();

    //Introduccion de las caracteristicas
    System.out.println(a.iniQ("{q1,q2,q3,q4,q5,q6}"));
    System.out.println(a.iniS("q1"));
    System.out.println(a.inif("{q4,q5,q6}"));
    System.out.println(a.iniAlf("{x,y}"));

    //Creacion de la tabla de tranciciones
    a.tablaTran();
    //a
    a.tablaT[0][0]="{q2,q5}";
    a.tablaT[0][1]="-";
    a.tablaT[0][2]="{q4}";
    a.tablaT[0][3]="{q2}";
    a.tablaT[0][4]="{q5}";
    a.tablaT[0][5]="{q6}";

    a.tablaT[1][0]="-";
    a.tablaT[1][1]="{q3}";
    a.tablaT[1][2]="{q4}";
    a.tablaT[1][3]="-";
    a.tablaT[1][4]="{q6}";
    a.tablaT[1][5]="{q6}";
    //b
    //a.tablaT[1][0]="-"; //q1 - b
    //a.tablaT[1][1]="-";//q2 - b

    a.validaTabla(a.tablaT);

    System.out.println(a.validaCadena("xxy",a.s));
  }

}
