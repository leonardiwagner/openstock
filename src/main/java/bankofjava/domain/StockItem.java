package bankofjava.domain;

import java.util.Date;

public class StockItem {
    private String stockName;
    private Date date;
    private float value;

    public StockItem(String stockName, Date date, float value){
        this.stockName = stockName;
        this.date = date;
        this.value = value;
    }
}