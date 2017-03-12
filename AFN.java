

public class AFN{

  //Caracteristicas del automata
  public char alf[];
  public String q[];
  public String s;
  public String f[];
  public String t[][][];

  public AFN(String alf, String q, String s, String f,String t[][]){
    //Inicializar las caracteristicas del AFN
    //Inicializar alf,q,s,f
    iniArreglos(alf,this.alf);
    iniArreglos(q,this.q);
    this.s = s;
    iniArreglos(f,this.f);

    //inicializar la tabla de transiciones

  }

  private void iniArreglos(String cadena,String arreglo[]){
    //Inicializar alf,q,s,f
    arreglo = cadena.split(",");
  }

  private void iniTran(String arreglo[][]){
    //Metodo para inicializar la tabla de transiciones
    int a = arreglo.length();
    int b = arreglo[0].length();
    int x = 0;
    if(a>b) x = a;
    else x = b;

    t = new String[a][b][x]
  }


}
