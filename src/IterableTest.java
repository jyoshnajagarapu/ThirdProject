import java.util.Iterator;

// Custom Linked Lista class using Generics
class Lista<T> implements Iterable<T> {
    Node<T> head, tail;

    // add new Element at tail of the linked lista in O(1)
    public void add(T data)
    {
        Node<T> node = new Node<>(data, null);
        if (head == null)
            tail = head = node;
        else {
            tail.setNext(node);
            tail = node;
        }
    }

    // return Head
    public Node<T> getHead()
    {
        return head;
    }

    // return Tail
    public Node<T> getTail()
    {
        return tail;
    }

    // return Iterator instance
    public Iterator<T> iterator()
    {
        return new ListaIterator<T>(this);
    }
}

class ListaIterator<T> implements Iterator<T> {
    Node<T> current;

    // initialize pointer to head of the lista for iteration
    public ListaIterator(Lista<T> lista)
    {
        current = lista.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public T next()
    {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

// Constituent Node of Linked Lista
class Node<T> {
    T data;
    Node<T> next;
    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }

    // Setter getter methods for Data and Next Pointer
    public void setData(T data)
    {
        this.data = data;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public T getData()
    {
        return data;
    }

    public Node<T> getNext()
    {
        return next;
    }
}

// Driver class
class Mainerr{
    public static void main(String[] args)
    {
        // Create Linked Lista
        Lista<String> myLista = new Lista<>();

        // Add Elements
        myLista.add("abc");
        myLista.add("mno");
        myLista.add("pqr");
        myLista.add("xyz");

        // Iterate through the lista using For Each Loop
        for (String string : myLista)
            System.out.println(string);
    }
}
