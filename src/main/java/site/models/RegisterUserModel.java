package site.models;

import site.enums.Faction;
import site.validators.IsPasswordsMatching;

public class RegisterUserModel {
    private String name;
    private String password;
    private String repeatPassword;
    private Faction faction;

    public RegisterUserModel() {
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
