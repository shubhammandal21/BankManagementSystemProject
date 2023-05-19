package com.org.bankmgmtSystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    UserControllerTest.LoginUserTest.class,
    UserControllerTest.EditUserDetailsTest.class,
    UserControllerTest.SaveUserTest.class,
    UserControllerTest.UserEntityTest.class,
    UserControllerTest.UserToStringTest.class,
    UserControllerTest.LoanEntityTest.class,
    UserControllerTest.ApplyLoanTest.class,
    UserControllerTest.UserDtoConstructorTest.class,
    UserControllerTest.LoginDtoConstructorTest.class,
    UserControllerTest.LoanDtoConstructorTest.class,
    UserControllerTest.LoginResponseToStringTest.class
})
public class UserControllerTestSuite {

}
