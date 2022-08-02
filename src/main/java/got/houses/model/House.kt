package got.houses.model

import javax.persistence.*

@Entity
@Table(name = "HOUSE")
class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
    val url: String? = null
    val name: String? = null
    val region: String? = null
    val coatOfArms: String? = null
    val words: String? = null
    @ElementCollection(targetClass = String::class)
    val titles: List<String>? = null
    @ElementCollection(targetClass = String::class)
    val seats: List<String>? = null
    val currentLord: String? = null
    val heir: String? = null
    val overlord: String? = null
    val founded: String? = null
    val founder: String? = null
    val diedOut: String? = null
    @ElementCollection(targetClass = String::class)
    val ancestralWeapons: List<String>? = null
    @ElementCollection(targetClass = String::class)
    val cadetBranches: List<String>? = null
    @ElementCollection(targetClass = String::class)
    val swornMembers: List<String>? = null
}