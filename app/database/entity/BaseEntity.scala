package database.entity

import java.time.LocalDateTime

trait BaseEntity {
  def id: Long
  def createdAt: LocalDateTime
  def updatedAt: LocalDateTime
  def deletedAt: Option[LocalDateTime]
}
