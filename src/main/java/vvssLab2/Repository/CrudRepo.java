package vvssLab2.Repository;

public interface CrudRepo <E,ID> {
    public E save(E elem);
    public E update(E elem);
    public E delete(ID id);
    public E findOne(ID id);
    public Iterable<E> findAll();
    public int size();

}
