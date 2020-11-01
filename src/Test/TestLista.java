/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import Lista.*;
import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author root
 */
public class TestLista {
    //private ABB arbol = new ABB();
    private OrderSet<Integer> set;
    private OrderSetWithoutDuplicates<Integer> uniqueset;
    public void iniciar(){
        Comparator<Integer> comparador = new Comparator<Integer>()
        {
            @Override
            public int compare(final Integer o1, final Integer o2)
            {
              
                int comparacion =  o1.compareTo(o2);
                System.out.println(" = " + String.valueOf(comparacion));
                return comparacion;
            }
        };
        set  = new OrderSet<>(comparador);
       uniqueset  = new OrderSetWithoutDuplicates<>(comparador);

        llenarLista(uniqueset);
        System.out.println(uniqueset.toString());
    }
    private void llenarLista(OrderSet<Integer> set){
                
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);

        set.add(10);
        set.add(10);

        set.add(11);
        set.add(13);
        set.add(0);
        set.add(15);
        set.add(-3);
        set.add(-4);
        set.add(-1);
        set.add(-2);        
        set.add(2);
        set.add(5);
        set.add(17);
        set.add(12);
        set.add(10);
    }
    

}
