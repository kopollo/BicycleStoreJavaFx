package models;

public class Admin {
    private int id;
    private String email;
    private String password;

    public Admin(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public boolean isAdmin() {
        if (password.equals("admin")) {
            return true;
        }
        return false;
    }


    public Admin(String email, String password) {
        this(0, email, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
