package by.goodreads;

public class Holder<T> {
    private T value;
    public Holder(T value){
        this.value = value;
    }
    public Holder(){}
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
}
