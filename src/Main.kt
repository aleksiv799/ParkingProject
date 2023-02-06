import data.Commands
import util.Messages
import repository.MessageRepository

val messageRepository = MessageRepository()
val commands = Commands()

fun main(args: Array<String>) {
    println(Messages.introMessage)
    while (true) {
        when (readLine().toString()) {
            commands.finishCommand -> messageRepository.endProgramExec()
            commands.helpCommand -> messageRepository.getHelpInfo()
            commands.startCommand -> messageRepository.startProgramExec()
            else -> messageRepository.wrongCommandExec()
        }
    }
}
















