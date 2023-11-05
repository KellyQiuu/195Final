package interface_adapter.user_list;

public class UserViewModel {
    private final String name;

    public UserViewModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
