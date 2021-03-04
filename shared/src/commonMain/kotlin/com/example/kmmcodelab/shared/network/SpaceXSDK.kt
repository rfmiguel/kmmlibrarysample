package com.example.kmmcodelab.shared.network

import com.example.kmmcodelab.shared.RocketLaunch

class SpaceXSDK {
    private val api = SpaceXApi()

    @Throws(Exception::class) suspend fun getLaunches(): List<RocketLaunch>  =
        api.getAllLaunches()
}