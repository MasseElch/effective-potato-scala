package database.table

import java.sql.Timestamp
import java.time.LocalDateTime

import database.entity.BaseEntity
import slick.jdbc.MySQLProfile.api._

abstract class BaseTable[E <: BaseEntity](tag: Tag, tableName: String) extends Table[E](tag, tableName) {
  implicit val localDateTimeToTimestamp: BaseColumnType[LocalDateTime] = MappedColumnType.base[LocalDateTime, Timestamp](
    l => Timestamp.valueOf(l),
    t => t.toLocalDateTime
  )
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def createdAt = column[LocalDateTime]("created_at")
  def updatedAt = column[LocalDateTime]("updated_at")
  def deletedAt = column[Option[LocalDateTime]]("deleted_at", O.Default(null))
}
