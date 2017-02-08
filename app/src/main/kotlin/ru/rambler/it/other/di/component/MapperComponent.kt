package ru.rambler.it.other.di.component


import dagger.Component
import ru.rambler.it.data.mappers.EventAttributesMapper
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.data.mappers.LectureMapper
import ru.rambler.it.other.di.module.MapperModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MapperModule::class))
interface MapperComponent {
    fun inject(eventMapper: EventMapper)
    fun inject(evetAttributesMapper: EventAttributesMapper)
    fun inject(lectureMapper: LectureMapper)
}
