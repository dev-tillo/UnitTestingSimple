package uz.devtillo.unittesting.utils

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    // 1
    @Test
    fun emailValidator1() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    // 2
    @Test
    fun emailValidator2() {
        assertTrue(EmailValidator.isValidEmail("name@pdp.uz"))
    }

    // Also Wrong

//    // 3
//    @Test
//    fun emailValidator3() {
//        assertTrue(EmailValidator.isValidEmail("name@email"))
//    }
//
//    // 4
//    @Test
//    fun emailValidator4() {
//        assertTrue(EmailValidator.isValidEmail("name@email..uz"))
//    }
//    // 5
//    @Test
//    fun emailValidator5() {
//        assertTrue(EmailValidator.isValidEmail("@email.com"))
//    }
//    // 6
//    @Test
//    fun emailValidator6() {
//        assertTrue(EmailValidator.isValidEmail(""))
//    }
//
//    // 7
//    @Test
//    fun emailValidator7() {
//        assertTrue(EmailValidator.isValidEmail(null))
//    }

}