package top.qiyuey.demo

import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(
        private val userRepository: UserRepository
) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Mono<User> {
        return userRepository.findById(id)
    }

    @GetMapping("/max-id")
    suspend fun getMaxId(): Long? {
        return userRepository.getMaxId().awaitFirstOrNull()
    }
}