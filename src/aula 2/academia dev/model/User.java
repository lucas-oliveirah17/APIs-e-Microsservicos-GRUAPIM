package br.com.academiadev.model;

/**
 * Classe abstrata base para todos os usuários.
 * Encapsulamento: atributos protegidos acessados via getters.
 */
public abstract class User {

    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return name + " <" + email + ">";
    }
}
