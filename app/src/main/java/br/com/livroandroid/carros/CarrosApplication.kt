package br.com.livroandroid.carros

import android.app.Application
import android.util.Log


//Chamado quando o Android criar o processo da aplicação
class CarrosApplication : Application() {
    private val TAG = "CarrosApplication"

    override fun onCreate() {
        super.onCreate()
        //Sava a instância para termos acesso como Singleton
        appInstance = this
    }

    companion object {
        //Singleton da classe Application

        private var appInstance: CarrosApplication? = null

        fun getInstance(): CarrosApplication{
            if (appInstance == null){
                throw IllegalStateException("Configue a classe de Application no AndroidManifest.xml")
            }

            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "CarrosApplication.onTerminate()")
    }
}