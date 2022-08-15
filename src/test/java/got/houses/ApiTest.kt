package got.houses

import got.houses.search.SearchController
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
@WebMvcTest(SearchController::class)
class ApiTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun `successful search`(){
        mockMvc.perform(get("/search?house=Ashford of Ashford"))
                .andExpect(status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("House Ashford of Ashford")).andDo(document("house-search-endpoint"))
    }

    @Test
    fun `search with incomplete parameters`(){
        mockMvc.perform(get("/api/search?house="))
                .andExpect(status().isBadRequest)
    }

}