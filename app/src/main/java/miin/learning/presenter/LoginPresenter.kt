package miin.learning.presenter

import miin.learning.`interface`.LoginInterface
import miin.learning.model.User

class LoginPresenter(private val loginInterface: LoginInterface) {


    fun login(user: User) {
        if (user.isValidEmail() && user.isValidPassword()) {
            loginInterface.onLoginSuccess()
        } else {
            loginInterface.onLoginFailure()
        }
    }
}
