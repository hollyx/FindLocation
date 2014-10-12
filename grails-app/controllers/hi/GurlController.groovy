
package hi

class GurlController {

  
    
    def index() { 
        def message = "hello"
        [myMessage:message]
        //render view: 'onfire'
        render message
    }
    
    def geoIpService 
    def tryone() {
            def defaultLocation = [latitude: 40.7141, longitude: 74.0064, countryName: "Unitad States", countryCode: "US"]
            def message = "78.153.217.226"
            def message2 = "3.255.255.255"
            def message3 = request.remoteAddr
            def ans = geoIpService.getLocation(message3)
            if ( ans == null) {
                ans = defaultLocation
            }
        
            def pls = ans.countryName
            render pls
    }

}
