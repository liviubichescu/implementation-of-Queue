public class Nod<E> {

    private E value;
    private Nod<E> urmator;

    public Nod(E value) {
        this.value = value;
        this.urmator = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Nod<E> getUrmator() {
        return urmator;
    }

    public void setUrmator(Nod<E> urmator) {
        this.urmator = urmator;
    }

    @Override
    public String toString() {
        return " "+value.toString();
    }
}
