package database.entity

import java.time.LocalDateTime

import play.api.libs.json.{JsValue, Json, Writes}

object User {
  implicit val list = new Writes[User] {
    def writes(user: User): JsValue = Json.obj(
      "firstname" -> user.firstname,
      "lastname" -> user.lastname,
      "createdAt" -> user.createdAt,
      "updatedAt" -> user.updatedAt,
    )
  }
}

case class User (id: Long, firstname: String, lastname: String, password: String, createdAt: LocalDateTime, updatedAt: LocalDateTime, deletedAt: Option[LocalDateTime]) extends BaseEntity
