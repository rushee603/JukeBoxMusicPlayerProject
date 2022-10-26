package juke.box;

import DAOimplclass.userimpl;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class userimplTest {
    userimpl user = null;

    @BeforeEach
    public void setUp() throws SQLException {
        user = new userimpl();
    }

    @AfterEach
    public void tearDown() {
        user = null;
    }

//    @Test
//    public  void loginTest() throws SQLException {
//      assertEquals(true,user.login("rushi@123",123));
//
//
//    }

    @Test
    public void loginTest() throws SQLException {
        assertEquals(true,user.login(123,"rushi@123"));
    }


    @Test
    public void loginTest2() throws SQLException {
       assertEquals(false,user.login(000,"abcd123"));
    }
}


