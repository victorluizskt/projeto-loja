package br.com.lojinha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/*
 * @brief Classe User
 * @author Victor Luiz Gonçalves
 * @date 24/11/2020
 * @since 24/11/2020
 *
 * Classe usuário.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;

    public User(int id, String name, String username, String password, String email)  {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = cryptography(password);
        this.email = email;
    }

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = cryptography(password);
        this.email = email;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = cryptography(password);
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = cryptography(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password);
    }

    /**
     *
     * Method responsible for encrypting the user's password.
     * @param password Password passed for encryption.
     */
    protected String cryptography(String password) {
        try {
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password must be longer than 8 characters.");
            } else {
                MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
                byte[] messageDigest = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));
                StringBuilder hexString = new StringBuilder();
                for (byte b : messageDigest) {
                    hexString.append(String.format("%02X", 0xFF & b));
                }
                return hexString.toString();
            }
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        return null;
    }

}