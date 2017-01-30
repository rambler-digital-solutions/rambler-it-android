package ru.rambler.it.data.network

import com.google.gson.Gson
import org.junit.Test
import ru.rambler.it.data.cache.mapToDbo
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.*
import java.io.File
import java.util.*

class CacheDataProviderTest {

    @Test
    fun testMap_DTO_in_DBO_single() {
        val eventList = ArrayList<Event>()
        eventList.add(createTestEvent())
        var eventDb = mapToDbo(eventList) as List<EventDbo>
        assert(eventDb[0].attributes?.lectures != null
                && eventDb[0].attributes?.lectures?.get(0) != null
                && eventDb[0].attributes?.lectures?.get(0)?.tags?.get(0)?.id == 1
                && eventDb[0].attributes?.lectures?.get(0)?.tags?.get(0)?.name == "name1"
                && eventDb[0].attributes?.lectures?.get(0)?.tags?.get(1)?.id == 2
                && eventDb[0].attributes?.lectures?.get(0)?.tags?.get(1)?.name == "name2")
    }

    @Test
    fun testMap_DTO_in_DBO_list() {
        val classLoader = javaClass.classLoader
        val file = File(classLoader.getResource("test_events_response.json").path)
        val eventInput = Gson().fromJson<EventsCollection>(file.readText(), EventsCollection::class.java).data
        val eventOutput = mapToDbo(eventInput) as List<EventDbo>
        assert(eventInput.size == eventOutput.size)
        assert(eventInput[3].attributes.lectures[1].speaker.firstName == eventOutput[3].attributes!!.lectures!![1].speaker!!.firstName)
    }


    private fun createTestEvent(): Event {
        val id = Random().nextInt()
        val name = "event" + id.toString()
        return Event(id, name, attributes = EventAttributes("asd", "asd", Date(), Date(), null, null, false,
                Brand(1, "brand", "description", "homePage", "logo"),
                Tech(1, "Android", "#00FF00"), listOf(Lecture(1, "lecture1", "description",
                listOf(Tag(1, "name1", "slug1"), Tag(2, "name2", "slug2")),
                listOf(Material(1, "title1", "link1", "kind1"), Material(2, "title2", "link2", "kind2")),
                Speaker(1, "fname", "lname", "bio", "job", "company", null, emptyList())))))
    }

}
