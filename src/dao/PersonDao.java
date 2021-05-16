package dao;

import dao.Dao;
import model.Person;

import java.util.List;

/**
 * Marker interface
 */
public interface PersonDao extends Dao<Person> {

    default boolean isValidArgument(List<Person> personList){
        return personList!=null && !personList.isEmpty();
    }

    default boolean isInvalidArgument(List<Person> personList){
        return !isValidArgument(personList);
    }
}
