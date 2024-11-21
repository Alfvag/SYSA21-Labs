package code.javalampa.models;

public class AppModel {
    private PersonRegister personRegister;

    public AppModel() {
        this.personRegister = new PersonRegister();
    }

    public PersonRegister getPersonRegister() {
        return this.personRegister;
    }
}
