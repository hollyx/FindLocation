package hi

class GurlController {

    
    def index() { 
        def message = "hello"
        [myMessage:message]
        //render view: 'onfire'
        render message
    }
    
    def list() {
    if (isInCountry('IE')) {
        render "yes ireland"
    } else {
        render "nope ireland"
    }
}

}
