package database.table

import database.entity.User
import slick.jdbc.MySQLProfile.api._

class UserTable(tag: Tag) extends BaseTable[User](tag, "user") {
  def firstname = column[String]("firstname")
  def lastname = column[String]("lastname")
  def password = column[String]("password")
  def * = (id, firstname, lastname, password, createdAt, updatedAt, deletedAt) <> (User.tupled, User.unapply)
}
