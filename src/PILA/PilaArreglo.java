/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PILA;

/**
 *
 * @author huesos
 */
public class PilaArreglo <T> implements PilaADT<T>{
    private T[] pila;
    private int tope;
    private static final int MAX=3;
    
    
    //CONSTRUCTORES
    public PilaArreglo(){
        pila= (T[]) new Object[MAX];
        tope=-1;
    }
    
    public PilaArreglo(int max){
        pila= (T[]) new Object[max];
        tope=-1;
    }
    
    //MÉTODOS
    public boolean isEmpty(){
        return tope <= -1;
    }
    
    public void push (T dato){
        if(tope+1 == pila.length)
            expande();
        tope++;
        pila[tope]=dato;
    }
    
    public T pop(){
        if(isEmpty())
            throw new EmptyCollectionException();
        
        T resp=pila[tope];
        pila[tope]=null;
        tope--;
        return resp;
    }
    
    public T peek(){
        if(isEmpty())
            throw new EmptyCollectionException();
        return pila[tope];
    }
    
    public boolean multiPop(int num){
        boolean resp=false;
        if(this.tope>=num-1){
            resp=true;
            for(int i=0; i<num; i++)
                pop();
        }
        return resp;
    }
    
    public void multiPop(int num, PilaADT<T> pila){
        
        while(!pila.isEmpty() && num !=0){
            pila.pop();
            num--;
        }
    }
    
    //MÉTODO (EXPANDE) AUXILIAR
    private void expande(){
        T[] nuevo = (T[]) new Object[pila.length*2];
        for(int i=0; i<=tope; i++)
            nuevo[i]= pila[i];
        pila=nuevo;  
    }
    
    //GET
    public int getTope(){
        return this.tope;
    }
    
    public static void main ( String [] args ){
        PilaArreglo pila = new PilaArreglo();
        
        
        pila.push("a");
        pila.push("b");
        pila.push("c");
        pila.push("d");
        
        System.out.println(pila.getTope());
        System.out.println(pila.peek());
        
        //pila.multiPop(4);
        
        
        System.out.println(pila.getTope());
        System.out.println(pila.peek());
    }
}
