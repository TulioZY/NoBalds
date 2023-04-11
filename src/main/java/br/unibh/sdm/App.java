package br.unibh.sdm;

/**
 * Classe inicial
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );

      Cliente c1 = new Cliente(1L, "João", "joao@gmail.com", "3155558888", "15577734298");
      System.out.println(c1);
    }
}
