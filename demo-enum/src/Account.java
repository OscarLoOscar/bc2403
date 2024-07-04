public class Account {

  // ...
  private Transaction[] transactions;

  public Account() {
    this.transactions = new Transaction[0];
  }

  public void add(Transaction transaction) {
    Transaction[] copyArr = this.transactions;
    this.transactions = new Transaction[copyArr.length + 1];
    int idx = 0;
    for (Transaction t : copyArr) {
      this.transactions[idx++] = t;
    }
    this.transactions[idx] = transaction;
  }

  public double balance() {
    return -1.0d;
  }

  public void credit(Currency currency, double amount) {

  }

  // boolean
  public void debit(Currency currency, double amount) {

  }

  public static void main(String[] args) {
    Account account = new Account();
    account.add(new Transaction(Sign.CREDIT, Currency.HKD, 2500));
    account.add(new Transaction(Sign.DEBIT, Currency.HKD, 1300));
    System.out.println(account.balance()); // 1200

    account.credit(Currency.HKD, 1000);
    account.debit(Currency.HKD, 500);
  }

}
