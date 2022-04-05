package com.example.testtask.di

import android.content.Context
import androidx.room.Room
import com.example.testtask.data.repository.*
import com.example.testtask.data.storage.database.*
import com.example.testtask.data.storage.network.retrofit.QuestionnairesStorageImpl
import com.example.testtask.data.storage.storagies.*
import com.example.testtask.domain.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule() {

    @Singleton
    @Provides
    fun provideBriefCaseDao(briefCaseDB: BriefCaseDB) = briefCaseDB.BriefCaseDao()

    @Singleton
    @Provides
    fun provideBriefCaseDB(context: Context): BriefCaseDB =
        Room.databaseBuilder(
            context,
            BriefCaseDB::class.java,
            "briefcase_db"
        ).build()

    @Provides
    fun provideBriefcaseStorage(impl: BriefCaseStorageImpl): BriefCaseStorage = impl

    @Provides
    fun provideBriefcaseRepository(impl: BriefCaseRepositoryImpl): BriefCaseRepository = impl

    @Provides
    fun provideVesselStorage(impl: VasselStorageImpl): VasselStorage = impl

    @Provides
    fun provideVesselsRepository(impl: VesselsRepositoryImpl): VesselsRepository = impl

    @Provides
    fun providePortStorage(impl: PortStorageImpl): PortStorage = impl

    @Provides
    fun providePortRepository(impl: PortRepositoryImpl): PortRepository = impl

    @Provides
    fun provideInspectionTypeStorage(impl: InspectionTypeStorageImpl): InspectionTypeStorage = impl

    @Provides
    fun provideInspectionTypeRepository(impl: InspectionTypeRepositoryImpl): InspectionTypeRepository =
        impl

    @Provides
    fun provideInspectionSourceStorage(impl: InspectionSourceStorageImpl): InspectionSourceStorage = impl

    @Provides
    fun provideInspectionSourceRepository(impl: InspectionSourceRepositoryImpl): InspectionSourceRepository =
        impl

    @Provides
    fun provideQuestionnairesRepository(impl: QuestionnairesRepositoryImpl): QuestionnairesRepository =
        impl

    @Provides
    fun provideQuestionnairesStorage (impl: QuestionnairesStorageImpl): QuestionnairesStorage = impl

    @Provides
    fun provideQuestionsRepository(impl: QuestionsRepositoryImpl): QuestionsRepository =
        impl

    @Provides
    fun provideQuestionsStorage (impl: QuestionsStorageImpl): QuestionsStorage = impl

    @Provides
    fun provideAnswersRepository(impl: AnswersRepositoryImpl): AnswersRepository =
        impl

    @Provides
    fun provideAnswersStorage (impl: AnswersStorageImpl): AnswersStorage = impl

}
