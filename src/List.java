import javax.lang.model.element.Element;
import java.util.Iterator;


public class List <E extends Comparable > implements  Iterable<E>{


    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>{
        private ListElement<E> temp;

        public ListIterator(){
            temp = head;
        }

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public E next() {
            E temp2 = temp.element;
            temp = temp.next;
            return temp2;
        }
    }


    private static class ListElement<E>{
        private E element;
        private ListElement<E> next;

        public ListElement(E element, ListElement<E> next){
            this.element = element;
            this.next = next;
        }
    }

    private ListElement<E> head;
    private ListElement<E> next;

    public void enqueue(E element) {
        if(element == null) {
            return;
        }
        if(head == null){
            head = new ListElement<E>(element,null);
        }else{
            ListElement<E> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListElement<E>(element, null);
        }
    }
    public void enqueue2(E element) {
        if(element == null) {
            return;
        }
        if(head == null){
            head = new ListElement<E>(element,null);
        }else{
            ListElement<E> temp = head;
            if((element.compareTo(head.element)) < 0) {
                head = new ListElement<E>(element, head);
                return;
            }
            while(temp.next != null && (element.compareTo(temp.next.element) > 0)){
                temp = temp.next;
            }
            if(temp.next == null) {
                temp.next = new ListElement<E>(element, null);
                return;
            }else{
                temp.next = new ListElement<E>(element, temp.next);
                return;
            }
        }
    }


    public E dequeue(){
        ListElement<E> temp = head;
        head = head.next;
        return temp.element;
    }

    public boolean isEmpty(){
        return(head == null);
    }

    public E getFirst(){
        return head.element;
    }
}
