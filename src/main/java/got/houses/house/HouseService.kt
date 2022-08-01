package got.houses.house

import got.houses.model.House
import got.houses.model.HouseDTO
import got.houses.networking.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HouseService @Autowired constructor(val repositoryService: RepositoryService, val houseRepository: HouseRepository) {

    //get houses from API
    fun fetchAllHouses(): List<HouseDTO>? {
        return repositoryService.getService().getHouses().execute().body()
    }

    fun saveHouses(houses: List<House>) {
        houseRepository.saveAll(houses)
    }

    //search cached houses
    fun findHouse(query: String): List<House> {
        return houseRepository.findAll()
    }

}