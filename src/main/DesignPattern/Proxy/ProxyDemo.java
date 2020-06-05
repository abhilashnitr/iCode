package main.DesignPattern.Proxy;

public class ProxyDemo {

  public static void main(String[] args) {

    boolean isUserLoggedIn= true;
    User user=new UserProxyHandler(isUserLoggedIn).getUser();
    user.checkOut();
  }
}

interface UserProxy {
  User getUser();
}

class UserProxyHandler implements UserProxy{
  private boolean isLoggedIn;

  public UserProxyHandler(boolean isLoggedIn) {
    this.isLoggedIn = isLoggedIn;
  }

  @Override
  public User getUser() {
    User user;
    if (isLoggedIn) {
      user = new AuthorizedUser();
    } else {
      user = new GuestUser();
    }
    return user;
  }
}

interface User {
  void checkOut();
}

class AuthorizedUser implements User {
  @Override
  public void checkOut() {
    System.out.print("checking out...");
  }
}

class GuestUser implements User {
  @Override
  public void checkOut() {
    System.out.print("Showing Registration Page");
  }
}
