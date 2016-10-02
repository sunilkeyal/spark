package info.keyal.dto;

import javax.persistence.*;

public class Trade {

    @Column(name = "TradeId")
    private Integer tradeId;

    @Column(name = "Desctiption")
    private String description;
}
