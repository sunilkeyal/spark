package info.keyal.service;

/**
 * Trade Service
 */
public interface TradeService {

    /**
     * This method receives a trade and persists in database
     *
     * @param trade A String representation of a trade
     */
    void send(String trade);
}
