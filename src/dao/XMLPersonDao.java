package dao;

import exception.DaoException;
import model.Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class XMLPersonDao implements PersonDao{

    static final String FILE_NAME = "persons.xml";
    @Override
    public List<Person> readAll() throws DaoException {
        //XMLDecoder
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(FILE_NAME))){
            List<Person> personList = (List<Person>) xmlDecoder.readObject();
            return personList;
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public void writeAll(List<Person> persons) throws DaoException {
        if(isInvalidArgument(persons)){
            return;
        }
        //XMLEncoder
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(FILE_NAME))){
            xmlEncoder.writeObject(persons);
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }
}
