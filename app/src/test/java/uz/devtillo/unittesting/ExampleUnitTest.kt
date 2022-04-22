package uz.devtillo.unittesting

import org.junit.Test

import org.junit.Assert.*
import uz.devtillo.unittesting.utils.Common
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun equalNowDateAndMyDate() {
        //incorrect value not something in the year and old year
//        var calendar = Calendar.getInstance()
//        calendar.set(Calendar.YEAR, 2020)
//        assertEquals(Common.doSomething(Date()), "Equal")
        //isCorrect
        assertEquals(Common.doSomething(Date()), "Equal")
    }

    @Test
    fun equalNowDate(){
        assertEquals(Common.doSomething(Date(), Date()),"Equal")
    }

}