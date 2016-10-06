package info.keyal.service.impl;

import info.keyal.dao.TradeDAO;
import info.keyal.dto.Person;
import info.keyal.service.TradeService;

import java.util.logging.Logger;

/**
 * Trade Service Implementation
 */
public class TradeServiceImpl implements TradeService {
    private Logger LOG = Logger.getLogger("TradeServiceImpl");

    private TradeDAO tradeDAO;

    @Override
    public void send(String trade) {
        LOG.info("Inside Send");
        tradeDAO.save(new Person());
    }

    public TradeDAO getTradeDAO() {
        return tradeDAO;
    }

    public void setTradeDAO(TradeDAO tradeDAO) {
        this.tradeDAO = tradeDAO;
    }
}
