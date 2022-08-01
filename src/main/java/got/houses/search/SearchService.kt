package got.houses.search

import got.houses.house.HouseService
import got.houses.model.House
import got.houses.networking.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SearchService @Autowired constructor(val houseService: HouseService) {

    fun searchHouses(query: String): List<House> {
        return houseService.findHouse(query)
    }

}