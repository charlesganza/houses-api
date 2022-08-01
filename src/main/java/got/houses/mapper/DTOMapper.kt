package got.houses.mapper

import got.houses.model.House
import got.houses.model.HouseDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface DTOMapper {

    fun housesDTOToHouses(housesDTO: List<HouseDTO>): List<House>

    fun housesToHousesDTO(houses: List<House>): List<HouseDTO>

}