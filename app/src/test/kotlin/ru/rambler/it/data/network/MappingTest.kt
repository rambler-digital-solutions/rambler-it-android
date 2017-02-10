package ru.rambler.it.data.network

import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.EventsCollectionDto
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.domain.entities.Event
import java.io.File
import java.util.*

class MappingTest {

    lateinit var eventMapper: EventMapper
    lateinit var file: File

    @Before
    fun setUp() {
        eventMapper = EventMapper()
        file = File(javaClass.classLoader.getResource("test_events_response.json").path)
    }

    @Test
    fun testMap_DTO_in_BE() {
        val eventInput = Gson().fromJson<EventsCollectionDto>(file.readText(), EventsCollectionDto::class.java).data
        val eventOutput = ArrayList<Event>()

        eventInput.mapTo(eventOutput){ eventMapper.mapDto(it) }

        assert(eventInput.size == eventOutput.size)
        assert(eventInput[2].id != eventOutput[20].id && eventInput[2].id == eventOutput[2].id && eventInput[20].id == eventOutput[20].id)
        assert(eventInput[3].attributes!!.lectures!![1].speaker!!.firstName == eventOutput[3].attributes!!.lectures!![1].speaker!!.firstName)
    }

    @Test
    fun testMap_BE_in_DBO_and_back() {
        val eventDtoList= Gson().fromJson<EventsCollectionDto>(file.readText(), EventsCollectionDto::class.java).data
        val eventInput = ArrayList<Event>()
        val eventOutput = ArrayList<Event>()
        val eventDboList = ArrayList<EventDbo>()

        eventDtoList.mapTo(eventInput){ eventMapper.mapDto(it) }
        eventInput.mapTo(eventDboList) { eventMapper.mapToDbo(it) }
        eventDboList.mapTo(eventOutput) { eventMapper.mapFromDbo(it) }

        assert(eventOutput == eventInput)
    }
}