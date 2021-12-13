package fr.esgi.tp1604.use_cases.user.application;

import fr.esgi.tp1604.kernel.CommandHandler;
import fr.esgi.tp1604.kernel.Event;
import fr.esgi.tp1604.kernel.EventDispatcher;
import fr.esgi.tp1604.use_cases.user.domain.Address;
import fr.esgi.tp1604.use_cases.user.domain.User;
import fr.esgi.tp1604.use_cases.user.domain.UserId;
import fr.esgi.tp1604.use_cases.user.domain.UserRepository;

public final class CreateUserCommandHandler implements CommandHandler<CreateUser, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }
    public UserId handle(CreateUser createUser) {
        final UserId userId = userRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, new Address(createUser.address.city));
        userRepository.add(user);
        eventEventDispatcher.dispatch(new CreateUserEvent(userId));
        return userId;
    }
}
