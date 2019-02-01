import java.util.Vector;

/**
 * Es la clase implementadora de la interfaz Staqck
 * @param <E>
 */
public class Pila<E> implements Stack<E> {
    //titi es el nombre del Vector
    public Vector titi = new Vector();

    /**
     * Este es el metodo que agrega un elemento
     * @param item
     */
    @Override
    public void push(E item){
        titi.add(item);
    }

    /**
     * Este metodo hace que el ultimo valor que se agrego (push) se elimine y retorne del vector
     * @return el ultimo elemento que se agrego (push)
     */
    @Override
    public E pop() {
        //Se creo una variable de tipo E para mostrar el ultimo elemento del vector
        E ultimoElemento = (E) titi.lastElement();
        titi.remove(titi.size()-1);
        return ultimoElemento;
    }

    /**
     * Este metodo retorna el ultimo elemento del vector
     * @return ultimo elemento
     */
    @Override
    public E peek() {
        return (E) titi.lastElement();
    }

    /**
     * Este metodo dice si el vector esta vacio
     * @return si esta vacio
     */
    @Override
    public boolean empty() {
        return titi.isEmpty();
    }

    /**
     * Este metodo dice el numero de elementos de Titi que es el vector
     * @return el numero de elementos
     */
    @Override
    public int size() {
        return titi.size();
    }
}