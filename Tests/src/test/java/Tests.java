import org.junit.jupiter.api.*;

public class Tests {
    @Tag("before")
    @Test
    @BeforeAll
    static void before_all(){
        System.out.println("@BeforeAll");
    }
    //@Disabled
    @Test
    @Tag("before")
    @BeforeEach
    void before_each(){
        System.out.println("@BeforeEach");
    }
    @Tag("after")
    @DisplayName("Test after_each")
    @Test
    @AfterEach
    void after_each(){
        System.out.println("@AfterEach");
    }
    @Tag("after")
    @Test
    @AfterAll
    static void after_all(){
        System.out.println("@AfterAll");
    }
}