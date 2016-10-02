package info.keyal.service;

import info.keyal.dto.Person;

import java.util.List;

/**
 * an example data access service, just show it works
 */
public interface PersonService {

    /**
     * persiste a new Person entity object
     * @param p
     * @return persistet object
     */
    public Person createPerson(Person p);

    /**
     * return a Person entity object by id
     * @param id
     * @return
     */
    public Person getPerson(Integer id);

    /**
     * return all person records (detached, no blob access)
     * @return
     */
    public List<Person> getPersonRecords();

    public void deletePerson(Integer id);
}