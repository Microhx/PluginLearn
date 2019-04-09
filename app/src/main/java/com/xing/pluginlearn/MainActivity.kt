package com.xing.pluginlearn

import android.Manifest
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Toast
import com.qihoo360.replugin.RePlugin
import com.qihoo360.replugin.model.PluginInfo


class MainActivity : AppCompatActivity() {

    private var pluginInfo : PluginInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun loadPlugin(view: View) {
        if(ContextCompat.checkSelfPermission(this,  Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),100)
        }else {
            loadPlugin()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          loadPlugin()
        }
    }

    private fun loadPlugin() {

        //安装插件
        pluginInfo = RePlugin.install("/sdcard/oneplugin.apk")
        if(pluginInfo != null) {

            //预加载插件
            RePlugin.preload(pluginInfo)

            Toast.makeText(this,"install success", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "uninstall !!!", Toast.LENGTH_LONG).show()
        }
    }


    fun startActivityForPlugin(view:View) {

        val intent = Intent()
        intent.component = ComponentName("com.xing.oneplugin","com.xing.oneplugin.MainActivity")
        RePlugin.startActivity(this, intent)

    }


    fun unInstall(view:View) {
        val result = RePlugin.uninstall("plugin1")
        Log.i("TAG","uninstall result : $result" )

    }
}

