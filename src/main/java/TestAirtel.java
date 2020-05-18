import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestAirtel {

  public static void main(String[] args) {
    List<Transaction> list=new ArrayList<>();
    Comparator<Transaction> transactionComparator= Comparator.comparingInt(Transaction::getAmount);

    Collections.sort(list,transactionComparator);   // o(nlogn)

  }

  class Transaction{

    int serialNo;

    int amount;

    public int getSerialNo() {
      return serialNo;
    }

    public void setSerialNo(int serialNo) {
      this.serialNo = serialNo;
    }

    public int getAmount() {
      return amount;
    }

    public void setAmount(int amount) {
      this.amount = amount;
    }
  }

}
