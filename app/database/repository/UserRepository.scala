package database.repository

import javax.inject.Inject

import database.entity.User
import database.table.UserTable
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

class UserRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends BaseRepository[User, UserTable](dbConfigProvider, executionContext, TableQuery[UserTable]) {

}
