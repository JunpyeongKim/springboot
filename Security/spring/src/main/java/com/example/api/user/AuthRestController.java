package com.example.api.user;


import com.example.domain.user.User;
import com.example.repository.user.UserRepository;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/auth") //TODO: api/auth --> (redirect) --> api/v#/auth
public class AuthRestController {
    @Autowired
    UserService userService;

//    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${version}")
    String version;

    @Value("${version.api}")
    String apiVersion;

    private static class LoginRequest {
        public String username;
        public String password;
        public String session;
        public String token;    // https://github.com/nielsutrecht/jwt-angular-spring
    }

    //TODO: Later, replace the following with User
    private static class LoginResponse {
        public String username;
        public String password;
        public String session;
        public String token;    // https://github.com/nielsutrecht/jwt-angular-spring
        public Integer role;

        public LoginResponse(String username, String password, String session, String token) {
            this.username = username;
            this.password = password;
            this.session = session;
            this.token = token;
        }
    }

    private static class AuthInfo {
        public String auth;
        public String session;
        public String token;
    }

    private static class PassCode {
        public String username;
        public String currentPass;
        public String newPass;
    }

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public User postAuthLogin(@RequestBody User user) {
        String username = user.getUsername();

        User found = userRepository.findOneByUsername(username);
        if (found != null && username.equals(found.getUsername())) {

        } else {
            // Nothing to do
        }

        return found;
    }

    /*
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<User> postAuthLogin(@RequestBody LoginRequest loginRequest) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;  // 404
        User loginResponse = null;
        AuthInfo authInfo = null;

        User user = userService.findOneByUsername(loginRequest.username);
        if (user != null) {
            httpStatus = HttpStatus.UNAUTHORIZED;    // 401

            if (user.getPassword().equals(loginRequest.password)) {
                if (user.isLocked()) {
                    httpStatus = HttpStatus.LOCKED; // 423
                    loginResponse = user;
                } else {
                    httpStatus = HttpStatus.OK;

                    authInfo = getAuth(user);
                    user.accessSucceeded(true, authInfo.session, authInfo.token);
                    loginResponse = userService.updateUserMetaInfo(user);
                }

            } else {
                if (user.isLocked()) {
                    httpStatus = HttpStatus.LOCKED;
                    loginResponse = user;
                } else {
                    httpStatus = user.accessFailed();
                    loginResponse = userService.updateUserMetaInfo(user);
                }
            }

        }

        return new ResponseEntity<User>(loginResponse, httpStatus);
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    public ResponseEntity<User> postAuthPassword(@RequestBody PassCode passCode) {
        User updated = null;
        AuthInfo authInfo = null;
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;   // 404

        User user = userService.findOneByUsername(passCode.username);
        if (user != null) {
            httpStatus = HttpStatus.UNAUTHORIZED;   // 401
            if (user.getPassword().equals(passCode.currentPass)) {
                httpStatus = HttpStatus.OK;

                user.changePassword(passCode.newPass);
                authInfo = getAuth(user);
                user.accessSucceeded(false, authInfo.session, authInfo.token);
                updated = userService.updateUserMetaInfo(user);
            }
        }

        return new ResponseEntity<User>(updated, httpStatus);
    }

    @RequestMapping(value = "{username}/unlock", method = RequestMethod.POST)
    public User postUserLock(@PathVariable String username) {
        User user = userService.findOneByUsername(username);
        User updated = null;
        if (user != null) {
            user.setFailCnt(0);
            user.setLocked("N");
            updated = userService.updateUserMetaInfo(user);
        }

        return updated;
    }
    */

//    private AuthInfo getAuth(User user) {
//        AuthInfo authInfo = new AuthInfo();
//
//        authInfo.auth = user.getUsername() + ":" + user.getPassword();
//        authInfo.session = Base64.getEncoder().encodeToString(authInfo.auth.getBytes());
//        authInfo.token = "JWT " + authInfo.session;
////        token = Jwts.builder().setSubject(/*login.name*/loginRequest.username)
////                .claim("roles", userDb.get(/*login.name*/loginRequest.username)).setIssuedAt(new Date())
////                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//
////        HttpStatus.RESET_CONTENT
//        return authInfo;
//    }
}
