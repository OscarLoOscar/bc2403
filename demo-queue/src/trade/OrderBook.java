package trade;

import java.util.Map;

public class OrderBook {

// 股價(港幣/股)	最小變動價位(港幣)
// 0.01至0.25	0.001
// 0.25至0.50	0.005
// 0.50至10.00 0.01
// 10.00至20.00	0.02
// 20.00至100.00 0.05
// 100.00至200.00	0.1
// 200.00至500.00	0.2
// 500.00至1,000.00  	0.5
// 1,000.00至2,000.00	1
// 2,000.00至5,000.00  2
// 5,000.00至9,995.00  5
  
  private int marketIndex; // 2 -> Buy_1 $1.05 Sell_1 $1.10
  
  private Map<Double, Integer> entries; // $1 - $2, no ordering
  // Map advantage: hash -> search by key ($1.5 -> 4000)

  // assumption $1 - $2, $0.05
  // Buy, your price < market price (Easy)
  // Buy, your price >= market price
  // Sell, your price > market price (Easy)
  // Sell, your price <= market price
  // getOrderBook, Map -> List

  // Buy
  // $10 2q (1) -> trade (Vincent/ Oscar 1q at $10)
  // $2 998q

  // Sell
  // $11 1q (1)
  // $13 100q (1)

  // Market Price -> the price of the last trade in the market
}
