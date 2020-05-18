package OppsConcepts;

public class DelegatePattern {

  public static void main (String[] args) {
    IPaymentGateway x=new CreditCardPayment();
    x.init();
  }
}

interface IPaymentGateway {
  void init();

  static class Implementation implements IPaymentGateway{
    Implementation(){
      System.out.println("Constructor of Implementation");
    }

    public void init() {
      System.out.println("Implementation of Init in static class");
    }
  }
}

class CreditCardPayment implements IPaymentGateway{

  private IPaymentGateway delegate =
      new IPaymentGateway.Implementation();

  @Override
  public void init() {
    delegate.init();
    System.out.println("Inside CreditCard");
  }
}

class DebitCardPayment implements IPaymentGateway{

  private IPaymentGateway delegate =
      new IPaymentGateway.Implementation();

  @Override
  public void init() {
    delegate.init();
    System.out.println("Inside DebitCard");
  }
}