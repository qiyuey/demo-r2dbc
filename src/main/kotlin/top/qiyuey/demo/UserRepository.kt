package top.qiyuey.demo

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepository : ReactiveCrudRepository<User, Long> {

    @Query(// language=sql
            "SELECT MAX(id) FROM user")
    fun getMaxId(): Mono<Long>
}