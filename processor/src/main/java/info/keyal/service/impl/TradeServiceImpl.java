package info.keyal.service.impl;

import info.keyal.service.TradeService;

import java.util.logging.Logger;

/**
 * Trade Service Implementation
 */
public class TradeServiceImpl implements TradeService {
    private Logger LOG = Logger.getLogger("TradeServiceImpl");

    @Override
    public void send(String trade) {
        LOG.info("Inside Send");
    }
}
