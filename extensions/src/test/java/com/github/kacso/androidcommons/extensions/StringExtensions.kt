package com.github.kacso.androidcommons.extensions

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StringExtensions {

    @Test
    fun isEmail() {
        Assertions.assertTrue("mail@mail.com".isEmail())
        Assertions.assertTrue("name.surname@mailProvider.co".isEmail())
        Assertions.assertFalse("mail@mail".isEmail())
        Assertions.assertFalse("mail.com".isEmail())
        Assertions.assertFalse("@mail.com".isEmail())
        Assertions.assertFalse("mail@mail.c".isEmail())
        Assertions.assertFalse("mail@mail.commm".isEmail())
    }

    @Test
    fun matchesEmptyKeyList() {
        Assertions.assertFalse(listOf<String>().matches(""))
    }

    @Test
    fun matchesEmptyQuery() {
        Assertions.assertTrue(listOf("key").matches(""))
        Assertions.assertTrue(listOf("key").matches(null))
    }

    @Test
    fun matchesSingleWordQuery() {
        Assertions.assertTrue(listOf("John", "Doe").matches("John"))
        Assertions.assertTrue(listOf("John", "Doe").matches("Doe"))
        Assertions.assertTrue(listOf("John", "Doe").matches("doe"))
        Assertions.assertTrue(listOf("John", "Doe").matches("joh"))
        Assertions.assertFalse(listOf("John", "Doe").matches("johndoe"))
    }

    @Test
    fun matchesMultipleWordsQuery() {
        Assertions.assertTrue(listOf("John", "Doe").matches("John Doe"))
        Assertions.assertTrue(listOf("John", "Doe").matches("john doe"))
        Assertions.assertFalse(listOf("John", "Doe").matches("john does"))
        Assertions.assertFalse(listOf("John", "Doe").matches("johne doe"))
    }
}