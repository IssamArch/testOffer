package com.testOffer;


import com.testOffer.models.User;
import com.testOffer.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {


    @Autowired
    UserRepository repository;


    User alex, bernard;

    @Before
    public void setUp() {

        repository.deleteAll();

        alex = repository.save(new User("alex06","alex34","deschamps","alex",19,"France"));
        bernard = repository.save(new User("bernard13","bernard54","gaull","bernard",12,"France"));

    }

    @Test
    public void setsIdOnSave() {
        assertThat(alex.getId()).isNotNull();
    }

    @Test
    public void findsByLogin() {

        User result = repository.findByLogin("alex06");
        assertThat(result.getLogin().equals(alex.getLogin()));


    }





}
