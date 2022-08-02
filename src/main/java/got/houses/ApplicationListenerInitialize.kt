package got.houses

import got.houses.house.HouseService
import got.houses.mapper.DTOMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class ApplicationListenerInitialize @Autowired constructor(val houseService: HouseService, val dtoMapper: DTOMapper) : ApplicationListener<ApplicationReadyEvent?> {
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        //application is ready, fetch and cache houses
        val houses = houseService.fetchAllHouses()
        if(houses != null) houseService.saveHouses(dtoMapper.housesDTOToHouses(houses))
    }
}