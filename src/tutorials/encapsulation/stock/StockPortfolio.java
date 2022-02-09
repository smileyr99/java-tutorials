package tutorials.encapsulation.stock;

public class StockPortfolio {
    public static void main(String[] args) {
        Stock stocks[] = new Stock[5];
        stocks[0] = new Stock("035", "카카오");
        stocks[1] = new Stock("005", "삼전");
        stocks[2] = new Stock("003", "현대차");
        stocks[3] = new Stock("004", "sk하이닉스");
        stocks[4] = new Stock("002", "삼생");

        stocks[0].setPreviousClosingPrice(70000);
        stocks[0].setCurrentPrice(71000);
        stocks[1].setPreviousClosingPrice(48000);
        stocks[1].setCurrentPrice(50000);
        stocks[2].setPreviousClosingPrice(169000);
        stocks[2].setCurrentPrice(167000);
        stocks[3].setPreviousClosingPrice(58000);
        stocks[3].setCurrentPrice(64000);
        stocks[4].setPreviousClosingPrice(62000);
        stocks[4].setCurrentPrice(65000);


        for(Stock stock : stocks){
            System.out.println(stock.changePercent());
        }

    }
}
