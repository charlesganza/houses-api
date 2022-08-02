package got.houses.house

import got.houses.model.HouseDTO
import got.houses.networking.NetClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HouseService @Autowired constructor(val netClient: NetClient) {

    //get houses from API
    fun searchHouse(): List<HouseDTO>? {
        return netClient.getService().getHouses().execute().body()
    }

}