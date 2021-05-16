package dao;

import exception.DaoException;
import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class FilePersonDao implements PersonDao {
    static final String FILE_NAME = "persons.txt";

    @Override
    public List<Person> readAll() throws DaoException {
        List<Person> personList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line = null;
            while((line = br.readLine())!=null){
                //nin;name;surname;age

                /*String[] personsField = line.split(";");
                String nin = personsField[0];
                String name = personsField[1];
                String surname = personsField[2];
                Integer age = Integer.parseInt(personsField[3]);
                Person person = new Person(nin, name, surname, age);
                personList.add(person);*/

                StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
                String nin = stringTokenizer.nextToken();
                String name = stringTokenizer.nextToken();
                String surname = stringTokenizer.nextToken();
                Integer age = Integer.parseInt(stringTokenizer.nextToken());
                Person person = new Person(nin, name, surname, age);
                personList.add(person);
            }
            return personList;
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public void writeAll(List<Person> persons) throws DaoException {
        //if (persons==null||persons.isEmpty())
        if (isInvalidArgument(persons)) {
            return;
        }
        //PrintWriter FileWriter
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FILE_NAME))) {
            //filewriter ce napraviti dokument sa sadrzajem:
            //nin;name;surname;age
            //nin;name;surname;age...
            for (Person person : persons) {
                String line = new StringJoiner(";")
                        .add(person.getNationalIdentificationNumber())
                        .add(person.getName())
                        .add(person.getSurname())
                        .add(person.getAge() + "")
                        .toString();
                printWriter.println(line);

            }
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
