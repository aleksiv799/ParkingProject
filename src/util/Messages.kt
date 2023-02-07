package util

object Messages {
    const val introMessage = "Это приложение предназначено для парковки автомобилей"
    const val overMessage = "До встречи в следующий раз!"
    const val infoMessage = """Справка по командам:                              
/start - команда для запуска программы            
/end - команда для завершения выполнения программы"""
    const val wrongMessage = "Неверная команда."+
            " Попробуйте ввести команду \"/help\" для получения справки"
    const val welcomeMessage = "С этой команды начинается выполнение программы"

    fun sendMessage(message: String) {
        println(message)
    }
}