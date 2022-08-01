package got.houses.search

import got.houses.mapper.DTOMapper
import got.houses.model.HouseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Validated
@RestController
@RequestMapping("/api")
class SearchController @Autowired constructor(val searchService: SearchService, val dtoMapper: DTOMapper) {

    @RequestMapping(value = ["search"], method = [RequestMethod.GET])
    fun search(@RequestParam(name = "query") @Valid @NotBlank query: String): ResponseEntity<List<HouseDTO>> {
        val houses: List<HouseDTO> = dtoMapper.housesToHousesDTO(searchService.searchHouses(query))

        return ResponseEntity<List<HouseDTO>>(houses, null, HttpStatus.OK)
    }

}