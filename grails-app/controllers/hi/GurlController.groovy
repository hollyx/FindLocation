
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
            render "ireland"
        } else {
            render "not in ireland"
        }
    }
    
    def getIpAddress(javax.servlet.http.HttpServletRequest request) {
        def ipAddress = request.getRemotrAddr()
        
        if (ipAddress && InetAddressValidator.VALIDATOR.isValid(ipAddress)) {
            log.debug("Remote IP Address ::: " + ipAddress)
            
            return ipAddress
        }
        
        ipAddress = request.getHeader("X-Forwarded-For")
        
        if(ipAddress && InetAddressValidator.VALIDATOR.isValid(ipAddress)) {
            log.debug("Remote IP Address ::: " + ipAddress)
            
            return ipAddress
        }
        
        ipAddress = request.getHeader("Client-IP")
        
        if(ipAddress && InetAddressValidator.VALIDATOR.isValid(ipAddress)) {
            log.debug("Remote IP Address ::: " + ipAddress)
            
            return ipAddress
        }
        
        ipAddress
    }

}
