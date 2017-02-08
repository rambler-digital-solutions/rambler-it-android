package ru.rambler.it.other.di.module

import dagger.Module
import dagger.Provides
import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.cache.RealmCacheProvider
import ru.rambler.it.data.mappers.*
import javax.inject.Singleton

@Module
class MapperModule {

    @Provides
    @Singleton
    fun provideCacheProvider(): CacheProvider {
        return RealmCacheProvider()
    }

    @Provides
    @Singleton
    fun provideBrandMapper(): BrandMapper {
        return BrandMapper()
    }

    @Provides
    @Singleton
    fun provideEventAttributesMapper(): EventAttributesMapper {
        return EventAttributesMapper()
    }

    @Provides
    @Singleton
    fun providesEventMapper(): EventMapper {
        return EventMapper()
    }

    @Provides
    @Singleton
    fun providesLectureMapper(): LectureMapper {
        return LectureMapper()
    }

    @Provides
    @Singleton
    fun providesMaterialMapper(): MaterialMapper {
        return MaterialMapper()
    }

    @Provides
    @Singleton
    fun providesSocialProfileMapper(): SocialProfileMapper {
        return SocialProfileMapper()
    }

    @Provides
    @Singleton
    fun providesSpeakerMapper(): SpeakerMapper {
        return SpeakerMapper()
    }

    @Provides
    @Singleton
    fun providesTagMapper(): TagMapper {
        return TagMapper()
    }

    @Provides
    @Singleton
    fun providesTechMapper(): TechMapper {
        return TechMapper()
    }

}