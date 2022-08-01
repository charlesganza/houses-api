package got.houses.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class HouseDTO(
    @JsonProperty("url") val url: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("region") val region: String,
    @JsonProperty("coatOfArms") val coatOfArms: String,
    @JsonProperty("words") val words: String,
    @JsonProperty("titles") val titles: List<String>,
    @JsonProperty("seats") val seats: List<String>,
    @JsonProperty("currentLord") val currentLord: String,
    @JsonProperty("heir") val heir: String,
    @JsonProperty("overlord") val overlord: String,
    @JsonProperty("founded") val founded: String,
    @JsonProperty("founder") val founder: String,
    @JsonProperty("diedOut") val diedOut: String,
    @JsonProperty("ancestralWeapons") val ancestralWeapons: List<String>,
    @JsonProperty("cadetBranches") val cadetBranches: List<String>,
    @JsonProperty("swornMembers") val swornMembers: List<String>
)