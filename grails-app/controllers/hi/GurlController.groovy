
package hi

class GurlController {

  
    
    def index() { 
        def message = "hello"
        [myMessage:message]
        //render view: 'onfire'
        render message
    }
    
    def list() {
        def guy = "1.02.1.2"
        if (guy.isInCountry('IE')) {
            render "ireland"
        } else {
            render "not in ireland"
        }
    }
    
    def doSomething() {
        def location = geoIpService.getLocation('88.158.9.150')
        render location
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
    
    def check() {
        log.info "User agent: " + request.getHeader()
        println "User agent: " + request.getHeader()
        render request.getHeader()
    }
    
    def trythis() {
        def geolocation = getLocation( request.remoteAddr )
        render geolocation
    }
    
    def tryone() {
        def message = request.remoteAddr
        render message
    }

}
