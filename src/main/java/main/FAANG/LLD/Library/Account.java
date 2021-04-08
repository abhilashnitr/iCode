package main.FAANG.LLD.Library;

public abstract class Account {
    private String id;
    private String password;
    private consts.AccountStatus status;
    private consts.Person person;

    public boolean resetPassword() {
        return false;
    }

    public String getId()
    {
        return this.id;
    }

}
