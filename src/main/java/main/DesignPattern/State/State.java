package main.DesignPattern.State;

public class State {

  public static void main(String[] args) {
    VpnManager vpnManager = new VpnManager();

    VpnState connectState = new VpnConnectState();
    VpnState disconnectState = new VpnDisconnectState();

    vpnManager.setState(connectState);
    vpnManager.perform();

    vpnManager.setState(disconnectState);
    vpnManager.perform();
  }

}
class VpnManager {

  private VpnState state;

  void setState(VpnState state) {
    this.state = state;
  }

  void perform() {
    state.perform();
  }
}

interface VpnState {
  void perform();
}

class VpnConnectState implements VpnState {

  @Override
  public void perform() {
    // Connect the VPN here.
    System.out.println("Connect the VPN here.");
  }
}

class VpnDisconnectState implements VpnState {

  @Override
  public void perform() {
    // Disconnect the vpn.
    System.out.println("DisConnect the VPN here.");
  }
}
