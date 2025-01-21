package com.venturo.formstepper

import com.venturo.formstepper.screen.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModules = module {
    viewModel { RegisterViewModel() }
}


