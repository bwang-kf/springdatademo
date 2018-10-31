package com.example.springdatademo

import com.example.springdatademo.entities.Appuser
import com.example.springdatademo.repositories.AppuserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.sql.DataSource


@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class AppuserRepositoryTest {
    @Autowired
    var appuserRepo: AppuserRepository? = null

    @Autowired
    var dataSource: DataSource? = null

    @Test
    fun `Create a user then update username then find it by id`() {
        val user = Appuser(null, "demouser@example.com", "foo", "")

        val saved = appuserRepo!!.save(user)

        assertThat(saved.id).isNotNull()

        saved.username = "bar"

        appuserRepo!!.save(saved)

        val reloaded = appuserRepo!!.findById(saved.id!!)

        assertThat(reloaded).isNotEmpty

        assertThat(reloaded.get().username).isEqualTo("bar")
    }
}