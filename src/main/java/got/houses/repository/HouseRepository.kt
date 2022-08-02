package got.houses.networking

import retrofit2.Call
import retrofit2.http.*
import got.houses.model.HouseDTO

interface HouseRepository {

    @GET(Endpoints.ENDPOINT_SEARCH_HOUSES)
    @Headers(ContentType.CONTENT_TYPE, ContentType.ACCEPT)
    fun findHouse(@Query("name") house: String): Call<List<HouseDTO>>

}

object ContentType {
    const val CONTENT_TYPE = "Content-Type: application/json"
    const val ACCEPT = "Accept: application/json"
}

object Endpoints {
    const val ENDPOINT_SEARCH_HOUSES = "houses"
}