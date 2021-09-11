package camp.nextstep.edu.github.domain.exception

class NotFoundUserException(message: String) : IllegalArgumentException(message) {
    constructor() : this("Cannot find github user")
}