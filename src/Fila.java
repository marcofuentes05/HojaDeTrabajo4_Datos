import java.util.Vector;

public class Fila<E> implements Stack<E> {
    public Vector titi = new Vector();

    @Override
    public void push(E item){
        titi.add(item);
    }

    @Override
    public E pop() {
        E ultimoElemento = (E) titi.lastElement();
        titi.remove(titi.size()-1);
        return ultimoElemento;
    }

    @Override
    public E peek() {
        return (E) titi.lastElement();
    }

    @Override
    public boolean empty() {
        return titi.isEmpty();
    }

    @Override
    public int size() {
        return titi.size();
    }
}