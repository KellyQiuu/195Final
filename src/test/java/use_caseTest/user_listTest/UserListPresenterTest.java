//package use_caseTest.user_listTest;
//
//import entity.User;
//import interface_adapter.ViewManagerModel;
//import interface_adapter.other_profile.OtherProfileViewModel;
//import interface_adapter.user_list.UserListPresenter;
//import interface_adapter.user_list.UserListState;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import use_case.user_list.UserListOutputData;
//import view.UserListViewModel;
//
//import java.util.ArrayList;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//class UserListPresenterTest {
//
//    @Mock
//    private ViewManagerModel mockViewManagerModel;
//    @Mock
//    private OtherProfileViewModel mockProfileViewModel;
//    @Mock
//    private UserListViewModel mockUserListViewModel;
//
//    private UserListPresenter userListPresenter;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        userListPresenter = new UserListPresenter(mockViewManagerModel, mockProfileViewModel, mockUserListViewModel);
//    }
//
//
//
//    @Test
//    void prepareSuccessViewUpdatesViewModel() {
//        // Mock the dependencies of UserListPresenter
//        ViewManagerModel mockViewManagerModel = mock(ViewManagerModel.class);
//        OtherProfileViewModel mockProfileViewModel = mock(OtherProfileViewModel.class);
//        UserListViewModel mockUserListViewModel = mock(UserListViewModel.class);
//
//        // Create a UserListPresenter instance with mocked dependencies
//        UserListPresenter presenter = new UserListPresenter(mockViewManagerModel, mockProfileViewModel, mockUserListViewModel);
//        ArrayList<String> courses = new ArrayList<>();
//
//        courses.add("CSC207");
//        courses.add("CSC07");
//        courses.add("CSC7");
//        courses.add("CSC27");
//        courses.add("CS7");
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User("Kelly", "1", "12", "123", courses));
//
//    }
//}
