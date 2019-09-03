package com.github.kacso.androidcommons.security.factories

import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [23])
class SecurityRepositoryFactoryTest {
    @Test
    fun getOAuth2Repository() {
        val r1 = SecurityRepositoryFactory.getOAuth2Repository(
            RuntimeEnvironment.systemContext,
            "http://repository1/",
            "key"
        )

        val r2 = SecurityRepositoryFactory.getOAuth2Repository(
            RuntimeEnvironment.systemContext,
            "http://repository2/",
            "key"
        )

        Assertions.assertNotEquals(r1, r2)

        Assertions.assertEquals(
            r1, SecurityRepositoryFactory.getOAuth2Repository(
                RuntimeEnvironment.systemContext,
                "http://repository1/",
                "key"
            )
        )

        Assertions.assertEquals(
            r2, SecurityRepositoryFactory.getOAuth2Repository(
                RuntimeEnvironment.systemContext,
                "http://repository2/",
                "key"
            )
        )
    }

    @Test
    fun getRxOAuth2Repository() {
        val r1 = SecurityRepositoryFactory.getRxOAuth2Repository(
            RuntimeEnvironment.systemContext,
            "http://repository1/",
            "key"
        )

        val r2 = SecurityRepositoryFactory.getRxOAuth2Repository(
            RuntimeEnvironment.systemContext,
            "http://repository2/",
            "key"
        )

        Assertions.assertNotEquals(r1, r2)

        Assertions.assertEquals(
            r1, SecurityRepositoryFactory.getRxOAuth2Repository(
                RuntimeEnvironment.systemContext,
                "http://repository1/",
                "key"
            )
        )

        Assertions.assertEquals(
            r2, SecurityRepositoryFactory.getRxOAuth2Repository(
                RuntimeEnvironment.systemContext,
                "http://repository2/",
                "key"
            )
        )
    }
}