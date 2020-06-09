package net.ihaha.sunny.fox.data.repository.mappers

import net.ihaha.sunny.fox.remote.models.user.UserData
import net.ihaha.sunny.fox.local.entity.user.UserData as DbUserData

internal fun UserData.toDbUserData() : DbUserData{
    return DbUserData(
        user = this.user?.toDbUser()
    )
}
