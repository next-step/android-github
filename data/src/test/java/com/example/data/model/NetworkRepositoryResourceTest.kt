package com.example.data.model

import org.junit.Assert.*
import org.junit.Test

class NetworkRepositoryResourceTest {

    @Test
    fun `null 값으로 들어와도 도메인모델로 변환하면 emptyString이 된다`() {
        val networkRepositoryResource = NetworkRepositoryResource(null, null)
        val repositoryResource = networkRepositoryResource.toRepositoryResource()
        assertEquals("", repositoryResource.fullName)
        assertEquals("", repositoryResource.description)
    }

    @Test
    fun `emptyString 값으로 들어와도 도메인모델로 변환하면 emptyString이 된다`() {
        val networkRepositoryResource = NetworkRepositoryResource(null, null)
        val repositoryResource = networkRepositoryResource.toRepositoryResource()
        assertEquals("", repositoryResource.fullName)
        assertEquals("", repositoryResource.description)
    }
}
