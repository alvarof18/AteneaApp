import android.app.Activity
import android.app.Application


class AteneaAplication:Application() {

    var mInstance: AteneaAplication? = null
    lateinit var activity: Activity

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        activity = mInstance!!.activity
    }

}