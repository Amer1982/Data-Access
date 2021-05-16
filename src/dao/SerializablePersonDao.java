package dao;

import exception.DaoException;
import model.Person;

import java.io.*;
import java.util.List;

//personList -> .dat
//ObjectOutputStream i FileOutputStream
//ObjectInputStream i FileInputStream
public class SerializablePersonDao implements PersonDao {

    static final String FILE_NAME = "persons.dat";

    @Override
    public List<Person> readAll() throws DaoException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Person> personList = (List<Person>) ois.readObject();
            return personList;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }


    @Override
    public void writeAll(List<Person> persons) throws DaoException {
        if (isInvalidArgument(persons)) {
            return;
        }
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            ous.writeObject(persons);
        } catch (IOException exception) {
            throw new DaoException(exception.getMessage());
        }
    }
}