import dao.PersonDao;
import exception.DaoException;
import model.Person;

import java.util.List;

public class PersonPersistanceStrategy {
    private PersonDao personDao;

    public PersonPersistanceStrategy(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> readPersons() throws DaoException {
        return personDao.readAll();
    }

    public void writePersons(List<Person> personList) throws DaoException{
        personDao.writeAll(personList);
    }
}
