package dao;

import exception.DaoException;

import java.util.List;

public interface Dao<E> {
    /**
     * Ova metoda treba da pročita podatke vezane za neke elemente
     * koji su prethodno trajno snimljeni i da nam vrati učitane objekte.
     *
     * @return list of elements
     * @throws DaoException
     */
    public List<E> readAll() throws DaoException;

    /**
     * Ova metoda treba da snimi listu elemenata
     * koje je dobila kao parametar
     *
     * @param elements
     * @throws DaoException
     */
    public void writeAll(List<E> elements) throws DaoException;
}