package com.example.app.features;

import com.example.app.models.User;
import com.example.app.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UsersUIFeatureTest {

    private User firstUser;
    private User secondUser;
    private Long firstUserId;
    private Long secondUserId;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
        firstUser = new User(
                "zjtisking",
                "123456",
                "Jintai",
                "Zhang",
                "Male",
                "jintaizhang2017@gmail.com",
                "224-714-8589",
                "1992-08-27"
        );
        firstUser = userRepository.save(firstUser);
        firstUserId = firstUser.getId();

        secondUser = new User(
                "tiantian",
                "654321",
                "Tian",
                "Li",
                "Female",
                "tiantian2017@gmail.com",
                "222-111-4444",
                "1994-10-09"
        );
        secondUser = userRepository.save(secondUser);
        secondUserId = secondUser.getId();
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }


    @Test
    public void shouldAllowUserSearchByKeyword() throws Exception {
        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");
        System.setProperty("selenide.timeout", "10000");

        open("http://localhost:3000");

        $("#search-bar").should(appear);
        $("#search-confirm-button").should(appear);
        $("#search-bar").sendKeys("student");
        $("#search-confirm-button").click();

        $$("[data-news-display]").shouldHave(size(50));
        $("#news-list").shouldHave(text("student"));
    }

    @Test
    public void shouldAllowFullCrudFunctionalityForAUser() throws Exception {
        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");
        System.setProperty("selenide.timeout", "10000");

        open("http://localhost:3000");

        // Check create user functionality
        $("#signup-button").click();
        $("#signup-page").should(appear);

        $("#signup-username").sendKeys("new user");
        $("#signup-password1").sendKeys("1234");
        $("#signup-password2").sendKeys("1234");
        $("#signup-firstname").sendKeys("New");
        $("#signup-lastname").sendKeys("User");
        $("#signup-gender").sendKeys("female");
        $("#signup-email").sendKeys("newuser@gmail.com");
        $("#signup-phonenumber").sendKeys("1112223333");
        $("#signup-birthday").sendKeys("2000-01-01");

        $("#signup-confirm-button").click();

        // Check show user profile functionality
        $("#configure-button").should(appear);
        $("#logout-button").should(appear);
        $("#delete-button").should(appear);

        $("#configure-button").click();
        $("#configure-page").should(appear);

        $("#configure-username").shouldHave(value("new user"));
        $("#configure-password1").shouldHave(value("1234"));
        $("#configure-password2").shouldHave(value("1234"));
        $("#configure-firstname").shouldHave(value("New"));
        $("#configure-lastname").shouldHave(value("User"));
        $("#configure-gender").shouldHave(value("female"));
        $("#configure-email").shouldHave(value("newuser@gmail.com"));
        $("#configure-phonenumber").shouldHave(value("1112223333"));
        $("#configure-birthday").shouldHave(value("2000-01-01"));

        // Check update user profile functionality
        $("#configure-username").clear();
        $("#configure-username").sendKeys("updated user");
        $("#configure-confirm-button").click();


        $("#private-welcome-text").shouldHave(text("Welcome updated user!"));

        $("#logout-button").click();

        // Check user log in functionality

        $("#public-welcome-text").should(appear);

        $("#login-button").click();
        $("#login-page").should(appear);

        $("#login-username").sendKeys("updated user");
        $("#login-password").sendKeys("1234");

        $("#login-confirm-button").click();

        // Check user delete account functionality

        $("#delete-button").should(appear);

        $("#delete-button").click();
        getWebDriver().switchTo().alert().accept();


        $("#public-welcome-text").should(appear);

        // Check if delete user successful or not
        $("#login-button").click();
        $("#login-username").sendKeys("updated user");
        $("#login-password").sendKeys("1234");
        $("#login-confirm-button").click();

        $("#login-error").shouldHave(text("Cannot find such user, please sign up first!"));

        
    }
}
