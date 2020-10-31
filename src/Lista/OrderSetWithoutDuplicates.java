package Lista;

import java.util.*;

public class OrderSetWithoutDuplicates<E> extends OrderSet<E>
{

    public OrderSetWithoutDuplicates(final E[] e)
    {
        this(Arrays.asList(e));
    }

    public OrderSetWithoutDuplicates(final List<E> l)
    {
        this();
        this.addAll(l);
    }

    public OrderSetWithoutDuplicates(final Collection<? extends E> c)
    {
        this();
        this.addAll(c);
    }

    public OrderSetWithoutDuplicates(Comparator<E> comparator){
       super(comparator);
    }


 public OrderSetWithoutDuplicates()
    {
        super();
    }

    @Override
    public boolean add(final E e)
    {
        System.out.println("HOLA");
        if(!this.contains(e)){
            IndexedEntry<E> element = new IndexedEntry<>(this.bs.size(), e);
            return this.bs.add(element);

        }
        else
            return false;
    }

    
}