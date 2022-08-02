package got.houses.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.time.Duration

@Service
class NetClient {

    private val httpLoggingInterceptor = HttpLoggingInterceptor()

    init {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }

    private final val okHttpClient = OkHttpClient.Builder()
            .callTimeout(Duration.ofSeconds(30))
            .readTimeout(Duration.ofSeconds(5))
            .writeTimeout(Duration.ofSeconds(30))
            .addInterceptor(httpLoggingInterceptor)
            .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://www.anapioficeandfire.com/api/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    fun instance(): Repository {
        return retrofit.create(Repository::class.java)
    }

}