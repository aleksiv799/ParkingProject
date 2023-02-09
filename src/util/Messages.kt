package util

import data.Commands

object Messages {
    const val introMessage =
        """Это приложение предназначено для парковки автомобилей,для работы введите ${Colors.blue}"/start"${Colors.resetColor}"""
    val overMessage = "До встречи в следующий раз!"
    const val infoMessage = """Справка по командам:                              
/start - команда для запуска программы            
/end - команда для завершения выполнения программы
/park - команда для парковки автомобиля на свободное место
/return - команда возвращает автомобиль владельцу по номеру с указанием даннных владельца 
/park_info_by_car - команда указывает место, где был припаркован автомобиль
/park_info_by_place - команда сообщает информацию об автомобиле,для этого необходимо ввести парковочное место
/park_stats - возвращает текущую загруженность парковки
/park_all_stats - возвращает количество операций парковки автомобилей
"""
    const val wrongMessage = "Неверная команда." +
            " Попробуйте ввести команду \"/help\" для получения справки"

    const val messageHelper =
        """Введите команду ${Colors.blue}"${Commands.startCommand}"${Colors.resetColor} для запуска работы программы
или наберите команду: ${Colors.blue}"${Commands.helpCommand}"${Colors.resetColor} для получения справки:"""

    fun sendMessage(message: String) {
        println(message)

    }



}