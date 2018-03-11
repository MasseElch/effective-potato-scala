package controllers

import javax.inject._

import database.entity.User
import database.repository.UserRepository
import play.api.mvc._
import play.api.libs.json._

import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()
(
  userRepository: UserRepository,
  controllerComponents: ControllerComponents
)(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def index = Action.async { implicit request: Request[AnyContent] =>
    userRepository.find(1).map { user =>
      Ok(Json.toJson(user))
    }
  }

  def secured =

}
