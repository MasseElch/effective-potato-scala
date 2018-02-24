package database.repository

import database.entity.BaseEntity
import database.table.BaseTable
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}

abstract class BaseRepository[E <: BaseEntity, T <: BaseTable[E]](val dbConfigProvider: DatabaseConfigProvider, executionContext: ExecutionContext, query: TableQuery[T]) extends HasDatabaseConfigProvider[JdbcProfile] {
  def all(): Future[Seq[E]] = db.run(query.result)
  def find(id: Long): Future[Option[E]] = db.run(query.filter(_.id === id).result.headOption)
}
