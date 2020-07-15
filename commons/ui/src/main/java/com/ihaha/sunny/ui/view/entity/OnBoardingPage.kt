package com.ihaha.sunny.ui.view.entity
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ihaha.sunny.ui.R

enum class OnBoardingPage(
    @StringRes val titleResource: Int,
    @StringRes val subTitleResource: Int,
    @StringRes val descriptionResource: Int,
    @DrawableRes val logoResource: Int
) {

    ONE(R.string.title_on_boarding_one_title, R.string.title_on_boarding_one_sub,R.string.title_on_boarding_one_des, R.drawable.image_onboarding_one),
    TWO(R.string.title_on_boarding_two_title, R.string.title_on_boarding_two_sub,R.string.title_on_boarding_two_des, R.drawable.image_onboarding_two),
    THREE(R.string.title_on_boarding_three_title, R.string.title_on_boarding_three_sub,R.string.title_on_boarding_three_des, R.drawable.image_onboarding_three),
    FOUR(R.string.title_on_boarding_four_title, R.string.title_on_boarding_four_sub,R.string.title_on_boarding_four_des, R.drawable.image_onboarding_four),
    FIVE(R.string.title_on_boarding_five_title, R.string.title_on_boarding_five_sub,R.string.title_on_boarding_five_des, R.drawable.image_onboarding_five)

}