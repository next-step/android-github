package camp.nextstep.edu.github.data.util

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

internal object GsonConverter {
    fun getConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        )
    }
}