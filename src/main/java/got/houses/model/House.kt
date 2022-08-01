package got.houses.model

import javax.persistence.*

@Entity
@Table(name = "HOUSE")
data class House(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val url: String,
    val name: String,
    val region: String,
    val coatOfArms: String,
    val words: String,
    @ElementCollection(targetClass = String::class)
    val titles: List<String>,
    @ElementCollection(targetClass = String::class)
    val seats: List<String>,
    val currentLord: String,
    val heir: String,
    val overlord: String,
    val founded: String,
    val founder: String,
    val diedOut: String,
    @ElementCollection(targetClass = String::class)
    val ancestralWeapons: List<String>,
    @ElementCollection(targetClass = String::class)
    val cadetBranches: List<String>,
    @ElementCollection(targetClass = String::class)
    val swornMembers: List<String>
)