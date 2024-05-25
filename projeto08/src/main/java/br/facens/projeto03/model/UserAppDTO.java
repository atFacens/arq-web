package br.facens.projeto03.model;

public class UserAppDTO {
    private long id;
    private String name;
    private String email;

    public UserAppDTO(UserApp userApp) {
        this.id = userApp.getId();
        this.name = userApp.getName();
        this.email = userApp.getEmail();
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

}
