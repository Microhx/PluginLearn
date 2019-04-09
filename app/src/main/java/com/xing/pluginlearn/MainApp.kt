package com.xing.pluginlearn

import com.qihoo360.replugin.RePluginApplication
import com.qihoo360.replugin.RePluginConfig

/**
 * created by Java
 * <p>
 * 纵然万劫不复，纵然相思入骨，我依然待你眉眼如初，岁月如故。
 * <p>
 * date : 2019/4/9
 * <p>
 * version :
 * <p>
 * desc :
 */
class MainApp : RePluginApplication() {


    override fun createConfig(): RePluginConfig {

        val config = RePluginConfig()

        //不校检内容
        config.verifySign = false

        return config
    }
}