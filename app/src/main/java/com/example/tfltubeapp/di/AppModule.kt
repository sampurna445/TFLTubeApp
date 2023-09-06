package com.example.tfltubeapp.di

import com.example.tfltubeapp.data.remote.ApiDetails
import com.example.tfltubeapp.data.remote.TubeStatusService
import com.example.tfltubeapp.data.repository.TubeStatusRepository
import com.example.tfltubeapp.data.repository.TubeStatusRepositoryImpl
import com.example.tfltubeapp.ui.TubeLineStatusData
import com.example.tfltubeapp.util.TubeLineStatusDataMapper
import com.example.tfltubeapp.util.TubeLineStatusDataMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideTubeStatusService(): TubeStatusService {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(TubeStatusService::class.java)
    }


    //Merging the repository class together
    @Provides
    fun provideRepository(
        tubeStatusService: TubeStatusService,
        tubeLineStatusDataMapper: TubeLineStatusDataMapper
    ): TubeStatusRepository {
        return TubeStatusRepositoryImpl(
            tubeStatusService,
            tubeLineStatusDataMapper
        )
    }

    @Provides
    fun provideTubeLineStatusDataMapper(): TubeLineStatusDataMapper {
        return TubeLineStatusDataMapperImpl()
    }


}