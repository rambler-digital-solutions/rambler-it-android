package ru.rambler.it.data.network

import com.google.gson.Gson
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.*
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.*
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.domain.entities.Brand
import ru.rambler.it.domain.entities.Event
import ru.rambler.it.domain.entities.EventAttributes
import ru.rambler.it.domain.entities.Tech
import rx.Observable
import rx.observers.TestSubscriber
import java.util.*


class NetworkDataProviderTest {

//    lateinit var dataProvider: NetworkDataProviderImpl
//    lateinit var api: ITRamblerApi
//    lateinit var eventMapper: EventMapper
//    lateinit var testSubscriber : TestSubscriber<List<EventDbo>>
//
//    @Before
//    fun setUp() {
//        api = mock(ITRamblerApi::class.java)
//        testSubscriber = TestSubscriber.create()
//        eventMapper = EventMapper()
//        dataProvider = NetworkDataProviderImpl(eventMapper)
//    }
//
//    @Test
//    fun testGetAllEvents_whenEmpty_noItems() {
//        // arrange
//        val emptyResult: List<EventDbo> = emptyList()
//        `when`(api.getAllEvents()).thenReturn(Observable.just(EventsCollection(emptyResult)))
//
//        // act
//        dataProvider.getAllEvents().subscribe(testSubscriber)
//        testSubscriber.awaitTerminalEvent()
//
//        // assert
//        testSubscriber.assertValueCount(1)
//        testSubscriber.assertValue(emptyResult)
//        testSubscriber.assertNoErrors()
//        testSubscriber.assertCompleted()
//        verify(api).getAllEvents()
//    }
//
//    @Test
//    fun testGetAllEvents_withItems_itemsReturned() {
//        // arrange
//        val event1 = createTestEvent()
//        val event2 = createTestEvent()
//        val resultList = arrayListOf(event1, event2)
//        `when`(api.getAllEvents()).thenReturn(Observable.just(EventsCollection(resultList)))
//
//        // act
//        dataProvider.getAllEvents().subscribe(testSubscriber)
//        testSubscriber.awaitTerminalEvent()
//
//        // assert
//        testSubscriber.assertValueCount(1)
//        testSubscriber.assertValues(resultList)
//        testSubscriber.assertNoErrors()
//        testSubscriber.assertCompleted()
//        verify(api).getAllEvents()
//    }
//
//    @Test
//    fun testGetEventsFromDate_whenEmpty_noItems() {
//        // arrange
//        val emptyResult: List<Event> = emptyList()
//        val modificationDate = Date()
//        val modificationTimestamp = modificationDate.time
//        `when`(api.getEventsModifiedSince(modificationTimestamp)).thenReturn(Observable.just(EventsCollection(emptyResult)))
//
//        // act
//        dataProvider.getEventsFromDate(modificationDate).subscribe(testSubscriber)
//        testSubscriber.awaitTerminalEvent()
//
//        // assert
//        testSubscriber.assertValueCount(1)
//        testSubscriber.assertValue(emptyResult)
//        testSubscriber.assertNoErrors()
//        testSubscriber.assertCompleted()
//        verify(api).getEventsModifiedSince(modificationTimestamp)
//    }
//
//    @Test
//    fun testGetEventsFromDate_withItems_itemsReturned() {
//        // arrange
//        val event1 = createTestEvent()
//        val event2 = createTestEvent()
//        val resultList = arrayListOf(event1, event2)
//        val modificationDate = Date()
//        val modificationTimestamp = modificationDate.time
//        `when`(api.getEventsModifiedSince(modificationTimestamp)).thenReturn(Observable.just(EventsCollection(resultList)))
//
//        // act
//        dataProvider.getEventsFromDate(modificationDate).subscribe(testSubscriber)
//        testSubscriber.awaitTerminalEvent()
//
//        // assert
//        testSubscriber.assertValueCount(1)
//        testSubscriber.assertValues(resultList)
//        testSubscriber.assertNoErrors()
//        testSubscriber.assertCompleted()
//        verify(api).getEventsModifiedSince(modificationTimestamp)
//    }
//
//
//
//    private fun createTestEvent(): Event {
//        val id = Random().nextInt()
//        val name = "event" + id.toString()
//        return Event(id, name, attributes = EventAttributes("asd", "asd", Date(), Date(), null, null, false,
//                Brand(1, "brand", "description", "homePage", "logo"),
//                Tech(1, "Android", "#00FF00"), emptyList()))
//    }

}