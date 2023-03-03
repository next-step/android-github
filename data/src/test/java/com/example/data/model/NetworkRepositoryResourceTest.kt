package com.example.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NetworkRepositoryResourceTest {

    @Test
    fun `null 값으로 들어와도 도메인모델로 변환하면 emptyString이 된다`() {
        val networkRepositoryResource = NetworkRepositoryResource(null, null)
        val repositoryResource = networkRepositoryResource.toRepositoryResource()
        assertThat(repositoryResource.fullName).isEqualTo("")
        assertThat(repositoryResource.description).isEqualTo("")
    }

    @Test
    fun `emptyString 값으로 들어와도 도메인모델로 변환하면 emptyString이 된다`() {
        val networkRepositoryResource = NetworkRepositoryResource(null, null)
        val repositoryResource = networkRepositoryResource.toRepositoryResource()
        assertThat(repositoryResource.fullName).isEqualTo("")
        assertThat(repositoryResource.description).isEqualTo("")
    }
}
