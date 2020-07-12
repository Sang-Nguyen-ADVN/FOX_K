package com.ihaha.sunny.fox.ui.auth

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.ihaha.sunny.base.exception.invalidEmail
import com.ihaha.sunny.base.exception.invalidNormalPassword
import com.ihaha.sunny.base.exception.invalidString
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.Constants
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentSignUpBinding
import com.ihaha.sunny.fox.domain.model.auth.User
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import com.ihaha.sunny.ui.extensions.string
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


@FlowPreview
@ExperimentalCoroutinesApi
class SignUpFragment : BaseBindingFragment<FragmentSignUpBinding, SignUpViewModel>() {

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    //endregion

    //region override

    override val viewModel: SignUpViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_sign_up

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is OnListenerNavigationToMainActivity -> onListenerNavigationToMainActivity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        initEventListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //endregion

    //region method
    private fun initComponents() {

    }

    private fun initEventListeners() {
        viewBinding.btnSignUp.setOnClickListener {
            launch {
                val email = viewBinding.edtEmail.text.toString()
                val password = viewBinding.edtUserPassword.text.toString()
                val rePassword = viewBinding.edtRePassword.text.toString()
                val userName = viewBinding.edtUserName.text.toString()
                if (invalidData(userName, email, password, rePassword)) {
                    viewModel.signUpWithEmailAndPassword(email = email, password = password)
                        .observe(viewLifecycleOwner, Observer { signUp ->
                            signUp.addOnCompleteListener { result ->
                                when {
                                    result.isSuccessful -> {
                                        if (result.result != null) {
                                            createUserData(compareUser(result.result?.user))
                                        }
                                    }
                                    else -> {
                                        viewBinding.tvError.text = result.exception?.message
                                    }
                                }
                            }
                        })
                }
            }
        }
        viewBinding.tvSignIn.setOnClickListener {
            it.findNavController()
                .navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        }
        //endregion
    }

    private fun createUserData(user: User?) {
        launch {
            viewModel.createUserData(user = user)
                .observe(viewLifecycleOwner, Observer { createUser ->
                    createUser.addOnCompleteListener { result ->
                        when {
                            result.isSuccessful -> {
                                result.addOnSuccessListener {
                                    Timber.tag(Constants.TAG_FIREBASE).d("Create User Success")
                                    onListenerNavigationToMainActivity?.onNavigation(Constants.ACTIVITY_MAIN)
                                }
                                result.addOnFailureListener {
                                    Timber.tag(Constants.TAG_FIREBASE).d("Create User Failed")
                                    Timber.tag(Constants.TAG_FIREBASE).d(it)
                                    viewBinding.tvError.text = it.message
                                }
                            }
                            else -> {
                                viewBinding.tvError.text = result.exception?.message
                            }
                        }
                    }
                    createUser.addOnFailureListener { result ->
                        viewBinding.tvError.text = result.message
                    }
                })
        }
    }

    private fun invalidData(
        userName: String?,
        email: String?,
        password: String?,
        rePassword: String?
    ): Boolean {
        when {
            !userName.invalidString() -> {
                viewBinding.tvError.text = string(R.string.error_user_name_empty)
                return false
            }
            !email.invalidEmail() -> {
                viewBinding.tvError.text = string(R.string.error_user_email_empty)
                return false
            }
            !password.invalidNormalPassword() -> {
                viewBinding.tvError.text = string(R.string.error_user_password_empty)
                return false
            }
            !rePassword.invalidNormalPassword() -> {
                viewBinding.tvError.text = string(R.string.error_user_re_password_empty)
                return false
            }
            password != rePassword -> {
                viewBinding.tvError.text = string(R.string.error_user_repeated_password_incorrect)
                return false
            }
            else -> {
                return true
            }
        }
    }

    private fun compareUser(firebaseUser: FirebaseUser?): User? {
        val profileUpdate = UserProfileChangeRequest.Builder()
            .setPhotoUri(Uri.parse("https://firebasestorage.googleapis.com/v0/b/fox-tech.appspot.com/o/user_avatar.png?alt=$PATH_ALT&token=$PATH_TOKEN"))
            .build()
        firebaseUser?.updateProfile(profileUpdate)
        return User(
            uid = firebaseUser?.uid,
            username = firebaseUser?.displayName,
            email = firebaseUser?.email,
            phone = firebaseUser?.phoneNumber,
            pictureUrl = firebaseUser?.photoUrl?.toString()
        )
    }

    companion object{
        const val PATH_ALT = "media"
        const val PATH_TOKEN = "21b1d2e5-a4e5-4b9f-9d9e-a6895fb98a9b"
    }
}