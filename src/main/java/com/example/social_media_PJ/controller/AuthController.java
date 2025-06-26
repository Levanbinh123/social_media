package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.config.JwtProvider;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.response.AuthResponse;
import com.example.social_media_PJ.model.dtos.LoginRequest;
import com.example.social_media_PJ.repository.UserRepository;
import com.example.social_media_PJ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody User user) {
        // Khởi tạo mới để tránh lỗi khi client cố set ID
        User userCheckEmail=userRepository.findByEmail(user.getEmail());
        if(userCheckEmail!=null){
            throw  new RuntimeException("User email already exists");
        }
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword())); // hoặc mã hóa
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        userRepository.save(newUser);
        return (ResponseEntity<AuthResponse>) ResponseEntity.ok();

    }

        @PostMapping("/signin")
        public AuthResponse signIn(@RequestBody LoginRequest loginRequest) throws Exception {
            Authentication authentication = authenticate(loginRequest.getEmail(), loginRequest.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication); //  lưu context nếu cần

            String token = JwtProvider.generateToken(authentication);
            return new AuthResponse(token, "Đăng nhập thành công");
        }

        private Authentication authenticate(String email, String password) throws Exception {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(email, password);
            return authenticationManager.authenticate(authToken);
        }

}
