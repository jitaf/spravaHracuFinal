package org.example.spravahracu;

import java.time.LocalDate;

public class Hrac {
    private String login;
    private int level;
    private String role;
    private String email;
    private LocalDate registrace;

    public Hrac(String login, int level, String role, String email, LocalDate registrace) {
        this.login = login;
        this.level = level;
        this.role = role;
        this.email = email;
        this.registrace = registrace;
    }

    public boolean jeProfik() {
        return level >= 50;
    }

    public boolean jePokrocily() {
        return level >= 20 && level < 50;
    }

    public boolean jeZacatecnik() {
        return level < 20;
    }

    public boolean hrajeViceNezRok() {
        return registrace.isBefore(LocalDate.now().minusYears(1));
    }

    @Override
    public String toString() {
        if (hrajeViceNezRok()){
            return "*" + login;
        } else {
            return login;
        }
    }

    // Gettery a settery
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrace() {
        return registrace;
    }

    public void setRegistrace(LocalDate registrace) {
        this.registrace = registrace;
    }
}

