# Pila

Cómo crear un clase Pila (en inglés, Stock) con la funcionalidad mínima requerida para su uso. Existen librerias en Java que incluyen una clase predeterminada para la estructura Pila, pero esta también se puede crear sin necesidad de utilizar una librería. Aquí se encuentran los métodos y clases necesario para construir la Pila.

## Tabla de contenidos
* [Instalaciones y tecnología](#instalaciones-y-tecnología)
* [Clase Base](#clase-base)
* [Métodos](#métodos)
* [Clase final](#clase-final)
* [Utilizar la Pila](#conclusión)


## Instalaciones y tecnología

Para trabajar con Java es necesario un IDE que permita usar el lenguaje. NetBeans 8.2 es una de las opciones y se puede [descargar gratuitamente.](https://www.oracle.com/technetwork/es...) Para instalarlo correctamente se puede ver un [tutorial en Youtube.](https://www.youtube.com/watch?v=WtKS7J7kVl8)


## Clase Base

PilaArreglo será la clase pública que tendrá todos los métodos que le darán la funcionalidad a la pila.
Declaramos a nuestras clase con el tipo < T > para que acepte cualquier objeto como int, String, float, etc.
Implementamos a PilaADT para indicar que nuestra clase será la que tendrá los métodos, pero PilaADT será la que los implementará.
```java
public class PilaArreglo <T> implements PilaADT<T>{
    private T[] pila;
    private int tope;
    private static final int MAX=3;
```
Después vienen los atributos de la clase, todos privados para que solo se pueda acceder a ellos desde la clase:
1. **T[] pila** es un arreglo de objetos que funcionará como el cuerpo de nuestra pila almacenando y eliminando en sus espacios.
2. **int tope** será un entero que nos indicará siempre en que espacio del arreglo está el tope. El tope es el último elemento que se agregó a la pila. Ver siguiente imagen.
3. **static final int MAX=x** es un entero que nunca cambiará que nos servirá para el constructor vacío.
<img src="http://1.bp.blogspot.com/-QTDcpd1_kyc/Uo1kL7cgH0I/AAAAAAAAAIc/Sh46LQr7Nas/s1600/pi.png" alt="Tope" width="200"/>

#### Constructores
1. Constructor vacío. Utiliza el valor que le dimos al entero MAX para inicializar el arreglo. 
Al entero tope se le asigna un menos uno como bandera de error que indica que la pila está vacía.
```java
public PilaArreglo(){
        pila= (T[]) new Object[MAX];
        tope=-1;
    }
```
2. Segundo constructor. Hace lo mismo con tope, pero recibe un entero que será el valor con el que se incializará el tamaño del arreglo.
```java
public PilaArreglo(int max){
        pila= (T[]) new Object[max];
        tope=-1;
    }
```

## Métodos
1. **isEmpty**: indica si está vacía la pila regresando TRUE si tope es negativo y FALSE si es no negativo
```java
    public boolean isEmpty(){
        return tope <= -1;
    }
```  
2. **push**: inserta un elemento a la pila. Este método aumenta en uno el tope para que coincida con el nuevo tope y si no hay espacio para un elemento más en el arreglo llama al método auxiliar **expande** que duplicará el tamaño del arreglo para tener el espacio suficiente.
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
3. **peek y pop**: permiten ver el elemento en el tope y sacarlo/eliminarlo respectivamente. Ambos mandan un error si está vacía la pila. 
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
4. **getTope**: regresa el lugar del arreglo en el que se encuentra el tope.
```java
    public int getTope(){
        return this.tope;
    }
```
5. **multipop**: permite sacar muchos elementos a la vez si la pila tiene esa cantidad. **main**: para probar los métodos. Ninguno de estos es necesario para el funcionamiento normal de la Pila.
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
Esta será la clase que llamaremos para utilizar los elementos de la Pila. Por esta razón es una interface. En ella solo debemos poner los nombres de los métodos con sus parámetros y la interface implementará los de la clase PilaArreglo.
```java
    public interface PilaADT <T> {

        public void push(T dato);
        public T pop();
        public T peek();
        public boolean isEmpty();
        public int getTope();

    }
```

## Utilizar la Pila
Con implementar este código es suficiente para tener una clase funcional que represente la Pila. Para poder utilizarla solo se debe de importar la clase al inicio del código y crear un objeto Pila. Este objeto ya incluirá toda la funcional descrita.


