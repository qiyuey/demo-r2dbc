package top.qiyuey.demo

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

class User {
    @Id
    var id: Long = 0L
    var createTime: LocalDateTime = LocalDateTime.MIN
}