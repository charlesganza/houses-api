package got.houses.search

import got.houses.model.HouseDTO
import got.houses.networking.NetClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SearchService @Autowired constructor(val netClient: NetClient) {

    fun findHouse(house: String): List<HouseDTO>? {
        return netClient.houseRepository().findHouse(house).execute().body()
    }

}