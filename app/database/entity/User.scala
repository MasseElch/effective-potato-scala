package database.entity

import java.time.LocalDateTime

case class User (id: Long, firstname: String, lastname: String, password: String, createdAt: LocalDateTime, updatedAt: LocalDateTime, deletedAt: Option[LocalDateTime]) extends BaseEntity
