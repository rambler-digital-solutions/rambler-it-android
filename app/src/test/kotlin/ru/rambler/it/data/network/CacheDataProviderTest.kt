package ru.rambler.it.data.network

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import ru.rambler.it.data.cache.mapDto
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.Brand
import ru.rambler.it.data.dto.Event
import ru.rambler.it.data.dto.EventAttributes
import ru.rambler.it.data.dto.Tech
import java.util.*

class CacheDataProviderTest {
    lateinit var dataProvider: NetworkDataProviderImpl
    lateinit var api: ITRamblerApi

    @Before
    fun setUp() {
        api = Mockito.mock(ITRamblerApi::class.java)
        dataProvider = NetworkDataProviderImpl(api)
    }

    @Test
    fun testMap_DTO_in_DBO() {
        val event = createTestEvent()
        var eventDb = mapDto(event) as EventDbo
        assert(eventDb.attributes?.brand != null && eventDb?.attributes?.tech != null)
    }


    private fun createTestEvent(): Event {
        val id = Random().nextInt()
        val name = "event" + id.toString()
        return Event(id, name, attributes = EventAttributes("asd", "asd", Date(), Date(), null, null, false,
                Brand(1, "brand", "description", "homePage", "logo"),
                Tech(1, "Android", "#00FF00"), emptyList()))
    }

}
