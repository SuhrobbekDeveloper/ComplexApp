package com.example.client_example.mvp

class GreetingPresenter(
    private final val model: GreetingModel,
    private final val view: GreetingView
) {
    fun loadGreeting() {
        val greeting = model.getGreeting()
        view.displayGreeting(greeting = greeting)
    }
}