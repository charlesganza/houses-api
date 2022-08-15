package got.houses

import got.houses.search.SearchController
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureRestDocs(outputDir = "build/snippets")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApiTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `successful search`(){
        mockMvc.perform(get("/api/search?query=House Algood"))
                .andExpect(status().isOk)
                .andExpect(MockMvcResultMatchers.content().string(containsString("House Algood"))).andDo(document("house-search-endpoint"))
    }

    @Test
    fun `search with incomplete parameters`(){
        mockMvc.perform(get("/api/search?house="))
                .andExpect(status().isBadRequest)
    }

}