package ru.rambler.it

import java.io.InputStream

fun readResourceStream(testObj: Any, filename: String): InputStream {
    return testObj::class.java.getClassLoader().getResourceAsStream(filename)
}