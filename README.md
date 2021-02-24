# Stock/Pila

## Tabla de contenidos
* [Introducción](#introducción)
* [Instalaciones y tecnología](#instalaciones-y-tecnología)
* [Clase Base](#clase-base)
* [Métodos](#métodos)
* [Clase final](#clase-final)
* [Conclusión](#conclusión)


## Introducción

Dentro del lenguaje de programación Java se pueden encontrar librerias que incluyen una clase predeterminada para distintas estructuras de datos, en particular es común que incluyan una que se llame stock o pila, pero ¿cómo está conformada esta conformada esta clase? ¿Qué puedo hacer si no conozco las librerías o no funcionan?
¿Qué se necesita para crear una Pila como estructura de datos en Java? Estas son las preguntas que resolveremos aquí.


## Instalaciones y tecnología

Para trabajar con Java es necesario un IDE que permita usar el lenguaje. Esta es una de las opciones de IDE que existen para trabajar con Java:
* NetBeans 8.2 ([link de descarga](https://www.oracle.com/technetwork/es...))


### Turorial de descarga
Tutorial para descargar NetBeans 8.2 y que este listo para programar con Java. 
* [link de video-tutorial de Youtube](https://www.youtube.com/watch?v=WtKS7J7kVl8)


## Clase Base

La clase pública que tendrá todos los métodos que le darán la funcionalidad a la pila será esta, PilaArreglo.
La primera línea que necesitamos es la que declara a nuestra clase. La < T > después del nombre de la clase indica que la pila funcionará con cualquier clase de objetos. No solo aceptará números o cadenas, aceptará cualquier objeto.
Y que nuestra clase implemente a PilaADT indica que nuestra clase será la que tendrá los métodos, pero PilaADT será la que los implementará, será a la que llamaremos para usarlos.
```java
public class PilaArreglo <T> implements PilaADT<T>{
    private T[] pila;
    private int tope;
    private static final int MAX=3;
```
Después vienen los atributos de la clase, todos privados para que solo se pueda acceder a ellos desde la clase:
1. **T[] pila** es un arreglo de objetos que funcionará como nuestra pila almacenando y eliminando espacios del arreglo.
2. **int tope** será un entero que nos indicará siempre en que espacio del arreglo está el tope. El tope es el último elemento que se agregó a la pila. Ver siguiente imagen.
3. **static final int MAX=x** es un entero que nunca cambiará que nos servirá para el constructor vacío.
<img src="http://1.bp.blogspot.com/-QTDcpd1_kyc/Uo1kL7cgH0I/AAAAAAAAAIc/Sh46LQr7Nas/s1600/pi.png" alt="Tope" width="200"/>

#### Constructores
1. Constructor vacío. Utiliza el valor que le dimos al entero MAX para inicializar el arreglo, ya que un arreglo necesita un tamaño inicial para poder crearse. 
Al entero tope se le asigna un menos uno como bandera de error que indica que aún no hay ningún elemento en la pila, en el arreglo.
```java
public PilaArreglo(){
        pila= (T[]) new Object[MAX];
        tope=-1;
    }
```
2. El segundo constructor hace lo mismo con tope, pero recibe un entero que será el valor con el que se incializará el tamaño del arreglo.
```java
public PilaArreglo(int max){
        pila= (T[]) new Object[max];
        tope=-1;
    }
```

## Métodos
1. **isEmpty** nos indica si está vacía la pila regresando TRUE si tope es negativo y FALSE si es no negativo
```java
    public boolean isEmpty(){
        return tope <= -1;
    }
```  
2. **push** sirve para insertar un elemento a la pila. Este método aumenta en uno el tope para que coincida con el nuevo tope y si no hay espacio para un elemento más en el arreglo llama al método auxiliar **expande** que duplicará el tamaño del arreglo para tener el espacio suficiente.
```java
    public void push (T dato){
        if(tope+1 == pila.length)
            expande();
        tope++;
        pila[tope]=dato;
    }
   
    private void expande(){
        T[] nuevo = (T[]) new Object[pila.length*2];
        for(int i=0; i<=tope; i++)
            nuevo[i]= pila[i];
        pila=nuevo;  
    }
```
3. **peek y pop** nos permiten ver el elemento en el tope y sacarlo/eliminarlo respectivamente. Ambos mandan un error si está vacía la pila. 
Ambos regresan el elemento que está en el tope, pero peek solo lo muestra y pop lo elimina de la pila y disminuye uno el tope.
```java
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
```
4. **getTope** es el único método get de la clase que regresa el lugar del arreglo en el que se encuentra el tope.
```java
    public int getTope(){
        return this.tope;
    }
```
5. Por último, tenemos el método **multipop** que nos permite sacar muchos elementos a la vez si tenemos la cantidad que queremos sacar y la pila, y un **main** para probar los métodos. Ninguno de estos es necesario para el funcionamiento normal de la Pila. Son métodos extra.
```java
    public void multiPop(int num, PilaADT<T> pila){
        
        while(!pila.isEmpty() && num !=0){
            pila.pop();
            num--;
        }
    }
    
    public static void main ( String [] args ){
    }
```
#### Ejemplo visual

De esta manera se vería una pila en uso.

<img src="https://image.slidesharecdn.com/estructuradedatospilasycolas-121106174209-phpapp02/95/estructura-de-datos-pilas-y-colas-7-638.jpg?cb=1352223860" alt="Ejemplo" width="320"/>

## Clase final
Esta será la clase que llamaremos para utilizar los elementos de la Pila, por eso es una interface. En ella solo debemos poner los nombres de los métodos incluyendo lo que piden y lo que devuelven y la interface implementará los de la clase PilaArreglo.
```java
    public interface PilaADT <T> {

        public void push(T dato);
        public T pop();
        public T peek();
        public boolean isEmpty();
        public int getTope();

    }
```

## Conclusión
Con implementar este código es suficiente para tener una clase funcional que represente a la estructura de datos de pila o stock y utilizarla en cualquier otro programa en Java.


