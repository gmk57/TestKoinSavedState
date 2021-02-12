package gmk57.testkoinsavedstate

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}

val appModule = module {
    // Resolve SavedStateHandle with get()
    viewModel { MyStateViewModel(get()) }
}

class MyStateViewModel(val state: SavedStateHandle) : ViewModel()
