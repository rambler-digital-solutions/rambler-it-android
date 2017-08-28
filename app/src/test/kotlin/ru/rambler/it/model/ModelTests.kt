package ru.rambler.it.model

import com.google.gson.Gson
import org.junit.Assert.*
import org.junit.Test
import ru.rambler.it.readResourceStream
import java.io.BufferedReader
import java.io.InputStreamReader

class ModelTests {
    @Test
    fun getEventsResponseTest() {
        val br = BufferedReader(InputStreamReader(readResourceStream(this, "getEventsResponse.json")))

        val response = Gson().fromJson(br, GetEventsResponse::class.java)

        val attributes = response.data.get(0).attributes
        assertTrue(response.data.size == 49)
        assertTrue(response.data[0].id == 67L)
        assertTrue(attributes.lectures.size == 1)
        assertTrue(attributes.name == "Rambler.iOS #9")
        assertNull(attributes.deletedAt)
        assertFalse(attributes.isDeleted)
        assertTrue(attributes.lectures[0].tags.size == 3)
        assertTrue(attributes.lectures[0].speaker.socialProfiles.size == 2)
    }
}