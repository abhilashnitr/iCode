package SystemDesigns.VendingMachine;

public class VendingMachineFactory {
  public static VendingMachine createVendingMachine() {
    return new VendingMachineImpl();
  }
}


