package info.keyal.dao.impl;

import info.keyal.dao.TradeDAO;
import info.keyal.dto.Person;

import java.util.logging.Logger;

/**
 * Created by skeyal on 10/2/16.
 */
public class TradeDAOImpl implements TradeDAO {

    private Logger LOG = Logger.getLogger("TradeDAOImpl");
    @Override
    public void save(Person person) {

        LOG.info("SAVING person in dao");
        Person person1 = new Person();

    }
}
