package miin.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import miin.learning.`interface`.LoginInterface
import miin.learning.databinding.ActivityMainBinding
import miin.learning.model.User
import miin.learning.presenter.LoginPresenter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val loginInterface = object : LoginInterface {
        override fun onLoginSuccess() {
            binding.errorText.apply {
                visibility = View.VISIBLE
                text = "Login Success"
                setTextColor(resources.getColor(R.color.design_default_color_primary_variant))
            }
        }

        override fun onLoginFailure() {
            binding.errorText.apply {
                visibility = View.VISIBLE
                text = "Login Failed"
                setTextColor(resources.getColor(R.color.design_default_color_error))
            }
        }
    }

    private val loginPresenter = LoginPresenter(loginInterface)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            val user = User(email, password)
            loginPresenter.login(user)
        }
    }
}
