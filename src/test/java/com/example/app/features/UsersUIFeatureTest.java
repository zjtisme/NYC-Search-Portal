package com.example.app.features;

import com.example.app.models.User;
import com.example.app.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UsersUIFeatureTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void shouldAllowFullCrudFunctionalityForAUser() throws Exception {

        User firstUser = new User(
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
        Long firstUserId = firstUser.getId();
        String firstUserUserName = firstUser.getUserName();

        User secondUser = new User(
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
        Long secondUserId = secondUser.getId();

        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");

        open("http://localhost:3000");

        $("#login-button").click();

        $("#login-page").should(appear);

        $("#login-username").sendKeys("zjtisking");
        $("#login-password").sendKeys("123456");
        $("#login-confirm-button").click();
    }

    @Test
    public void shouldAllowUserSearchByKeyword() throws Exception {
        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");

        open("http://localhost:3000");

        $("#search-bar").should(appear);
        $("#search-confirm-button").should(appear);
        $("#search-bar").sendKeys("student");
        $("#search-confirm-button").click();

        $$("[data-news-display]").shouldHave(size(50));
    }
}
