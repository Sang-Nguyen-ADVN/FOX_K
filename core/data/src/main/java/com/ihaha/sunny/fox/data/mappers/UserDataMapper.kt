package com.ihaha.sunny.fox.data.mappers

import com.ihaha.sunny.fox.remote.models.user.UserData
import com.ihaha.sunny.fox.local.entity.user.UserData as DbUserData

internal fun UserData.toDbUserData() : DbUserData{
    return DbUserData(
        user = this.user?.toDbUser()
    )
}
