package fr.esgi.tp1603.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
